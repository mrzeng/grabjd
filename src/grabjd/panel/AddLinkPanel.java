/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grabjd.panel;

import grabjd.GrabFrame;
import grabjd.dto.Link;
import grabjd.service.LinkService;
import java.util.Date;
import javax.swing.JOptionPane;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author cz
 */
public class AddLinkPanel extends javax.swing.JPanel {
    
    private ApplicationContext ctx;

    /**
     * Creates new form addLinkPanel
     */
    public AddLinkPanel(ApplicationContext ctx) {
        this.ctx = ctx;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form
     * Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LinkStatusButtonGroup = new javax.swing.ButtonGroup();
        linkUrlJLabel = new javax.swing.JLabel();
        linkUrlJTextField = new javax.swing.JTextField();
        periodJLabel = new javax.swing.JLabel();
        periodJTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        linkSave = new javax.swing.JButton();
        linkCla = new javax.swing.JButton();
        linkNameJLabel = new javax.swing.JLabel();
        linkNameJTextField = new javax.swing.JTextField();
        linkStatus = new javax.swing.JLabel();
        statusJRadioButtonStart = new javax.swing.JRadioButton();
        statusJRadioButtonStop = new javax.swing.JRadioButton();

        LinkStatusButtonGroup.add(statusJRadioButtonStart);
        LinkStatusButtonGroup.add(statusJRadioButtonStop);

        linkUrlJLabel.setText("url地址：");

        linkUrlJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkUrlJTextFieldActionPerformed(evt);
            }
        });

        periodJLabel.setText("扫描周期：");

        jLabel3.setText("秒");

        linkSave.setText("保存");
        linkSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkSaveActionPerformed(evt);
            }
        });

        linkCla.setText("取消");
        linkCla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkClaActionPerformed(evt);
            }
        });

        linkNameJLabel.setText("链接名称：");

        linkNameJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkNameJTextFieldActionPerformed(evt);
            }
        });

        linkStatus.setText("链接状态：");

        statusJRadioButtonStart.setSelected(true);
        statusJRadioButtonStart.setText("启动");
        statusJRadioButtonStart.setActionCommand("1");
        statusJRadioButtonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusJRadioButtonStartActionPerformed(evt);
            }
        });

        statusJRadioButtonStop.setText("停止");
        statusJRadioButtonStop.setActionCommand("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(linkUrlJLabel)
                            .addComponent(linkNameJLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(linkUrlJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(linkNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(linkStatus)
                            .addComponent(periodJLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(statusJRadioButtonStart)
                                .addGap(18, 18, 18)
                                .addComponent(statusJRadioButtonStop))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(linkSave)
                                .addGap(76, 76, 76)
                                .addComponent(linkCla))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(periodJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(linkNameJLabel)
                    .addComponent(linkNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(linkUrlJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(linkUrlJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(periodJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(periodJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(linkStatus)
                    .addComponent(statusJRadioButtonStart)
                    .addComponent(statusJRadioButtonStop))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(linkSave)
                    .addComponent(linkCla))
                .addContainerGap(112, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void linkUrlJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkUrlJTextFieldActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_linkUrlJTextFieldActionPerformed

    private void linkSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkSaveActionPerformed
        // TODO add your handling code here:
        String urlVal = linkUrlJTextField.getText();
        String linkNameVal = linkNameJTextField.getText();
        String periodJTextFieldVal = periodJTextField.getText();
        if(!NumberUtils.isDigits(periodJTextFieldVal)){
            JOptionPane.showMessageDialog(this, "扫描周期必须为整数");
            return;
        }
        long periodVal = Long.valueOf(periodJTextFieldVal);
        int statusVal = Integer.valueOf(LinkStatusButtonGroup.getSelection().getActionCommand());
        Date date = new Date();
        Link link = new Link();
        link.setPeriod(periodVal);
        link.setLinkUrl(urlVal);
        link.setEtime(date.getTime()+periodVal);
        link.setLinkName(linkNameVal);
        link.setStatus(statusVal);
        LinkService linkService = ctx.getBean("linkService",LinkService.class);
        linkService.saveLink(link);
        JOptionPane.showMessageDialog(this, "添加链接成功");
        linkUrlJTextField.setText("");
        periodJTextField.setText("");
        linkNameJTextField.setText("");
    }//GEN-LAST:event_linkSaveActionPerformed

    private void linkClaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkClaActionPerformed
        // TODO add your handling code here:
        GrabFrame frame = (GrabFrame)this.getParent().getParent().getParent().getParent();
        LinkListPanel llp = new LinkListPanel(ctx);
        frame.replacePanle(llp);
    }//GEN-LAST:event_linkClaActionPerformed

    private void linkNameJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkNameJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_linkNameJTextFieldActionPerformed

    private void statusJRadioButtonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusJRadioButtonStartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusJRadioButtonStartActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup LinkStatusButtonGroup;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton linkCla;
    private javax.swing.JLabel linkNameJLabel;
    private javax.swing.JTextField linkNameJTextField;
    private javax.swing.JButton linkSave;
    private javax.swing.JLabel linkStatus;
    private javax.swing.JLabel linkUrlJLabel;
    private javax.swing.JTextField linkUrlJTextField;
    private javax.swing.JLabel periodJLabel;
    private javax.swing.JTextField periodJTextField;
    private javax.swing.JRadioButton statusJRadioButtonStart;
    private javax.swing.JRadioButton statusJRadioButtonStop;
    // End of variables declaration//GEN-END:variables
}
