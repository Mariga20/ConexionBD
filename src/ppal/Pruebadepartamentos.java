package ppal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexion.ConexionBD;

public class Pruebadepartamentos {

	public static void main(String[] args) {
		
		ConexionBD conexion = new ConexionBD();
		
		System.out.println("Conectando a la base de datos...");
		Connection con = conexion.getConexion();
		//Objetos necesarios para hacer una consulta
		Statement sentencia= null;
		ResultSet resultado=null;
		
		// Algún procesamiento con la base de datos...
		
		try {
			//Paso 2. Otener el Statement
			sentencia = con.createStatement();
			//Paso 3. Ejecujtar la sentencia
			resultado=sentencia.executeQuery("select cod_centro,nombre,salario from empleados");
			//Paso 4.Recorrer el resultado
			while(resultado.next()) {
				int codEmpleado = resultado.getInt("cod_empleado");
				String nombre = resultado.getString("nnombre");
				int salario = resultado.getInt("salario");
				
				System.out.println(codEmpleado+"\t"+nombre+"\t"+salario);
			}
		} catch (SQLException e) {
			System.out.println("Error al consultar los datos."+e.getMessage());
		}finally{
			try {
				resultado.close();
				sentencia.close();
			}catch (SQLException e) {
			System.out.println("Error al liberar los recurssos");
			
		}
		// Liberamos la conexión
		System.out.println("Desconectando de la base de datos.");
		conexion.desconectar();
		
		// TODO Auto-generated method stub

	}

	}
	}
