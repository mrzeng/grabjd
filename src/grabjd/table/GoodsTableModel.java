/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grabjd.table;

import grabjd.dto.Goods;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cz
 */
public class GoodsTableModel extends  AbstractTableModel{
    
    private String[] columnNames =  new String[]{"商品id","商品名称", "商品原价", "商品折扣价"} ;
    private List<Goods> data;

    public GoodsTableModel(List<Goods> data) {
        this.data = data;
    }
   
   
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
    

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Goods goods = data.get(rowIndex);
        switch(columnIndex){
            case 0:
                return goods.getId();
            case 1:
                return goods.getTitle();
            case 2:
                String costPriceStr = "";
                long costPrice = goods.getCostprice();
                if(costPrice % 100 == 0){
                   costPriceStr = costPrice / 100 + ".00"; 
                }else{
                   costPriceStr = String.valueOf(costPrice/100) + String.valueOf(costPrice % 100);
                }
                return costPriceStr;
            case 3:
                String discountPriceStr = "";
                long discountPrice = goods.getDiscountPrice();
                if(discountPrice % 100 == 0){
                   discountPriceStr = discountPrice / 100 + ".00"; 
                }else{
                   discountPriceStr = String.valueOf(discountPrice/100) + String.valueOf(discountPrice % 100);
                } 
                return discountPriceStr;
        }
        return "";
    } 

    public void setData(List<Goods> data) {
        this.data = data;
    }
    
    
}
