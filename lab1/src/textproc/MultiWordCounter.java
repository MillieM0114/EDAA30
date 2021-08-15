package textproc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MultiWordCounter implements TextProcessor {
    private Map<String, Integer> words = new HashMap<String,Integer>();
    
    public MultiWordCounter(String[] addWords){
         Arrays.stream(addWords).forEach(x -> words.put(x, 0));
    }

    public void process(String w) {
        words.forEach((x, y) -> { if (x.equals(w)) { words.put(x,y+=1);}});
    }

    public void report() {
       words.forEach((x, y) -> System.out.println(x + ": " + y));  
    }
}