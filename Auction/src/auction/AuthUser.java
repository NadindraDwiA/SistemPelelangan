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
public class AuthUser extends Auth {

    public AuthUser(String id, String nama, String username, String gender, String tglLahir, String alamat, String noTelp){
        super(id, nama, username, gender, tglLahir, alamat, noTelp);
    }
    
    @Override
    public void setRole() {
        super.role = "user";
    }

    @Override
    public String welcomeMessage() {
        String message = "Selamat datang!, anda sebagai user dapat melakukan penawaran dan pembelian barang.";
        System.out.println(message);
        
        return message;
    }
}
