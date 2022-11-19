package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.util.List;
import java.util.Calendar;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fintech.Dao.Investimento.InvestimentoDAO;
import br.com.fiap.fintech.entity.Investimento;

import br.com.fiap.fintech.Dao.DAOFactory;
import br.com.fiap.fintech.Dao.Investimento.*;



/**
 * Servlet implementation class InvestimentosCard
 */
@WebServlet("/InvestimentosCard")
public class InvestimentosCard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
private InvestimentoDAO dao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getInvestimentoDAO();
	}
  
	
	public InvestimentosCard() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Investimento> lista = dao.getAll();
		request.setAttribute("investimentos", lista);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		listar(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
