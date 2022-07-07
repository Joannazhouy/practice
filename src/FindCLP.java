import java.util.Arrays;

public class FindCLP {

    public FindCLP() {

    }

    public String findLCP(String[] strs) {
        if (strs.length == 0) return " ";
        String prefix = strs[0];
        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
            if (prefix.isEmpty())
                break;
        }
        return prefix;
    }

    public int findDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i == 0 || n > nums[i - 1]) {
                i += 1;
                nums[i] = n;
            }
        System.out.println(Arrays.toString(nums));
        return i;
    }

    public int removeElement(int[] nums, int val) {
        int ptr = 0;
        for (int n : nums){
            if (n!=val) {
                nums[ptr++] = n;
            }
        }
        return ptr;
    }

    public boolean findPalinedrome(int n){
        int remainder, copy, palindrome;
        palindrome = 0;
        copy = n;
        while (copy != 0){
            remainder = copy % 10;
            palindrome = palindrome * 10 + remainder;
            copy /= 10;
        }
        return palindrome == n;
    }

}