package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Juice {

    public ArrayList<String> words;

    Juice( String[] words ) {
        this.words = new ArrayList<String>(Arrays.asList(words));
        Collections.sort(this.words, new MyComparator());
    }

    boolean isSubset(Juice value) {
        for(String word : words) {
            if(!value.words.contains(word))
                return false;
        }

        return true;
    }

}
