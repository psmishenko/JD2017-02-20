package by.it.kolenda.MatLab;


public class VarV extends Var {
    @Override
    public void fromString(String value) {

    }

    @Override
    public Var add(Var var) {
        System.out.println("Поймали сложение вектора с чем-либо");
        return null;
    }
}
