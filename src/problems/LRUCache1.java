package problems;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * Another Method : LinkedHashMap --> LRU Cache
 * Not ACCEPTED
 * @author ls
 *
 */
public class LRUCache1 {

	private int capacity;
	private MyLinkedHashMap map = null;
	
	public LRUCache1(int capacity) {
        this.capacity = capacity;
        map = new MyLinkedHashMap();
    }
    
    public int get(int key) {
    	if(map.containsKey(key))
    		return map.get(key);
    	else
    		return -1;
    }
    
    public void set(int key, int value) {
    	map.put(key, value);
    }
    
    @SuppressWarnings("serial")
	public class MyLinkedHashMap extends LinkedHashMap<Integer, Integer> {
    	public MyLinkedHashMap() {
    		super(16, 0.75f, true);
    	}
		@Override
		protected boolean removeEldestEntry(Entry<Integer, Integer> eldest) {
			return ( size() > capacity );
		}
    }
}
