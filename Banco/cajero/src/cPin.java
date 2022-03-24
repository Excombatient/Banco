import java.io.Console;
import java.sql.*;

public class cPin {
  public static void cambio(){
    String tem = login.codOpera();
    String ping = Cajero.codigo();
    String nt = Cajero.numero(); 
    Console cnsl = System.console();
    String p;
    Connection connection = null;
    Statement selectStmt = null;
    try{
      Class.forName("com.mysql.cj.jdbc.Driver");
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "arma1994");
      selectStmt = connection.createStatement();
      p = cnsl.readLine("Introducce el ping:");
        if(ping.equals(p)){
            p = cnsl.readLine("Introducce el nuevo ping:");
            selectStmt.executeUpdate("UPDATE tarjeta SET pin='"+p+"' WHERE Cuenta_idCuenta='"+tem+"' && numTarjeta='"+nt+"';");
        }else{
            System.out.println("Ping Incorrecto");
        }
    } 
    catch (Exception e) {
      e.printStackTrace();
    }finally {
      try {
        selectStmt.close();
        connection.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}