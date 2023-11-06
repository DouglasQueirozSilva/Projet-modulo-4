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
import model.Cliente;

@WebServlet(urlPatterns={"/cliente","/cliente-save","/cliente-delete"})
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClienteDAO cdao=new ClienteDAO();
	public ClienteController() {
	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String route=request.getServletPath();
		switch (route) {
		case "/cliente":
			read(request,response);
			break;
		case "/cliente-save":
			
			save(request,response);
			break;
		case "/cliente-delete":
			delete(request,response);
			
			break;
		default:
			
			break;
		}
	}
	protected void save(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cliente cliente=new Cliente();
		cliente.setNome(request.getParameter("nome"));
		cliente.setCelular(request.getParameter("celular"));
		if(request.getParameter("id")!=null) {
			cliente.setId_Cliente(Integer.parseInt(request.getParameter("id")));
			cdao.update(cliente);
			
		}else {
			cdao.create(cliente);
		}
		response.sendRedirect("./cliente");
	}
	protected void read(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Cliente>clientes=cdao.read();
		request.setAttribute("clientes", clientes);
		RequestDispatcher rd=request.getRequestDispatcher("./cliente.jsp");
		rd.forward(request, response);
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		cdao.delete(id);
		response.sendRedirect("./cliente");
	}
}
