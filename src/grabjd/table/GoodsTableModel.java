/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grabjd.table;

import grabjd.dto.Goods;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import org.apache.commons.lang.math.NumberUtils;

/**
 *
 * @author cz
 */
public class GoodsTableModel extends AbstractTableModel {

    private String[] columnNames = new String[]{"商品名称", "商品优惠", "网站价格", "秒杀价格", "折扣价格", "手动报价", "差价"};
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
        switch (columnIndex) {
            case 0:
                return goods.getTitle();
            case 1:
                return goods.getSalesTitle();
            case 2:
                return convertPrice(goods.getCostPrice());
            case 3:
                return convertPrice(goods.getSeckillPrice());
            case 4:
                return convertPrice(goods.getDiscountPrice());
            case 5:
                return convertPrice(goods.getManualPrice());
            case 6:
                return convertPrice(goods.getDiffPrice());
        }
        return "";
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 5) {
            return true;
        }
        return false;
    }

    public String convertPrice(long price) {
        String priceStr = "";
        if (price % 10000 == 0) {
            priceStr = String.valueOf(price / 10000) + ".00";
        } else {
            priceStr = String.valueOf(price / 10000) + "." + String.valueOf(price % 10000).substring(0,2);
        }
        return priceStr;
    }
    
    public long convertPrice(String sprice){
      Long lsprice = 0L;
      String sprices[] =  sprice.split("\\.");
      if(sprices.length == 2){
          lsprice = Long.valueOf(sprices[0] + sprices[1]) * 100;
      }else{
           lsprice = Long.valueOf(sprice)* 100;
      }
      return lsprice;
    }

    public void setData(List<Goods> data) {
        this.data = data;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (NumberUtils.isNumber(String.valueOf(aValue))) {
            Goods goods = data.get(rowIndex);
            switch (columnIndex) {
                case 5:
                    goods.setManualPrice(convertPrice(aValue.toString()));
            }
            fireTableCellUpdated(rowIndex, columnIndex);
        } else {
            JOptionPane.showMessageDialog(null, "请输入数字");
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }
}
