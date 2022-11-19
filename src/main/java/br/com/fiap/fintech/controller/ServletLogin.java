package br.com.fiap.fintech.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.fintech.Dao.DAOFactory;
import br.com.fiap.fintech.Dao.Usuario.UsuarioDAO;
import br.com.fiap.fintech.entity.Usuario;
import br.com.fiap.fintech.util.CriptografiaUtils;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UsuarioDAO dao;

	public ServletLogin() {
        super();
        dao = DAOFactory.getUsuarioDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String email = request.getParameter("email");
			String senha = CriptografiaUtils.criptografar(request.getParameter("senha")).trim();

			Usuario usuario = dao.validarUsuario(email, senha);
						
			if (usuario != null) {
				
				Integer cd_usuario = usuario.getCd_usuario();
				Integer cd_conta   = 1;
				
				request.getSession().setAttribute("UserName", usuario.getNm_usuario());
				request.getSession().setAttribute("CurrentPage", "Home");
				response.sendRedirect("ServletHome?User="+cd_usuario+"&Account="+cd_conta);
				
			} else {
				
				request.setAttribute("erro", "Usu·rio e/ou senha inv√°lidos");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
