package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Cliente;
import model.Compra;
import model.Destino;

public class CompraDAO {

	// create
	public void create(Compra compra) {

		String sql = "insert into Compra (Id_Destino, Id_Cliente, Id_Compra) values (?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, compra.getDestino().getId_destino());
			pstm.setInt(2, compra.getCliente().getId_Cliente());
			pstm.setInt(3, compra.getId_compra());
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
	public List<Compra> read() {
		List<Compra> compras = new ArrayList<Compra>();
		String sql = "select * from Compra";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Compra compra = new Compra();

				int Id_Destino = rset.getInt("Id_Destino");
				DestinoDAO destinodao = new DestinoDAO();
				Destino destino = destinodao.readById(Id_Destino);
				compra.setDestino(destino);

				int Id_Cliente = rset.getInt("Id_Cliente");
				ClienteDAO clientedao = new ClienteDAO();
				Cliente cliente = clientedao.readById(Id_Cliente);
				compra.setCliente(cliente);

				compra.setId_compra(rset.getInt("Id_Compra"));

				compras.add(compra);
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

		return compras;
	}

	// update
	public void update(Compra compra) {
		String sql = "UPDATE compra SET Id_Destino = ?, Id_Cliente = ? WHERE Id_Compra = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, compra.getDestino().getId_destino());
			pstm.setInt(2, compra.getCliente().getId_Cliente());
			pstm.setInt(3, compra.getId_compra());

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
		String sql = "DELETE FROM Compra WHERE Id_Compra = ?";

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
	public Compra readById(int id) {
		Compra compra = new Compra();
		String sql = "select * from Compra WHERE Id_Compra = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			int Id_Destino = rset.getInt("Id_Destino");
			DestinoDAO destinodao = new DestinoDAO();
			Destino destino = destinodao.readById(Id_Destino);
			compra.setDestino(destino);

			int Id_Cliente = rset.getInt("Id_Cliente");
			ClienteDAO clientedao = new ClienteDAO();
			Cliente cliente = clientedao.readById(Id_Cliente);
			compra.setCliente(cliente);
			compra.setId_compra(rset.getInt("Id_Compra"));

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
		return compra;
	}

}