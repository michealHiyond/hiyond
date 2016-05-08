package server.tools;

import java.util.UUID;

/**
 * 
 * @author Hiyond
 *
 */
public class Tools {

    /**
     * 产生一个UUID字符串 
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString();
    }
    
}
