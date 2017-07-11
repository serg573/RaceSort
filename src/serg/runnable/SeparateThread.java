package serg.runnable;

import serg.sort_variants.SortVariant;

/**
 * Created by Sergey Vasiliev on 7/10/17.
 */
public class SeparateThread implements Runnable {

    private SortVariant sortVariant;

    public SeparateThread(SortVariant sortVariant) {
        this.sortVariant = sortVariant;
    }

    @Override
    public void run() {

        System.out.println(sortVariant.getClass().getSimpleName()+" - Unsorted: "+sortVariant);

        sortVariant.sortWithTimeMeasurement();

        System.out.println(sortVariant.getClass().getSimpleName()+" - Sorted: "+sortVariant);

    }
}
