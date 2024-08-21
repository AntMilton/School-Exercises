/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ANTONIO MILTON
 */
public class conexao {
    
    
      private static final String USERNAME ="root";
    private static final String PASSWORD ="";
    private static final String DATABASE_URL ="jdbc:mysql://localhost/exercicio3";
    
    public static Connection obterConexao() throws Exception{
       Class.forName("com.mysql.jdbc.Driver");
     
       Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
       
       return connection;
       
}
    public static void main(String args[]) throws SQLException, Exception{
        
        Connection con = obterConexao();
          
          if(con != null){
       System.out.println("Conexao obtida com sucesso!!" + con);
       con.close();
    }
}
}
