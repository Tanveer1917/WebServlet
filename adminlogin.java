package pack1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class adminlogin
 */
@WebServlet("/adminlogin")
public class adminlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminlogin() {
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
		//first i will get the object of servletConfig
		
		ServletConfig config= getServletConfig();
		
		//now i want to assosicated parameters from the servletConfiguration
		//object
		
		String uservalue=config.getInitParameter("user-name");
		String passwordValue= config.getInitParameter("user-password");
		
		
		//now fetching value from Htmlform elemnt
		String clientUserName=request.getParameter("t1");
		String clientUserPass=request.getParameter("t2");
		
		if(uservalue.equals(clientUserName)&& passwordValue.equals(clientUserPass))
		{
			request.setAttribute("admin-key", clientUserName);
			RequestDispatcher rd=request.getRequestDispatcher("adminWelcome");
			rd.forward(request,response);
		}

		

	}}
