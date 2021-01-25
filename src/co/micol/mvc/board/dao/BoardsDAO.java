package co.micol.mvc.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.mvc.board.service.BoardVO;
import co.micol.mvc.common.DAO;

public class BoardsDAO extends DAO{
	
//보드 테이블 접속하는 dao
		private PreparedStatement psmt;
		private ResultSet rs;
		
		private final String BOARDSELECTLIST = "SELECT * FROM boards ORDER BY board_no desc";		//c콜?
		private final String BOARDSELECT = "SELECT * FROM boards WHERE board_no=?";
		private final String BOARDINSERT = "INSERT INTO boards VALUES (?,?,?,?,?)";
		private final String BOARDDELETE = "DELETE FROM boards WHERE board_no=?";
		//조회	
		
		public ArrayList<BoardVO> selectList() { 						//selectList (전체 리스트를 가져옴)
				ArrayList<BoardVO> list = new ArrayList<BoardVO>();
				BoardVO vo; //vo 객체를 만듬
			
				try {
					psmt = conn.prepareStatement(BOARDSELECTLIST);
					rs = psmt.executeQuery(); 							//recode set(DB에선) 리턴(resultSet.자바에선)
					while(rs.next()) { 									//몇개들어왔는지 모르니까 while
						vo = new BoardVO(); 							//vo 객체 초기화
						vo.setBoardNo(rs.getInt("board_no"));
						vo.setTitle(rs.getString("title"));
						vo.setContent(rs.getString("content"));
						vo.setWriter(rs.getString("writer"));
						vo.setCreationDate(rs.getDate("creation_date"));
						list.add(vo);			//리스트에 vo객체를 추가
					}
				} catch (SQLException e) {
						e.printStackTrace();
				}finally {
					close();
				}
							
				return list;
		}
//한가지 조회		
		public BoardVO select(BoardVO vo) {
			//한개레코드 조회 구문 작성
			try {
				psmt = conn.prepareStatement(BOARDSELECT);
				psmt.setInt(1, vo.getBoardNo());
				rs = psmt.executeQuery();
				if(rs.next()) {//한개행이 돌아옴으로 if씀
					vo.setBoardNo(rs.getInt("board_no"));
					vo.setTitle(rs.getString("title"));
					vo.setContent(rs.getString("content"));
					vo.setWriter(rs.getString("writer"));
					vo.setCreationDate(rs.getDate("creation_date"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close();
			}
			return vo;
		}
		
//입력		
		public int insert(BoardVO vo) {				//boards 테이블에 데이터를 삽입
			int n=0;			
			try {
				psmt = conn.prepareStatement(BOARDINSERT);
				psmt.setInt(1, vo.getBoardNo());
				psmt.setString(2, vo.getTitle());
				psmt.setString(3, vo.getContent());
				psmt.setString(4, vo.getWriter());
				psmt.setDate(5,vo.getCreationDate());
				n = psmt.executeUpdate();
				System.out.println(n + " 건 입력되었습니다.");
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close();
			}
			
			return n;
			
		}
		
//수정		
		public int update(BoardVO vo) {
			int n=0;
			
			return n;
			
		}
//삭제
		public int delete(BoardVO vo) {
			int n=0;
			try {
				psmt = conn.prepareStatement(BOARDDELETE);
				psmt.setInt(1, vo.getBoardNo());
				rs = psmt.executeQuery();
				System.out.println(n + " 건 삭제되었습니다.");
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close();
			}
			return n;
			
		}
	
		
		private void close() {
			try {
				if(rs != null) rs.close();
				if(psmt != null) psmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
				
		}
	
}
