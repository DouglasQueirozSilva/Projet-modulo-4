package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Cliente;
import model.Contato;

public class ContatoDAO {

	// create
	public void create(Contato contato) {

		String sql = "insert into Contato (Nome_Completo, Mensagem, Telefone, Email, Id_Cliente) values (?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, contato.getNome_completo());
			pstm.setString(2, contato.getMensagem());
			pstm.setString(3, contato.getTelefone());
			pstm.setString(4, contato.getEmail());
			pstm.setInt(5, contato.getCliente().getId_Cliente());
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// read
	public List<Contato> read() {
		List<Contato> contatos = new ArrayList<Contato>();
		String sql = "select * from contato_cliente order by id_contato";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Contato contato = new Contato();
				Cliente cliente = new Cliente();
				
				contato.setId_contato(rset.getInt("id_contato"));
				contato.setNome_completo(rset.getString("Nome_Completo"));
				contato.setMensagem(rset.getString("Mensagem"));
				contato.setTelefone(rset.getString("Telefone"));
				contato.setEmail(rset.getString("Email"));
				
				cliente.setId_Cliente(rset.getInt("Id_Cliente"));
			    cliente.setNome(rset.getString("Nome"));
			    cliente.setCelular(rset.getString("Celular"));
				
				contato.setCliente(cliente);

				contatos.add(contato);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return contatos;
	}

	// update
	public void update(Contato contato) {
		String sql = "UPDATE contato SET Nome_Completo = ?, Mensagem = ?, Telefone = ?, Email = ?, Id_Cliente = ? WHERE Id_Contato = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, contato.getNome_completo());
			pstm.setString(2, contato.getMensagem());
			pstm.setString(3, contato.getTelefone());
			pstm.setString(4, contato.getEmail());
			pstm.setInt(5, contato.getCliente().getId_Cliente());
            pstm.setInt(6, contato.getId_contato());
            
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// delete
	public void delete(int id) {
		String sql = "DELETE FROM Contato WHERE Id_Contato = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// readById
	public Contato readById(int id) {
		Contato contato = new Contato();
		String sql = "select * from Contato WHERE Id_Contato = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			contato.setNome_completo(rset.getString("Nome_Completo"));
			contato.setMensagem(rset.getString("Mensagem"));
			contato.setTelefone(rset.getString("Telefone"));
			contato.setEmail(rset.getString("Email"));
			contato.setId_contato(id);
			int Id_Cliente = rset.getInt("Id_Cliente");
			ClienteDAO clientedao = new ClienteDAO();
			Cliente cliente = clientedao.readById(Id_Cliente);
			contato.setCliente(cliente);
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return contato;
	}

}