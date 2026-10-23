/// https://leetcode.com/problems/longest-common-prefix
void main() {
    System.out.println(longestCommonPrefix(new String[] { "ab", "a" }));
}

public String longestCommonPrefix(String[] strs) {
    StringBuilder b = new StringBuilder();

    for (int i = 0; i < strs[0].length(); i++) {
        for (int j = 1; j < strs.length; j++) {
            if (strs[j].length() <= i || strs[j].charAt(i) != strs[0].charAt(i)) {
                return b.toString();
            }
        }
        b.append(strs[0].charAt(i));
    }

    return b.toString();
}
