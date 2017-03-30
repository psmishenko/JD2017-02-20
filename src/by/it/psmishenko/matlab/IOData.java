package by.it.psmishenko.matlab;


import java.io.*;


/**
 * Created by GN on 28.03.2017.
 */
public class IOData  {
    public static String path = System.getProperty("user.dir")+"\\src\\by\\it\\psmishenko\\matlab\\";
    public static File fileForVars = new File(path+"vars.txt");
    public static File fileForLogs = new File(path+"log.txt");

    static void saveVarInTxt() throws IOException {
        try(PrintWriter pr = new PrintWriter(new FileWriter(fileForVars))) {
                pr.print(Var.vars);
        }catch (IOException e){
            throw new IOException("Данные не записаны",e);
        }
    }
    static void loadFromTxt() throws MathException {
        if(fileForVars.exists()){
            try (BufferedReader br = new BufferedReader(new FileReader(fileForVars))) {
                String line;
                while ((line = br.readLine()) != null) {
                   Parser.calc(line);
                }
                br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static void saveErrorsInTxt(StackTraceElement[] t,String message) throws IOException {
        try(PrintWriter pr = new PrintWriter(new FileWriter(fileForLogs,true))) {
            pr.println("Ошибка:"+message);
            pr.println("Stack:");
            for (StackTraceElement el:t) {
                pr.printf("В классе \"%s\" ,в методе \"%s\" , в строке \"%s\"\n",
                        el.getClassName(),el.getMethodName(),el.getLineNumber());
                if(el.getMethodName().equals("main"))break;
            }
            pr.println("----------------------------------------------------------------------------");
        }catch (IOException e){
            throw new IOException("Данные не записаны",e);
        }
    }
    static void saveOperationsInTxt(String expression,String res){
        try(PrintWriter pr = new PrintWriter(new FileWriter(fileForLogs,true))) {
            pr.printf("%s=%s\n",expression,res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
