package serg.sort_variants;

import java.util.Collections;
import java.util.List;

import static serg.UnsortedArray.ARRAY_SIZE;

/**
 * Created by Sergey Vasiliev on 7/10/17.
 */
public class CollectionsSort extends AbstractVariant implements SortVariant {

    public CollectionsSort(List<Integer> list) {
        super(list);
    }

    @Override
    public List<Integer> sort() {
        sortTime = 0;

        Collections.sort(list);

        return list;
    }
}
