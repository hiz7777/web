package servlet.cookie.stacknum;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowStackNumberServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//값조회
		Cookie [] cks = req.getCookies();
		String message = null;
		if(cks !=null)
		{
			for(Cookie ck : cks)
			{
				if(ck.getName().equals("stackNumber"))
				{
					message = ck.getValue();
				}
			}
		}
		if(message !=null)
		{
			req.setAttribute("message", message);
		}
		else
		{
			req.setAttribute("message", "값이 없다.");
		}
		
		
		//출력
		req.getRequestDispatcher("/cookie/stack/response.jsp").forward(req,resp);

	}
}
