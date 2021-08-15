package lpt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Map<String, Integer> m = new HashMap<String, Integer>();

        m.put("albatross", 12);
        m.put("pelikan", 27);
        m.put("lunnefågel", 19);
        m.put("albatross", 7);


        System.out.println(m.containsValue(7));

    }
}
