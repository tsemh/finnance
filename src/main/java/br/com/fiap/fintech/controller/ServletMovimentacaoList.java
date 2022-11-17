package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fintech.Dao.DAOFactory;
import br.com.fiap.fintech.entity.Movimentacao;

/**
 * Servlet implementation class ServletMovimentacaoList
 */
@WebServlet("/ServletMovimentacaoList")
public class ServletMovimentacaoList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMovimentacaoList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("Title", "Movimentações");
		request.setAttribute("h1", "Histórico Movimentações");
	
		List<String> titles = new ArrayList<String>();
		String[] values = "L10Tipo-L40Categoria-L30Valor-C10Data-C05-C05".split("-");
		for (int i = 0 ; i < values.length ; i++) {
			titles.add(values[i]);
		}
		
		request.setAttribute("Titles", titles);
		
		List<Movimentacao> movimentacoes = DAOFactory.getMovimentacaoDAO().getAllByConta(DAOFactory.getContaDAO().getByID(1, 1));		
		request.setAttribute("Movimentacoes", movimentacoes);
		
		request.getRequestDispatcher("Listagem.jsp").forward(request, response);
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
