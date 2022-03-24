import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class saldo {
  public static void money(String x){
    String tem = login.codOpera();
    String s,r;
    double saldoTotal;
    Connection connection = null;
    Statement selectStmt = null;
    try{
      Class.forName("com.mysql.cj.jdbc.Driver");
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "arma1994");
      selectStmt = connection.createStatement();

      ResultSet rs = selectStmt.executeQuery("SELECT sum(ingreso) FROM ingreso WHERE Operaciones_idOperaciones='"+tem+"';");
      rs.next();
      s =rs.getString(1);
      rs = selectStmt.executeQuery("SELECT sum(extraccion) FROM extraccion WHERE Operaciones_idOperaciones='"+tem+"';");
      rs.next();
      r = rs.getString(1);

      double num1 = Double.parseDouble(s);
      double num2 = Double.parseDouble(r);
      
      saldoTotal = num1-num2;
      System.out.println("Saldo Actual: "+saldoTotal);
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
