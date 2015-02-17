package solution;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Processor extends Thread
{
    ArrayList<String> sorted_words = new ArrayList<String>();
    ArrayList<String> words = new ArrayList<String>();
    ArrayList<Juice> juices = new ArrayList<Juice>();
    int n, minimum;
    String line_to_add;

    @Override
    public void run() {
        String[] temp = line_to_add.split(" ");
        for(String word : temp) {
            if(!words.contains(word)) {
                words.add(word);
            }
        }

        sorted_words = (ArrayList< String >)words.clone();
        Collections.sort(sorted_words, new MyComparator());
        juices.add(new Juice(temp));
    }


    void addLine(String line)
    {
        line_to_add = line;
        Thread thread = new Thread(this);

        thread.start();
        try {
            thread.join();
        }
        catch (InterruptedException ex) {}
    }

    boolean nextPermutation(int[] p) {
        for (int a = p.length - 2; a >= 0; --a)
            if (p[a] < p[a + 1])
                for (int b = p.length - 1;; --b)
                    if (p[b] > p[a]) {
                        int t = p[a];
                        p[a] = p[b];
                        p[b] = t;
                        for (++a, b = p.length - 1; a < b; ++a, --b) {
                            t = p[a];
                            p[a] = p[b];
                            p[b] = t;
                        }
                        return true;
                    }
        return false;
    }

    void findMinimum() {
        n = juices.size();
        int permutation[] = new int[n];
        for (int i = 0; i < n; ++i) {
            permutation[i] = i;
        }
        minimum = Integer.MAX_VALUE;
        while(nextPermutation(permutation)) {
            int ans = 1;
            for (int i = 0; i < n - 1; ++i) {
                if (!juices.get(permutation[i]).isSubset(juices.get(permutation[i + 1])))
                    ++ans;
            }
            minimum = Integer.min(minimum, ans);
        }
    }

    void printWords() throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new File("juice1.out"));
        for(String word : words) {
            out.println(word);
        }
        out.close();
    }

    void printSortedWords() throws FileNotFoundException
    {
        PrintWriter out = new PrintWriter(new File("juice2.out"));
        for(String word : sorted_words) {
            out.println(word);
        }
        out.close();
    }

    void printMinimum() throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new File("juice3.out"));
        out.println(minimum);
        out.close();
    }
}
