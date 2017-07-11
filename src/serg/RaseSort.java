package serg;

import serg.runnable.SeparateThread;
import serg.sort_variants.BubbleSort;
import serg.sort_variants.CollectionsSort;
import serg.sort_variants.QuickSort;

import java.util.*;

import static serg.UnsortedArray.getListByRandomWithoutDuplicates;

/**
 * Created by Sergey Vasiliev on 7/8/17.
 * lskdfjsdklfj
 */
public class RaseSort {

    public static void main(String[] args) {

        //Пора добавлять подсчет времени выполнения, возможно возвращать их в качестве результата и потом сравнивать программно.
        //Добавлять новые алгоритмы сортировки

        //List<Integer> initialList = getListByRandomeWithDuplicates();
        List<Integer> initialList = getListByRandomWithoutDuplicates();
        //List<Integer> initialList = getListByMix();

        SeparateThread threadBubleSort = new SeparateThread(new BubbleSort(new ArrayList<>(initialList)));
        threadBubleSort.run();

        SeparateThread collectionsSort = new SeparateThread(new CollectionsSort(new ArrayList<>(initialList)));
        collectionsSort.run();

        SeparateThread quickSort = new SeparateThread(new QuickSort(new ArrayList<>(initialList)));
        quickSort.run();

    }

}
