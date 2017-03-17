/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts_pemesanantiket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author KEVIN_E15
 */
public class KoneksiDB {
    public static com.mysql.jdbc.Connection setKoneksi(){
        String konString = "jdbc:mysql://localhost:3306/db_uts";
        com.mysql.jdbc.Connection koneksi = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = (com.mysql.jdbc.Connection)
                    DriverManager.getConnection(konString,"root","");
                        System.out.println("Koneksi Berhasil");
        } catch (ClassNotFoundException ex){
            Logger.getLogger(KoneksiDB.class.getName()).log(Level.SEVERE,null, ex);
                System.out.println("Koneksi Gagal");
        } catch (SQLException ex){
            Logger.getLogger(KoneksiDB.class.getName()).log(Level.SEVERE,null, ex);
                System.out.println("Koneksi Gagal");
        }
         return koneksi;   
        }
    
    public static int execute(String SQl) {
        int status  = 0;
        com.mysql.jdbc.Connection koneksi = setKoneksi();
        try{
            Statement st = koneksi.createStatement();
            status = st.executeUpdate(SQl);
        } catch (SQLException ex){
            Logger.getLogger(KoneksiDB.class.getName()).log(Level.SEVERE,null, ex);
        }
        return status;
    }
    
    public static ResultSet executeQuery(String SQL){
        ResultSet rs = null;
        com.mysql.jdbc.Connection koneksi = setKoneksi();
        try{
            Statement st = koneksi.createStatement();
            rs = st.executeQuery(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(KoneksiDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    static Object GetConnection(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    }
    
    
    

