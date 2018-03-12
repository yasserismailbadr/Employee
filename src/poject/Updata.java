package poject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Updata
 */
@WebServlet("/Updata")
public class Updata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter=response.getWriter();
//		printWriter.println("<h1> Updata Employee</h1>");
		String employeeId=request.getParameter("id")  ;
		int id=Integer.parseInt(employeeId);
		dataEmployee DataEmployee = ConnectDB.getEmployeeId(id);
		
		printWriter.println("<head>");
		printWriter.println("<link href='css/bootstrap.min.css'rel='stlesheet'>");
		printWriter.println("</head>");
		printWriter.println("<body>");
		printWriter.println("<form action='Updata2'method='post'>");
		printWriter.println("<table>");
		printWriter.println("<tr><td>ID</td><td><input name='id'value='"+DataEmployee.getId()+"'/></td></tr>");
		printWriter.println("<tr><td>NAME</td><td><input tybe='text' name='name'value='"+DataEmployee.getName()+"'/></td></tr>");
		printWriter.println("<tr><td>EMAIL</td><td><input tybe='email' name='email'value='"+DataEmployee.getEmail()+"'/></td></tr>");
		printWriter.println("<tr><td>PASSWORD</td><td><input tybe='password' name='password'value='"+DataEmployee.getPassword()+"'/></td></tr>");
		printWriter.println("<tr><td>COUNTRY</td><td><input tybe='text' name='country'value='"+DataEmployee.getCountry()+"'/></td></tr>");
		printWriter.println("</td></tr>");
		printWriter.println("<tr><td colspan='2'><input type='submit'value='submit'/></td></tr>");
		printWriter.println("</table>");
		printWriter.println("</form>");
		printWriter.println("</body>");

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html");
//		PrintWriter printWriter=response.getWriter();
//		printWriter.println("<h1> Updata Employee</h1>");
//		String employeeId=request.getParameter("id")  ;
//		int id=Integer.parseInt(employeeId);
//		dataEmployee DataEmployee = ConnectDB.getEmployee(id);
//		
//		printWriter.println("<head>");
//		printWriter.println("<link href='css/bootstrap.min.css'rel='stlesheet'>");
//		printWriter.println("</head>");
//		printWriter.println("<body>");
//		printWriter.println("<form action='Updata2'method='post'>");
//		printWriter.println("<table>");
//		printWriter.println("<tr><td>ID</td><td><input name='id'valve="+DataEmployee.getId()+"'/></td></tr>");
//		printWriter.println("<tr><td>NAME</td><td><input tybe='text' name='name'valve="+DataEmployee.getName()+"'/></td></tr>");
//		printWriter.println("<tr><td>EMAIL</td><td><input tybe='email' name='email'valve="+DataEmployee.getEmail()+"'/></td></tr>");
//		printWriter.println("<tr><td>PASSWORD</td><td><input tybe='password' name='password'valve="+DataEmployee.getPassword()+"'/></td></tr>");
//		printWriter.println("<tr><td>COUNTRY</td><td><input tybe='text' name='country'valve="+DataEmployee.getCountry()+"'/></td></tr>");
//		printWriter.println("</td></tr>");
//		printWriter.println("<tr><td colspan='2'><input type='submit'value='submit'/></td></tr>");
//		printWriter.println("</table>");
//		printWriter.println("</form>");
//		printWriter.println("</body>");

		
		
		
	}

}
