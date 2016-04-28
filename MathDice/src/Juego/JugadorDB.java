package Juego;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JugadorDB {
	
	private Jugador jugador;
	//Conexion a la base de datos
	private Statement orden = null;

	public JugadorDB(Jugador j) {
		this.jugador=j;
	}
	
	//Método que permite insertar un usuario en la base de datos
	public void insertarUsuario(Connection c){
			try{
				orden = c.createStatement();
			    String sql = "INSERT INTO usuarios (nombre,apellido1,apellido2,edad) " +
			                   "VALUES ('"+jugador.getNombre()+"', '"+jugador.getApellido1()+"', '"+jugador.getApellido2()+
			                   "', "+jugador.getEdad()+")";
			    orden.executeUpdate(sql);
			    System.out.println("Usuario registrado con exito");
			   }catch(SQLException se){
				      //Se produce un error con la consulta
				      se.printStackTrace();
			   }catch(Exception e){
				      //Se produce cualquier otro error
				      e.printStackTrace();
			   }finally{
				      //Cerramos los recursos
				      try{
				         if(orden!=null)
				        	 c.close();
				      }catch(SQLException se){
				      }
				      try{
				         if(c!=null)
				        	 c.close();
				      	 }catch(SQLException se){
				         se.printStackTrace();
				      }//end finally try
				}//end try
	}
}
