package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static Conexion instancia;
	private Connection conexion;

	private final String url = "jdbc:mysql://localhost:3307/excusa_entrega";
	private final String usuario = "root";
	private final String contra = "Usuario0*";

	private Conexion() {

	}

	public static synchronized Conexion getInstancia() {
		if (instancia == null) {
			instancia = new Conexion();
		}
		return instancia;
	}

	public synchronized Connection getConexion() throws SQLException {
		if (conexion == null || conexion.isClosed()) {
			conexion = DriverManager.getConnection(url, usuario, contra);
		}
		return conexion;
	}

	public void cerrar() throws SQLException {
		if (conexion != null && !conexion.isClosed()) {
			conexion.close();
		}
	}

}