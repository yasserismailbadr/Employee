package poject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveData1
 */
@WebServlet("/SaveData")
public class SaveData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter printWriter=response.getWriter();
		
		response.setContentType("text/html");
	String name =request.getParameter("name");
	String email =request.getParameter("email");
	String password =request.getParameter("password");
	String country =request.getParameter("country");
	dataEmployee DataEmployee =new dataEmployee();
	DataEmployee.setName(name);
	DataEmployee.setEmail(email);
	DataEmployee.setPassword(password);
	DataEmployee.setCountry(country);
	int num =ConnectDB.saveData(DataEmployee);
	if (num>0) {
		
		printWriter.println("<h2> Save successfull</h2>");
		request.getRequestDispatcher("info.html").include(request, response);
		
		
	}else{
		printWriter.println("<h2> sory not save</h2>");
	}
	}

	}


