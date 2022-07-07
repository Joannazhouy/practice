import java.util.*;

import static java.lang.Math.min;

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
        for(int i = 0; i < length; i++){
            if(s.charAt(i) == 'I'){
                romanValue.add(1);
            }
            if(s.charAt(i) == 'V'){
                romanValue.add(5);
            }
            if(s.charAt(i) == 'X'){
                romanValue.add(10);
            }
            if(s.charAt(i) == 'L'){
                romanValue.add(50);
            }
            if(s.charAt(i) == 'C'){
                romanValue.add(100);
            }
            if(s.charAt(i) == 'D'){
                romanValue.add(500);
            }
            if(s.charAt(i) == 'M'){
                romanValue.add(1000);
            }
        }
        for(int i = 0; i < length; i++){
            if(i!=length-1 && romanValue.get(i)==1 && romanValue.get(i+1)==5){
                answer += 4;
                i++;
                continue;
            }
            if(i!=length-1 && romanValue.get(i)==1 && romanValue.get(i+1)==10){
                answer += 9;
                i++;
                continue;
            }
            if(i!=length-1 && romanValue.get(i)==10 && romanValue.get(i+1)==50){
                answer += 40;
                i++;
                continue;
            }
            if(i!=length-1 && romanValue.get(i)==10 && romanValue.get(i+1)==100){
                answer += 90;
                i++;
                continue;
            }
            if(i!=length-1 && romanValue.get(i)==100 && romanValue.get(i+1)==500){
                answer += 400;
                i++;
                continue;
            }
            if(i!=length-1 && romanValue.get(i)==100 && romanValue.get(i+1)==1000){
                answer += 900;
                i++;
            } else {
                answer += romanValue.get(i);
            }

        }
        return answer;

    }

    //Reverse the character order of each word in a sentence. the order of words stays the same.
    public String reverseWord(String s){
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
    public String prefix(String[] strings){
        // use the first word as prefix check
        String pre = strings[0];
        //the length of the remaining words in the list for iteration
        int length = strings.length;

        for(int i=1; i<length; i++){
            while(strings[i].indexOf(pre) != 0){
                pre = pre.substring(0, pre.length()-1);
                if (pre.isEmpty()){
                    break;
                }
            }
        }
        return pre;
    }






}