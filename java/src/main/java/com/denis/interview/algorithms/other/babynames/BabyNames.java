package com.denis.interview.algorithms.other.babynames;

import java.util.HashMap;
import java.util.Map;

/**
 * Baby Names: Given baby names and their frequency and a list of equivalent name pairs. Reduce the data
 * to a synonym to the total of all equivalent synonym to that name.
 *
 * Assumptions:
 * synonym relationships are transitive
 * all data is valid
 * remove names with no frequency.
 *
 * Time complexity: O(names + synonyms)
 * Space complexity: O(names)
 *
 * Input :
 * Names : John (15), Jon (12), Chris (13), Kris (4), Christopher (19)
 * Synonyms : (Jon, John), (John, Johnny), (Chris, Kris), (Chris, Christopher)
 *
 * Output : John (27), Kris (36)
 */
public class BabyNames {


    public static Map<String, Integer> getActualFrequency(Map<String, Integer> names, String[][] synonyms) {

        Map<String, Integer> actualNamesFrequency = new HashMap<>();

        DisjointSet set = new DisjointSet(names);

        for (String[] array : synonyms) {
            set.union(array[0], array[1]);
        }

        for (String key : names.keySet()) {

            DisjointSetNode current = set.getNodesMap().get(key);
            DisjointSetNode representative = set.find(key);


            if (!actualNamesFrequency.containsKey(representative.getName())) {
                actualNamesFrequency.put(representative.getName(), current.getFrequency());
            }

            else {
                int currentFrequency = actualNamesFrequency.get(representative.getName());
                actualNamesFrequency.put(representative.getName(), current.getFrequency() + currentFrequency);
            }
        }

        return actualNamesFrequency;

    }

    public static void main(String[] args) {

        HashMap<String, Integer> names = new HashMap<>();


        names.put("John", 15);
        names.put("Jon", 12);
        names.put("Chris", 13);
        names.put("Christopher", 19);
        names.put("Kris", 4);
        names.put("Brian", 2);
        names.put("Bryan", 4);
        names.put("Carleton", 4);

        String[][] synonyms = {
                {"John", "Jonathan"},
                {"Jon", "John"},
                {"John", "Johnny"},
                {"Jonathan", "Johnny"},
                {"Chris", "Kris"},
                {"Chris", "Christopher"},
                {"Brian", "Bryan"}
        };

        Map<String, Integer> rootNames = getActualFrequency(names, synonyms);

        for (Map.Entry<String, Integer> entry : rootNames.entrySet()) {
            String name = entry.getKey();
            int frequency = entry.getValue();
            System.out.println(name + " : " + frequency);
        }

    }
}