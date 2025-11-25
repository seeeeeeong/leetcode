class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letterList = new ArrayList<>();
        List<String> digitList = new ArrayList<>();

        for (String log : logs) {
            char[] s = log.toCharArray();

            if (Character.isDigit(s[s.length - 1])) {
                digitList.add(log);
            } else {
                letterList.add(log);
            }
        }

        letterList.sort((s1, s2) -> {
            String[] x1 = s1.split(" ", 2);
            String[] x2 = s2.split(" ", 2);

            int compare = x1[1].compareTo(x2[1]);
            if (compare == 0) {
                return x1[0].compareTo(x2[0]);
            } else {
                return compare;
            }
        });

        letterList.addAll(digitList);

        return letterList.toArray(new String[0]);
    }
}