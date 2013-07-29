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
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author cz
 */
public class IconTableCellRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (column == 8) {
            GoodsTableModel goodsTableModle = (GoodsTableModel) table.getModel();
            String diffPriceStr = (String) goodsTableModle.getValueAt(row, 7);
            long diffPrice = new BigDecimal(diffPriceStr).longValue();
            if (diffPrice > 0) {
                String imgUrl = System.getProperty("user.dir") + "/src/com/sound/icn_best.gif";
                ImageIcon icon = new ImageIcon(imgUrl);
                JLabel label = new JLabel(icon);
                label.setOpaque(false);
                return label;
            }
        }
        return null;
    }
}