package edu.wctc.eligrow;

import java.util.*;

/**
 * Methods for sorting maps
 * @author eplig
 * @version 1.0
 */
public class SortMap {

    /**
     * Sorts input HashMap
     * @param hm HashMap<String, Integer>: Map to sort
     * @return HashMap<String, Integer>
     */
    public static HashMap<String, Integer> sortByValue(Map<String, Integer> hm)
    {
        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        }.reversed());
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
