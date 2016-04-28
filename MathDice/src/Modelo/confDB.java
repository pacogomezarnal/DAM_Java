package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
* <h1>confDB</h1>
* Esta clase realiza la conexión a una base de datos y nos devuelve el conector a dicha base de datos
* 
*
* @author  Paco Gómez
* @version 1.0
* @since   2016-04-11 
* @see <a href="">Java. Layout Managers</a>
*/
public class confDB {
	private Connection connect = null;
	
	public confDB() {

	}
	
	//Método que conecta a la base de datos devolviendo un null si no hay errores
	//Devuelve el error si no hay conectividad
	public String conectar(){
		try {
		      // Cargamos en ejecución 
		      Class.forName("com.mysql.jdbc.Driver");
		      // Setup the connection with the DB
		      connect = DriverManager
		          .getConnection("jdbc:mysql://10.1.97.224/mathDice?"
		              + "user=cook&password=cook01");
		      //Conexion realizada
		      return null;
	    } catch (Exception e) {
	        return e.getMessage();
	    } 		
	}
	
	public Connection getConexion(){
			return connect;
	}

}