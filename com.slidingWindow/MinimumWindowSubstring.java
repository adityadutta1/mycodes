public class MinimumWindowSubstring {
    //minimum window substring , minimum window subsequence
        public String minWindow(String s, String t) {
            if(t.length()> s.length()) return "";
            Map<Character, Integer> map = new HashMap<>();
            for(char c : t.toCharArray()){
                map.put(c, map.getOrDefault(c,0) + 1);
            }
            int counter = map.size();

            int begin = 0, end = 0;
            int head = 0;
            int len = Integer.MAX_VALUE;

            while(end < s.length()){
                char c = s.charAt(end);
                if( map.containsKey(c) ){
                    map.put(c, map.get(c)-1);
                    if(map.get(c) == 0) counter--;
                }
                end++;

                //we would have checked by end and begin pointer then end would have
                //increased after below while loop
                //but here we check the counter condition
                while(counter == 0){
                    // counter means this windows contains  full target string
                    char tempc = s.charAt(begin);// this means like reset the first begin and find at end if found then calculate the curr substring size()
                    if(map.containsKey(tempc)){
                        map.put(tempc, map.get(tempc) + 1);
                        if(map.get(tempc) > 0){
                            counter++;
                        }
                    }
                    if(end-begin < len){
                        len = end - begin;
                        head = begin;
                    }
                    begin++;
                }

            }
            if(len == Integer.MAX_VALUE) return "";
            return s.substring(head, head+len);
        }

}
