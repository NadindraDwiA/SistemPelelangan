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
public abstract class Auth {
    
    String nama;
    String username;
    String gender;
    String tglLahir;
    String alamat;
    String noTelp;
    String role;
    
    public Auth(String nama, String username, String gender, String tglLahir, String alamat, String noTelp){
        this.nama = nama;
        this.username = username;
        this.gender = gender;
        this.tglLahir = tglLahir;
        this.alamat = alamat;
        this.noTelp = noTelp;
    }
    
    public abstract void setRole();
    public abstract String welcomeMessage();
    public abstract boolean manageItemAccess();
}
