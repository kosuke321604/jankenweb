

import java.io.IOException;

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
@WebServlet("/JankenServlet")
public class JankenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JankenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("WEB-INF/index.jsp");
		dispatcher.forward(request, response);	
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//クエストパラメータ取得（String型にする必要あり）
		String janken = request.getParameter("janken");
		//インスタンす生成　入力値をプロパティに設定
		JankenBean jankenBean = new JankenBean();
		jankenBean.setMyselfResult(Integer.parseInt(janken));
		
		//判定を実行し、結果を設定
		JankenLogic jankenLogic = new JankenLogic();
		
//		jankenLogic.execute(jankenBean);
		request.setAttribute("jankenBean",jankenBean);
		
		//フォワード
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("WEB-INF/result.jsp");
		dispatcher.forward(request, response);
		
		
		
	}

	
}
