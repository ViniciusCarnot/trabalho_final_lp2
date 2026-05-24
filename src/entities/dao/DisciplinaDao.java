package entities.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entities.Curso;
import entities.DB;
import entities.Disciplina;
import entities.Professor;
import entities.dto.DisciplinaDtoResposta;
import entities.dto.DisciplinaDtoRequisicao;
import entities.interfaces.IDisciplinaCrud;
import entities.interfaces.IFuncoesCrud;
import exceptions.DbExcessao;
import exceptions.RecursoNaoEncontradoExcessao;

public class DisciplinaDao implements IDisciplinaCrud {
	
	private Connection conn;
	
	public DisciplinaDao(Connection conn) {
		this.conn = conn;
	}
	
	public DisciplinaDao() {
		this.conn = DB.getConnection();
	}

	@Override
	public DisciplinaDtoResposta inserir(DisciplinaDtoRequisicao dtoRequisicao) {
		
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("INSERT INTO disciplina "
					+ "(numero, nome, dataInicio, dataEncerramento, codigoFuncional_professor, codigo_curso) "
					+ "values "
					+ "(?, ?, ?, ?, ?, ?)");
			
			ps.setInt(1, dtoRequisicao.getNumero());
			ps.setString(2, dtoRequisicao.getNome());
			ps.setObject(3, dtoRequisicao.getDataInicio());
			ps.setObject(4, dtoRequisicao.getDataEncerramento());
			ps.setObject(5, dtoRequisicao.getCodigoProfessor());
			ps.setString(6, dtoRequisicao.getCodigoCurso());
			
			int linhasAfetadas = ps.executeUpdate();
			
			DisciplinaDtoResposta dtoResposta = new DisciplinaDtoResposta();
			
			if(linhasAfetadas > 0) {
				dtoResposta = ler(dtoRequisicao.getNumero());
				System.out.println("Disciplina inserida com sucesso.");
			} else {
				throw new DbExcessao("Erro inesperado! Nenhuma linha afetada.");
			}
			
			return dtoResposta;
			
		} catch (SQLException e) {
			throw new DbExcessao("Erro ao inserir disciplina: " + e.getMessage());
		}
		finally {
			DB.closeStatement(ps);
		}
		
	}

	@Override
	public DisciplinaDtoResposta atualizar(Integer numeroAtual, DisciplinaDtoRequisicao dtoRequisicao) {
		
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("UPDATE disciplina SET "
					+ "numero = ?, "
					+ "nome = ?, "
					+ "dataInicio = ?, "
					+ "dataEncerramento = ?, "
					+ "codigo_curso = ?, "
					+ "codigoFuncional_professor = ? "
					+ "WHERE numero = ?");
			
			ps.setInt(1, dtoRequisicao.getNumero());
			ps.setString(2, dtoRequisicao.getNome());
			ps.setObject(3, dtoRequisicao.getDataInicio());
			ps.setObject(4, dtoRequisicao.getDataEncerramento());
			ps.setString(5, dtoRequisicao.getCodigoCurso());
			ps.setObject(6, dtoRequisicao.getCodigoProfessor());
			ps.setInt(7, numeroAtual);
			
			int linhasAfetadas = ps.executeUpdate();
			
			DisciplinaDtoResposta dtoResposta;
			
			if(linhasAfetadas > 0) {
				dtoResposta = ler(dtoRequisicao.getNumero());
				System.out.println("Disciplina atualizada com sucesso.");
			} else {
				throw new DbExcessao("Erro inesperado. Nenhuma linha afetada.");
			}
			
			return dtoResposta;
			
		} catch (SQLException e) {
			throw new DbExcessao("Erro ao atualizar disciplina: " + e.getMessage());
		}
		finally {
			DB.closeStatement(ps);
		}
		
	}

	@Override
	public DisciplinaDtoResposta ler(Integer numero) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(
					"SELECT "
					+ "d.numero, d.nome, d.dataInicio, d.dataEncerramento, "
					+ "c.codigo AS 'codigo_curso', c.nome AS 'nome_curso', "
					+ "p.codigoFuncional AS 'codigo_prof', p.nome AS 'nome_prof' " 
					+ "FROM disciplina d "
					+ "LEFT JOIN curso c ON d.codigo_curso = c.codigo "
					+ "LEFT JOIN professor p ON d.codigoFuncional_professor = p.codigoFuncional "
					+ "WHERE d.numero = ?"
					);
			
			ps.setInt(1, numero);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return instanciaDisciplinaDtoResposta(rs);
			} else {
				throw new RecursoNaoEncontradoExcessao("Disciplina com o número: " + numero + ", não encontrada.");
			}
			
			
		} catch (SQLException e) {
			throw new DbExcessao("Erro ao ler disciplina: " + e.getMessage());
		}
		finally {
			DB.closeStatement(ps);
			DB.closeResultSet(rs);
		}
		
	}

	@Override
	public List<DisciplinaDtoResposta> lerTodos() {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(
					"SELECT "
						+ "d.numero, d.nome, d.dataInicio, d.dataEncerramento, "
						+ "c.codigo AS 'codigo_curso', c.nome AS 'nome_curso', "
						+ "p.codigoFuncional AS 'codigo_prof', p.nome AS 'nome_prof' " 
						+ "FROM disciplina d "
						+ "LEFT JOIN curso c ON d.codigo_curso = c.codigo "
						+ "LEFT JOIN professor p ON d.codigoFuncional_professor = p.codigoFuncional "
						+ "ORDER BY d.nome"
						);
			
			rs = ps.executeQuery();
			
			List<DisciplinaDtoResposta> lista = new ArrayList<>();
			
			while(rs.next()) {
				lista.add(instanciaDisciplinaDtoResposta(rs));
			} 
			
			return lista;
			
		} catch (SQLException e) {
			throw new DbExcessao("Erro ao ler disciplinas: " + e.getMessage());
		} 
		finally {
			DB.closeStatement(ps);
			DB.closeResultSet(rs);
		}
		
	}
	
	@Override
	public void deletar(Integer numero) {
		
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("DELETE FROM disciplina "
					+ "WHERE numero = ? "
					+ "LIMIT 1");
			
			ps.setInt(1, numero);
			
			int linhasAfetadas = ps.executeUpdate();
			
			if(linhasAfetadas > 0) {
				System.out.println("Linhas modificadas: " + linhasAfetadas + ".");
				System.out.println("Disciplina de número: " + numero + ", deletada com sucesso.");
			} else {
				throw new RecursoNaoEncontradoExcessao("Disciplina com o número: " + numero + ", não encontrada.");
			}
			
		} catch (SQLException e) {
			throw new DbExcessao("Erro ao excluir disciplina: " + e.getMessage());
		} 
		finally {
			DB.closeStatement(ps);
		}
		
	}
	
	private DisciplinaDtoResposta instanciaDisciplinaDtoResposta(ResultSet rs) throws SQLException {
		DisciplinaDtoResposta dtoResposta = new DisciplinaDtoResposta();
		dtoResposta.setNumero(rs.getInt("numero"));
		dtoResposta.setNome(rs.getString("nome"));
		dtoResposta.setDataInicio(rs.getDate("dataInicio").toLocalDate());
		dtoResposta.setDataEncerramento(rs.getDate("dataEncerramento").toLocalDate());
		dtoResposta.setCodigoCurso(rs.getString("codigo_curso"));
		dtoResposta.setNomeCurso(rs.getString("nome_curso"));
		dtoResposta.setCodigoProfessor(rs.getString("codigo_prof"));
		dtoResposta.setNomeProfessor(rs.getString("nome_prof"));
		return dtoResposta;
	}
	
	
}
