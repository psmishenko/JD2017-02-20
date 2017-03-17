package by.it.kolenda.MatLab;


public interface Operation {
    Var add(Var var);
    Var sub(Var var);
    Var mul(Var var);
    Var div(Var var);
    void save (String name);
}
