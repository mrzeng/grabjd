/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grabjd;

import grabjd.dto.Goods;
import grabjd.dto.Link;
import grabjd.service.GoodsService;
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
        GoodsService goodsService = ac.getBean("goodsService", GoodsService.class);
        while (true) {
            List<Link> linkList = linkService.getExeLink();
            for (Link link : linkList) {
                try {
                    String url = link.getLinkUrl().trim();

                    Document doc = Jsoup.connect(url).get();
                    String title = doc.select("#btAsinTitle").text().trim();
                    String costPrice = doc.select("#listPriceValue").text().trim();
                    String discountPrice = doc.select(".priceLarge").text().trim();
                    long cPrice = Long.valueOf(costPrice.split("\\s{1,}")[1].replace(".", "").replace(",", ""));
                    long dPrice = Long.valueOf(discountPrice.split("\\s{1,}")[1].replace(".", "").replace(",", ""));
                    Goods goods = goodsService.getGoods(title);
                    if (goods == null) {
                        goods = new Goods();
                        goods.setTitle(title);
                        goods.setCostprice(cPrice);
                        goods.setDiscountPrice(dPrice);
                        goodsService.saveGoods(goods);
                    } else{
                        goods.setCostprice(cPrice);
                        goods.setDiscountPrice(dPrice);
                        goodsService.updateGoods(goods);
                    }
                    link.setEtime(System.currentTimeMillis() + link.getPeriod() * 1000);
                    linkService.updateLinkEtime(link);

                } catch (IOException ex) {
                    Logger.getLogger(Grab.class.getName()).log(Level.SEVERE, null, ex);
                    continue;
                }
            }
        }
    }
}
