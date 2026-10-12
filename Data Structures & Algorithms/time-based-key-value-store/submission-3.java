class TimeMap {
    class Helper {
        int timestamp;
        String value;

        public Helper(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
    
    HashMap<String, ArrayList<Helper>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)) {
            map.get(key).add(new Helper(timestamp, value));

        } else {
            ArrayList<Helper> arr = new ArrayList<>();
            arr.add(new Helper(timestamp, value));
            map.put(key, arr);
        }
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        ArrayList<Helper> arr = map.get(key);
        int lo = 0;
        int hi = arr.size() - 1;
        Helper closest = null;

        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            
            Helper m = arr.get(mid);
            
            if (m.timestamp == timestamp) {
                return m.value;
            }

            if (m.timestamp > timestamp) {
                hi = mid - 1;
            } else {
                closest = m;
                lo = mid + 1;
            }
        }

        return closest == null ? "" : closest.value;
        
    }
}











