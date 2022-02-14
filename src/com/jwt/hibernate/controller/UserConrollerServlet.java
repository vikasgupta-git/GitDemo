package com.jwt.hibernate.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jwt.hibernate.dao.UserDAO;

/**
 * Servlet implementation class UserConrollerServlet
 */
@WebServlet("/UserConrollerServlet")
public class UserConrollerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserConrollerServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		 String userName = request.getParameter("userName");
	        String password = request.getParameter("password1");
	        String email = request.getParameter("email");
	        String phone = request.getParameter("phone");
	        String city = request.getParameter("city");
	 
	        HttpSession session = request.getSession(true);
	        try {
	            UserDAO userDAO = new UserDAO();
	            userDAO.addUserDetails(userName, password, email, phone, city);
	            response.sendRedirect("Success");
	        } catch (Exception e) {
	 
	            e.printStackTrace();
	        }
	}

}
