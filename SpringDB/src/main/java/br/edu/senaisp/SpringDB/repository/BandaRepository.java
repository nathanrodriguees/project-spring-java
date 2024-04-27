package br.edu.senaisp.SpringDB.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.edu.senaisp.SpringDB.model.Banda;

@Repository
public class BandaRepository implements ICrud {

	private String qrSelectAll = "SELECT id, nome, anoLancamento FROM banda";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Banda> lista() {

		return jdbcTemplate.query(qrSelectAll, (rs, rowNum) -> {
			return new Banda(rs.getInt("id"), 
					rs.getString("nome"), 
					rs.getInt("anoLancamento"));
		});
	}

	@Override
	public Banda buscaPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Banda altera(Banda banda, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Banda insere(Banda banda) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exclui(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
