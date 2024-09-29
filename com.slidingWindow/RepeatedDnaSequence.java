public class RepeatedDnaSequence {
    public List<String> findRepeatedDnaSequences(String s) {
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
}