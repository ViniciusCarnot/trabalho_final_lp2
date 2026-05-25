package entities.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.DB;
import entities.dto.ProfessorDtoRequisicao;
import entities.dto.ProfessorDtoResposta;
import entities.interfaces.IProfessorCrud;
import exceptions.DbExcessao;
import exceptions.RecursoNaoEncontradoExcessao;

public class ProfessorDao implements IProfessorCrud {
	
	private Connection conn;
	
	public ProfessorDao(Connection conn) {
		this.conn = conn;
	}
	
	public ProfessorDao() {
		this.conn = DB.getConnection();
	}

	@Override
	public ProfessorDtoResposta inserir(ProfessorDtoRequisicao dtoRequisicao) {
		
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("INSERT INTO professor "
					+ "(codigoFuncional, nome, dataNascimento) "
					+ "VALUES "
					+ "(?, ?, ?)");
			
			ps.setString(1, dtoRequisicao.getCodigoFuncional());
			ps.setString(2, dtoRequisicao.getNome());
			ps.setObject(3, dtoRequisicao.getDataNasc());
			
			int linhasAfetadas = ps.executeUpdate();
			
			ProfessorDtoResposta dtoResposta;
			
			if(linhasAfetadas > 0) {	
				dtoResposta = ler(dtoRequisicao.getCodigoFuncional());
				System.out.println("Professor adicionado com sucesso.");
			} else {
				throw new DbExcessao("Erro inesperado! Nenhuma linha afetada.");
			}
			
			return dtoResposta;
			
		} catch (SQLException e) {
			throw new DbExcessao("Erro ao inserir Professor: " + e.getMessage());
		}
		finally {
			DB.closeStatement(ps);
		}
		
	}
	
	@Override
	public ProfessorDtoResposta atualizar(String codigoAtual, ProfessorDtoRequisicao dtoRequisicao) {
		
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("UPDATE professor SET "
					+ "codigoFuncional = ?, "
					+ "nome = ?, "
					+ "dataNascimento = ?"
					+ "WHERE codigoFuncional = ?");
			
			ps.setString(1, dtoRequisicao.getCodigoFuncional());
			ps.setString(2, dtoRequisicao.getNome());
			ps.setObject(3, dtoRequisicao.getDataNasc());
			ps.setString(4, codigoAtual);
			
			int linhasAfetadas = ps.executeUpdate();
			
			ProfessorDtoResposta dtoResposta;
			
			if(linhasAfetadas > 0) {
				dtoResposta = ler(dtoRequisicao.getCodigoFuncional());
				System.out.println("Professor atualizado com sucesso.");
			} else {
				throw new DbExcessao("Erro inesperado. Nenhuma linha afetada.");
			}
			
			return dtoResposta;
		
			
		} catch (SQLException e) {
			throw new DbExcessao("Erro ao atualizar Professor: " + e.getMessage());
		}
		finally {
			DB.closeStatement(ps);
		}
		
	}
	
	@Override
	public ProfessorDtoResposta ler(String codigo) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("SELECT * FROM professor WHERE codigoFuncional = ?");
			
			ps.setString(1, codigo);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return instanciaProfessor(rs);
			} else {
				throw new RecursoNaoEncontradoExcessao("Professor com o código: " + codigo + ", não encontrado.");
			}
			
			
		} catch (SQLException e) {
			throw new DbExcessao("Erro ao ler professor: " + e.getMessage());
		}
		finally {
			DB.closeStatement(ps);
			DB.closeResultSet(rs);
		}
		
	}

	@Override
	public List<ProfessorDtoResposta> lerTodos() {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("SELECT * FROM professor");
			
			rs = ps.executeQuery();
			
			List<ProfessorDtoResposta> lista = new ArrayList<>();
			
			while(rs.next()) {
				lista.add(instanciaProfessor(rs));
			} 
			
			return lista;
			
		} catch (SQLException e) {
			throw new DbExcessao("Erro ao ler professores: " + e.getMessage());
		} 
		finally {
			DB.closeStatement(ps);
			DB.closeResultSet(rs);
		}
		
	}

	@Override
	public void deletar(String codigo) {
		
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("DELETE FROM professor "
					+ "WHERE codigoFuncional = ? "
					+ "LIMIT 1");
			
			ps.setString(1, codigo);
			
			int linhasAfetadas = ps.executeUpdate();
			
			if(linhasAfetadas > 0) {
				System.out.println("Linhas modificadas: " + linhasAfetadas + ".");
				System.out.println("Professor de código: " + codigo + ", deletado com sucesso.");
			} else {
				throw new RecursoNaoEncontradoExcessao("Professor com o código: " + codigo + ", não encontrado.");
			}
			
		} catch (SQLException e) {
			throw new DbExcessao("Erro ao excluir professor: " + e.getMessage());
		} 
		finally {
			DB.closeStatement(ps);
		}
		
	}
	
	private ProfessorDtoResposta instanciaProfessor(ResultSet rs) throws SQLException {
		ProfessorDtoResposta dtoResposta = new ProfessorDtoResposta();
		dtoResposta.setCodigoFuncional(rs.getString("codigoFuncional"));
		dtoResposta.setNome(rs.getString("nome"));
		dtoResposta.setDataNasc(rs.getDate("dataNascimento").toLocalDate());
		return dtoResposta;
	}

}
