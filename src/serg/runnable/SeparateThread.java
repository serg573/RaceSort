package serg.runnable;

import serg.sort_variants.SortVariant;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Sergey Vasiliev on 7/10/17.
 */
public class SeparateThread implements Runnable {

    private SortVariant sortVariant;
    private CountDownLatch countDownLatch;

    public SeparateThread(CountDownLatch countDownLatch, SortVariant sortVariant) {
        this.sortVariant = sortVariant;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        sortVariant.sortWithTimeMeasurement();

        //System.out.println(GetClassNameWithIndents()+" - "+sortVariant);

        countDownLatch.countDown();

    }

    public String GetClassNameWithIndents() {

        final int size = 15;
        StringBuilder strRez = new StringBuilder(size);

        strRez.append(sortVariant.getClass().getSimpleName());
        while (strRez.length() < size) strRez.append(" ");

        return strRez.toString();
    }

    public long getSortTime() {
        return sortVariant.getSortTime();
    }

    public String printCutList() {
        return sortVariant.printCutList();
    }

    public int compareTo(SeparateThread th2) {
        long ii = getSortTime() - th2.getSortTime();
        if (ii > 1) {
            return 1;
        } else if (ii < 0) {
            return -1;
        } else {
            return 0;
        }
    }

}
