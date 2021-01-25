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


@WebServlet("/BoardDelete.do")
public class BoardDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardDelete() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			BoardsDAO dao = new BoardsDAO();
			BoardVO vo = new BoardVO();
			
			vo.setBoardNo(Integer.parseInt(request.getParameter("row")));
			int n = dao.delete(vo);			//n을 쓰던안쓰던 integer로 받아야되기때문에 선언
			String viewPage= null;
			
			//돌려줄 페이지 , n을 사용해야 오류가 없기때문에 if 구문으로 지정
			if(n != 0) {
				viewPage="BoardList.do";
			}
						
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
