package FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileManage {

    public void createFile() {
        File file = new File("test.txt");

        try {
            if (file.createNewFile()) {
                System.out.println("File Created Successfully");
            } else {
                System.out.println("File Already Exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void writeFile() {

        FileWriter write = null;

        try {
            write = new FileWriter("test.txt");

            write.write("Hello Testing ....");
           
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                write.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void readFile() {

        File file = new File("test.txt");

        try {
            Scanner scan  = new Scanner(file);
            while(scan.hasNextLine()){
                System.out.println(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
