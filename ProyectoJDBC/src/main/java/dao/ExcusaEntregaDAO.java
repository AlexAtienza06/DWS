package dao;

import model.Excusa_entrega;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ExcusaEntregaDAO {
	List<Excusa_entrega> consultaBasica() throws SQLException;

	Optional<List<Excusa_entrega>> consultaPerro_Gato() throws SQLException;

	Optional<List<Excusa_entrega>> consultaSinEntrega() throws SQLException;

	Optional<List<Excusa_entrega>> consultaAvanzada() throws SQLException;

}
