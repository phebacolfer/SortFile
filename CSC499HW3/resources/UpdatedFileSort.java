
package updatedfilesort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class UpdatedFileSort {

    public static void main(String[] args) {
        BufferedReader in = null;
        BufferedWriter write = null;

        try {

            //declare finResult as the list to be printed from
            ArrayList<String> finResult = new ArrayList<String>();
            //declare subSort as the list to be sorted
            ArrayList<String> subSort = new ArrayList<String>();
            in = new BufferedReader(new FileReader("resources/Sort Me.txt"));
            String curLine = in.readLine();
            //read the file contents into the sorting sublist
            while (curLine != null) {
                subSort.add(curLine);
                curLine = in.readLine();
            }
            //sort the contents of the file by name length
            Collections.sort(subSort, new Comparator<String>() {
                public int compare(String first, String second) {
                    return first.length() - second.length();
                }
            });

            //declare i so it can be altered when the length changes
            int i;

            //declare an array to hold all of the words of the same length
            ArrayList<String> lengthSub = new ArrayList<String>();

            for (i = 0; i < subSort.size(); i++) {
                for (int j = i; j < subSort.size() - 1; j++) {
                    if (subSort.get(j).length() != subSort.get(j + 1).length()) {
                        i = j;
                        break;
                    } else {
                        lengthSub.add(subSort.get(j));
                    }
                }

                Collections.sort(lengthSub);

                for (int k = 0; k < lengthSub.size(); k++) {
                    finResult.add(lengthSub.get(k));
                }
                lengthSub.clear();
            }
            String[] argument;
            if (args.length == 0){
                argument = new String[1];
                argument[0] = "f";
            } else {
                argument = args;
            }
            
            for (String str : argument) {
                if (str.equalsIgnoreCase("r")) {
                    for (int m = finResult.size()-1; m >=0; m--) {
                        System.out.println(finResult.get(m));
                    }
                } else {
                    for (int m = 0; m < finResult.size(); m++) {
                        System.out.println(finResult.get(m));
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("An error has occured.");
            e.printStackTrace();
        }

        try {
            if (in != null) {
                in.close();
            }
            if (write != null) {
                write.close();
            }
        } catch (IOException e) {
            System.out.println("An error has occured.");
            e.printStackTrace();
        }
    }
    
}
