package serg.sort_variants;

import java.util.List;

/**
 * Created by Sergey Vasiliev on 7/11/17.
 */
public class QuickSort extends AbstractVariant implements SortVariant {

    public QuickSort(List<Integer> list) {
        super(list);
    }

    @Override
    public List<Integer> sort() {
        sortTime = 0;

        if (list.size() < 2) {
            return list;
        } else {
            return quickSortStart(0, list.size()-1);
        }
    }

    private List<Integer> quickSortStart(int lo, int hi) {
        if (lo < hi) {
            int p = partition(lo, hi);
            quickSortStart(lo, p-1);
            quickSortStart(p, hi);
        }

        return list;
    }

    private int partition(int lo, int hi) {
        int pivot = list.get(hi);
        while (lo < hi) {
            while (list.get(lo) < pivot)
                lo++;
            while (list.get(hi) > pivot)
                hi--;
            if (lo <= hi)
                swap(lo, hi);
        }

        return lo;
    }

}
