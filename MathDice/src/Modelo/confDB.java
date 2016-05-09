package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
* <h1>confDB</h1>
* Esta clase realiza la conexi�n a una base de datos y nos devuelve el conector a dicha base de datos
* 
*
* @author  Paco G�mez
* @version 1.0
* @since   2016-04-11 
* @see <a href="">Java. Layout Managers</a>
*/
public class confDB {
	private static Connection connect = null;
	private static confDB INSTANCE = null;
	
	
	private confDB() {
		try {
		      // Cargamos en ejecuci�n 
		      Class.forName("com.mysql.jdbc.Driver");
		      // Setup the connection with the DB
		      connect = DriverManager
		          .getConnection("jdbc:mysql://192.168.1.192/mathDice?"
		              + "user=cook&password=cook01");
		      //Mensaje de conexion realizada
		      System.out.println("Conexion realizada");
	    } catch (Exception e) {
	        System.out.println(e);
	    } 
	}
	
	public static Connection getConexion(){
        if (connect == null){
        	INSTANCE = new confDB();
        }
		return connect;
	}


}