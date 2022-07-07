import java.util.ArrayList;
import java.util.List;

public class DPA4 {

    public DPA4(List<Integer> data) {
        this.costs = data;
    }

    private List<Integer> costs = new ArrayList<>();



    public int findMinCost(int num) {
        if (num == 0) {
            return 0;
        } else {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                temp.add(findMinCost(i) + sumHelper(num - i - 1));

            }
            return costs.get(num-1) + this.findMin(temp);
        }

    }

    public void printCost() {
        System.out.println(costs);
    }


    public int sumHelper(int num) {
        if (num == 1 || num == 0) {
            return num;
        } else {
            return num + sumHelper(num - 1);
        }


    }

    public int findMin(List<Integer> temp) {
        if (temp.size() == 1) {
            return temp.get(0);
        } else if (temp.isEmpty()) {

            return 0;
        } else {

            int tempNum = temp.get(0);
            for (int i = 1; i < temp.size(); i++) {
                if (temp.get(i) < tempNum) {
                    tempNum = temp.get(i);
                }

            }
            return tempNum;

        }


    }
}
