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
            String url = "http://www.amazon.cn/Apple-MD094CH-A-iMac-21-5%E8%8B%B1%E5%AF%B8%E4%B8%80%E4%BD%93%E6%9C%BA/dp/B009X6I1OY/ref=sr_1_2?s=pc&ie=UTF8&qid=1375096310&sr=1-2";
            Document docu =  Jsoup.connect(url).get();
            System.out.println( docu.html());
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
