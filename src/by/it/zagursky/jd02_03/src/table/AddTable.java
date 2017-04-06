package by.it.zagursky.jd02_03.src.table;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author Drygba
 * Date: 02.02.13
 */

public class AddTable extends JFrame{
    //myData будет хранилищем для наших данных,
    // ArrayList используется просто для примера
    private ArrayList<String[]> myData;
    private MyModel model; // наша модель таблицы
    private static int countNewRow = 0; // счетчик новых строк


    public static void main(String[] arg){
        AddTable at = new AddTable();
        JTable full = at.createTable();

        at.add(new JScrollPane(full));
        at.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        at.pack();
        at.setVisible(true);

    }

    public void createFrame(){
        setLayout(new BorderLayout());
        JButton addButon = new JButton("Add Data");

        addButon.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //добавляем данные через модель таблицы
                model.setValueAt(new String[]{ "новая" + String.valueOf(countNewRow),
                        "новая" + String.valueOf(countNewRow)
                        , "новая" + String.valueOf(countNewRow) });
                countNewRow++;
            }
        });
        add(addButon, BorderLayout.SOUTH);
    }

    public JTable createTable(){
        myData = new ArrayList<String[]>();
        myData.add(new String[]{ "1", "2", "3" });


        model = new MyModel(myData);//создаем модель таблицы и предаем начальные данные
        JTable table = new JTable(model);//создаем таблицу и передаем туда модель
        return table;
    }
}