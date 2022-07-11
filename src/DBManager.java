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

    public static void insertarPersona(int id , String first_name, String last_name, String email){
        try {
            PreparedStatement stmn = connection.prepareStatement("INSERT INTO persona VALUES(?, ?, ? ,? );");
            stmn.setInt(1,id);
            stmn.setString(2,first_name);
            stmn.setString(3,last_name);
            stmn.setString(4,email);

            stmn.executeQuery();


        } catch (SQLException e){
            e.printStackTrace();

        }
    }

    public static void consultarPersona(){

        try {
            PreparedStatement stmn =  connection.prepareStatement("SELECT * FROM persona;");
            ResultSet result = stmn.executeQuery();

            System.out.println("id | first_name | last_name | email");
            while (result.next()){
                long id = result.getLong("id");
                String first_name = result.getString("first_name");
                String last_name = result.getString("last_name");
                String email = result.getString("email");
                System.out.println(id + " \t" + first_name +" \t"+ last_name + " \t" + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void actualizarPersona(int id, String new_name) {
        try {
            PreparedStatement stmn =  connection.prepareStatement("UPDATE persona SET first_name = ? WHERE id = ?");
            stmn.setString(1, new_name);
            stmn.setInt(2, id);
            stmn.execute();
            System.out.println("Se ah actualizado con exito");

        }catch (SQLException e){
            e.printStackTrace();

        }
    }
}
