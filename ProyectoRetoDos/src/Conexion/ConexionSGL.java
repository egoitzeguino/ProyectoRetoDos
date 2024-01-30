package Conexion;



import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionSGL {
	private static ConexionSGL instancia = null;
	private static Connection con;
	private ConexionSGL () {
		String host = "127.0.0.1"; //Podríamos poner "localhost"
		String user = "egoitz";
		String pass = "egoitz";
		String dtbs = "tortugajuanes";
		try{
			Class.forName("com.mysql.jdbc.Driver"); //Inicializar el driver
			String newConnectionURL = "jdbc:mysql://" + host + "/" + dtbs + "?" + "user=" + user + "&password=" + pass;
			con = DriverManager.getConnection(newConnectionURL);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al abrir la conexión.");
		}
	}
	public static ConexionSGL getInstancia(){
		if (instancia == null) instancia = new ConexionSGL();
		return instancia;
	}
	public Connection getCon (){
		return con;
	}
	public void cerrarConexion() {
		try {
			con.close();
		}catch (Exception e) {
			System.out.println("Error al cerrar la conexión.");
		}
	}
}
