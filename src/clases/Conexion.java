package clases;

import java.sql.*;


public class Conexion {
	//Conexión Local
	
	public static Connection conectar () {
		try{
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_ds", "root", "");
			return cn;
			
			
		}catch (SQLException ex) {
			System.out.println("Error en la conexión local" +ex);
		
		}
		return (null); 
	}
	}
