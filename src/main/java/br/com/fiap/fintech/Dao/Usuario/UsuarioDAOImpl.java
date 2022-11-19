package br.com.fiap.fintech.Dao.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.fiap.fintech.entity.Usuario;
import br.com.fiap.fintech.Dao.Usuario.UsuarioDAO;
import br.com.fiap.fintech.jdbc.ConnectionManager;
import br.com.fiap.fintech.util.CriptografiaUtils;

public class UsuarioDAOImpl implements UsuarioDAO{
	
	private Connection conexao;

	@Override
	public Usuario validarUsuario(String email, String senha) {

		Usuario user = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_FIN_USUARIO WHERE DS_EMAIL = ? AND DS_SENHA = ?");
			
			stmt.setString(1, email);
			stmt.setString(2, senha);

			rs = stmt.executeQuery();

			if (rs.next()){
				
				Integer cd_usuario = rs.getInt   ("CD_USUARIO");
				String  nm_usuario = rs.getString("NM_USUARIO");
				
				user = new Usuario(cd_usuario, email, senha, nm_usuario);	
				return user;
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			try {
				rs.close();
				stmt.close();
				conexao.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return user;
	}

}