package br.com.fiap.fintech.testes;

import br.com.fiap.fintech.Dao.DAOFactory;
import br.com.fiap.fintech.entity.Usuario;

public class Testando {

	public static void main(String[] args) {

		Usuario user = new Usuario(0, "emailusuario@gmail.com", "123456","");
		
		
		System.out.println(DAOFactory.getUsuarioDAO().validarUsuario(user).getEmail());
		
		
		
	}

}
