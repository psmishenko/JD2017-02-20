package by.it.akhmelev.jd01_09.nested;

public class ParentForNested {
    private int id;

    // abstract, final, private, protected - допустимы
    public static class SubClassNested {
        private int boatId;

        public static void downAll() {
            System.out.println("Всем стоп");
        }

        public void goOne() {
            System.out.println("Один пошел");
        }
    }
}