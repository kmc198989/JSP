package main.com.daewoo.dto;

public class ComuVO {
	private Integer code;
	private String c_title;
	private String c_post;
	private Integer c_post_num;
	private String c_post_date;
	private String c_comment;
	private Integer c_comment_num;
	private String c_comment_date;
	private String userid;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getC_title() {
		return c_title;
	}
	public void setC_title(String c_title) {
		this.c_title = c_title;
	}
	public String getC_post() {
		return c_post;
	}
	public void setC_post(String c_post) {
		this.c_post = c_post;
	}
	public Integer getC_post_num() {
		return c_post_num;
	}
	public void setC_post_num(Integer c_post_num) {
		this.c_post_num = c_post_num;
	}
	public String getC_post_date() {
		return c_post_date;
	}
	public void setC_post_date(String c_post_date) {
		this.c_post_date = c_post_date;
	}
	public String getC_comment() {
		return c_comment;
	}
	public void setC_comment(String c_comment) {
		this.c_comment = c_comment;
	}
	public Integer getC_comment_num() {
		return c_comment_num;
	}
	public void setC_comment_num(Integer c_comment_num) {
		this.c_comment_num = c_comment_num;
	}
	public String getC_comment_date() {
		return c_comment_date;
	}
	public void setC_comment_date(String c_comment_date) {
		this.c_comment_date = c_comment_date;
	}
	@Override
	public String toString() {
		return "ComuVO [code=" + code + ", c_title=" + c_title + ", c_post=" + c_post + ", c_post_num=" + c_post_num
				+ ", c_post_date=" + c_post_date + ", c_comment=" + c_comment + ", c_comment_num=" + c_comment_num
				+ ", c_comment_date=" + c_comment_date + ", userid=" + userid + "]";
	}
	
	
	
}
