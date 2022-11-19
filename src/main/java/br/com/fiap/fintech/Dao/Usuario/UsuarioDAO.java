package br.com.fiap.fintech.Dao.Usuario;


import br.com.fiap.fintech.entity.Usuario;

public interface UsuarioDAO {

	Usuario validarUsuario(String email, String senha);
	
}