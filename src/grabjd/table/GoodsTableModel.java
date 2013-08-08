/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grabjd.table;

import grabjd.dto.Goods;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import org.apache.commons.lang3.math.NumberUtils;

/**
 *
 * @author cz
 */
public class GoodsTableModel extends AbstractTableModel {

    private String[] columnNames = new String[]{"商品id","商品名称", "商品优惠", "网站价格", "秒杀价格", "折扣价格", "手动报价", "差价",""};
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
                return goods.getId();
            case 1:
                return goods.getTitle();
            case 2:
                return goods.getSalesTitle();
            case 3:
                String costPrice = convertPrice(goods.getCostPrice());
                return costPrice ;
            case 4:
                return convertPrice(goods.getSeckillPrice());
            case 5:
                return convertPrice(goods.getDiscountPrice());
            case 6:
                return convertPrice(goods.getManualPrice());
            case 7:
                return convertPrice(goods.getDiffPrice());

        }
        return "";
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 6) {
            return true;
        }
        return false;
    }

    public String convertPrice(long price) {
       return new BigDecimal(String.valueOf(price)).divide(new BigDecimal("100")).toString();
    }
    
    public long convertPrice(String sprice){
       return new BigDecimal(sprice).multiply(new BigDecimal("100")).longValue();
    }

    public void setData(List<Goods> data) {
        this.data = data;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (NumberUtils.isNumber(String.valueOf(aValue))) {
            Goods goods = data.get(rowIndex);
            switch (columnIndex) {
                case 6:
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

    public List<Goods> getData() {
        return data;
    }
    
    
}
