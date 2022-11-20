package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fintech.Dao.DAOFactory;
import br.com.fiap.fintech.Dao.Movimentacao.MovimentacaoDAO;
import br.com.fiap.fintech.entity.Categoria;
import br.com.fiap.fintech.entity.Movimentacao;

/**
 * Servlet implementation class ServletMovimentacaoList
 */
@WebServlet("/ServletMovimentacao")
public class ServletMovimentacao extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMovimentacao() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int cd_usuario = Integer.parseInt(request.getParameter("User"));
		int cd_conta   = Integer.parseInt(request.getParameter("Account"));
		
		String RedirectList = "ServletMovimentacao?User="+cd_usuario+"&Account="+cd_conta+"&Action=Show";
		
		MovimentacaoDAO mov_dao = DAOFactory.getMovimentacaoDAO();

		switch (request.getParameter("Action").toUpperCase().trim()) {
		
			case "INS":
				try {
					
					Categoria categoria 	  = DAOFactory.getCategoriaDAO().getByID(Integer.parseInt(request.getParameter("Categoria")));
					Double 	  vl_movimentacao = Double.parseDouble(request.getParameter("Valor"));
					String    tp_movimentacao = request.getParameter("Tipo").toUpperCase().trim();
					Calendar  dt_movimentacao = Calendar.getInstance();
					dt_movimentacao.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("Data")));
					
					Movimentacao movimentcao = new Movimentacao(cd_usuario, cd_conta, 0, categoria, dt_movimentacao, vl_movimentacao, tp_movimentacao);
					mov_dao.insertByID(movimentcao);
					
					response.sendRedirect("ServletHome?User="+cd_usuario+"&Account="+cd_conta+"&Action=Show");
				
				} catch (Exception e) {
					
				}
				break;
				
			case "SHOW":
				
				request.getSession().setAttribute("Title", "Movimentações");
				request.getSession().setAttribute("h1", "Histórico Movimentações");
			
				List<String> titles = new ArrayList<String>();
				String[] values = "L10Tipo-L40Categoria-L30Valor-C10Data-C05-C05".split("-");
				for (int i = 0 ; i < values.length ; i++) {
					titles.add(values[i]);
				}
				
				request.getSession().setAttribute("Titles", titles);
				
				List<Movimentacao> movimentacoes = mov_dao.getAllByConta(cd_usuario, cd_conta);		
				request.getSession().setAttribute("Movimentacoes", movimentacoes);
				break;
				
			default:

				String  mode 			= request.getParameter("Action").substring(0,3);
				Integer cd_movimentacao = Integer.parseInt(request.getParameter("Action").substring(3));
				request.setAttribute("MovimentacaoTRN", new ControllerMovimentacaoTRN(mode, cd_usuario, cd_conta, cd_movimentacao));
				break;
		}

		request.getRequestDispatcher("Listagem.jsp").forward(request, response);
}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
