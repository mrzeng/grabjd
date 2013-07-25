/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grabjd;

import grabjd.dto.Link;
import grabjd.service.LinkService;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author cz
 */
public class Grab implements Runnable {

    private ApplicationContext ac;

    public Grab(ApplicationContext ac) {
        this.ac = ac;
    }

    @Override
    public void run() {
        LinkService linkService = ac.getBean("linkService", LinkService.class);
        while (true) {
            List<Link> linkList = linkService.getExeLink();
            for (Link link : linkList) {
                try {
                    String url = link.getLinkUrl().trim();
                    Document doc = Jsoup.connect(url).get();
                    String title = doc.select("#btAsinTitle").text();
                    String costPrice = doc.select("#listPriceValue").text();
                    String discountPrice = doc.select(".priceLarge").text();
                    System.out.println(title + "@@@@@@@@@@@@@@@" + costPrice + "@@@@@@@@@@@@" + discountPrice);
                    link.setEtime(System.currentTimeMillis() + link.getPeriod()*1000);
                    linkService.updateLinkEtime(link);
                } catch (IOException ex) {
                    Logger.getLogger(Grab.class.getName()).log(Level.SEVERE, null, ex);
                    continue;
                }
            }
        }
    }
}
