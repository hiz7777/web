package servlet.cookie.stacknum;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveStackNumberServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//삭제
		Cookie ck = new Cookie("stackNumber","");
		ck.setMaxAge(0);
		resp.addCookie(ck);
		RequestDispatcher rdp = req.getRequestDispatcher("/cookie/stack/request.jsp");
		rdp.forward(req, resp);
	}
}
