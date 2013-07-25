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
   
    private String title;
    
    /** 原价  **/
    private long costprice;
    
    /** 折扣价 **/
    private long discountPrice;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getCostprice() {
        return costprice;
    }

    public void setCostprice(long costprice) {
        this.costprice = costprice;
    }

    public long getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(long discountPrice) {
        this.discountPrice = discountPrice;
    }
   
    
    
}
