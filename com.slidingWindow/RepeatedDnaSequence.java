public class RepeatedDnaSequence {
    public List<String> findRepeatedDnaSequences1(String s) {
        Map<String, Integer> hashMap = new HashMap<>();
        int n = s.length();
        List<String> ans = new ArrayList<>();
        if(n<=10)
            return ans;
        for(int i=0;i<=n-10;i++){
            String t = s.substring(i,i+10);
            hashMap.put(t, hashMap.getOrDefault(t,0)+1);
            if(hashMap.get(t) == 2) ans.add(t);
        }
        return ans;
    }
    //approach using the sliding window template
    public static List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        int begin = 0, end = 10;

        while (end <= s.length()) {
            String currentSequence = s.substring(begin, end);

            if (!seen.add(currentSequence)) {
                repeated.add(currentSequence);
            }

            // Move the window
            begin++;
            end++;
        }

        return new ArrayList<>(repeated);
    }
}