
package csc499hw3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;

public class CSC499HW3 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = null;
        BufferedWriter write = null;
        Process initial = new ProcessBuilder("javac", "resources/UpdatedFileSort.java").start();
        ProcessBuilder forward = new ProcessBuilder("java", "resources/UpdatedFileSort.java", "f");
        ProcessBuilder reverse = new ProcessBuilder("java", "resources/UpdatedFileSort.java", "r");
        forward.redirectErrorStream(true);
        reverse.redirectErrorStream(true);
        
        Process process = forward.start();
        InputStream is = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line = null;
        String forOut = "";
        while ((line = reader.readLine()) != null) {
            forOut += line.substring(1)+"\n";
        }
        
        Process process2 = reverse.start();
        InputStream is2 = process2.getInputStream();
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(is2));
        String line2 = null;
        String revOut = "";
        while ((line2 = reader2.readLine()) != null) {
            revOut += line2.substring(1)+"\n";
        }
        in = new BufferedReader(new FileReader("resources/Sorted Text.txt"));
        String curLine = in.readLine();
        String forRight = "";
        String revRight = "";
        while (curLine != null) {
                forRight += curLine+"\n";
                curLine = in.readLine();
            }
        in = new BufferedReader(new FileReader("resources/Sorted Text.txt"));
        String newLine = in.readLine();
        while (newLine != null) {
                revRight += newLine+"\n";
                newLine = in.readLine();
            }
        if (forRight.equals(forOut)){
            System.out.println("Forward sort is working correctly!");
        }
        else{
            System.out.println("Forward sort is not working correctly!");
        }
        
        if (revRight.equals(revOut)){
            System.out.println("Reverse sort is working correctly!");
        }
        else{
            System.out.println("Reverse sort is not working correctly!");
        }
    }

}
