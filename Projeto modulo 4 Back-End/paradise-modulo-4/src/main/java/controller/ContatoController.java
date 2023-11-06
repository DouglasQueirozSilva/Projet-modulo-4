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
import dao.ContatoDAO;
import model.Contato;

@WebServlet(urlPatterns = { "/contato", "/contato-save", "/contato-delete" })
public class ContatoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ContatoDAO cdao = new ContatoDAO();
	ClienteDAO cldao = new ClienteDAO();

	public ContatoController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String route = request.getServletPath();
		switch (route) {
		case "/contato":
			read(request, response);
			break;
		case "/contato-save":

			save(request, response);
			break;
		case "/contato-delete":
			delete(request, response);

			break;
		default:

			break;
		}
	}

	protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Contato contato = new Contato();
		int idcliente = Integer.parseInt(request.getParameter("cliente"));
		contato.setCliente(cldao.readById(idcliente));
		contato.setEmail(request.getParameter("email"));
		contato.setMensagem(request.getParameter("mensagem"));
		contato.setNome_completo(request.getParameter("nome"));
		contato.setTelefone(request.getParameter("telefone"));
		if (request.getParameter("id") != null) {
			contato.setId_contato(Integer.parseInt(request.getParameter("id")));
			cdao.update(contato);
		} else {
			cdao.create(contato);
		}
		response.sendRedirect("./contato");
	}

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Contato> contatos = cdao.read();
		request.setAttribute("contatos", contatos);
		RequestDispatcher rd = request.getRequestDispatcher("./contato.jsp");
		rd.forward(request, response);
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		cdao.delete(id);
		response.sendRedirect("./contato");
	}
}
