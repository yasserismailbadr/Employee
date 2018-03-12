package poject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class view
 */
@WebServlet("/View")
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public View() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter=response.getWriter();
		printWriter.println("<head>");
		printWriter.println("<link href='css/bootstrap.min.css'rel='stlesheet'>");
		printWriter.println("</head>");
		printWriter.println("<body>");
		printWriter.println("<a href='info.html'class='btn btn-info'role=button'>ADD EMPLOYEE</a>");
		printWriter.println("<h2> EMPLOYEE TABLE</h2>");
		List<dataEmployee>list=ConnectDB.getEmployee();
		printWriter.println("<table border='1'width='100%'");
		printWriter.println("<tr><th>id</th><th>name</th><th>email</th><th>password</th><th>country</th><th>edit</th><th>delete</th></tr>");
		for (dataEmployee DataEmployee : list) {
			printWriter.println("<tr><td>"+DataEmployee.getId()+"</td><td>"+DataEmployee.getName()+"</td><td>"+DataEmployee.getEmail()+"</td><td>"
					+DataEmployee.getPassword()+"</td><td>"
					+DataEmployee.getCountry()+"'</td><td><a href='Updata?id="+DataEmployee.getId()+"'>edit</a></td><td><a href='Delete?id="
					+DataEmployee.getId()+"'>delete</a></td></tr>");
		}
		printWriter.println("</table>");
		printWriter.println("</body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
