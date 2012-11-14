package servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class CompileServlet
 */
@WebServlet("/CompileServlet")
public class CompileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CompileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String source = (String) session.getAttribute("sourceCode");
		File dir = new File("/tmp/XBDPL/" + id + "/");
		
		if(!dir.exists()){
			Process p2 = Runtime.getRuntime().exec("mkdir " + id, null, new File("/tmp/XBDPL/"));
			try {
				p2.waitFor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Process p3 = Runtime.getRuntime().exec("cp ./xbdpl.jar ./" + id + "/", null, new File("/tmp/XBDPL/"));
			try {
				p3.waitFor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		FileWriter fw = new FileWriter("/tmp/XBDPL/" + id + "/source.db");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(source);
		bw.flush();
		fw.flush();
		bw.close();
		fw.close();
		
		
		String info = null;
		
		
		
		
		Process p1 = Runtime.getRuntime().exec("java -jar xbdpl.jar source.db", null, dir);
		try {
			int value = p1.waitFor();
			
			if(value == 0){
				info = "Successfully Compiled!<br>";
			}
			else{
				info = "Successfully Failed! <br>";
			}
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

		BufferedReader bufferedReader1 = new BufferedReader(
				new InputStreamReader(p1.getInputStream()));
	
		String line = null;

		while ((line = bufferedReader1.readLine()) != null) {
			info = info + "<br>" + line;
		}		

		session.setAttribute("result", info);
		response.sendRedirect("/IDE/result.jsp");
	

	}

}
