package br.com.fiap.fintech.Dao.Usuario;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.entity.ContaUsuario;
import br.com.fiap.fintech.entity.Usuario;
import br.com.fiap.fintech.Dao.Usuario.UsuarioDAO;
import br.com.fiap.fintech.jdbc.ConnectionManager;
import br.com.fiap.fintech.util.CriptografiaUtils;

public class UsuarioDAOImpl implements UsuarioDAO{
	
	private Connection conexao;
	Usuario user = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public Usuario validarUsuario(String email, String senha) {



		try {
			
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_USUARIO WHERE DS_EMAIL = ? AND DS_SENHA = ?");
			
			pstmt.setString(1, email);
			pstmt.setString(2, senha);

			rs = pstmt.executeQuery();

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
				pstmt.close();
				conexao.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return user;
	}
	
	
	public void insertByID(Usuario usuario) {
		PreparedStatement pstmt = null;
		try {

			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("INSERT INTO T_FIN_USUARIO VALUES(SEQ_FIN_CONTA.NEXTVAL,?,?,?,?,?)");

			pstmt.setInt   (1, usuario.getCd_usuario());
			pstmt.setString(2, usuario.getEmail());
			pstmt.setString(3, usuario.getSenha());
			pstmt.setString(4, usuario.getNm_usuario());
	        
	        pstmt .executeUpdate();
	        
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				pstmt.close();
				conexao.close();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Usuario> getAll() {
		
		List<Usuario> lista = new ArrayList<Usuario>();
		ResultSet rs = null;
		
		try {
			
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_USUARIO");
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				Integer cd_usuario = rs.getInt("CD_USUARIO");
				String ds_email = rs.getString("DS_EMAIL");
				String nm_usuario = rs.getString("NM_USUARIO");
				String ds_senha = rs.getString("DS_SENHA");
		
				Usuario usuario = new Usuario(cd_usuario,ds_email,nm_usuario,ds_senha);
				lista.add(usuario);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				rs.close();
				pstmt.close();
				conexao.close();
		
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return lista;
	}

	public Usuario getByID(Integer cd_usuario) {

		Usuario usuario = null;
		ResultSet rs = null;

		try {
			
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("SELECT * FROM T_FIN_CONTA_USUARIO "
											+"WHERE T_FIN_USUARIO_CD_USUARIO = ?");
			
			pstmt.setInt(1, cd_usuario);
			
			rs = pstmt.executeQuery();

			if (rs.next()) {
				
				cd_usuario        = rs.getInt("CD_USUARIO");
				String ds_email   = rs.getString("DS_EMAIL");
				String nm_usuario = rs.getString("NM_USUARIO");
				String ds_senha   = rs.getString("DS_SENHA");
				
				usuario = new Usuario(cd_usuario,ds_email,nm_usuario,ds_senha);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				rs.close();
				pstmt.close();
				conexao.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return usuario;
	}

	public void updateByID(Usuario usuario) {

		try {
			
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("UPDATE T_FIN_CONTA_USUARIO SET NM_USUARIO = ? , DS_EMAIL = ? , DS_SENHA = ? "
											+"WHERE T_FIN_USUARIO_CD_USUARIO = ? AND CD_USUARIO = ?");
			
			pstmt.setInt   (1, usuario.getCd_usuario());
			pstmt.setString(2, usuario.getEmail());
			pstmt.setString(3, usuario.getSenha());
			pstmt.setString(4, usuario.getNm_usuario());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				pstmt.close();
				conexao.close();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteByID(Integer cd_usuario) {

		try {
			
			conexao = ConnectionManager.getInstance().getConnection();
			pstmt = conexao.prepareStatement("DELETE FROM T_FIN_CONTA_USUARIO "
											+"WHERE T_FIN_USUARIO_CD_USUARIO = ?");

			pstmt.setInt(1, cd_usuario);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		
		} finally {
			try {
				pstmt.close();
				conexao.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}