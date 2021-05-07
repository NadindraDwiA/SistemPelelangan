/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction;

import Koneksi.Koneksi;
import java.sql.*;

public class Bids {
    private String nama, alamat;
    private int harga_tawar, kode;
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
    
    public void setNama(String nama)
    {
        this.nama = nama;
    }
    
    public String getNama()
    {
        return nama;
    }
    
    public void setAlamat(String alamat){
        this.alamat = alamat;
    }
    
    public String getAlamat()
    {
        return alamat;
    }
    
    public void setKode(int kode){
        this.kode = kode;
    }
    
    public int getKode()
    {
        return kode;
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
    
    public void simpanData(int kode, String nama, String alamat, int harga_tawar)
    {
        query = "insert into bids values(?,?,?,?)";
        try {
            pst = con.prepareStatement(query);
            pst.setInt(1, kode);
            pst.setString(2, nama);
            pst.setString(3, alamat);
            pst.setInt(4, harga_tawar);
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
