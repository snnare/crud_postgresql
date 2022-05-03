import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Principal {

    private  static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        DBManager.initConnection();

        int opc;

        do {
            System.out.println("\n1. Ver personas");
            System.out.println("\n2. Salir");
            opc = scanner.nextInt();
            if( opc == 1){
                consultarTable();
            }

        }while (opc != 2);
    }



    public static void consultarTable(){
        DBManager.consultarPersona();

    }
}
