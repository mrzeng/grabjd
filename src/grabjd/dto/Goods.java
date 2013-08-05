/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grabjd.dto;

/**
 *
 * @author cz
 */
public class Goods {
   
    private long id;
    
    private String title;
      
    private String salesTitle;
    
    /** 原价  **/
    private long costPrice;
    
    /** 秒杀价 **/
    private long seckillPrice;
        
    /** 折扣价 **/
    private long discountPrice;
    
    private long manualPrice;
    
    private long diffPrice;
    
    private long discountRate;
    
    private String link;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(long costPrice) {
        this.costPrice = costPrice;
    }

    public long getSeckillPrice() {
        return seckillPrice;
    }

    public void setSeckillPrice(long seckillPrice) {
        this.seckillPrice = seckillPrice;
    }

    public long getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(long discountPrice) {
        this.discountPrice = discountPrice;
    }

    public long getManualPrice() {
        return manualPrice;
    }

    public void setManualPrice(long manualPrice) {
        this.manualPrice = manualPrice;
    }

    public long getDiffPrice() {
        return diffPrice;
    }

    public void setDiffPrice(long diffPrice) {
        this.diffPrice = diffPrice;
    }

    public String getSalesTitle() {
        return salesTitle;
    }

    public void setSalesTitle(String salesTitle) {
        this.salesTitle = salesTitle;
    }

    public long getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(long discountRate) {
        this.discountRate = discountRate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
    @Override
    public String toString() {
        return "Goods{" + "id=" + id + ", title=" + title + ", salesTitle=" + salesTitle + ", costPrice=" + costPrice + ", seckillPrice=" + seckillPrice + ", discountPrice=" + discountPrice + ", manualPrice=" + manualPrice + ", diffPrice=" + diffPrice + '}';
    }
     
}
