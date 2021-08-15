package textproc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GeneralWordCounter implements TextProcessor {
    private Map<String, Integer> wordCounter = new HashMap<String, Integer>();
    private Set<String> stopwords = new HashSet<String>();

    public GeneralWordCounter(Set<String> stopwords) {
        this.stopwords = stopwords;
    }

    @Override
    public void process(String w) {
        int i = wordCounter.containsKey(w) ? wordCounter.get(w) : 0;
        if(!stopwords.contains(w)){
            wordCounter.put(w, i + 1);
        }
    }

    @Override
    public void report() {
        
        // wordCounter.forEach((x, y) -> { if(y.intValue() >= 200) { System.out.println(x + ": " + y);}});

        Set<Map.Entry<String, Integer>> wordSet = wordCounter.entrySet();
        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);

        wordList.sort((x, y) -> (y.getValue().compareTo(x.getValue())));
        for(int i = 0; i < 4; i++) { System.out.println(wordList.get(i)); }
    }
}