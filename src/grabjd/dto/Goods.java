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
     
}
