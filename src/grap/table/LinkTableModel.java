/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grap.table;

import grap.dto.Link;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cz
 */
public class LinkTableModel extends AbstractTableModel  {
    
    private String[] columnNames =  new String[]{"链接id","链接名字", "择取链接url", "执行周期"} ;
    private List<Link>  data;

    public LinkTableModel(List<Link> data) {
        this.data = data;
    }
   
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Link link = data.get(rowIndex);
        switch(columnIndex){
            case 0:
                return link.getId();
            case 1:
                return link.getLinkName();
            case 2:
                return link.getLinkUrl();
            case 3:
                return link.getPeriod();
        }
        return "";
    }
    
}
