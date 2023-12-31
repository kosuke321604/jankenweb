
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homework.JankenBean;
import homework.JankenLogic;

/**
 * Servlet implementation class JankenServlet
 */
@WebServlet("/JankenServlet2")
public class JankenServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JankenServlet2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("paramemo");
		if(action==null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/index.jsp");
			dispatcher.forward(request, response);
	
		}
		else if(action.equals("done")){
			String memo = request.getParameter("memo");
			JankenBean jankenBean = new JankenBean(memo);
			JankenLogic jankenLogic = new JankenLogic();
			jankenLogic.creatememo(jankenBean);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/index.jsp");
			dispatcher.forward(request, response);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String myChoice = request.getParameter("janken");
		
				
		JankenLogic jankenLogic = new JankenLogic();

		JankenBean jankenBean = jankenLogic.getJankenResult(myChoice);
		jankenLogic.create(jankenBean);
		List<JankenBean>jankenList = jankenLogic.findAll();
		

		
		request.setAttribute("jankenList", jankenList);

		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/result.jsp");
		dispatcher.forward(request, response);

	}

}
