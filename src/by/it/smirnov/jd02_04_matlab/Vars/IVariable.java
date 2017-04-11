package by.it.smirnov.jd02_04_matlab.Vars;

import by.it.smirnov.jd02_04_matlab.Error.MatLabException;

/**
 * Интерфейс нематематических операций
 */
public interface IVariable {
   String toString();
   void setFrom(String x) throws MatLabException;
}
