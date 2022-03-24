import java.io.*;

public class Cajero{   
    private static String numt;
    private static String ping;
    private static String bucle;
    private static int repeat;
    private static Console cnsl = System.console();
    private static String si = "si";
    public static void main(String[] args) throws Exception {
      Boolean acc = false;
      int option;
        do{
        if (cnsl == null) {
            System.out.println("No console available");
            return;
        }
        numt = cnsl.readLine("Num Tarjeta: ");  
        ping = cnsl.readLine("Introduzca el PIN: ");
        login.validar(numt,ping);
        acc = login.acceso();
        if(acc==true){
            do{
            System.out.println("---------- Bienvvenido a Bank ----------------");
            System.out.println("1.Consultar Saldo");            
            System.out.println("2.Ingresar Saldo");
            System.out.println("3.Retirar Saldo");
            System.out.println("4.Cambiar PIN");
            option = Integer.parseInt(cnsl.readLine("Seleccione una opcion: "));
            switch (option) {
                case 1:
                  saldo.money(numt);
                  repetir();
                  break;
                case 2:
                  ingreso.ingresar(numt);
                  repetir();
                  break;
                case 3:
                  extraccion.extraer(numt);
                  repetir();
                  break;
                case 4:
                  cPin.cambio();
                  repetir();
                  break;
              }              
            }while(repeat==0);
        }
        }while(acc==false);  
     }
    public static String numero(){
        return numt;
    }
    public static String codigo(){
        return ping;
    }
    private static void repetir(){
      bucle = cnsl.readLine("Desea hacer otra operacion?? Si/No ");  
      if(bucle.equals(si)){
        repeat = 0;
      }else{
        System.out.println("Hasta otra, vuelva pronto");
        repeat = 1;
      }
    }
}
