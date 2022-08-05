package com.yedam.member0805;

public class MemberService {

	public MemberDTO doLogin(MemberDTO member) {
		MemberDTO mem = MemberManage.getInstance().Login(member);
		if (mem == null) {
			System.out.println("로그인 실패");
			return null;
		} else {
			System.out.println("로그인 성공");
			return mem;
		}
	}
}
