package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import exceptions.DbExcessao;

public class ProfessorDao implements IFuncoesCrud<Professor> {
	
	private Connection conn;
	
	public ProfessorDao(Connection conn) {
		this.conn = conn;
	}
	
	public ProfessorDao() {
		this.conn = DB.getConnection();
	}

	@Override
	public void inserir(Professor professor) {

		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("INSERT INTO professor "
					+ "(codigoFuncional, nome, dataNascimento) "
					+ "values "
					+ "(?, ?, ?)" ,
					Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, professor.getCodigoFuncional());
			ps.setString(2, professor.getNome());
			ps.setObject(3, professor.getDataNascimento());
			
			int rowsAffected = ps.executeUpdate();
			
			if(rowsAffected > 0) {
				
				ResultSet rs = ps.getGeneratedKeys();
				
				if(rs.next()) {
					
					int id = rs.getInt(1);
					professor.setId(id);
				}
				
				DB.closeResultSet(rs);
				
			}
			
		} catch (SQLException e) {
			throw new DbExcessao("Erro inesperado! Nenhuma linha afetada. ");
		}
		finally {
			DB.closeStatement(ps);
		}
		
		
	}

	@Override
	public void deletar(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Professor entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ler(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lerTodos() {
		// TODO Auto-generated method stub
		
	}

	

}
