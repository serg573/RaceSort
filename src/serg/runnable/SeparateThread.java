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

        sortVariant.sortWithTimeMeasurement();

        System.out.println(GetClassNameWithIndents()+" - "+sortVariant);

    }

    private String GetClassNameWithIndents() {

        final int size = 15;
        StringBuilder strRez = new StringBuilder(size);

        strRez.append(sortVariant.getClass().getSimpleName());
        while (strRez.length() < size) strRez.append(" ");

        return strRez.toString();
    }
}
