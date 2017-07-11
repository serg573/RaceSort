package serg.sort_variants;

import java.util.List;

/**
 * Created by Sergey Vasiliev on 7/10/17.
 */
public interface SortVariant {
    List<Integer> sort();
    List<Integer> sortWithTimeMeasurement();
    String toString();
    long getSortTime();
    String printCutList();
}
