package com.yedam.common0808;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DAOasdasd {

//	java <-> DB연결할 때 쓰는 객체
	protected Connection conn = null;
//	Select(조회)결과 값 반환 받는 객체
	protected ResultSet rs = null;
//	Query문을 담고 실행하는 객체 2가지 차이점은 따로설명
	protected PreparedStatement pstmt = null; //
	protected Statement stmt = null; // select문에서는 이게 편함

	Properties pro = new Properties();

	String driver = ""; // 고정, 접속할때 사용하는 문구
	String url = "";// 고정, @뒤는 바뀔 수 있음.
	String id = "";
	String pw = "";

	public void conn() {
		try {
//			1.드라이버 로딩
			Class.forName(driver);
//			2.DB연결
			conn = DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	열어둔 DB를 닫는것
	public void disconnect() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getProperties() {
		try {
			FileReader resuouce = new FileReader("src/config/db.properties");
			pro.load(resuouce);
			driver = pro.getProperty("driver");
			url = pro.getProperty("url");
			id = pro.getProperty("id");
			pw = pro.getProperty("pw");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
