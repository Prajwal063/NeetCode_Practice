class TimeValue{
    String value;
    int time;
    
    public TimeValue(String value, int time){
        this.value = value;
        this.time = time;  
    }
}

class TimeMap {
   
    Map<String, List<TimeValue>> map = new HashMap();
    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        List<TimeValue> li = map.get(key);
        map.get(key).add(new TimeValue(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) 
            return "";
        return binarySearchMethod(map.get(key), timestamp);
    }
    
    public String binarySearchMethod(List<TimeValue> list, int timestamp){
        int low = 0;
        int high = list.size() - 1;
        
        while(low < high){
            int mid = (low + high) / 2;
            
            if(list.get(mid).time == timestamp){
                return list.get(mid).value;
            }
            else if(timestamp > list.get(mid).time){
                if(timestamp < list.get(mid + 1).time){
                    return list.get(mid).value;
                }
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return list.get(low).time <= timestamp ? list.get(low).value : "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */