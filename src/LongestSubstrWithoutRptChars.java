/// https://leetcode.com/problems/longest-substring-without-repeating-characters
void main() {
    assert lengthOfLongestSubstring("abcabcbb") == 3 : "Failed test 1";
    assert lengthOfLongestSubstring("bbbbb") == 1 : "Failed test 2";
    assert lengthOfLongestSubstring("pwwkew") == 3 : "Failed test 3";
}

public int lengthOfLongestSubstring(String s) {
    if (s.isEmpty()) {
        // useless ahh test case
        return 0;
    }

    // map to true if letter contributing to current substr
    HashMap<Character, Boolean> map = new HashMap<>();
    int start = 0;
    int longestSubstr = 1;
    map.put(s.charAt(0), true);
    for (int i = 1; i < s.length(); i++) {
        if (!map.containsKey(s.charAt(i)) || !map.get(s.charAt(i))) {
            // new character
            // huge for us
            map.put(s.charAt(i), true);
            longestSubstr = Math.max(longestSubstr, i - start + 1);
        } else {
            while (s.charAt(start) != s.charAt(i)) {
                map.put(s.charAt(start), false);
                start++;
            }
            start++;
        }
    }

    return longestSubstr;
}
