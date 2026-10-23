/// https://leetcode.com/problems/remove-element/submissions/
public int removeElement(int[] nums, int val) {
    int lastIdx = nums.length - 1;
    for (int i = 0; i <= lastIdx; i++) {
        if (nums[i] == val) {
            nums[i] = nums[lastIdx];
            lastIdx--;
            i--;
        }
    }

    return lastIdx + 1;
}

void main() {
    assert removeElement(new int[] { 4, 5 }, 5) == 1;
    assert removeElement(new int[] { 3, 2, 2, 3 }, 3) == 2;
    assert removeElement(new int[] { 3, 3 }, 3) == 0;
    assert removeElement(new int[] { 3 }, 3) == 0;
}
