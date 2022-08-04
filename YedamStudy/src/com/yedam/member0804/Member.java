package com.yedam.member0804;

/*member의 데이터를 받기위한 클래스*/
//DTO(Data Transfer Object)라고 많이 부름 
//BEANS옛날에 부르던 이름
public class Member {
//	필드
	private String id;
	private String pw;
	private String name;

//	생성자

//	메소드
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + "]";
	}
	
}
