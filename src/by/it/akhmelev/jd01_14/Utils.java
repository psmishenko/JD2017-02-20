package by.it.akhmelev.jd01_14;

class Utils {
    static String getFilePath(String name) {
        String src = System.getProperty("user.dir") + "/src/by/it/akhmelev/";
        return src + "jd01_14/"+name;
    }
}
