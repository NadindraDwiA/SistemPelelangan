package auction;

import Koneksi.Koneksi;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public final class Admin extends javax.swing.JFrame implements Halaman {

    Connection con = new Koneksi().konek();
    PreparedStatement pst = null;
    ResultSet rs = null;
    Statement st = null;
    DefaultTableModel tabelmodel;

    public Admin() {
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nama_barang = new javax.swing.JTextField();
        ID = new javax.swing.JTextField();
        harga = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nama_penjual = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        mulai = new com.toedter.calendar.JDateChooser();
        akhir = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        addbtn = new javax.swing.JButton();
        editbtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
        uploadbtn = new javax.swing.JButton();
        detailbtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_barang = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        image = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Nama Barang");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Harga");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, -1, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("ID");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 30));
        jPanel1.add(nama_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 150, 30));

        ID.setEditable(false);
        ID.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 150, 30));
        jPanel1.add(harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 160, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Nama Penjual");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, -1, 30));
        jPanel1.add(nama_penjual, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 160, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Mulai");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Akhir");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, -1, 30));

        mulai.setBackground(new java.awt.Color(255, 255, 255));
        mulai.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(mulai, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 150, 30));

        akhir.setBackground(new java.awt.Color(255, 255, 255));
        akhir.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(akhir, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, 160, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 670, 170));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addbtn.setBackground(new java.awt.Color(0, 102, 255));
        addbtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addbtn.setForeground(new java.awt.Color(255, 255, 255));
        addbtn.setText("Add");
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });
        jPanel2.add(addbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 80, 40));

        editbtn.setBackground(new java.awt.Color(0, 102, 255));
        editbtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        editbtn.setForeground(new java.awt.Color(255, 255, 255));
        editbtn.setText("Edit");
        editbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtnActionPerformed(evt);
            }
        });
        jPanel2.add(editbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 80, 40));

        deletebtn.setBackground(new java.awt.Color(0, 102, 255));
        deletebtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        deletebtn.setForeground(new java.awt.Color(255, 255, 255));
        deletebtn.setText("Delete");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });
        jPanel2.add(deletebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 80, 40));

        uploadbtn.setBackground(new java.awt.Color(0, 102, 255));
        uploadbtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        uploadbtn.setForeground(new java.awt.Color(255, 255, 255));
        uploadbtn.setText("Upload");
        uploadbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadbtnActionPerformed(evt);
            }
        });
        jPanel2.add(uploadbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, 40));

        detailbtn.setBackground(new java.awt.Color(0, 102, 255));
        detailbtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        detailbtn.setForeground(new java.awt.Color(255, 255, 255));
        detailbtn.setText("Detail");
        detailbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailbtnActionPerformed(evt);
            }
        });
        jPanel2.add(detailbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, 73, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 920, 80));

        jPanel3.setBackground(new java.awt.Color(0, 102, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabel_barang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nama Barang", "Nama Penjual", "Harga", "Photo", "Mulai", "Akhir"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabel_barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_barangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_barang);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 880, 230));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Daftar Barang");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 924, 50));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 252, 924, 320));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));
        jDesktopPane1.setMaximumSize(new java.awt.Dimension(228, 162));
        jDesktopPane1.setMinimumSize(new java.awt.Dimension(228, 162));
        jDesktopPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        image.setMaximumSize(new java.awt.Dimension(228, 162));
        image.setMinimumSize(new java.awt.Dimension(228, 162));
        image.setPreferredSize(new java.awt.Dimension(228, 162));
        jDesktopPane1.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 170));

        jPanel4.add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 170));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 170));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
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
    int Key = 0;
    private void tabel_barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_barangMouseClicked

        DefaultTableModel model = (DefaultTableModel) tabel_barang.getModel();
        int MyIndex = tabel_barang.getSelectedRow();
        try {
            Key = Integer.valueOf(model.getValueAt(MyIndex, 0).toString());
            ID.setText(String.valueOf(Key));
            nama_barang.setText(model.getValueAt(MyIndex, 1).toString());
            nama_penjual.setText(model.getValueAt(MyIndex, 2).toString());
            harga.setText(model.getValueAt(MyIndex, 3).toString());
            FetchPhoto();
            java.util.Date awald = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(MyIndex, 5).toString());
            mulai.setDate(awald);
            java.util.Date akhird = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(MyIndex, 6).toString());
            akhir.setDate(akhird);
        } catch (ParseException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tabel_barangMouseClicked

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
        if (nama_barang.getText().isEmpty() || nama_penjual.getText().isEmpty() || harga.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter The data");
        } else {
            add();
        }

    }//GEN-LAST:event_addbtnActionPerformed

    private void editbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtnActionPerformed
        if (imgpath != null) {
            edit();
        } else {
            JOptionPane.showMessageDialog(this, "Select Photo");
            image.setIcon(null);
            image.setText("");
        }
        imgpath = null;
    }//GEN-LAST:event_editbtnActionPerformed

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
        if (Key == 0) {
            JOptionPane.showMessageDialog(this, "Select the data");
        } else {
            delete();
        }
    }//GEN-LAST:event_deletebtnActionPerformed
    String imgpath = null;
    private void uploadbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadbtnActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg", "png");
        chooser.addChoosableFileFilter(filter);
        int result = chooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            image.setIcon(ResizePhoto(path, null));
            imgpath = path;
        }
    }//GEN-LAST:event_uploadbtnActionPerformed

    private void detailbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailbtnActionPerformed
        detail();
    }//GEN-LAST:event_detailbtnActionPerformed

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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Admin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JButton addbtn;
    private com.toedter.calendar.JDateChooser akhir;
    private javax.swing.JButton deletebtn;
    private javax.swing.JButton detailbtn;
    private javax.swing.JButton editbtn;
    private javax.swing.JTextField harga;
    private javax.swing.JLabel image;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser mulai;
    private javax.swing.JTextField nama_barang;
    private javax.swing.JTextField nama_penjual;
    private javax.swing.JTable tabel_barang;
    private javax.swing.JButton uploadbtn;
    // End of variables declaration//GEN-END:variables

    @Override
    public void add() {
        try {
            String str = "INSERT INTO barangs(nama_barang, nama_penjual, harga, photo, mulai, akhir) VALUES(?,?,?,?,?,?)";
            java.util.Date awald = mulai.getDate();
            java.util.Date akhird = akhir.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String strmulai = sdf.format(awald);
            String strakhir = sdf.format(akhird);

            PreparedStatement Add = con.prepareStatement(str);
            InputStream img = new FileInputStream(imgpath);

            Add.setString(1, nama_barang.getText());
            Add.setString(2, nama_penjual.getText());
            Add.setInt(3, Integer.valueOf(harga.getText()));
            Add.setBlob(4, img);
            Add.setString(5, strmulai);
            Add.setString(6, strakhir);
            Add.executeUpdate();

            JOptionPane.showMessageDialog(this, "Barang dimasukkan");
            con.close();
            DisplayTable();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete() {
        try {
            con = new Koneksi().konek();
            String Query = "Delete from barangs where ID=" + Key;
            Statement Del = con.createStatement();
            Del.executeUpdate(Query);
            JOptionPane.showMessageDialog(this, "Barang terhapus");
            DisplayTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    @Override
    public void edit() {
        try {
            java.util.Date awald = mulai.getDate();
            java.util.Date akhird = akhir.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String strmulai = sdf.format(awald);
            String strakhir = sdf.format(akhird);
            InputStream img = new FileInputStream(imgpath);
            con = new Koneksi().konek();
            String Query = "Update barangs set nama_barang=?,nama_penjual=?,harga=?,photo=?,mulai=?,akhir=? where ID=?";
            PreparedStatement UpdateQuery = con.prepareStatement(Query);
            UpdateQuery.setString(1, nama_barang.getText());
            UpdateQuery.setString(2, nama_penjual.getText());
            UpdateQuery.setInt(3, Integer.valueOf(harga.getText()));
            UpdateQuery.setBlob(4, img);
            UpdateQuery.setString(6, strmulai);
            UpdateQuery.setString(7, strakhir);
            UpdateQuery.setInt(5, Key);
            if (UpdateQuery.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(this, "Barang diupdate");
                DisplayTable();
            } else {
                JOptionPane.showMessageDialog(this, "Missing Information");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

    @Override
    public void detail() {
        if (Key == 0) {
            JOptionPane.showMessageDialog(this, "Tidak ada barang yang dipilih!");
        } else {
            DetailItem dtlitem = new DetailItem(Key);
            dtlitem.setVisible(true);
            dispose();
        }

    }
    byte[] photo = null;
    String filename = null;

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
