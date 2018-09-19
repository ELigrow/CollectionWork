package edu.wctc.eligrow;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private final static FileInput indata = new FileInput("the_book.csv");
    private final static Map<String, Integer> map = new HashMap<String, Integer>();

    public static void main(String[] args) {
        String line;
        String[] words;
        Object wordFound;
        Map<String, Integer> oneOnly = new HashMap<>();
     //   String[] fields;

        while ((line = indata.fileReadLine()) != null) {
            line=line.replace(",","").replace(".","")
                    .replace(";","").replace(":","")
                    .replace("'","").replace("\"","")
                    .replace("-","").replace("!","")
                    .replace("#","").replace("(","")
                    .replace(")","").replace("?","")
                    .replace("_"," ").replace("?","")
                    .toLowerCase().trim();
            words = line.split(" ");
            int counter = 0;
            for (String s:words) {

                wordFound = map.get(s);
                if (wordFound == null) {
                    map.put(s, new Integer(1));
                }
                else {
                    map.put(s, map.get(s) + 1);
                    counter++;
                }
                if(counter == 1){
                    oneOnly.put(s, new Integer(1));
                }

            }


            System.out.println("Words used only once:");
            for (Map.Entry<String, Integer> entry : oneOnly.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }

        Map<String, Integer> topTwenty = SortMap.sortByValue(map);

        System.out.println("Top twenty most used:");
            for (int counter = 0; counter < 100; counter++) {
                System.out.println(topTwenty.keySet().toArray()[counter] + " " + topTwenty.get(topTwenty.keySet().toArray()[counter]));
            }

    }

}