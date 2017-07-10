package serg;

import serg.sort_variants.BubbleSort;

import java.util.*;

/**
 * Created by Sergey Vasiliev on 7/8/17.
 */
public class RaseSort {

    public static final int ARRAY_SIZE = 20;

    public static void main(String[] args) {

        //List<Integer> initialList = getListByRandome();
        List<Integer> initialList = getListByRandomWithoutDuplicates();
        //List<Integer> initialList = getListByMix();

        System.out.println("Unsorted:"+initialList);

        List<Integer> bubleSortedList = new BubbleSort(new ArrayList<>(initialList)).sort();

        System.out.println("Sorted:"+bubleSortedList);

    }

    private static List<Integer> getListByRandome() {
        List<Integer> list = new ArrayList<>(ARRAY_SIZE);
        for (int i=0; i<ARRAY_SIZE; i++)
            list.add((int) (Math.random()*(10+1)));

        return list;
    }

    private static List<Integer> getListByRandomWithoutDuplicates() {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>(ARRAY_SIZE); // If I used "return new ArrayList<>(set);" instead, it would return sorted list but I need unsorted one
        while (set.size()<ARRAY_SIZE) {
            int ii = (int) (Math.random()*(20+1));
            if (set.add(ii)) list.add(ii);
        }

        return list;
    }

    private static List<Integer> getListByMix() {
        List<Integer> list = new ArrayList<>(ARRAY_SIZE);
        for (int i=0; i<ARRAY_SIZE; i++)
            list.add(i);

        Collections.shuffle(list);

        return list;
    }
}
