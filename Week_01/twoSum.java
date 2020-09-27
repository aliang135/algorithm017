import java.util.HashMap;
import java.util.Map;

public class Solution {
     public int[] twoSum(int[] nums, int target) {
         Map<Integer, Integer> map = new HashMap<>();
		 
         for (int i = 0; i < nums.length; i++) {
             int minusValue = target - nums[i];
             if (map.containsKey(minusValue)) {
                 return new int[] { map.get(minusValue), i };
             }
             map.put(nums[i], i);
         }
		 
         throw new IllegalArgumentException("No two sum solution");
     }
 }