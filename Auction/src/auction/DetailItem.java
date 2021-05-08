package auction;

import Koneksi.Koneksi;
import java.awt.Image;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class DetailItem extends javax.swing.JFrame {

    Connection con = new Koneksi().konek();
    PreparedStatement pst = null;
    ResultSet rs = null;
    Statement st = null;
    String imgpath = null;
    DefaultTableModel tabelmodel;
    int key;

    public DetailItem() {
        initComponents();
        GetTable();

        tabelmodel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabel_bid.setModel(tabelmodel);
        tabelmodel.addColumn("Kode");
        tabelmodel.addColumn("Nama Barang");
        tabelmodel.addColumn("Penawar");
        tabelmodel.addColumn("Alamat");
        tabelmodel.addColumn("Tawaran");

        DisplayTable();
    }

    public DetailItem(int id_barang) {
        this.key = id_barang;
        initComponents();
        GetTable();

        tabelmodel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabel_bid.setModel(tabelmodel);
        tabelmodel.addColumn("Kode");
        tabelmodel.addColumn("Nama Barang");
        tabelmodel.addColumn("Penawar");
        tabelmodel.addColumn("Alamat");
        tabelmodel.addColumn("Tawaran");

        DisplayTable();
        setItem();
    }
    
    private ImageIcon ResizePhoto(String ImagePath, byte[] pic)
    {
        ImageIcon MyImage = null;
        if(ImagePath != null)
        {
            MyImage = new ImageIcon(ImagePath);
        }else{
            MyImage = new ImageIcon(pic);
        }
        Image img = MyImage.getImage();
        Image newimg = img.getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newimg);
        return image;
    }

    private void setItem() {
        String Query = "select * from barangs where ID = " + key;
        try{
            con = new Koneksi().konek();
            st = con.createStatement();
            rs = st.executeQuery(Query);
            if(rs.next())
            {
                image.setIcon(ResizePhoto(null, rs.getBytes("photo")));
                deskripsi.setText("Nama Barang : "+rs.getString("nama_barang")+"\nNama Penjual : "+rs.getString("nama_penjual")+"\nHarga Awal : "+rs.getInt("harga")+"\nPelelangan Dimulai Pada : "+rs.getString("mulai"));
                carapenawaran.setText("Open Bidding");
                batasakhir.setText(rs.getString("akhir"));
                id.setText(rs.getString("ID"));
            }
        }catch(Exception e){
            System.out.println("Error Set: " + e);
        }
    }

    private void GetTable() {
        try {
            st = con.createStatement();
            String Query = "SELECT * FROM bids";
            rs = st.executeQuery(Query);
        } catch (Exception e) {
            System.out.println("Error GetTable: " + e);
        }
    }

    private void DisplayTable() {
        tabelmodel.getDataVector().removeAllElements();
        tabelmodel.fireTableDataChanged();
        try {
            Statement state = con.createStatement();
            String sql = "SELECT bids.*, barangs.nama_barang FROM bids JOIN barangs ON bids.id_barang = barangs.ID WHERE bids.id_barang = " + key + " ORDER BY bids.harga_tawar DESC";

            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                Object obj[] = new Object[5];
                obj[0] = rs.getString("kode");
                obj[1] = rs.getString("nama_barang");
                obj[2] = rs.getString("nama");
                obj[3] = rs.getString("alamat");
                obj[4] = rs.getString("harga_tawar");

                tabelmodel.addRow(obj);
            }
        } catch (Exception ex) {
            System.out.println("Error Display Table: " + ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        deskripsi = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_bid = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        batasakhir = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        carapenawaran = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        image.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 160));

        deskripsi.setEditable(false);
        deskripsi.setColumns(20);
        deskripsi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        deskripsi.setRows(5);
        jScrollPane2.setViewportView(deskripsi);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 570, 160));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 0, 820, 160));

        jPanel3.setBackground(new java.awt.Color(0, 102, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack.setBackground(new java.awt.Color(255, 255, 255));
        btnBack.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(0, 102, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel3.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        tabel_bid.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode", "Nama Penawar", "Alamat", "Harga Tawar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabel_bid);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 430, 220));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Penawar");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 490, 70));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 490, 360));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        batasakhir.setEditable(false);
        batasakhir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        batasakhir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batasakhirActionPerformed(evt);
            }
        });
        jPanel4.add(batasakhir, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 250, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Batas Akhir Pelelangan");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, 30));

        id.setEditable(false);
        id.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        jPanel4.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 250, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Kode Lelang");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, 30));
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 74, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Cara Penawaran");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, 30));

        carapenawaran.setEditable(false);
        carapenawaran.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        carapenawaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carapenawaranActionPerformed(evt);
            }
        });
        jPanel4.add(carapenawaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 250, 30));

        jButton1.setBackground(new java.awt.Color(0, 102, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Ikut Lelang");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 280, 130, 40));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, 330, 360));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void batasakhirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batasakhirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_batasakhirActionPerformed

    private void carapenawaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carapenawaranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carapenawaranActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        Bid form = new Bid(Integer.valueOf(id.getText()));
        form.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        if (Auth.role == "admin") {
            this.dispose();
            Admin adm = new Admin();
            adm.setVisible(true);
        } else {
            this.dispose();
            User usr = new User();
            usr.setVisible(true);
        }
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(DetailItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetailItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetailItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetailItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetailItem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField batasakhir;
    public javax.swing.JButton btnBack;
    public javax.swing.JTextField carapenawaran;
    public javax.swing.JTextArea deskripsi;
    public javax.swing.JTextField id;
    public javax.swing.JLabel image;
    public javax.swing.JButton jButton1;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel4;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tabel_bid;
    // End of variables declaration//GEN-END:variables

}
