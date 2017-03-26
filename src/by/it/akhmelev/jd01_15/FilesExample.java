package by.it.akhmelev.jd01_15;

import java.io.IOException;
import java.nio.file.*;

public class FilesExample {
    public static void main(String[] args) throws IOException {
        String src = System.getProperty("user.dir") + "/src/by/it/akhmelev/";
        String fileInTxt = src + "jd01_15/in.txt";
        String fileBak = src + "jd01_15/in.bak";
        String fileMove = src + "jd01_15/in.move";
        // Cоздание объекта Path через вызов статического метода get() класса Paths
        Path path = Paths.get(fileInTxt);
        Path pathForCopy= Paths.get(fileBak);
        Path pathForMove= Paths.get(fileMove);
        //проверка свойств файла (каталога)
        System.out.printf("Readable: %b, Writable: %b, Executable: %b\n",
                Files.isReadable(path), Files.isWritable(path),
                Files.isExecutable(path));
        //проверка аттрибутов файла (каталога)
        System.out.printf("Creation time: %s\nLast modified time: %s\nSize: %s\nDir: %s\n",
                Files.getAttribute(path, "creationTime", LinkOption.NOFOLLOW_LINKS),
                Files.getAttribute(path, "lastModifiedTime", LinkOption.NOFOLLOW_LINKS),
                Files.getAttribute(path, "size"),
                Files.getAttribute(path, "isDirectory")
        );
        //копирование файла(ов) (StandardCopyOption.REPLACE_EXISTING - перезапись)
        Files.copy(path,pathForCopy, StandardCopyOption.REPLACE_EXISTING);
        //перенос файла(ов) (StandardCopyOption.REPLACE_EXISTING - перезапись)
        Files.move(pathForCopy, pathForMove, StandardCopyOption.REPLACE_EXISTING);
        //удаление файла(ов)
        Files.delete(pathForMove);
    }
}
