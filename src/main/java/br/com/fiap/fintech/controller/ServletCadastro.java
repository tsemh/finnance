package br.com.fiap.fintech.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.fintech.entity.ContaUsuario;
import br.com.fiap.fintech.entity.Usuario;
import br.com.fiap.fintech.Dao.Usuario.UsuarioDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.Dao.DAOFactory;
import br.com.fiap.fintech.Dao.ContaUsuario.ContaUsuarioDAO;


@WebServlet("/ServletCadastro")

public class ServletCadastro extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private UsuarioDAO 		  daouser;
	private ContaUsuarioDAO   daoconta;
	
	@Override
	public void init() throws ServletException {
		super.init();
		daouser  = DAOFactory.getUsuarioDAO();
		daoconta = DAOFactory.getContaDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			String nome  = request.getParameter("nome");
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			Usuario usuario = new Usuario(0, email, senha, nome); 
			daouser.insertByID(usuario);
			
			ContaUsuario conta = new ContaUsuario(0, daouser.getLastCode(), "F", 0.0, "99999999999", "");
			daoconta.insertByID(conta);
			
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}catch(DBException db) {
			db.printStackTrace();

		}catch(Exception e){
			e.printStackTrace();

		}
	}

}
