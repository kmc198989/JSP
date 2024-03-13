package main.com.daewoo.dto;
//안녕하세요
public class CommunityDTO {
     private String c_post; //게시글 
     private int c_post_num; // 게시글 번호 
     private String c_comment;// 댓글 
     private int c_comment_num;// 댓글 번호 
     private String c_post_date; //게시글 등록 일자 
     private String c_comment_date; //댓글 등록 일자
     private String c_title; //게시글  제목
	public String getC_post() {
		return c_post;
	}
	public void setC_post(String c_post) {
		this.c_post = c_post;
	}
	public int getC_post_num() {
		return c_post_num;
	}
	public void setC_post_num(int c_post_num) {
		this.c_post_num = c_post_num;
	}
	public String getC_comment() {
		return c_comment;
	}
	public void setC_comment(String c_comment) {
		this.c_comment = c_comment;
	}
	public int getC_comment_num() {
		return c_comment_num;
	}
	public void setC_comment_num(int c_comment_num) {
		this.c_comment_num = c_comment_num;
	}
	public String getC_post_date() {
		return c_post_date;
	}
	public void setC_post_date(String c_post_date) {
		this.c_post_date = c_post_date;
	}
	public String getC_comment_date() {
		return c_comment_date;
	}
	public void setC_comment_date(String c_comment_date) {
		this.c_comment_date = c_comment_date;
	}
	public String getC_title() {
		return c_title;
	}
	public void setC_title(String c_title) {
		this.c_title = c_title;
	}
	@Override
	public String toString() {
		return "CommunityDTO [c_post=" + c_post + ", c_post_num=" + c_post_num + ", c_comment=" + c_comment
				+ ", c_comment_num=" + c_comment_num + ", c_post_date=" + c_post_date + ", c_comment_date="
				+ c_comment_date + ", c_title=" + c_title + "]";
	}
  
     
}