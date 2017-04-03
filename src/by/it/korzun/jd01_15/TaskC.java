package by.it.korzun.jd01_15;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class TaskC {
    private static void processFolder(String prefix, File object){
        System.out.println("Containing of the folder " + object.getAbsolutePath());
        File []dir = object.listFiles();
        String type;
        String usableSpace;
        int fileCount = 0;
        int dirCount = 0;
        for(File f:dir){
            if(f.isDirectory()){
                type = "<DIR>";
                usableSpace = "";
                dirCount++;
            }else {
                type = "";
                usableSpace = String.valueOf(f.length());
                fileCount++;
            }
            System.out.printf("%20s\t%-9s\t%-18s\t%-15s\n", new Date(f.lastModified()), type, usableSpace, f.getName());
        }
        System.out.println("\t\t" + fileCount + " files\n\t\t" +
                dirCount + " directories\t" + object.getFreeSpace() + " free");

    }

    void run() {
        String currentLocation = System.getProperty("user.dir") + "\\src\\by\\it\\korzun\\jd01_15";
        String currentDisk = currentLocation.split("[\\\\/]")[0] + "\\";
        File file;

        while(true){
            Scanner scanner = new Scanner(System.in);
            file = new File(currentLocation);
            System.out.print(currentLocation + ">");
            String command = scanner.nextLine();
            String regExForCheck = "cd\\\\(([A-Za-zА-Яа-я0-9.,\\[\\]()&!@#$%^_]\\\\?)+)*";


            if(command.matches(regExForCheck)){
                if(new File(currentDisk + command.substring(3)).exists()) {
                    currentLocation = currentDisk + command.substring(3);
                }else {
                    System.out.println("System can't find this path");
                }
            }else if(command.equalsIgnoreCase("dir")){
                processFolder("", file);
            }else if(command.equalsIgnoreCase("exit")){
                break;
            }else{
                System.out.println("Incorrect command");
            }
        }
    }
}
