package serg;

import serg.runnable.SeparateThread;
import serg.sort_variants.BubbleSort;
import serg.sort_variants.CollectionsSort;
import serg.sort_variants.QuickSort;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static serg.UnsortedArray.getListByRandomWithoutDuplicates;
import static serg.UnsortedArray.printCutList;

/**
 * Created by Sergey Vasiliev on 7/8/17.
 * lskdfjsdklfj
 */
public class RaseSort {

    public static void main(String[] args) {

        //Сделать автоСортировку коллекцией в Листе Threads
        //Добавлять новые алгоритмы сортировки

        //List<Integer> initialList = getListByRandomeWithDuplicates();
        List<Integer> initialList = getListByRandomWithoutDuplicates();
        //List<Integer> initialList = getListByMix();

        System.out.println("Array size: "+initialList.size());
        System.out.println("Unsorted: "+printCutList(initialList)+"\n");

        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        List<SeparateThread> listOfThreads = new LinkedList<>();
        listOfThreads.add(new SeparateThread(countDownLatch, new BubbleSort(new ArrayList<>(initialList))));
        listOfThreads.add(new SeparateThread(countDownLatch, new CollectionsSort(new ArrayList<>(initialList))));
        listOfThreads.add(new SeparateThread(countDownLatch, new QuickSort(new ArrayList<>(initialList))));

        for (SeparateThread thred : listOfThreads) {
            executorService.execute(thred);
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();

        Comparator<SeparateThread> comparator = (SeparateThread th1, SeparateThread th2) -> (th1.compareTo(th2));
        SortedSet<SeparateThread> sortedSet = new TreeSet<>(comparator);
        sortedSet.addAll(listOfThreads);

        System.out.println("Results sorted by time of sorting:");

        for (SeparateThread thred : sortedSet) {
            System.out.println(thred.GetClassNameWithIndents()+" - SortTime "+thred.getSortTime()+" Nano seconds, "+thred.printCutList());
        }

    }

}
