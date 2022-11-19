package br.com.fiap.fintech.testes;

import java.util.List;
import java.util.Locale;

import br.com.fiap.fintech.Dao.DAOFactory;
import br.com.fiap.fintech.controller.ControllerFluxoCaixa;
import br.com.fiap.fintech.entity.Movimentacao;
import br.com.fiap.fintech.util.CriptografiaUtils;

public class Testes {

<<<<<<< HEAD
    public static void main(String[] args) {
      try {
        System.out.println(CriptografiaUtils.criptografar("123456"));
        System.out.println(CriptografiaUtils.criptografar("123456"));
      } catch (Exception e) {
        e.printStackTrace();
      }
=======
	public static void main(String[] args) {

		String[] teste = "-checked-disabled".split("-");

		for (int i = 0; 0 < 2; i++) {
			System.out.println(teste[i]);
		}
>>>>>>> f9972bd0fd438f8dd801b151581d78f8f747e742
		
	}

}
