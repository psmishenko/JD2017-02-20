package by.it.prigozhanov.jd02_06;

/**
 * Created by v-omf on 4/11/2017.
 *
 * @author v-omf
 */
public interface IOperations {

    Var add(Var var) throws MatlabException;
    Var sub(Var var) throws MatlabException;
    Var div(Var var) throws MatlabException;
    Var mul(Var var) throws MatlabException;

}
