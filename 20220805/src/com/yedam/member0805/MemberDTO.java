package com.yedam.member0805;
/*
MEMBER_ID     NOT NULL VARCHAR2(20)  
MEMBER_PW     NOT NULL VARCHAR2(20)  
MEMBER_NAME   NOT NULL VARCHAR2(10)  
MEMBER_BELONG          VARCHAR2(100) 
모르는 사람이 프로그램을 봐도 알 수 있게끔 주석으로 표시해주는것*/

public class MemberDTO {
	private String memberId; // DB의 member_id와 같은 의미) 두 번째 단어 첫글자는 대문자라는뜻
	private String memberPw; // MEMBER_PW 회원 패스워드
	private String memberName; // MEMBER_NAME 회원 이름
	private String memberBelong; // MEMBER_BELONG 회원 소속

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberBelong() {
		return memberBelong;
	}

	public void setMemberBelong(String memberBelong) {
		this.memberBelong = memberBelong;
	}

}
