package p3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletForm
 */
public class ServletValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String cnfpassword = request.getParameter("confpassword");
		int age = Integer.parseInt(request.getParameter("age"));
		String tech[] = request.getParameterValues("tech");
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		RequestDispatcher rdd = request.getRequestDispatcher("/MyForm.html");
		
		boolean userbool = false;
		String regex = "^[a-zA-Z\\s]*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(username); 
		if(matcher.matches())
				userbool = true;
			
		if(username.length()<3 && userbool)
		{
			out.print("Username is less than 3 and Username cannot contains nmbers and special characters");
		}
		else if(!password.equals(cnfpassword))
		{
			out.print("Password Mismatch");
		}
		else if(age<18 || age>60)
		{
			out.print("Age should be between 18 to 60");
		}
		else if(tech.length==0)
		{
			out.print("Select at least one technology");
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("ServletResponse");
			rd.forward(request, response);
		}
		
		rdd.include(request, response);
		
		
		
	}

}
