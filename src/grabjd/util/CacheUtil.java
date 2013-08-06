/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grabjd.util;

import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author cz
 */
public class CacheUtil {
    private static Map<String,Boolean> cacheMap;
    
    static{
        cacheMap = new HashMap<>();
        cacheMap.put("setting", false);
    }
    
    public static Map<String,Boolean> getCacheMap(){
        return cacheMap;
    }
}
