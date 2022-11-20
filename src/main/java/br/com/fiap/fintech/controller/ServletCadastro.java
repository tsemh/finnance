package br.com.fiap.fintech.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.fiap.fintech.entity.Usuario;
import br.com.fiap.fintech.Dao.Usuario.UsuarioDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.Dao.DAOFactory;


@WebServlet("/ServletCadastro")

public class ServletCadastro extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private UsuarioDAO dao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getUsuarioDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			Usuario usuario = new Usuario(0, nome, email, senha); 
			dao.insertByID(usuario);
			
		}catch(DBException db) {
			db.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
