import java.*;
import java.util.ArrayList;
import java.util.List;

public class PruneAndSearch {

    public PruneAndSearch() {


    }

    private List<Integer> lesser;
    private List<Integer> greater;


    public int quickFind(List<Integer> list, int k) {
        if (list.size() > 1) {
            int pivot = list.get(0);
            this.greater = findLessor(false, list, pivot);
            this.lesser = findLessor(true, list, pivot);
            if (this.lesser.size() < k-1 ){
                return quickFind(this.greater, k-this.lesser.size());
            }
            if (this.lesser.size() == k-1){
                return pivot;
            }

            if (this.lesser.size() > k-1){
                return quickFind(this.lesser, k);
            }
        }
        return list.get(0);

    }

    private List<Integer> findLessor(boolean less, List<Integer> list, int p) {
        List<Integer> targets = new ArrayList<Integer>();
        if (less) {
            for (int i = 0; i < list.size(); i++) {
                int cur = list.get(i);
                if (cur < p) {
                    targets.add(cur);
                }
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                int cur = list.get(i);
                if (cur > p) {
                    targets.add(cur);
                }
            }

        }
        return targets;

    }
}



