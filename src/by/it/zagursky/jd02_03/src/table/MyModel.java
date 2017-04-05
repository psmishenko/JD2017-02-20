package by.it.zagursky.jd02_03.src.table;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 * @author Drygba
 * Date: 02.02.13
 */
public class MyModel extends AbstractTableModel{

    private ArrayList<String[]> myData; // хранилище данных на основе
    // которых строится таблица

    public MyModel(ArrayList<String[]> myData){
        this.myData = myData;
    }

    @Override
    public int getRowCount(){
        return myData.size();//количество строк = размер ArrayList myData
    }

    @Override
    public int getColumnCount(){
        return myData.get(0).length;//количество строк = размер массива String в ArrayList myData
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        return myData.get(rowIndex)[columnIndex];
    }

    public void setValueAt(String[] newData){
        myData.add(newData);//добавляем в наш ArrayList новые данные
        fireTableDataChanged();//обновляем данные
    }
}