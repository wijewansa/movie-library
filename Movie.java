/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author My DELL
 */
class Movie {
     Statement st;
             
    void addMovie(String mtitle, String mprod, String mdir, int myear) {
       connectToDb();
       String sql = "INSERT INTO movie_tbl VALUES('"+mtitle+"','"+mprod+"','"+mdir+"',"+myear+")";
         try {
             st.executeUpdate(sql);
         } catch (SQLException ex) {
             Logger.getLogger(Movie.class.getName()).log(Level.SEVERE, null, ex);
         }
    }  

    private void connectToDb() {
        String driver ="com.mysql.jdbc.Driver";
        String url="jjdbc:mysql://localhost:3306/moviestore";
        try {
            Class.forName(driver);
            Connection con =DriverManager.getConnection(url, "root", "");//import java.sql.Connection & import java.sql.DriverManager;
            con.createStatement(); //Add import for java.sql.Statement
        } catch (ClassNotFoundException | SQLException ex) {//import java.sql.SQLException;
            Logger.getLogger(Movie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
