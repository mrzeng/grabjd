/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grabjd;

import grabjd.panel.GoodsListPanel;
import grabjd.panel.LinkListPanel;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author cz
 */
public class GrabFrame extends javax.swing.JFrame {

    /**
     * Creates new form mframe
     */
    private ApplicationContext ctx;
    
    private JPanel tempJpanel;

    public GrabFrame() {
        ctx = new ClassPathXmlApplicationContext("classpath:/grabjd/SpringXMLConfig.xml");
        initComponents();
        this.tempJpanel = mainPanel;
        Thread grabThread = new Thread(new Grab(ctx));
        grabThread.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new JPanel();
        topMainJMenuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu grabLinkJMenu = new javax.swing.JMenu();
        goodsJMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("卓越商品抓取软件");

        mainPanel.setName(""); // NOI18N

        topMainJMenuBar.setFont(new java.awt.Font("宋体", 0, 12)); // NOI18N
        topMainJMenuBar.setPreferredSize(new java.awt.Dimension(90, 30));

        grabLinkJMenu.setText("抓取链接");
        grabLinkJMenu.setPreferredSize(new java.awt.Dimension(57, 30));
        grabLinkJMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grabLinkJMenuMouseClicked(evt);
            }
        });
        topMainJMenuBar.add(grabLinkJMenu);
        grabLinkJMenu.getAccessibleContext().setAccessibleName("grapLink");

        goodsJMenu.setText("商品");
        goodsJMenu.setPreferredSize(new java.awt.Dimension(33, 30));
        goodsJMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                goodsJMenuMouseClicked(evt);
            }
        });
        topMainJMenuBar.add(goodsJMenu);

        setJMenuBar(topMainJMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void grabLinkJMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grabLinkJMenuMouseClicked
        // TODO add your handling code here:
        JPanel rp = new LinkListPanel(ctx);
        replacePanle(rp);

    }//GEN-LAST:event_grabLinkJMenuMouseClicked

    private void goodsJMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goodsJMenuMouseClicked
        // TODO add your handling code here:
        JPanel rp = new GoodsListPanel(ctx);
        replacePanle(rp);
    }//GEN-LAST:event_goodsJMenuMouseClicked

    public void replacePanle(JPanel panel) {
        GroupLayout gl = (GroupLayout)getContentPane().getLayout();
        gl.replace(tempJpanel, panel); 
        this.tempJpanel = panel;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GrabFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GrabFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GrabFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GrabFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GrabFrame().setVisible(true);
            }
        });
    }

    public ApplicationContext getCtx() {
        return ctx;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu goodsJMenu;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar topMainJMenuBar;
    // End of variables declaration//GEN-END:variables
}
