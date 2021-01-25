package co.micol.mvc.board.service;
//도메인 거꾸로. co.micol.프로젝트명.~

import java.sql.Date;

public class BoardVO {
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private Date creationDate;

	public BoardVO() {		//보호객체, DTO 객체(데이터 전송, 교환을 위해서 만듦)
			
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}