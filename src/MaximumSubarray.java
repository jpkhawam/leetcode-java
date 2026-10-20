/// https://leetcode.com/problems/maximum-subarray
void main() {
    assert maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}) == 6 : "Failed test 1";
    assert maxSubArray(new int[]{1}) == 1 : "Failed test 2";
    assert maxSubArray(new int[]{5, 4, -1, 7, 8}) == 23 : "Failed test 3";
}

public int maxSubArray(int[] nums) {
    int max = nums[0];
    int currentPrefix = 0;

    for (int x : nums) {
        if (currentPrefix < 0) {
            currentPrefix = 0;
        }
        currentPrefix += x;
        max = Math.max(max, currentPrefix);
    }

    return max;
}
