package serg;

import java.util.*;

/**
 * Created by Sergey Vasiliev on 7/10/17.
 */
public class UnsortedArray {

    public static final int ARRAY_SIZE = 30;

    public static List<Integer> getListByRandomeWithDuplicates() {
        List<Integer> list = new ArrayList<>(ARRAY_SIZE);
        for (int i=0; i<ARRAY_SIZE; i++)
            list.add((int) (Math.random()*(10+1)));

        return list;
    }

    public static List<Integer> getListByRandomWithoutDuplicates() {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>(ARRAY_SIZE); // If I used "return new ArrayList<>(set);" instead, it would return sorted list but I need unsorted one
        while (set.size()<ARRAY_SIZE) {
            int ii = (int) (Math.random()*(ARRAY_SIZE+1));
            if (set.add(ii)) list.add(ii);
        }

        return list;
    }

    public static List<Integer> getListByMix() {
        List<Integer> list = new ArrayList<>(ARRAY_SIZE);
        for (int i=0; i<ARRAY_SIZE; i++)
            list.add(i);

        Collections.shuffle(list);

        return list;
    }

    public static String printCutList(List<Integer> list) {
        if (list.size() > 20) {
            StringBuilder str = new StringBuilder("[");
            for(int i=0; i<20; i++) str.append(list.get(i)).append(", ");
            return str.append("..]").toString();
        } else {
            return list.toString();
        }
    }

}
