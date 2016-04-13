package com.user.servlet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.user.UserDaoFactory;

import com.dao.user.UserImpProxy;
import com.object.User;

/**
 * Servlet implementation class UserSearch
 */
@WebServlet("/UserSearch")
public class UserSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public UserSearch() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		User user = new User();
		List<User> list = new ArrayList<User>();
		String id = null;

		id = request.getParameter("id");

		UserImpProxy userdao;
		try {
			userdao = UserDaoFactory.getUserDaoInstance();

			if (userdao.findbyID(id, list)) {
				System.out.println("查询成功！");
			
					request.setAttribute("flag", 1);
					request.setAttribute("result", list);
					
				
			} else {
				System.out.println("未查询到相关记录！");
				request.setAttribute("flag", 0);
				request.setAttribute("info", "No Results！");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		request.getRequestDispatcher("result.jsp").forward(request, response);
		response.getWriter().append("Served at: ")
				.append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
