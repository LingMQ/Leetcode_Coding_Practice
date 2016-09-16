/**
 * Given an array of integers, return indices of the two numbers such that they add up to a 
 * specific target. 
 * You may assum that each input would have exactly one solution.
 **/

// My first attempt
public class Solution{

	public int[] twoSum(int[] nums, int target){

		int[] returnVal = new int[2];

		for(int i = 0; i < nums.length; i++){
			int complimentary = target - nums[i];

			for(int j = i + 1; j < nums.length; j++){
				if(nums[j] == complimentary){
					returnVal[0] = i;
					returnVal[1] = j;
					return returnVal;
				}
			}
		}
		return null;
	}
}

// My second attempt (Two-pass Hash Table)
	public int[] twoSum(int[] nums, int target){

        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            map.put(target - nums[i], i);
        }
        
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]) && i != map.get(nums[i]))
                return new int[] {i, map.get(nums[i])};
        }
        
        return new IllegalArgumentException("No two sum solution");
	}

// Solution 1: Brute Force w/ Better Format and More Accurate
	public int[] twoSum(int[] nums, int target){
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] == target - nums[i]) {
					return new int[] { i, j };
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

// Solution 3: One-pass Hash Table
	public int[] twoSum(int[] nums, int target){
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] {map.get(complement), i};
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}