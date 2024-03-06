package com.daewoo.dto;
   
public class AskDTO {
     private  String a_post; // 게시글 
     private  int a_post_num; //게시글 번호 
     private  String a_post_date; // 게시글 등록 일자 
     private  String a_comment; //댓글 
     private  int a_comment_num; //댓글 번호 
     private  String a_comment_date; //댓글 등록 일자
     private  String a_check; //문의글 답변 여부
	public String getA_post() {
		return a_post;
	}
	public void setA_post(String a_post) {
		this.a_post = a_post;
	}
	public int getA_post_num() {
		return a_post_num;
	}
	public void setA_post_num(int a_post_num) {
		this.a_post_num = a_post_num;
	}
	public String getA_post_date() {
		return a_post_date;
	}
	public void setA_post_date(String a_post_date) {
		this.a_post_date = a_post_date;
	}
	public String getA_comment() {
		return a_comment;
	}
	public void setA_comment(String a_comment) {
		this.a_comment = a_comment;
	}
	public int getA_comment_num() {
		return a_comment_num;
	}
	public void setA_comment_num(int a_comment_num) {
		this.a_comment_num = a_comment_num;
	}
	public String getA_comment_date() {
		return a_comment_date;
	}
	public void setA_comment_date(String a_comment_date) {
		this.a_comment_date = a_comment_date;
	}
	public String getA_check() {
		return a_check;
	}
	public void setA_check(String a_check) {
		this.a_check = a_check;
	}
	@Override
	public String toString() {
		return "AskDTO [a_post=" + a_post + ", a_post_num=" + a_post_num + ", a_post_date=" + a_post_date
				+ ", a_comment=" + a_comment + ", a_comment_num=" + a_comment_num + ", a_comment_date=" + a_comment_date
				+ ", a_check=" + a_check + "]";
	}
	
	
}
