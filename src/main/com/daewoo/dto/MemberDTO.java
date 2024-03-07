package main.com.daewoo.dto;

public class MemberDTO {

	private int code; //회원 식별 코드
	private String id; // 아이디
	private String pass; //비밀번호
	private String name; //이름
	private String phone; //전화번호
	private String join_date; //가입 일자
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getJoin_date() {
		return join_date;
	}
	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}
	@Override
	public String toString() {
		return "MemberDTO [code=" + code + ", id=" + id + ", pass=" + pass + ", name=" + name + ", phone=" + phone
				+ ", join_date=" + join_date + "]";
	}
	
	
	
	
}
