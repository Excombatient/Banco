import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class login {
  public static String tem;
  public static Boolean acces;
  public static void validar(String x,String y){
    String p = Cajero.codigo();
    String t = Cajero.numero();
    
    Connection connection = null;
    Statement selectStmt = null;
    try{
      Class.forName("com.mysql.cj.jdbc.Driver");
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "arma1994");
      selectStmt = connection.createStatement();
      ResultSet rs = selectStmt.executeQuery("SELECT Cuenta_idCuenta FROM tarjeta WHERE numTarjeta='"+t+"';");      
      rs.next();
      tem = rs.getString(1);
      rs = selectStmt.executeQuery("SELECT numTarjeta,pin FROM tarjeta WHERE numTarjeta='"+t+"'&& pin='"+p+"';");
      rs.next();
      if(rs.getString(1).equals(t)&&rs.getString(2).equals(p)){
        acces = true;
      }
    } 
    catch (Exception e) {
        System.out.println("Acceso Denegado");
        acces = false;
    }finally {
      try {
        selectStmt.close();
        connection.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
  public static String codOpera(){
    return tem;
  }
  public static Boolean acceso(){
    return acces;
  }
}