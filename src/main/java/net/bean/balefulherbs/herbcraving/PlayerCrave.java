package net.bean.balefulherbs.herbcraving;

import java.util.HashMap;

public class PlayerCrave
{
    private long kempConsumedTime;
    HashMap<String, Long> hashMap = new HashMap<>();

    {
        hashMap.put("kemp", 0L);
        hashMap.put("kemp_powder", 0L);
        hashMap.put("refined_kemp", 0L);
        hashMap.put("silver_speedberry", 0L);
        hashMap.put("silver_speedberry_powder", 0L);
        hashMap.put("refined_silver_speedberry", 0L);
    }

    public void setConsumedTime(String key, long time) {
        this.hashMap.put(key, time);
    }

    public long getConsumedTime(String key) {
        return this.hashMap.get(key);
    }


    public void setKempConsumedTime(long time) {
        this.kempConsumedTime = time;
    }

    public long getKempConsumedTime() {
        return this.kempConsumedTime;
    }

}
