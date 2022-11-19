package br.com.fiap.fintech.testes;

import java.util.List;
import java.util.Locale;

import br.com.fiap.fintech.Dao.DAOFactory;
import br.com.fiap.fintech.controller.ControllerFluxoCaixa;
import br.com.fiap.fintech.entity.Movimentacao;
import br.com.fiap.fintech.util.CriptografiaUtils;

public class Testes {

    public static void main(String[] args) {
      try {
        System.out.println(CriptografiaUtils.criptografar("123456"));
        System.out.println(CriptografiaUtils.criptografar("123456"));
      } catch (Exception e) {
        e.printStackTrace();
      }
		
	}

}
