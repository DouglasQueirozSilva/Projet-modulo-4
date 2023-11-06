package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import dao.CompraDAO;
import dao.DestinoDAO;
import model.Compra;

@WebServlet(urlPatterns = { "/compra", "/compra-save", "/compra-delete" })
public class CompraController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CompraDAO cdao = new CompraDAO();
	ClienteDAO cldao = new ClienteDAO();
	DestinoDAO ddao = new DestinoDAO();

	public CompraController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String route = request.getServletPath();
		switch (route) {
		case "/compra":
			read(request, response);
			break;
		case "/compra-save":

			save(request, response);
			break;
		case "/compra-delete":
			delete(request, response);

			break;
		default:

			break;
		}
	}

	protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Compra compra = new Compra();
		int idcliente = Integer.parseInt(request.getParameter("cliente"));
		int iddestino = Integer.parseInt(request.getParameter("destino"));
		compra.setCliente(cldao.readById(idcliente));
		compra.setDestino(ddao.readById(iddestino));
		if (request.getParameter("id") != null) {
			compra.setId_compra(Integer.parseInt(request.getParameter("id")));
			cdao.update(compra);
		} else {
			cdao.create(compra);
		}
		response.sendRedirect("./compra");
	}

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Compra> compras = cdao.read();
		request.setAttribute("compras", compras);
		RequestDispatcher rd = request.getRequestDispatcher("./compra.jsp");
		rd.forward(request, response);
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		cdao.delete(id);
		response.sendRedirect("./compra");
	}

}
