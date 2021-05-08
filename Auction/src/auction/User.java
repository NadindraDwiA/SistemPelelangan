/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction;

import Koneksi.Koneksi;
import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public final class User extends javax.swing.JFrame implements Halaman {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Statement st = null;
    String imgpath = null;
    DefaultTableModel tabelmodel;

    public User() {
        initComponents();
        GetTable();

        tabelmodel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabel_barang.setModel(tabelmodel);
        tabelmodel.addColumn("ID");
        tabelmodel.addColumn("Nama Barang");
        tabelmodel.addColumn("Nama Penjual");
        tabelmodel.addColumn("Harga");
        tabelmodel.addColumn("Photo");
        tabelmodel.addColumn("Mulai");
        tabelmodel.addColumn("Akhir");

        DisplayTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_barang = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        image = new javax.swing.JLabel();
        detailbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabel_barang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nama Barang", "Nama Penjual", "Harga"
            }
        ));
        tabel_barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_barangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_barang);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 550, 330));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Daftar Barang");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 260, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 460));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));
        jDesktopPane1.setMaximumSize(new java.awt.Dimension(227, 164));
        jDesktopPane1.setMinimumSize(new java.awt.Dimension(227, 164));
        jDesktopPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        image.setMaximumSize(new java.awt.Dimension(227, 164));
        image.setMinimumSize(new java.awt.Dimension(227, 164));
        image.setPreferredSize(new java.awt.Dimension(227, 164));
        jDesktopPane1.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 190));

        jPanel2.add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 240, 190));

        detailbtn.setBackground(new java.awt.Color(0, 102, 255));
        detailbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        detailbtn.setForeground(new java.awt.Color(255, 255, 255));
        detailbtn.setText("Detail");
        detailbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailbtnActionPerformed(evt);
            }
        });
        jPanel2.add(detailbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 104, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 280, 460));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    int Key = 0;

    private ImageIcon ResizePhoto(String ImagePath, byte[] pic) {
        ImageIcon MyImage = null;
        if (ImagePath != null) {
            MyImage = new ImageIcon(ImagePath);
        } else {
            MyImage = new ImageIcon(pic);
        }
        Image img = MyImage.getImage();
        Image newimg = img.getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newimg);
        return image;
    }
    private void detailbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailbtnActionPerformed
        detail();
    }//GEN-LAST:event_detailbtnActionPerformed

    private void tabel_barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_barangMouseClicked
        DefaultTableModel model = (DefaultTableModel) tabel_barang.getModel();
        int MyIndex = tabel_barang.getSelectedRow();
        Key = Integer.valueOf(model.getValueAt(MyIndex, 0).toString());
        model.getValueAt(MyIndex, 0);
        model.getValueAt(MyIndex, 1);
        model.getValueAt(MyIndex, 2);
        model.getValueAt(MyIndex, 3);
        FetchPhoto();
    }//GEN-LAST:event_tabel_barangMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | javax.swing.UnsupportedLookAndFeelException | IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new User().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton detailbtn;
    public javax.swing.JLabel image;
    public javax.swing.JDesktopPane jDesktopPane1;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tabel_barang;
    // End of variables declaration//GEN-END:variables

    @Override
    public void add() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void detail() {
        if(Key == 0){
            JOptionPane.showMessageDialog(this, "Tidak ada barang yang dipilih!");
        }else {
            DetailItem dtlitem = new DetailItem(Key);
            dtlitem.setVisible(true);
            dispose();
        }
        
    }

    @Override
    public void GetTable() {
        try {
            con = new Koneksi().konek();
            st = con.createStatement();
            String Query = "SELECT * FROM 'barangs'";
            rs = st.executeQuery(Query);
        } catch (Exception e) {
        }
    }

    @Override
    public void DisplayTable() {

        tabelmodel.getDataVector().removeAllElements();
        tabelmodel.fireTableDataChanged();
        try {
            con = new Koneksi().konek();
            Statement state = con.createStatement();
            String sql = "SELECT * FROM barangs";

            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                Object obj[] = new Object[7];
                obj[0] = rs.getString("ID");
                obj[1] = rs.getString("nama_barang");
                obj[2] = rs.getString("nama_penjual");
                obj[3] = rs.getString("harga");
                obj[4] = rs.getBlob("photo");
                obj[5] = rs.getString("mulai");
                obj[6] = rs.getString("akhir");

                tabelmodel.addRow(obj);
            }
        } catch (Exception ex) {
            System.out.println("Error Display Table: " + ex);
        }
    }

    @Override
    public void FetchPhoto() {
        String Query = "select photo from barangs where ID=" + Key;
        try {
            con = new Koneksi().konek();
            st = con.createStatement();
            rs = st.executeQuery(Query);
            if (rs.next()) {
                image.setIcon(ResizePhoto(null, rs.getBytes("photo")));
            }
        } catch (Exception e) {

        }
    }
}
