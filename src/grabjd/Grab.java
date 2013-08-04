/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grabjd;

import grabjd.dto.Goods;
import grabjd.dto.Link;
import grabjd.service.GoodsService;
import grabjd.service.LinkService;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.context.ApplicationContext;
import sun.audio.AudioPlayer;

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
                    long costPrice = 0L;
                    long seckillPrice = 0L;
                    String costPriceStr = "";
                    String seckillPriceStr = "";
                    String url = link.getLinkUrl().trim();
                    Document doc = Jsoup.connect(url).get();
                    String title = doc.select("#btAsinTitle").text().trim();
                    String salesTitle = "";
                    if (title.indexOf("减") != -1) {
                        Pattern pt = Pattern.compile("\\d+减{1}\\d+");
                        Matcher matcher = pt.matcher(title);
                        while (matcher.find()) {
                            salesTitle = salesTitle + "," + matcher.group();
                        }
                    }
                    costPriceStr = doc.select(".priceLarge").text().trim();
                    costPriceStr = costPriceStr.split("\\s{1,}")[1].replaceAll(",", "");
                    costPrice = new BigDecimal(costPriceStr).multiply(new BigDecimal("100")).longValue();
                    Goods goods = goodsService.getGoods(title);
                    if (goods == null) {
                        goods = new Goods();
                        goods.setTitle(title);
                        goods.setSalesTitle(salesTitle);
                        goods.setCostPrice(costPrice);
                        goodsService.saveGoods(goods);
                    } else {
                        long discount_price = new BigDecimal(costPrice).multiply(new BigDecimal(goods.getDiscountRate())).divide(new BigDecimal("100")).longValue();
                        goods.setCostPrice(costPrice);
                        goods.setDiscountPrice(discount_price);
                        goods.setDiffPrice(goods.getManualPrice() - discount_price);
                        goodsService.updateGoods(goods);
                        if (goods.getDiffPrice() > 0) {
                            AudioPlayer.player.start(this.getClass().getResourceAsStream("/grabjd/sound/msg.wav"));
                        }
                    }
                    link.setEtime(System.currentTimeMillis() + link.getPeriod() * 1000);
                    linkService.updateLinkEtime(link);

                } catch (IOException ex) {
                    Logger.getLogger(Grab.class.getName()).log(Level.SEVERE, null, ex);
                    continue;
                } catch (Exception ex) {
                    Logger.getLogger(Grab.class.getName()).log(Level.SEVERE, null, ex);
                    continue;
                }
            }
        }
    }
}
