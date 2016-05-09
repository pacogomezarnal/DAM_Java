package Juego;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;

public class JugadorDB {
	
	private Jugador jugador;
	//Conexion a la base de datos
	private Statement orden = null;

	public JugadorDB() {
	}
	
	public JugadorDB(Jugador j) {
		this.jugador=j;
	}
	
	//Método que permite insertar un usuario en la base de datos
	public int insertarUsuario(Connection c){
			int id=0;
			try{
				ResultSet rs;
				orden = c.createStatement();
			    String sql = "INSERT INTO usuarios (nombre,apellido1,apellido2,edad) " +
			                   "VALUES ('"+jugador.getNombre()+"', '"+jugador.getApellido1()+"', '"+jugador.getApellido2()+
			                   "', "+jugador.getEdad()+")";
			    orden.executeUpdate(sql);
			    System.out.println("Usuario registrado con exito");
				orden = c.createStatement();
			    sql = "SELECT id FROM Table ORDER BY ID DESC LIMIT 1";
			    rs = orden.executeQuery(sql);
			    //Cogemos los usuarios
			    while(rs.next()){
			    	  id=rs.getInt("id");
			    }
			    }catch(SQLException se){
				      //Se produce un error con la consulta
				      se.printStackTrace();
			   }catch(Exception e){
				      //Se produce cualquier otro error
				      e.printStackTrace();
			   }
		    return id;
	}
	//Método que permite buscar un usuario en la base de datos devolviendolos en un JComboBox
	public void buscarUsuario(Connection c,JComboBox jc){
		ResultSet rs;
		try{
		  orden = c.createStatement();
	      String sql = "SELECT id,nombre, apellido1, apellido2, edad,puntos FROM usuarios";
	      rs = orden.executeQuery(sql);
	      //Cogemos los usuarios
	      while(rs.next()){
	    	  Jugador player=new Jugador();
	    	  player.setId(rs.getInt("id"));
	    	  player.setNombre(rs.getString("nombre"));
	    	  player.setApellido1(rs.getString("apellido1"));
	    	  player.setApellido2(rs.getString("apellido2"));
	    	  player.setEdad(rs.getInt("edad"));
	    	  player.setPuntos(rs.getInt("puntos"));
		      jc.addItem(player);
	      }
	      //Debemos cerrar la conexion
	      rs.close();
		}catch(SQLException se){
			      //Se produce un error con la consulta
			      se.printStackTrace();
		}catch(Exception e){
			      //Se produce cualquier otro error
			      e.printStackTrace();
		}
	}
	//Método que permite buscar actualizar un usuario en la base de datos con un preparedStatement
	public void actualizarUsuario(Connection c){
		try{
		  orden = c.createStatement();
		// create the java mysql update preparedstatement
	      String sql = "UPDATE usuarios " +
                       "SET nombre = ?"+
                       ",apellido1 = ?"+
                       ",apellido2 = ?"+
                       ",edad = ? "+
	    		       "WHERE id = "+jugador.getId();
	      PreparedStatement preparedStmt = c.prepareStatement(sql);
	      preparedStmt.setString(1, jugador.getNombre());
	      preparedStmt.setString(2, jugador.getApellido1());
	      preparedStmt.setString(3, jugador.getApellido2());
	      preparedStmt.setInt(4, jugador.getEdad());
	 
	      // se ejecuta la consulta
	      preparedStmt.executeUpdate();
		}catch(SQLException se){
			      //Se produce un error con la consulta
			      se.printStackTrace();
		}catch(Exception e){
			      //Se produce cualquier otro error
			      e.printStackTrace();
		}		
	}
	
	//Método que permite buscar actualizar un usuario en la base de datos con un preparedStatement
	public void actualizarUsuarioPuntos(Connection c){
		try{
		  orden = c.createStatement();
		// create the java mysql update preparedstatement
	      String sql = "UPDATE usuarios " +
                       "SET puntos = ? "+
	    		       "WHERE id = "+jugador.getId();
	      PreparedStatement preparedStmt = c.prepareStatement(sql);
	      preparedStmt.setInt(1, jugador.getPuntos());

	      // se ejecuta la consulta
	      preparedStmt.executeUpdate();
		}catch(SQLException se){
			      //Se produce un error con la consulta
			      se.printStackTrace();
		}catch(Exception e){
			      //Se produce cualquier otro error
			      e.printStackTrace();
		}		
	}
}
