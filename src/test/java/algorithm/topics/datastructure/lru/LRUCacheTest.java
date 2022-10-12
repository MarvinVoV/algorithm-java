package algorithm.topics.datastructure.lru;

import algorithm.datastructure.lru.LRUCache;
import org.junit.jupiter.api.Test;

/**
 * @author hufeng
 * @version LRUCacheTest.java, v 0.1 2021/2/17 09:46 Exp $
 */

class LRUCacheTest {
    @Test
    public void testLRUCache() {
        LRUCache cache = new LRUCache(2);

        cache.set(1, 10);

        cache.set(2, 20);

        System.out.println("Value for the key: 1 is " + cache.get(1));

        // evicts key 2 and store key 3 with value 30 in the cache
        cache.set(3, 30);

        System.out.println("Value for the key: 2 is " + cache.get(2));

        // evicts key 1 and store key 4 with value 40 in the cache
        cache.set(4, 40);

        System.out.println("Value for the key: 1 is " + cache.get(1));

        System.out.println("Value for the key: 3 is " + cache.get(3));
        System.out.println("Value for the key: 4 is " + cache.get(4));
    }

}