package main;

import java.sql.SQLException;
import java.util.Scanner;

import conexion.Conexion;
import dao.ExcusaEntregaDAO;
import dao.ExcusaEntregaDAOImpl;
import model.Excusa_entrega;

public class Main {
	public static void main(String[] args) {
		Conexion conexionSingleton = Conexion.getInstancia();

		ExcusaEntregaDAO excusaEntregaDAO = new ExcusaEntregaDAOImpl();
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Consulta básica:");
			for (Excusa_entrega excusas : excusaEntregaDAO.consultaBasica()) {
				System.out.println(excusas);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}