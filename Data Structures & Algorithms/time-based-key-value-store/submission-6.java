class TimeItem {
    String value;
    int timestamp;

    TimeItem (String aValue, int aTimestamp) {
        value = aValue;
        timestamp = aTimestamp;
    }
}

class TimeMap {
    Map<String, List<TimeItem>> map;

    public TimeMap() {
        map = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList());
        }

        map.get(key).add(new TimeItem(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<TimeItem> list = map.get(key);
        if (list == null || list.isEmpty()) {
            return "";
        }

        int left = 0;
        int right = list.size() - 1;
        int middle;
        String res = "";

        while (left <= right) {
            middle = (left + right) / 2;

            if (timestamp < list.get(middle).timestamp) {
                right = middle - 1;
            } else {
                res = list.get(middle).value;
                left = middle + 1;
            }
        }

        return res;
    }
}
