/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grabjd.panel;

import grabjd.util.CacheUtil;

/**
 *
 * @author cz
 */
public class SettingJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SettingJPanel
     */
    public SettingJPanel() {
        initComponents();
        init();
    }
    
    private void init(){
        boolean setting = CacheUtil.getCacheMap().get("setting");
        if(setting){
             voiceJToggleButton.setActionCommand("close");
             voiceJToggleButton.setText("关闭");
        }else{
             voiceJToggleButton.setActionCommand("open");
             voiceJToggleButton.setText("开启");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form
     * Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        voiceJLabel1 = new javax.swing.JLabel();
        voiceJToggleButton = new javax.swing.JToggleButton();

        voiceJLabel1.setText("声音提示：");

        voiceJToggleButton.setText("关闭");
        voiceJToggleButton.setActionCommand("close");
        voiceJToggleButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                voiceJToggleButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(voiceJLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(voiceJToggleButton)
                .addContainerGap(269, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(voiceJLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(voiceJToggleButton))
                .addContainerGap(236, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void voiceJToggleButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voiceJToggleButtonMouseClicked
        // TODO add your handling code here:
        String actionCommand = voiceJToggleButton.getActionCommand();
        if("close".equals(actionCommand)){
            voiceJToggleButton.setActionCommand("open");
            voiceJToggleButton.setText("开启");
            CacheUtil.getCacheMap().put("setting",false);
        }else if("open".equals(actionCommand)){
            voiceJToggleButton.setActionCommand("close");
            voiceJToggleButton.setText("关闭");
            CacheUtil.getCacheMap().put("setting",true);
        }
    }//GEN-LAST:event_voiceJToggleButtonMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel voiceJLabel1;
    private javax.swing.JToggleButton voiceJToggleButton;
    // End of variables declaration//GEN-END:variables
}