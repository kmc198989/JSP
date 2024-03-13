package main.com.daewoo.dto;

import java.util.Date;

public class AskVO {
	private int code;
	private String a_title;
	private String a_post;
	private int a_post_num;
	private String a_comment;
	private int a_comment_num;
	private Date a_post_date;
	private Date a_comment_date;
	private String a_check;
	private String userid;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getA_title() {
		return a_title;
	}
	public void setA_title(String a_title) {
		this.a_title = a_title;
	}
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
	public Date getA_post_date() {
		return a_post_date;
	}
	public void setA_post_date(Date a_post_date) {
		this.a_post_date = a_post_date;
	}
	public Date getA_comment_date() {
		return a_comment_date;
	}
	public void setA_comment_date(Date a_comment_date) {
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
		return "AskVO [code=" + code + ", a_title=" + a_title + ", a_post=" + a_post + ", a_post_num=" + a_post_num
				+ ", a_comment=" + a_comment + ", a_comment_num=" + a_comment_num + ", a_post_date=" + a_post_date
				+ ", a_comment_date=" + a_comment_date + ", a_check=" + a_check + ", userid=" + userid + "]";
	}

	
}
