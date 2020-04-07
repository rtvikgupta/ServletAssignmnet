package p3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletResponse
 */
public class ServletResponse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String cnfpassword = request.getParameter("confpassword");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String city = request.getParameter("city");
		String tech[] = request.getParameterValues("tech");
		String workexp = (request.getParameter("workexp"));
		
		UserModel um = new UserModel(username, password, cnfpassword, age, tech, city, gender, workexp);
		
		String project = new UserService().getProject(um.tech);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("<html> <body>");
		out.print("<table>");
		out.print("<tr> <td> Username: </td> <td>"+username+"</td> </tr>");
		out.print("<tr><td> Password: </td><td>"+password+"</td></tr>");
		out.print("<tr><td> Age: </td><td>"+age+" years</td></tr>");
		out.print("<tr><td> Gender: </td><td>"+gender+"</td></tr>");
		out.print("<tr><td> City: </td><td>"+city+"</td></tr>");
		out.print("<tr><td> Technologies Known: </td><td>");
		for(int i=0;i<tech.length;i++)
		{
			out.print(i+1+". "+tech[i]+" ");
		}
		out.print("</td></tr>");
		out.print("<tr><td> Work Experience: </td><td>"+workexp+" years </td></tr>");
		out.print("<tr><td> Project Assigned: </td><td>"+project+"</td></tr>");
		out.print("<table>");
		out.print("</body> </html>");
		
	}

}
