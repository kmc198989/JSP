package main.com.daewoo.dto;
// 달력에 내역 채우기 위한 데이터테이블
public class MyDTO {
	private String title;
	private String start;
	private String end;
	private String color;
	private String textColor;
	
	public String getTitle() {
		return title;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getTextColor() {
		return textColor;
	}
	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	@Override
	public String toString() {
		return "MyDTO [title=" + title + ", start=" + start + ", end=" + end + ", color=" + color + ", textColor="
				+ textColor + "]";
	}
	
	
}
