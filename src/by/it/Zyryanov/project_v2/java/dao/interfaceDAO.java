package by.it.Zyryanov.project_v2.java.dao;


import java.util.List;

public interface interfaceDAO <Type> {

    boolean create(Type entity);
    Type read(int id);
    boolean update(Type entity);
    boolean delete(Type entity);


    List<Type> getAll(String whereString);



}
