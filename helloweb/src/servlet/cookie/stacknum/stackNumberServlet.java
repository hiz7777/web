package servlet.cookie.stacknum;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class stackNumberServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int num = (int)(Math.random()*100)+1;
		//조회
		Cookie [] cks = req.getCookies();
		String ckv = "";
		if(cks != null)
		{
			for(int i =0; i<cks.length;i++)
			{
				if(cks[i].getName().equals("stackNumber"))
				{
					ckv = cks[i].getValue()+","+num;
					break;
				}
			}
		}
		//처음 누적 숫자
		if(ckv.isEmpty())
		{
			ckv = ckv+num;
		}
	
	resp.addCookie(new Cookie("stackNumber",ckv));
	RequestDispatcher rdp = req.getRequestDispatcher("/cookie/stack/request.jsp");
	rdp.forward(req, resp);
	
	
	}
}
