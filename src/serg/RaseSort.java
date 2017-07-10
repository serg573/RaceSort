package serg;

import serg.runnable.SeparateThread;
import serg.sort_variants.BubbleSort;

import java.util.*;

import static serg.UnsortedArray.getListByRandomWithoutDuplicates;

/**
 * Created by Sergey Vasiliev on 7/8/17.
 */
public class RaseSort {

    public static void main(String[] args) {

        //List<Integer> initialList = getListByRandomeWithDuplicates();
        List<Integer> initialList = getListByRandomWithoutDuplicates();
        //List<Integer> initialList = getListByMix();

        SeparateThread threadBubleSort = new SeparateThread(new BubbleSort(new ArrayList<>(initialList)));
        threadBubleSort.run();

    }

}
