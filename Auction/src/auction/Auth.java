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
    
    public static String id;
    public static String nama;
    public static String username;
    public static String gender;
    public static String tglLahir;
    public static String alamat;
    public static String noTelp;
    public static String role;
    
    public Auth(String id, String nama, String username, String gender, String tglLahir, String alamat, String noTelp){
        this.id = id;
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
