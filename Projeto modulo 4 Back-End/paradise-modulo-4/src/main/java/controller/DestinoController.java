package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DestinoDAO;
import model.Destino;

@WebServlet(urlPatterns = { "/destino", "/destino-save", "/destino-delete" })
public class DestinoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DestinoDAO ddao = new DestinoDAO();

	public DestinoController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String route = request.getServletPath();
		switch (route) {
		case "/destino":
			read(request, response);
			break;
		case "/destino-save":

			save(request, response);
			break;
		case "/destino-delete":
			delete(request, response);

			break;
		default:

			break;
		}
	}

	protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Destino destino = new Destino();
		destino.setValor(Float.parseFloat(request.getParameter("valor")));
		destino.setIda(request.getParameter("ida"));
		destino.setVolta(request.getParameter("volta"));
		if (request.getParameter("id") != null) {
			destino.setId_destino(Integer.parseInt(request.getParameter("id")));
			ddao.update(destino);

		} else {
			ddao.create(destino);
		}
		response.sendRedirect("./destino");
	}

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Destino> destinos = ddao.read();
		request.setAttribute("destinos", destinos);
		RequestDispatcher rd = request.getRequestDispatcher("./destino.jsp");
		rd.forward(request, response);
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ddao.delete(id);
		response.sendRedirect("./destino");
	}

}
