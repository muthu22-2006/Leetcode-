class Solution {
    String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    void bt(List<String> res, String digits, StringBuffer s, int i) {
        if (s.length() == digits.length()) {
            res.add(s.toString());
            return;
        }
        String letters = phone[digits.charAt(i) - '0'];
        for (char c : letters.toCharArray()) {
            s.append(c);
            bt(res, digits, s, i + 1);
            s.deleteCharAt(s.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res; 
        bt(res, digits, new StringBuffer(), 0);
        return res;
    }
}
