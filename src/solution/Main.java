package solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(new File("juice.in"));
            Processor p = new Processor();
            while(in.hasNext()) {
                String line = in.nextLine();
                p.addLine(line);
            }
            in.close();

            p.findMinimum();
            p.printWords();
            p.printSortedWords();
            p.printMinimum();
        }
        catch( FileNotFoundException ex ) {}
    }
}
