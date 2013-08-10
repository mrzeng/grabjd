/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grabjd.table;

import java.awt.Component;
import java.math.BigDecimal;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author cz
 */
public class IconTableCellRenderer extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        int newRow = table.convertRowIndexToModel(row);
        if (column == 1) {
            GoodsTableModel goodsTableModle = (GoodsTableModel) table.getModel();
            String diffPriceStr = (String) goodsTableModle.getValueAt(newRow, 7);
            String costPriceStr = (String) goodsTableModle.getValueAt(newRow, 3);
            long diffPrice = new BigDecimal(diffPriceStr).longValue();
            if (diffPrice > 0 && !"无货".equals(costPriceStr)) {
                ImageIcon icon = new ImageIcon(this.getClass().getResource("/grabjd/sound/icn_best.gif"));
                JLabel label = new JLabel(icon);
                label.setText(value.toString());
                label.setOpaque(false);
                return label;
            }else{
                JLabel label = new JLabel(value.toString());
                return label;
            }
        }
        return this;
    }
}
