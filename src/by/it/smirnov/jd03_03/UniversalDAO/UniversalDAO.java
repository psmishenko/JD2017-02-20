package by.it.smirnov.jd03_03.UniversalDAO;

import by.it.smirnov.jd03_03.Connection.ConnectorCreator;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

// Чуть более сложный пример с Generics.
// Потенциально способен обработать произольный bean со стандартными полями.

public class UniversalDAO<TypeBean> {

    private Class classBean;
    private String tableName;
    private LinkedList<Field> fields;
    private Field fieldId=null;

    public UniversalDAO(Class classBean, String sqlTableName, String keyFieldName) {
        this.classBean = classBean;
        this.tableName = sqlTableName;
        this.fields = new LinkedList<>();
        Class currentClass = classBean;
        do {
            Field[] field = currentClass.getDeclaredFields();
            for (int i = field.length - 1; i >= 0; i--) {
                field[i].setAccessible(true);
                if (field[i].getName().equalsIgnoreCase(keyFieldName))
                    fieldId = field[i];
                this.fields.addFirst(field[i]);
            }
        } while((currentClass = currentClass.getSuperclass()) != null);
    }

    public List<TypeBean> getAll(String WHERE) throws SQLException {
        List<TypeBean> beans = new ArrayList<>();
        String sql = "SELECT * FROM " + tableName + " " + WHERE + " ;";
        try (
                Statement statement = ConnectorCreator.getConnection().createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                TypeBean newBean = newBean();
                ListIterator<Field> itr = fields.listIterator();
                int i = 1;
                while (itr.hasNext()){
                    Field f = itr.next();
                    try {
                        f.set(newBean, rs.getObject(i++));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                beans.add(newBean);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return beans;
    }

    public TypeBean read(int id) throws SQLException {
        List<TypeBean> beans = getAll("WHERE ID=" + id );
        if (beans.size() > 0) {
            return beans.get(0);
        } else
            return null;
    }


    public boolean update(TypeBean bean) throws SQLException {
        StringBuilder sql = new StringBuilder("UPDATE `" + tableName + "` SET ");
        String delimiter = "";
        try {
            ListIterator<Field> itr = fields.listIterator();
            while (itr.hasNext()){
                Field f = itr.next();
                if (f!=fieldId) {
                    sql.append(delimiter).append("`").append(f.getName()).append("` = '").append(f.get(bean)).append("'");
                    delimiter = ", ";
                }
            }
            sql.append(" WHERE `").append(fieldId.getName()).append("` = '").append(fieldId.get(bean)).append("'");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return (0 < executeUpdate(sql.toString(), false));
    }

    public boolean create(TypeBean bean) throws SQLException {
        StringBuilder names = new StringBuilder();
        StringBuilder values = new StringBuilder();
        String delimiter = "";
        try {
            ListIterator<Field> itr = fields.listIterator();
            while (itr.hasNext()){
                Field f = itr.next();
                if (f!=fieldId) {
                    names.append(delimiter).append(f.getName());
                    values.append(delimiter).append("'").append(f.get(bean)).append("'");
                    delimiter = ", ";
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        String sql = "insert INTO " + tableName + " (" + names.toString() + ") values(" + values.toString() + ")";
        int id = executeUpdate(sql, true);
        if (id > 0) try {
            fieldId.set(bean, id);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return (id > 0);
    }

    public boolean delete(TypeBean bean) throws SQLException {
        String sql = null;
        try {
            sql = "DELETE FROM `" + tableName + "` WHERE `ID` = '" + fieldId.get(bean) + "'";
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return (0 < executeUpdate(sql, false));
    }

    private TypeBean newBean() {
        try {
            return (TypeBean) classBean.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static int executeUpdate(String sql, boolean returnLastID) throws SQLException {
        int result;
        try (Statement statement = ConnectorCreator.getConnection().createStatement()) {
            result = statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
            if (result>0 && returnLastID) {
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) result = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return result;
    }

}