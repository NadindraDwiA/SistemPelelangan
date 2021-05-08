/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction;

/**
 *
 * @author Asus
 */
public class AuthAdmin extends Auth{
    
    public AuthAdmin(String id, String nama, String username, String gender, String tglLahir, String alamat, String noTelp){
        super(id, nama, username, gender, tglLahir, alamat, noTelp);
    }

    @Override
    public void setRole() {
        super.role = "admin";
    }

    @Override
    public String welcomeMessage() {
        String message = "Selamat datang! anda masuk sebagai admin. Admin dapat menambah, mengedit, dan menghapus barang yang dilelang.";
        System.out.println(message);
        
        return message;
    }

}
