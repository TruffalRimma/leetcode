
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers nums and an integer target,
return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution,
and you may not use the same element twice.

You can return the answer in any order.
*/

public class Task1 {
    public static void main(String[] args) {
        int[] nums = {-1, -2, -3, -4, -5};
        System.out.println(Arrays.toString(twoSum(nums, -8)));
        System.out.println(Arrays.toString(twoSum2(nums, -6)));
        System.out.println(Arrays.toString(twoSum3(nums, -5)));
    }

    // мое решение - наивное :(
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i <= nums.length - 1; i++) {
            int test1 = nums[i];
            for (int j = 0; j <= nums.length - 1; j++) {
                if (j != i) {
                    int test2 = nums[j];
                    if (test1 + test2 == target) {
                        result[0] = i;
                        result[1] = j;
                    }
                }
            }
        }
        return result;
    }

    public static int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No solution");
    }

    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int requiredNumber = target - nums[i];

            if (map.containsKey(requiredNumber) && map.get(requiredNumber) != i) {
                return new int[]{i, map.get(requiredNumber)};
            }
        }

        throw new IllegalArgumentException("No solution");
    }
}