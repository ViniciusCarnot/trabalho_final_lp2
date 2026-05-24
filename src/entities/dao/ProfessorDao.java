package entities.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entities.DB;
import entities.Professor;
import entities.interfaces.IFuncoesCrud;
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
		
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("DELETE FROM professor "
					+ "WHERE id = ? "
					+ "LIMIT 1");
			
			ps.setInt(1, id);
			
			int rowsAffected = ps.executeUpdate();
			
			if(rowsAffected > 0) {
				System.out.println("Linhas modificadas: " + rowsAffected);
			} else {
				throw new DbExcessao("Erro inesperado! Nenhuma linha modificada. ");
			}
			
		} catch (SQLException e) {
			throw new DbExcessao(e.getMessage());
		} 
		finally {
			DB.closeStatement(ps);
		}
		
	}

	@Override
	public void atualizar(Professor professor) {
		
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("UPDATE professor "
					+ "set codigoFuncional = ?, "
					+ "nome = ?, "
					+ "dataNascimento = ? "
					+ "WHERE id = ?");
			
			ps.setString(1, professor.getCodigoFuncional());
			ps.setString(2, professor.getNome());
			ps.setObject(3, professor.getDataNascimento());
			ps.setInt(4, professor.getId());
			
			ps.executeUpdate();
		
			
		} catch (SQLException e) {
			throw new DbExcessao(e.getMessage());
		}
		finally {
			DB.closeStatement(ps);
		}
		
	}

	@Override
	public Professor ler(Integer id) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("SELECT * FROM professor WHERE id = ?");
			
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				Professor professor = instanciaProfessor(rs);
				return professor;
			} else {
				System.out.println("Professor com o id: " + id + " não existe.");
				return null;
			}
			
			
		} catch (SQLException e) {
			throw new DbExcessao(e.getMessage());
		}
		finally {
			DB.closeStatement(ps);
			DB.closeResultSet(rs);
		}
		
	}

	@Override
	public List<Professor> lerTodos() {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("SELECT * FROM professor");
			
			rs = ps.executeQuery();
			
			List<Professor> lista = new ArrayList<Professor>();
			
			while(rs.next()) {
				Professor professor = instanciaProfessor(rs);
				lista.add(professor);
			} 
			
			return lista;
			
		} catch (SQLException e) {
			throw new DbExcessao(e.getMessage());
		} 
		finally {
			DB.closeStatement(ps);
			DB.closeResultSet(rs);
		}
		
	}

	private Professor instanciaProfessor(ResultSet rs) throws SQLException {
		Professor professor = new Professor();
		professor.setId(rs.getInt("id"));
		professor.setCodigoFuncional(rs.getString("codigoFuncional"));
		professor.setNome(rs.getString("nome"));
		LocalDate data = rs.getDate("dataNascimento").toLocalDate();
		professor.setDataNascimento(data);
		return professor;
	}

}
