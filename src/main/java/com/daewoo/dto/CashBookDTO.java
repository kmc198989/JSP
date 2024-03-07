package main.java.com.daewoo.dto;


public class CashBookDTO {
	private int code; //수입/지출
	private String in_out; //수입/지출
	private int amount; //금액
	private int in_date; //입력일자
	private String content; //내용
	private String payment; //결제 수단
	private String monthly; //고정 수입/ 지출 여부
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getIn_out() {
		return in_out;
	}
	public void setIn_out(String in_out) {
		this.in_out = in_out;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getIn_date() {
		return in_date;
	}
	public void setIn_date(int in_date) {
		this.in_date = in_date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getMonthly() {
		return monthly;
	}
	public void setMonthly(String monthly) {
		this.monthly = monthly;
	}
	
	@Override
	public String toString() {
		return "CashBookDTO [code=" + code + ", in_out=" + in_out + ", amount=" + amount + ", in_date=" + in_date
				+ ", content=" + content + ", payment=" + payment + ", monthly=" + monthly + "]";
	}
	
	
}
