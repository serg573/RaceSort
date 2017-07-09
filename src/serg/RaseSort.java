package serg;

import serg.sort_variants.BubbleSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Sergey Vasiliev on 7/8/17.
 */
public class RaseSort {

    public static final int ARRAY_SIZE = 20;

    public static void main(String[] args) {

        //List<Integer> list = getListByRandome();
        List<Integer> initialList = getListByMix();

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

    private static List<Integer> getListByMix() {
        List<Integer> list = new ArrayList<>(ARRAY_SIZE);
        for (int i=0; i<ARRAY_SIZE; i++)
            list.add(i);

        Collections.shuffle(list);

        return list;
    }
}
