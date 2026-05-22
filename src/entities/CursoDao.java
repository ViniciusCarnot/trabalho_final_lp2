package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import exceptions.DbExcessao;

public class CursoDao implements IFuncoesCrud<Curso> {
	
	private Connection conn;
	
	public CursoDao(Connection conn) {
		this.conn = conn;
	}
	
	public CursoDao() {
		this.conn = DB.getConnection();
	}

	@Override
	public void inserir(Curso curso) {
		
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("INSERT INTO curso "
					+ "(codigo, nome, descricao, dataInicio, dataEncerramentoPrevista) "
					+ "values "
					+ "(?, ?, ?, ?, ?)" ,
					Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, curso.getCodigo());
			ps.setString(2, curso.getNome());
			ps.setString(3, curso.getDescricao());
			ps.setObject(4, curso.getDataInicio());
			ps.setObject(5, curso.getDataEncerramentoPrevista());
			
			int rowsAffected = ps.executeUpdate();
			
			if(rowsAffected > 0) {
				
				ResultSet rs = ps.getGeneratedKeys();
				
				if(rs.next()) {
					
					int id = rs.getInt(1);
					curso.setId(id);
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
			ps = conn.prepareStatement("DELETE FROM curso "
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
	public void atualizar(Curso curso) {
		
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("UPDATE curso "
					+ "set codigo = ?, "
					+ "nome = ?, "
					+ "descricao = ?, "
					+ "dataInicio = ?, "
					+ "dataEncerramentoPrevista = ? "
					+ "WHERE id = ?");
			
			ps.setString(1, curso.getCodigo());
			ps.setString(2, curso.getNome());
			ps.setString(3, curso.getDescricao());
			ps.setObject(4, curso.getDataInicio());
			ps.setObject(5, curso.getDataEncerramentoPrevista());
			ps.setInt(6, curso.getId());
			
			ps.executeUpdate();
		
			
		} catch (SQLException e) {
			throw new DbExcessao(e.getMessage());
		}
		finally {
			DB.closeStatement(ps);
		}
		
	}

	@Override
	public Curso ler(Integer id) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("SELECT * FROM curso WHERE id = ?");
			
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				Curso curso = instanciaCurso(rs);
				return curso;
			} else {
				System.out.println("Curso com o id: " + id + " não existe.");
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
	public List<Curso> lerTodos() {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("SELECT * FROM curso");
			
			rs = ps.executeQuery();
			
			List<Curso> lista = new ArrayList<Curso>();
			
			while(rs.next()) {
				Curso curso = instanciaCurso(rs);
				lista.add(curso);
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
	
	private Curso instanciaCurso(ResultSet rs) throws SQLException {
		Curso curso = new Curso();
		curso.setId(rs.getInt("id"));
		curso.setCodigo(rs.getString("codigo"));
		curso.setNome(rs.getString("nome"));
		curso.setDescricao(rs.getString("descricao"));
		LocalDate dataInicio = rs.getDate("dataInicio").toLocalDate();
		LocalDate dataEncerramentoPrevista = rs.getDate("dataEncerramentoPrevista").toLocalDate();
		curso.setDataInicio(dataInicio);
		curso.setDataEncerramentoPrevista(dataEncerramentoPrevista);
		return curso;
	}

}
