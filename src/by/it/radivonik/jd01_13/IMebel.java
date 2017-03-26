package by.it.radivonik.jd01_13;

/**
 * Created by Radivonik on 10.03.2017.
 * Интерфейс Мебель
 */
public interface IMebel {
    void sborka() throws MebelException ;
    void razborka() throws MebelException ;
    void otkrytie() throws MebelException ;
    void zakrytie() throws MebelException ;
    void upakovka() throws MebelException ;
    void raspakovka() throws MebelException ;
    void perevozka() throws MebelException ;
}
