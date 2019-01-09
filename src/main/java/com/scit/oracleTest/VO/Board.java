package com.scit.oracleTest.VO;

public class Board {
	private String boardseq;
	private String id;
	private String boardtitle;
	private String boardcontent;
	private int hitcount;
	private String indate;//알아서 잘 형변환이 된다. 
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Board(String boardseq, String id, String boardtitle, String boardcontent, int hitcount, String indate) {
		super();
		this.boardseq = boardseq;
		this.id = id;
		this.boardtitle = boardtitle;
		this.boardcontent = boardcontent;
		this.hitcount = hitcount;
		this.indate = indate;
	}
	public String getBoardseq() {
		return boardseq;
	}
	public void setBoardseq(String boardseq) {
		this.boardseq = boardseq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBoardtitle() {
		return boardtitle;
	}
	public void setBoardtitle(String boardtitle) {
		this.boardtitle = boardtitle;
	}
	public String getBoardcontent() {
		return boardcontent;
	}
	public void setBoardcontent(String boardcontent) {
		this.boardcontent = boardcontent;
	}
	public int getHitcount() {
		return hitcount;
	}
	public void setHitcount(int hitcount) {
		this.hitcount = hitcount;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	@Override
	public String toString() {
		return "Board [boardseq=" + boardseq + ", id=" + id + ", boardtitle=" + boardtitle + ", boardcontent="
				+ boardcontent + ", hitcount=" + hitcount + ", indate=" + indate + "]";
	}
	
	
}
