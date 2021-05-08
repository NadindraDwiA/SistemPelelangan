/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction;

import Koneksi.Koneksi;
import java.sql.*;

public class Bids {
    private int harga_tawar;
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private Statement st = null;
    private String query;
    
    public Bids(){
        try{
            con = new Koneksi().konek();
        }catch(Exception e){   
            System.out.println(e);
        }
    }
    
    public int getHargaTawar() {
        return this.harga_tawar;
    }

    public void setHargaTawar(int harga_tawar) {
        this.harga_tawar = harga_tawar;
    }
    
    public ResultSet tampilData()
    {
        query = "select * from bids";
        try { st = con.createStatement();
              rs = st.executeQuery(query);
        } catch (Exception e) {
        }
        return rs;
    }
    
    public void simpanData(String id_barang, int harga_tawar)
    {
        int idUser = Integer.parseInt(Auth.id);
        String namaUser = Auth.nama;
        String alamatUser = Auth.alamat;
        
        query = "INSERT INTO bids (id_barang, id_user, nama, alamat, harga_tawar) VALUES(?,?,?,?,?)";
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, id_barang);
            pst.setInt(2, idUser);
            pst.setString(3, namaUser);
            pst.setString(4, alamatUser);
            pst.setInt(5, harga_tawar);
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println("Error Simpan Data: " + e);
        }
    }
}
