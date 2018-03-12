package poject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Updata2
 */
@WebServlet("/Updata2")
public class Updata2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updata2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter=response.getWriter();
		String employeeId=request.getParameter("id");
		int id=Integer.parseInt(employeeId);
		String name =request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String country =request.getParameter("country");
		dataEmployee DataEmployee=new dataEmployee();
		
		DataEmployee.setId(id);
		DataEmployee.setName(name);
		DataEmployee.setEmail(email);
		DataEmployee.setPassword(password);
		DataEmployee.setCountry(country);
		int num= ConnectDB.upData(DataEmployee);
		if (num>1){ 
			
		
		response.sendRedirect("View");
		}else{
			printWriter.println("<h2> sorry not updata!!!!!</h2>");
		}
		
	}

}
