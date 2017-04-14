package by.it.smirnov.jd02_06_matlab.Vars;

import by.it.smirnov.jd02_06_matlab.Error.MatLabException;

/**
 * Интерфейс нематематических операций
 */
public interface IVariable {
   String toString();
   void setFrom(String x) throws MatLabException;
}
