package entities.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.DB;
import entities.dto.CursoDtoRequisicao;
import entities.dto.CursoDtoResposta;
import entities.interfaces.ICursoCrud;
import exceptions.DbExcessao;
import exceptions.RecursoNaoEncontradoExcessao;

public class CursoDao implements ICursoCrud {
	
	private Connection conn;
	
	public CursoDao(Connection conn) {
		this.conn = conn;
	}
	
	public CursoDao() {
		this.conn = DB.getConnection();
	}

	@Override
	public CursoDtoResposta inserir(CursoDtoRequisicao dtoRequisicao) {
		
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("INSERT INTO curso "
					+ "(codigo, nome, descricao, dataInicio, dataEncerramentoPrevista) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)");
			
			ps.setString(1, dtoRequisicao.getCodigo());
			ps.setString(2, dtoRequisicao.getNome());
			ps.setString(3, dtoRequisicao.getDescricao());
			ps.setObject(4, dtoRequisicao.getDataInicio());
			ps.setObject(5, dtoRequisicao.getDataEncerramentoPrevista());
			
			int linhasAfetadas = ps.executeUpdate();
			
			CursoDtoResposta dtoResposta;
			
			if(linhasAfetadas > 0) {	
				dtoResposta = ler(dtoRequisicao.getCodigo());
				System.out.println("Curso adicionado com sucesso.");
			} else {
				throw new DbExcessao("Erro inesperado! Nenhuma linha afetada.");
			}
			
			return dtoResposta;
			
		} catch (SQLException e) {
			throw new DbExcessao("Erro ao inserir curso: " + e.getMessage());
		}
		finally {
			DB.closeStatement(ps);
		}
		
	}
	
	@Override
	public CursoDtoResposta atualizar(String codigoAtual, CursoDtoRequisicao dtoRequisicao) {
		
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("UPDATE curso SET "
					+ "codigo = ?, "
					+ "nome = ?, "
					+ "descricao = ?, "
					+ "dataInicio = ?, "
					+ "dataEncerramentoPrevista = ? "
					+ "WHERE codigo = ?");
			
			ps.setString(1, dtoRequisicao.getCodigo());
			ps.setString(2, dtoRequisicao.getNome());
			ps.setString(3, dtoRequisicao.getDescricao());
			ps.setObject(4, dtoRequisicao.getDataInicio());
			ps.setObject(5, dtoRequisicao.getDataEncerramentoPrevista());
			ps.setString(6, codigoAtual);
			
			int linhasAfetadas = ps.executeUpdate();
			
			CursoDtoResposta dtoResposta;
			
			if(linhasAfetadas > 0) {
				dtoResposta = ler(dtoRequisicao.getCodigo());
				System.out.println("Curso atualizado com sucesso.");
			} else {
				throw new DbExcessao("Erro inesperado. Nenhuma linha afetada.");
			}
			
			return dtoResposta;
		
			
		} catch (SQLException e) {
			throw new DbExcessao("Erro ao atualizar curso: " + e.getMessage());
		}
		finally {
			DB.closeStatement(ps);
		}
		
	}
	
	@Override
	public CursoDtoResposta ler(String codigo) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("SELECT * FROM curso WHERE codigo = ?");
			
			ps.setString(1, codigo);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return instanciaCursoDtoResposta(rs);
			} else {
				throw new RecursoNaoEncontradoExcessao("Curso com o código: " + codigo + ", não encontrado.");
			}
			
			
		} catch (SQLException e) {
			throw new DbExcessao("Erro ao ler curso: " + e.getMessage());
		}
		finally {
			DB.closeStatement(ps);
			DB.closeResultSet(rs);
		}
		
	}

	@Override
	public List<CursoDtoResposta> lerTodos() {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("SELECT * FROM curso");
			
			rs = ps.executeQuery();
			
			List<CursoDtoResposta> lista = new ArrayList<>();
			
			while(rs.next()) {
				lista.add(instanciaCursoDtoResposta(rs));
			} 
			
			return lista;
			
		} catch (SQLException e) {
			throw new DbExcessao("Erro ao ler cursos: " + e.getMessage());
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
			ps = conn.prepareStatement("DELETE FROM curso "
					+ "WHERE codigo = ? "
					+ "LIMIT 1");
			
			ps.setString(1, codigo);
			
			int linhasAfetadas = ps.executeUpdate();
			
			if(linhasAfetadas > 0) {
				System.out.println("Linhas modificadas: " + linhasAfetadas + ".");
				System.out.println("Curso de código: " + codigo + ", deletado com sucesso.");
			} else {
				throw new RecursoNaoEncontradoExcessao("Curso com o código: " + codigo + ", não encontrado.");
			}
			
		} catch (SQLException e) {
			throw new DbExcessao("Erro ao excluir curso: " + e.getMessage());
		} 
		finally {
			DB.closeStatement(ps);
		}
		
	}
	
	private CursoDtoResposta instanciaCursoDtoResposta(ResultSet rs) throws SQLException {
		CursoDtoResposta dtoResposta = new CursoDtoResposta();
		dtoResposta.setCodigo(rs.getString("codigo"));
		dtoResposta.setNome(rs.getString("nome"));
		dtoResposta.setDescricao(rs.getString("descricao"));
		dtoResposta.setDataInicio(rs.getDate("dataInicio").toLocalDate());
		dtoResposta.setDataEncerramentoPrevista(rs.getDate("dataEncerramentoPrevista").toLocalDate());
		return dtoResposta;
	}

}
