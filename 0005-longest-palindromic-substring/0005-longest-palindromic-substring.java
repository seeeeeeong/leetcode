class Solution {
    private int ansStart = 0;
    private int ansEnd = 0;

    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        if (n < 2) return s;

        for (int i = 0; i < n; i++) {
            expand(arr, i, i);
            expand(arr, i, i + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = ansStart; i <= ansEnd; i++) sb.append(arr[i]);

        return sb.toString();
    }

    private void expand(char[] arr, int left, int right) {
        while (left >= 0 && right < arr.length && arr[left] == arr[right]) {
            left--;
            right++;
        }

        int start = left + 1;
        int end = right - 1;

        if (end - start > ansEnd - ansStart) {
            ansStart = start;
            ansEnd = end;
        }
    }
}