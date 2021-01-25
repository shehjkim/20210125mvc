package co.micol.mvc.board.web;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.mvc.board.dao.BoardsDAO;
import co.micol.mvc.board.service.BoardVO;


@WebServlet("/Boardinput.do")
public class Boardinput extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Object message;
       

    public Boardinput() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			BoardsDAO dao = new BoardsDAO();
			BoardVO vo = new BoardVO();
			vo.setBoardNo(Integer.parseInt(request.getParameter("boardNo"))); //boardInputform.jsp의 각각의 id와 name
			vo.setTitle(request.getParameter("title"));
			vo.setContent(request.getParameter("content"));
			vo.setWriter(request.getParameter("writer"));
			vo.setCreationDate(Date.valueOf(request.getParameter("creationDate")));

			String viewPage = null;
			int n = dao.insert(vo);
			
			if(n != 0) {	
				viewPage = "BoardList.do";
			}else {				//실패시
				String massage="입력한 내용이 DB에 저장하지 못하였습니다. ";
				request.setAttribute("mag", message);
				viewPage = "views/board/jsp/boardInputFail.jsp";
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
	
	
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
