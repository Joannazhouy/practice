import java.util.*;

public class Queue {

    public Queue(){}
    private Stack stack1;
    private Stack stack2;


    //running time: constant
    public void enqueue(int item){
        stack1.push(item);

    }

    // running time: O(n)
    //best case time running: constant
    // amortized analysis would be useful here
    //

    public int dequeue(int item) {
        if (stack2.isEmpty()) {

            int size = stack1.size();
            for (int i = 0; i < size; i++) {
                stack2.push(stack1.pop());
            }
        }
        return (int) stack2.pop();
    }

    // running time: constant
    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }

}

