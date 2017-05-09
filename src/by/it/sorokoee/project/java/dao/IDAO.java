package by.it.sorokoee.project.java.dao;



import java.util.List;

 interface IDAO<T> {
    boolean create(T entity) ;
    T read(int id) ;
    boolean update(T entity) ;
    boolean delete(T entity);

    List<T> getAll(String WhereAndOrder);
}
