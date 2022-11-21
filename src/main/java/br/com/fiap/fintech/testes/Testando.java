package br.com.fiap.fintech.testes;

<<<<<<< HEAD
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import br.com.fiap.fintech.Dao.DAOFactory;
import br.com.fiap.fintech.controller.ControllerFluxoCaixa;
import br.com.fiap.fintech.entity.Aplicacao;
=======
import java.util.List;

import br.com.fiap.fintech.Dao.DAOFactory;
>>>>>>> 7c89ff9d3a29b777a8c6a778ba9b6d0566297063
import br.com.fiap.fintech.entity.Investimento;

public class Testando {

	public static void main(String[] args) {		
		
<<<<<<< HEAD
		ControllerFluxoCaixa tmc = new ControllerFluxoCaixa(13, 1, new Locale("pt","BR"), Calendar.getInstance());
		
		
		
		System.out.println(DAOFactory.getContaDAO().getByID(13, 3).getVl_saldo());
=======
		List <Investimento> investimento = DAOFactory.getInvestimentoDAO().getAll();
		
		for(Aplicacao a: investimento) {
			System.out.println(inv.toString());	
		}
		
>>>>>>> 7c89ff9d3a29b777a8c6a778ba9b6d0566297063
		
	}

}
