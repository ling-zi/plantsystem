package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.UserSer;

/**
 * Servlet implementation class LoginSevlet
 */
public class LoginSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String type = request.getParameter("type");

		// 首页
		if ("index".equals(type)) {
			request.getRequestDispatcher("WEB-INF/login_register.jsp").forward(request, response);
		}

		// 登录
		if ("login".equals(type)) {
			UserLogin(request, response);
		}

		// 注册
		if ("register".equals(type)) {
			UserRegister(request, response);
		}

	}

	/**
	 * 用户注册
	 * 
	 * @param request
	 * @param response
	 */
	private void UserRegister(HttpServletRequest request, HttpServletResponse response) {
		// 注册
		String rname = request.getParameter("r_username");
		String rpassword = request.getParameter("r_password");
		String remail = request.getParameter("r_email");
		UserSer us = new UserSer();
		User user = new User(rname, remail, rpassword);
		boolean b = us.register(user);
		try {
			if (b) {
				response.sendRedirect(request.getContextPath()+"/myLogin?type=index");
			} else {
				response.sendRedirect(request.getContextPath()+"/404.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 用户登录
	 * @param request
	 * @param response
	 */
	private void UserLogin(HttpServletRequest request, HttpServletResponse response) {
		// 登录
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		// 把从网页中获取的值存起来
		UserSer us = new UserSer();
		User u = us.login(name, password);
		try {
			if (u != null) {
				// 设置一个登录状态，存放用户名（过滤器可以检测到这个状态，让已登录的用户不被过滤掉）
				request.setAttribute("loginstate", u.getUname());
				request.getRequestDispatcher("index.jsp").forward(request,
						response);
			} else {
				response.sendRedirect(request.getContextPath() + "/404.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
