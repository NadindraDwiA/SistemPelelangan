package auction;

import Koneksi.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Bid extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Statement st = null;
    int key;

    //membuat objek baru dari kelas Bids yang sudah terkoneksi dengan database
    Bids ab = new Bids();

    public Bid() {
        initComponents();
        setLocationRelativeTo(this);
    }

    public Bid(int id_barang) {
        this.key = id_barang;
        initComponents();
        setLocationRelativeTo(this);
        setItem();
    }

    //method untuk reset text
    public void reset_text() {
        harga_tawar.setText("");
    }

    public void setItem() {
        id_barang.setText(String.valueOf(key));
        
        String Query = "select * from barangs where ID = " + key;
        try {
            con = new Koneksi().konek();
            st = con.createStatement();
            rs = st.executeQuery(Query);
            if (rs.next()) {
                nama_barang.setText(rs.getString("nama_barang"));
                harga_min.setText(rs.getString("harga"));
            }
        } catch (Exception e) {
            System.out.println("Error Set: " + e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        harga_tawar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        id_barang = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        nama_barang = new javax.swing.JLabel();
        harga_min = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack.setBackground(new java.awt.Color(204, 204, 204));
        btnBack.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(0, 51, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bid Form");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 70));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Harga Tawar");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 360, -1));

        harga_tawar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(harga_tawar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 180, 40));

        jButton1.setBackground(new java.awt.Color(0, 102, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Bid");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, 110, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 255));
        jLabel6.setText("ID Barang");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, 30));

        id_barang.setEditable(false);
        id_barang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(id_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 160, 30));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 360, 10));

        nama_barang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nama_barang.setForeground(new java.awt.Color(0, 102, 255));
        nama_barang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nama_barang.setText("Nama Barang");
        jPanel1.add(nama_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 360, -1));

        harga_min.setEditable(false);
        harga_min.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        harga_min.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                harga_minActionPerformed(evt);
            }
        });
        jPanel1.add(harga_min, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 160, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 255));
        jLabel3.setText("Min. Harga");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (harga_tawar.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Maaf, Tawaran belum diisi !");
            harga_tawar.requestFocus();
        } else {
            
            if(Integer.valueOf(harga_tawar.getText()) < Integer.valueOf(harga_min.getText())){
                JOptionPane.showMessageDialog(this, "Tawaran anda di bawah harga minimum, Naikkan tawaran!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }else {
                try {
                    ab.setHargaTawar(Integer.parseInt(harga_tawar.getText()));
                    ab.simpanData(id_barang.getText(), ab.getHargaTawar());
                    JOptionPane.showMessageDialog(this, "Berhasil Melakukan Bid!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                    reset_text();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Gagal Melakukan Bid!", "Gagal", JOptionPane.ERROR_MESSAGE);
                    System.err.println("Parameter yang dimasukkan salah");
                    System.err.println("Exception yang ditangkap adalah : " + ex);
                }
                dispose();
                DetailItem detail = new DetailItem(Integer.valueOf(id_barang.getText()));
                detail.setVisible(true);
            }
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        if (id_barang.getText().isEmpty()) {
            this.dispose();
            User user = new User();
            user.setVisible(true);
        } else {
            this.dispose();
            DetailItem detail = new DetailItem(Integer.valueOf(id_barang.getText()));
            detail.setVisible(true);
        }

    }//GEN-LAST:event_btnBackActionPerformed

    private void harga_minActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_harga_minActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_harga_minActionPerformed

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
            java.util.logging.Logger.getLogger(Bid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bid().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JTextField harga_min;
    private javax.swing.JTextField harga_tawar;
    javax.swing.JTextField id_barang;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel nama_barang;
    // End of variables declaration//GEN-END:variables
}
