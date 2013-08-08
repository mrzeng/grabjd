/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grabjd.test;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author cz
 */
public class Test {
    public static void main(String[] args){
        try {
            String url = "http://www.amazon.cn/SAMSUNG-%E4%B8%89%E6%98%9F-Galaxy-Premier-I9260-%E6%99%BA%E8%83%BD3G%E6%89%8B%E6%9C%BA/dp/B00AMV9ZFS/ref=sr_1_1?s=wireless&ie=UTF8&qid=1375354391&sr=1-1&keywords=%E4%B8%89%E6%98%9F9260";
            Document docu =  Jsoup.connect(url).get();
            System.out.println( docu.html());
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
