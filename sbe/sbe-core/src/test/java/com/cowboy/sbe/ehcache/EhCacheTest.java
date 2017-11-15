package com.cowboy.sbe.ehcache;/**
 * Created by Administrator on 2017/11/14/0014.
 */

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * @author Tangynbo
 * @version 1.0
 * @create 2017-11-14 15:16
 **/
public class EhCacheTest {
        public static void main(String[] args) throws Exception {
            // Create a cache manager
            final CacheManager cacheManager = new CacheManager();

            // create the cache called "helloworld"
            final Cache cache = cacheManager.getCache("helloworld");

            // create a key to map the data to
            final String key = "greeting";

            // Create a data element
            final Element putGreeting = new Element(key, "Hello, World!");

            // Put the element into the data store
            cache.put(putGreeting);
            Element element2 = new Element("kaka","ddd");
            cache.put(element2);

            //Thread.sleep(20000);

            // Retrieve the data element
            final Element getGreeting = cache.get(key);

            // Print the value
            System.out.println(getGreeting.getObjectValue());
            System.out.println("-----------------------");
        }
}
