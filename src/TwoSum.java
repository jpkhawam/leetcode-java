/// https://leetcode.com/problems/two-sum
public int[] twoSum(int[] nums, int target) {
    // please ignore that im solving twosum in the big 2026
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        if (map.containsKey(target - nums[i])) {
            return new int[] { map.get(target - nums[i]), i };
        } else {
            map.put(nums[i], i);
        }
    }
    return new int[] { -1, -1 };
}

void main() {
    assert Arrays.equals(twoSum(new int[] { 2, 7, 11, 15 }, 9), new int[] { 0, 1 });
}
