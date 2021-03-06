import java.util.*;


public class Practices {
    //Given an array of integers nums and an integer target, return indices of the two numbers such
    // that they add up to target.
    // solutions: using a hashmap
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>() {
        };
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                break;
            }
        }
        return result;
    }

    public boolean isPalindrome(int x) {
        int copy = x;
        int result = 0;
        int remainder = 0;
        while (copy != 0) {
            remainder = copy % 10;
            result = result * 10 + remainder;
            copy /= 10;

        }
        return result == x;

    }

    // roman to integer
    // I 1
    // V 5
    // X 10
    // my original solution
    public int romanToInt(String s) {
        ArrayList<Integer> romanValue = new ArrayList<>();
        int length = s.length();
        int answer = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 'I') {
                romanValue.add(1);
            }
            if (s.charAt(i) == 'V') {
                romanValue.add(5);
            }
            if (s.charAt(i) == 'X') {
                romanValue.add(10);
            }
            if (s.charAt(i) == 'L') {
                romanValue.add(50);
            }
            if (s.charAt(i) == 'C') {
                romanValue.add(100);
            }
            if (s.charAt(i) == 'D') {
                romanValue.add(500);
            }
            if (s.charAt(i) == 'M') {
                romanValue.add(1000);
            }
        }
        for (int i = 0; i < length; i++) {
            if (i != length - 1 && romanValue.get(i) == 1 && romanValue.get(i + 1) == 5) {
                answer += 4;
                i++;
                continue;
            }
            if (i != length - 1 && romanValue.get(i) == 1 && romanValue.get(i + 1) == 10) {
                answer += 9;
                i++;
                continue;
            }
            if (i != length - 1 && romanValue.get(i) == 10 && romanValue.get(i + 1) == 50) {
                answer += 40;
                i++;
                continue;
            }
            if (i != length - 1 && romanValue.get(i) == 10 && romanValue.get(i + 1) == 100) {
                answer += 90;
                i++;
                continue;
            }
            if (i != length - 1 && romanValue.get(i) == 100 && romanValue.get(i + 1) == 500) {
                answer += 400;
                i++;
                continue;
            }
            if (i != length - 1 && romanValue.get(i) == 100 && romanValue.get(i + 1) == 1000) {
                answer += 900;
                i++;
            } else {
                answer += romanValue.get(i);
            }

        }
        return answer;

    }

    //Reverse the character order of each word in a sentence. the order of words stays the same.
    public String reverseWord(String s) {
        //create an array of string to tokenize each word in the sentence;
        String[] words = s.split(" ");
        //initiate a stringbuilder for putting back all the words into one string
        StringBuilder answer = new StringBuilder();
        //inistate a stringbuilder for reversing the characters
        StringBuilder reversed = new StringBuilder();
        for (String word : words) {
            reversed.append(word);
            reversed.reverse();
            answer.append(reversed + " ");
            reversed.setLength(0);
        }
        return answer.toString();
    }

    //find the longest common substring in a string array
    public String prefix(String[] strings) {
        // use the first word as prefix check
        String pre = strings[0];
        //the length of the remaining words in the list for iteration
        int length = strings.length;

        for (int i = 1; i < length; i++) {
            while (strings[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
                if (pre.isEmpty()) {
                    break;
                }
            }
        }
        return pre;
    }

    public ListNode mergeSorted(ListNode ln1, ListNode ln2) {
        if (ln1 == null) return ln2;
        if (ln2 == null) return ln1;
        if (ln1.val > ln2.val) {
            ln2.next = mergeSorted(ln1, ln2.next);
        } else {
            ln1.next = mergeSorted(ln1.next, ln2);
        }


        return null;
    }

    public int lastStone(List<Integer> weights) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.addAll(weights);
        while (queue.size() > 1) {
            queue.add(queue.poll() - queue.poll());
        }
        return queue.poll();

    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (c == '(') stack.push(')');
            else if (stack.isEmpty() || c != stack.pop()) return false;
        }
        return stack.isEmpty();


    }

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        char[] stack = haystack.toCharArray();
        char[] need = needle.toCharArray();
        for (int i = 0; i < stack.length; i++) {
            if (stack[i] == need[0]) {
                if (need.length == 1) {
                    return i;
                }
                if (stack.length-i < need.length){
                    return -1;
                }
                for (int y = 1; y < need.length; y++) {
                    if (stack[i + y] != need[y]) {
                        break;
                    }
                    if(y==need.length-1){
                        return i;
                    }
                }

            }
        }
        return -1;


    }

    private int binarySearch(int[] nums, int target, int first, int last, int middle){
        if (nums[middle] == target){
            return middle;
        } else if (first==last){
            if (nums[first] < target){
                return first+1;
            } else return first;
        } else if (nums[middle] < target){
            return binarySearch(nums, target, middle+1, last, middle+(last-middle)/2);
        } else {
            return binarySearch(nums, target, first, middle-1, (middle-first)/2);
        }
    }

    //return the target value index or the expected index
    public int searchInsert(int[] nums, int target){
        int first = 0;
        int last = nums.length-1;
        int middle = (last-first)/2;
        return binarySearch(nums, target, first, last, middle);


    }

    //count the length of last word
    public int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");
        List<String> arr2 = new ArrayList<>();
        for (String a : arr){
            if (a!=" "){
                arr2.add(a);
            }
        }
        String last =arr2.get(arr2.size()-1);
        return last.length();




    }

}


