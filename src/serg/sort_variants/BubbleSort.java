package serg.sort_variants;

import java.util.List;

import static serg.UnsortedArray.ARRAY_SIZE;

/**
 * Created by Sergey Vasiliev on 7/9/17.
 */
public class BubbleSort extends AbstractVariant implements SortVariant {

    public BubbleSort(List<Integer> list) {
        super(list);
    }

    @Override
    public List<Integer> sort() {
        sortTime = 0;
        for (int i=0; i<ARRAY_SIZE; i++) {
            for (int j=0; j<ARRAY_SIZE-1; j++){
                if (list.get(j)>list.get(j+1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
            }
        }
        return list;
    }

}
