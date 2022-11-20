package br.com.fiap.fintech.testes;

import java.util.List;

import br.com.fiap.fintech.Dao.DAOFactory;
import br.com.fiap.fintech.entity.Investimento;

public class Testando {

	public static void main(String[] args) {		
		
		List <Investimento> investimento = DAOFactory.getInvestimentoDAO().getAll();
		
		for(Aplicacao a: investimento) {
			System.out.println(inv.toString());	
		}
		
		
	}

}
