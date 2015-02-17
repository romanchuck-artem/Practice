package solution;

import java.util.Comparator;

class MyComparator implements Comparator<String> {
    public int compare(String lhv, String rhv) {

        return lhv.compareTo(rhv);
    }
}