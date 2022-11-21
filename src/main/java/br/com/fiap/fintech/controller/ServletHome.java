package br.com.fiap.fintech.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fintech.entity.Movimentacao;
import br.com.fiap.fintech.util.Function;

/**
 * Servlet implementation class ServletHome
 */

@WebServlet("/ServletHome")
public class ServletHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int cd_usuario = Integer.parseInt(request.getParameter("User"));
		int cd_conta   = Integer.parseInt(request.getParameter("Account"));
		
		Calendar today 	 = Calendar.getInstance();
		Locale local_br  = new Locale("pt","BR");
		List<String> msg = new ArrayList<String>();
			
		if (request.getParameter("Action").toUpperCase().trim().equals("SHOW")) {

			ControllerFluxoCaixa controller_fluxo = new ControllerFluxoCaixa(cd_usuario, cd_conta, local_br, today);
			
			request.getSession().setAttribute("MonthInFull", controller_fluxo.getMonth());
			
			try {

				request.setAttribute("ContaSaldo", controller_fluxo.getSaldoConta());

				Double total_receitas = 0.00;
				Double total_despesas = 0.00;
				List<Movimentacao> movimentacoes = controller_fluxo.getMovimentacoes();

				Integer count_rec = 0;
				Integer count_des = 0;
				List<Movimentacao> receitas = new ArrayList<Movimentacao>();
				List<Movimentacao> despesas = new ArrayList<Movimentacao>();
				
				
				for (Movimentacao movimentacao : movimentacoes) {

					if("R".equals(movimentacao.getTp_movimentacao().toUpperCase().trim())) {
						
						total_receitas = total_receitas + movimentacao.getVl_movimentacao();
						
						if (count_rec < 5) {
							receitas.add(movimentacao);
							count_rec ++;
						}
				
					} else{
						
						total_despesas =+ movimentacao.getVl_movimentacao();	
						
						if (count_des < 5) {
							despesas.add(movimentacao);
							count_des ++;
						}
					}
				}
				
				
				request.setAttribute("TotalReceita", Function.DoubleToCurrency(total_receitas, local_br));
				request.setAttribute("TotalDespesa", Function.DoubleToCurrency(total_despesas, local_br));
				
				request.setAttribute("Receitas", receitas);
				request.setAttribute("Despesas", despesas);
				
				request.setAttribute("Remaining_Rec", controller_fluxo.checkRemaining(count_rec));
				request.setAttribute("Remaining_Des", controller_fluxo.checkRemaining(count_des));
				
			} catch(Exception e) {
				
				System.out.println(e);
				request.setAttribute("ValuesError_FC", "--");
				msg.add("E"+"Falha ao Obter os Dados do Fluxo de Caixa. Usuário / Conta Inexistente ou Falha na sua Conexão.");
			}
						
		} else {
			
			String mode = request.getParameter("Action");
			request.setAttribute("MovimentacaoTRN", new ControllerMovimentacaoTRN(mode, cd_usuario, cd_conta, 0));

		}	
		
		request.setAttribute("Msg", msg);
		request.getRequestDispatcher("Home.jsp").forward(request, response);		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}	
}
