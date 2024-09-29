 class TimeStoreProblem 
{
    HashMap<String, List<Pair<String, Integer>>> myMap;
    
    public TimeMap()
    {
        
        myMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) 
    {
        // constraints: timestamp is strictly increasing as real world is
        if(!myMap.containsKey(key))
            myMap.put(key, new ArrayList<>());
        
        myMap.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) 
    {
        //Can replace getOrdefault
       // if(!myMap.containsKey(key)) return "";
    
         List<Pair<String, Integer>> myList = myMap.getOrDefault(key,new ArrayList<>());
        int left = 0, right = myList.size() - 1;
        String  res = "";
        
        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            int time = myList.get(mid).getValue();
            
            //uncommenting this line will make it optimesd
           // if(time == timestamp)   return mid;
            
            // if all time in myList greater than timestamp, return -1 eventually.
     
     ///***THIS IS LOWERBOUND CODE BS */
     
            if(time <= timestamp)
            {//this is like lowerbound
                 res = myMap.get(key).get(mid).getKey();
                left = mid + 1;
            }
                
            else
            {//  and this our upperbound but we want lower bound
                right = mid - 1;
                // return largest time <= timestamp
                
                
            }
            
        }
        return res;
    }
}
