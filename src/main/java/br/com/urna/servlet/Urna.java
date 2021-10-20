package br.com.urna.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.urna.controle.Controle;
import br.com.urna.entidades.Candidato;

/**
 * Servlet implementation class Urna
 */

@WebServlet("/urna")
public class Urna extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Controle controle = new Controle();
	public static Candidato candidato = null;
	public String contexto = "/index.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Urna() {
		super();
	}

	@Override
	public void init() {
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		controle.setNumero("");
		candidato = null;
		response.sendRedirect(request.getContextPath() + "/index.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		contexto = "/index.jsp";
		
		controle.addDigito(request.getParameter("numero"));
		
		// Pesquisa prefeito/vereador
		if (controle.getRank().equals("Prefeito") && controle.getNumero().length() == 2) {
			candidato = controle.buscar("P");
			if (candidato == null) {
				controle.setNumero("");
			}
		} else if (controle.getRank().equals("Vereador") && controle.getNumero().length() == 5) {
			candidato = controle.buscar("V");
			if (candidato == null) {
				controle.setNumero("");
			}
		}
		
		//Votar branco
		if(request.getParameter("branco") != null) {
			controle.setNumero("");
			candidato = null;
			controle.votar(candidato);
		}

		// Vota prefeito/vereador
		if (request.getParameter("confirma") != null && controle.isBloquear() == true) {
			controle.setNumero("");
			candidato = null;
			controle.setBloquear(false);
		} else if (request.getParameter("confirma") != null && controle.getRank().equals("Prefeito") ) {
			if(candidato != null) {
				controle.votar(candidato);
			}
			controle.setNumero("");
			candidato = null;
		} else if (request.getParameter("confirma") != null && controle.getRank().equals("Vereador")) {
			if(candidato != null) {
				controle.votar(candidato);
				controle.setBloquear(true);
			}
			controle.setNumero("");
			candidato = null;
		}
		
		//Rediciona para a tela de resultado
		if(request.getParameter("resultado") != null) {
			contexto = "/resultado.jsp";
		}
		
		response.sendRedirect(request.getContextPath() + contexto);
	}
}
