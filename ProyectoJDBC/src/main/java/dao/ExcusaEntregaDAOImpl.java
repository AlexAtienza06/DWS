package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import conexion.Conexion;
import model.Excusa_entrega;

public class ExcusaEntregaDAOImpl implements ExcusaEntregaDAO {

	private static String selectBasico = "SELECT alumno, excusa, dias_retraso, nivel_drama FROM excusa_entrega ORDER BY nivel_drama DESC";

	private static String selectPerroGato = "SELECT * FROM excusa_entrega WHERE (excusa LIKE '%perro%' OR excusa LIKE '%gato%') AND (dias_retraso >=2 AND dias_retraso <=6) ORDER BY dias_retraso DESC";

	private static String selectSinEntrega = "SELECT * FROM excusa_entrega WHERE (fecha_entrega IS NULL) AND (credibilidad <4) AND (nivel_drama >=9)";

	private static String selectDramaNoCreible = "SELECT * FROM excusa_entrega WHERE (nivel_drama >=8 AND credibilidad <= 3) OR ((dias_retraso > 2 AND dias_retraso < 5) AND excusa LIKE '%perro%')";

	private Conexion conexion;

	public ExcusaEntregaDAOImpl() {
		this.conexion = Conexion.getInstancia();
	}

	@Override
	public List<Excusa_entrega> consultaBasica() throws SQLException {
		List<Excusa_entrega> excusaEntrega = new ArrayList<>();
		Connection connection = conexion.getConexion();
		try (PreparedStatement statement = connection.prepareStatement(selectBasico);
				ResultSet resultSet = statement.executeQuery()) {

			while (resultSet.next()) {
				excusaEntrega.add(mapRow(resultSet));
			}
		}
		return excusaEntrega;
	}

	@Override
	public Optional<List<Excusa_entrega>> consultaPerro_Gato() throws SQLException {
		List<Excusa_entrega> perroGato = new ArrayList<>();
		Connection connection = conexion.getConexion();
		try (PreparedStatement statement = connection.prepareStatement(selectPerroGato)) {
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					perroGato.add(mapRow(resultSet));
					return Optional.of(perroGato);
				}
			} catch (Exception e) {

			}
		}
		return Optional.empty();
	}

	@Override
	public Optional<List<Excusa_entrega>> consultaSinEntrega() throws SQLException {
		List<Excusa_entrega> sinEntrega = new ArrayList<>();
		Connection connection = conexion.getConexion();
		try (PreparedStatement statement = connection.prepareStatement(selectSinEntrega)) {
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					sinEntrega.add(mapRow(resultSet));
					return Optional.of(sinEntrega);
				}
			} catch (Exception e) {

			}
		}
		return Optional.empty();
	}

	@Override
	public Optional<List<Excusa_entrega>> consultaAvanzada() throws SQLException {
		List<Excusa_entrega> noCreible = new ArrayList<>();
		Connection connection = conexion.getConexion();
		try (PreparedStatement statement = connection.prepareStatement(selectDramaNoCreible)) {
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					noCreible.add(mapRow(resultSet));
					return Optional.of(noCreible);
				}
			} catch (Exception e) {

			}
		}
		return Optional.empty();
	}

	private Excusa_entrega mapRow(ResultSet resultSet) throws SQLException {
		return new Excusa_entrega(resultSet.getString("alumno"), resultSet.getString("excusa"),
				resultSet.getInt("dias_retraso"), resultSet.getInt("nivel_drama"));
	}
}
