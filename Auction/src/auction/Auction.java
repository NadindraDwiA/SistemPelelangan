/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction;

import Koneksi.Koneksi;
import java.sql.Connection;

/**
 *
 * @author nadindradwi
 */
public class Auction {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection con = new Koneksi().konek();
    }
    
}
