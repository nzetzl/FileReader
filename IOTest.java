package FileReader;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.Scanner;

/**
 * @author nicholaszetzl
 */
public class IOTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        File file = new File("Text");
        
        FileOutputStream fos = new FileOutputStream(file, true);
        PrintWriter pw = new PrintWriter(fos);
        Scanner s = new Scanner(System.in);
        System.out.println("Enter input to be placed into a file. When you are done type '^]' and press enter.");
        while (true) {
            String line = s.nextLine();
            if (line.equals("^]")) {
                break;
            } else {
                pw.println(line);
            }
        }
        s.close();
        pw.close();
        
        FileReader fr = new FileReader(file);
        BufferedReader bfr = new BufferedReader(fr);
        String st;
        System.out.println("This is the text of the file:");
        while (true) {
            st = bfr.readLine();
            if (st == null) {
                break;
            } else {
                System.out.println(st);
            }
        }
        bfr.close();
    }
}
