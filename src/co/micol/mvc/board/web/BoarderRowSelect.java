package co.micol.mvc.board.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.mvc.board.dao.BoardsDAO;
import co.micol.mvc.board.service.BoardVO;

/**
 * Servlet implementation class BoarderRowSelect
 */
@WebServlet("/BoarderRowSelect.do")
public class BoarderRowSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoarderRowSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			BoardsDAO dao = new BoardsDAO();
			BoardVO vo = new BoardVO();
			int row = Integer.parseInt(request.getParameter("row"));  //문자를 숫자로 변환, get Parameter로 row값을 받음, string 방식으로 넘어오기때문에 숫자로 변환시켜줘야함 	
			vo.setBoardNo(row);
			
			vo = dao.select(vo);			//DB 호출
			request.setAttribute("vo", vo);
			String viewPage = "views/board/boardSelect.jsp";
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response); //두 줄은 항상 같음
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
