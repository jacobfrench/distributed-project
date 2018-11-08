/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributedproject;

import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import distributedproject.p2p.Client;
import distributedproject.p2p.PortScanner;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import javax.swing.ListSelectionModel;
import javax.swing.text.DefaultCaret;

/**
 *
 * @author Jacob French
 */
public class MainWindow extends javax.swing.JFrame {

    private String alias;
    private String destIp;
    private Client client;
    private PortScanner portScanner;
    private Vector<String> peers;

    /**
     * Creates new form MainWindow
     */
    public MainWindow() throws SocketException {
        initComponents();
        this.chatArea.setFocusable(false);
        DefaultCaret caret = (DefaultCaret) chatArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        peers = new Vector<String>();
        peerList.setListData(peers);
        peerList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        alias = "Anon";
        connectToClient();

    }

    /*
    * This method establishes a connection to a client on port 8000.
    * the destination ip (destIp) determines which IP address will recieve 
    * any message sent on this window.
    */
    private void connectToClient() {
        try {
            client = new Client(destIp, chatArea, 8000, 8000);
            portScanner = new PortScanner(this.peerList, this.client.getClientIp());
        } catch (SocketException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        southPanel = new javax.swing.JPanel();
        messageField = new javax.swing.JTextField();
        sendButton = new javax.swing.JButton();
        scanButton = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        ipField = new javax.swing.JTextField();
        ipButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        chatArea = new javax.swing.JTextArea();
        aliasField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        rightPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        peerList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainPanel.setLayout(new java.awt.BorderLayout());

        messageField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageFieldActionPerformed(evt);
            }
        });

        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        scanButton.setText("Scan Peers");
        scanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scanButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Message");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                directMessageButton(evt);
            }
        });

        ipButton.setText("Add IP");
        ipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addIPbutton(evt);
            }
        });

        javax.swing.GroupLayout southPanelLayout = new javax.swing.GroupLayout(southPanel);
        southPanel.setLayout(southPanelLayout);
        southPanelLayout.setHorizontalGroup(
            southPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, southPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(southPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(southPanelLayout.createSequentialGroup()
                        .addComponent(ipField, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ipButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(southPanelLayout.createSequentialGroup()
                        .addComponent(messageField, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sendButton)))
                .addContainerGap())
        );
        southPanelLayout.setVerticalGroup(
            southPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, southPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(southPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scanButton)
                    .addComponent(jButton1)
                    .addComponent(ipField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ipButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(southPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sendButton)
                    .addComponent(messageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        MainPanel.add(southPanel, java.awt.BorderLayout.PAGE_END);

        chatArea.setEditable(false);
        chatArea.setColumns(20);
        chatArea.setRows(5);
        jScrollPane2.setViewportView(chatArea);

        jLabel2.setText("Alias:");

        rightPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        peerList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "User 1", "User 2", "User 3", "User 4", "User 5", " . . ." };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(peerList);

        rightPanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 50, 160, 420));

        jLabel1.setText("Available Peers");
        rightPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(aliasField, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(aliasField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(rightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        MainPanel.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(MainPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
     * This method is called whenever the port scan button is pressed. If the 
     * button is pressed down, a port scan will begin. Otherwise, the port scan
     * will stop.
    */
    private void scanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scanButtonActionPerformed
        if (scanButton.isSelected()) {
            peers.clear();
            portScanner.start();
            scanButton.setText("Click to Stop");
        } else {
            portScanner.stop();
            scanButton.setText("Scan Peers");
        }


    }//GEN-LAST:event_scanButtonActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        sendMessage();
    }//GEN-LAST:event_sendButtonActionPerformed

    private void messageFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageFieldActionPerformed
        sendMessage();
    }//GEN-LAST:event_messageFieldActionPerformed

    private void directMessageButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_directMessageButton
        //new DmWindow(peerList.getSelectedValue(), alias).setVisible(true);
        Hashtable yafeelme = new Hashtable(); 
        Enumeration aliases;
        String str;
        
        // change alias to current alias
        this.alias = this.aliasField.getText();
        yafeelme.put(alias, new String(ipField.getText()));        
        // show da Hash Table lawels
        aliases = yafeelme.keys();
        str = (String) aliases.nextElement();
        System.out.println(alias + ": " + yafeelme.get(str));
        String y = (String) (yafeelme.get(str)); /* gets ipAddr of user*/
        // get the ipAddr of that Alias
        new DmWindow(y, alias).setVisible(true);
        
    }//GEN-LAST:event_directMessageButton

    private void addIPbutton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addIPbutton
        /*
        * @editor Angel Rojas 
        */
        //peers.add(ipField.getText());
        //peerList.setListData(peers);
        Hashtable yafeelme = new Hashtable(); 
        Enumeration aliases;
        String str;
        
        // change alias to current alias
        this.alias = this.aliasField.getText();
            
        yafeelme.put(alias, new String(ipField.getText()));
                
        // show da Hash Table lawels
        aliases = yafeelme.keys();
                
        while(aliases.hasMoreElements()) {
            str = (String) aliases.nextElement();
            System.out.println(alias + ": " + yafeelme.get(str));
            String x = (String) (yafeelme.get(str)); /* gets ipAddr of user*/
            
            // add that current alias to our peerlist
            peers.add(alias);
            
            //System.out.println(x); /* testing the ipAddr of that Alias*/
        }        
        System.out.println();
        peerList.setListData(peers);
    }//GEN-LAST:event_addIPbutton

    
    /*
    * This method will send a message to every IP address found after a port scan.
    * if the IP is in the list on the right side, a message will be sent to that
    * address on port 8000.
    */
    public void sendMessage() {
        String message = messageField.getText();
        String sentMessage = "";
        this.alias = this.aliasField.getText();

        for (int i = 0; i < peerList.getModel().getSize(); i++) {
            destIp = peerList.getModel().getElementAt(i);
            if (!alias.equals("")) {
                client.setAlias(this.aliasField.getText());
            } else {
                client.setAlias("Anon");
            }
            if (!message.equals("")) {
                sentMessage = client.sendMessage(message, alias, destIp) + "\n";
                messageField.setText("");
            }
            

        }
        chatArea.append(sentMessage);



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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainWindow().setVisible(true);
                } catch (SocketException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    private javax.swing.JTextField aliasField;
    private javax.swing.JTextArea chatArea;
    private javax.swing.JButton ipButton;
    private javax.swing.JTextField ipField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField messageField;
    private javax.swing.JList<String> peerList;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JToggleButton scanButton;
    private javax.swing.JButton sendButton;
    private javax.swing.JPanel southPanel;
    // End of variables declaration//GEN-END:variables
}
