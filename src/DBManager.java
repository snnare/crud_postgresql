import java.sql.*;

public class DBManager {
    private static String user = "postgres";
    private static String pass = "22";
    private static Connection connection;

    public static void initConnection(){
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/prueba1",user,pass);
            System.out.println("Conectado con exito");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void consultarPersona(){

        try {
            PreparedStatement stmn =  connection.prepareStatement("SELECT * FROM persona;");
            ResultSet result = stmn.executeQuery();

            System.out.println("id | nombre | apellido | edad");
            while (result.next()){
                long id = result.getLong("id");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                int edad = result.getInt("edad");


                System.out.println(id + " \t" + nombre +" \t"+ apellido + " \t" + edad);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
