package co.micol.mvc.board.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.mvc.board.dao.BoardsDAO;
import co.micol.mvc.board.service.BoardVO;

/**
 * Servlet implementation class BoardList
 */
@WebServlet("/BoardList.do")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardList() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				request.setCharacterEncoding("UTF-8");
				BoardsDAO dao = new BoardsDAO();					//dao 객체 생성 , 초기호
				ArrayList<BoardVO> list = new ArrayList<BoardVO>(); //list 객체 생성 , 
				
				list = dao.selectList();				//실제 테이블 접속해서 list 가져옴, BoardDAO에 있는 selectList()를 list에 담음 
				request.setAttribute("list", list);		//request 객체에 list라는 걸 만들고 이름을 list로 하기
				String viewPage = "views/board/boardList.jsp";		// 결과를 보여줄 페이지 
				
				
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);		//viewpage에 실어서 이 페이지를 보여줌 . 권한위임
				dispatcher.forward(request, response);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
