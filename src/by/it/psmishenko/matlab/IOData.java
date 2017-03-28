package by.it.psmishenko.matlab;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Created by GN on 28.03.2017.
 */
public class IOData  {
    public static String path = System.getProperty("user.dir")+"\\src\\by\\it\\psmishenko\\matlab\\";
    public static File file = new File(path+"vars.txt");

    static void saveVarInTxt(String name,Var var) throws IOException {
        try(PrintWriter pr = new PrintWriter(new FileWriter(file,true))) {
                pr.printf("%s=%s\n",name,var);
        }catch (IOException e){
            throw new IOException("Данные не записаны",e);
        }
    }
}
