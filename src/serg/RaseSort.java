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

        System.out.println("Unsorted: "+initialList+"\n");

//        SeparateThread threadBubleSort = new SeparateThread(new BubbleSort(new ArrayList<>(initialList)));
//        threadBubleSort.run();
//
//        SeparateThread collectionsSort = new SeparateThread(new CollectionsSort(new ArrayList<>(initialList)));
//        collectionsSort.run();
//
//        SeparateThread quickSort = new SeparateThread(new QuickSort(new ArrayList<>(initialList)));
//        quickSort.run();


        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        executorService.execute(new SeparateThread(countDownLatch, new BubbleSort(new ArrayList<>(initialList))));
        executorService.execute(new SeparateThread(countDownLatch, new CollectionsSort(new ArrayList<>(initialList))));
        executorService.execute(new SeparateThread(countDownLatch, new QuickSort(new ArrayList<>(initialList))));

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();

    }

}
