package br.edu.senaisp.SpringDB.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.edu.senaisp.SpringDB.model.Banda;

@Repository
public class BandaRepository implements ICrud {

	private String qrSelectAll = "SELECT id, nome, anoLancamento FROM banda";

	private String qrSelectById = "SELECT id, nome, anoLancamento FROM banda WHERE id = ?";

	private String qrUpdate = "UPDATE banda SET nome = ?, anoLancamento = ? WHERE id = ?";

	private String qrInsert = "INSERT INTO banda (id, nome, anoLancamento) VALUES (default, ?, ?)";

	private String qrDelete = "DELETE FROM banda WHERE id = ?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Banda> lista() {

		return jdbcTemplate.query(qrSelectAll, (rs, rowNum) -> {
			return new Banda(rs.getInt("id"), rs.getString("nome"), rs.getInt("anoLancamento"));
		});
	}

	@Override
	public Banda buscaPorId(int id) {
		Object[] params = { id };

		return jdbcTemplate.queryForObject(qrSelectById, params, (rs, rowNum) -> {
			return new Banda(rs.getInt("id"), rs.getString("nome"), rs.getInt("anoLancamento"));
		});
	}

	@Override
	public int altera(Banda banda, int id) {

		Object[] params = { banda.getNome(), banda.getAnoLancamento(), id };

		return jdbcTemplate.update(qrUpdate, params);

	}

	@Override
	public int insere(Banda banda) {

		Object[] params = { banda.getNome(), banda.getAnoLancamento() };

		return jdbcTemplate.update(qrInsert, params);

	}

	@Override
	public boolean exclui(int id) {

		Object[] params = { id };

		if (jdbcTemplate.update(qrDelete, params) > 0) {
			jdbcTemplate.update(qrDelete, params);
			return true;
		} else {
			return false;
		}
	}

}
