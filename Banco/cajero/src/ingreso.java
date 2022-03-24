import java.io.Console;
import java.sql.*;

public class ingreso {
  public static void ingresar(String x){
    String tem = login.codOpera();    
    Console cnsl = System.console();
    String fecha,cantidad;
    Connection connection = null;
    Statement selectStmt = null;
    try{
      Class.forName("com.mysql.cj.jdbc.Driver");
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "arma1994");
      selectStmt = connection.createStatement();
      fecha = cnsl.readLine("Fecha:");
      cantidad = cnsl.readLine("Cantidad:");
      selectStmt.executeUpdate("INSERT into operaciones(entidad,nombreOperacion,Cuenta_idCuenta,categoria,fecha)values('Cajero','Ingreso Manual','"+tem+"','ingreso','"+fecha+"');");
      selectStmt.executeUpdate("INSERT into ingreso(descripcion,ingreso,Operaciones_idOperaciones)values('Ingreso Manual','"+cantidad+"','"+tem+"');");
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