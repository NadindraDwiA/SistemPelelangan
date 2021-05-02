/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Asus
 */
public class Koneksi {
    private Connection koneksi;
    public Connection konek(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Koneksi Database Berhasil");
        }
        catch(ClassNotFoundException cnfe){
            System.out.println("Gagal Koneksi Database "+cnfe);
        }
        String url = "jdbc:mysql://localhost:3306/auction";
        try{
            koneksi=DriverManager.getConnection(url, "root", "");
            System.out.println("Data Berhasil tersambung");
        }
        catch(SQLException se){
            System.out.println("Tidak Ada Database "+se);
        }
        return koneksi;
    }
}
