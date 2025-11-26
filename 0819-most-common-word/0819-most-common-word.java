class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] letterList = paragraph.replaceAll("[^A-Za-z]", " ").toLowerCase().split(" ");
        Set<String> banSet = new HashSet<>();
        for (String ban : banned) {
            banSet.add(ban);
        }

        Map<String, Integer> result = new HashMap<>();

        for(String letter : letterList) {
            if (letter.isEmpty()) continue;
            if (!banSet.contains(letter)) {
                result.put(letter, result.getOrDefault(letter, 0) + 1);
            }
        }

        return Collections.max(result.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}