package serg.sort_variants;

import java.util.List;

import static serg.UnsortedArray.printCutList;

/**
 * Created by Sergey Vasiliev on 7/10/17.
 * sdlkfjsdlkfj
 */
abstract class AbstractVariant implements SortVariant {

    List<Integer> list;
    long sortTime;

    AbstractVariant(List<Integer> list) {
        this.list = list;
        this.sortTime = 0;
    }

    @Override
    public abstract List<Integer> sort();

    @Override
    public List<Integer> sortWithTimeMeasurement() {
        List<Integer> list;

        long startTime = System.nanoTime();
        list = sort();
        sortTime = System.nanoTime() - startTime;

        return list;
    }

    @Override
    public String toString() {

        if (sortTime == 0) {
            return list.toString();
        } else {
            return "SortTime "+sortTime+" Nano seconds, "+printCutList(list);
        }
    }

    void swap(int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public long getSortTime() {
        return sortTime;
    }
}
