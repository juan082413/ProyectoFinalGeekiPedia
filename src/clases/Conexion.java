package clases;

import java.sql.*;


public class Conexion {
	//Conexi�n Local
	
	public static Connection conectar () {
		try{
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_ds", "root", "");
			return cn;
			
			
		}catch (SQLException ex) {
			System.out.println("Error en la conexi�n local" +ex);
		
		}
		return (null); 
	}
	}
