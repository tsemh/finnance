package br.com.fiap.fintech.testes;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import br.com.fiap.fintech.Dao.DAOFactory;
import br.com.fiap.fintech.controller.ControllerFluxoCaixa;
import br.com.fiap.fintech.entity.Aplicacao;
import br.com.fiap.fintech.entity.Investimento;

public class Testando {

	public static void main(String[] args) {		
		
		ControllerFluxoCaixa tmc = new ControllerFluxoCaixa(13, 1, new Locale("pt","BR"), Calendar.getInstance());
		
		
		
		System.out.println(DAOFactory.getContaDAO().getByID(13, 3).getVl_saldo());
		
	}

}
