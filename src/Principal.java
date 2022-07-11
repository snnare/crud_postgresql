import java.util.Scanner;

public class Principal {

    private  static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        DBManager.initConnection();

        int opc;

        do {
            System.out.println("\n1. Insertar ");
            System.out.println("\n2. Consultar ");
            System.out.println("\n3. Actualizar");
            System.out.println("\n4. Eliminar");
            System.out.println("\n5. Salir");
            opc = scanner.nextInt();
            if( opc == 1){
                insertar();
            }
            if (opc == 2){
                consultar();
            }
            if (opc == 3){
                actualizar();
            }

        }while (opc != 5);
    }


    public  static void insertar(){
        DBManager.insertarPersona(1001, "Jose","Romero", "@@@");
    }
    public static void consultar(){
        DBManager.consultarPersona();

    }

    public static  void actualizar(){
       DBManager.actualizarPersona(2, "krikoso");
    }
}
