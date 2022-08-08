package co.cofe;

import java.util.ArrayList;
import java.util.List;

import co.coffee.common.DAO;

public class CoffeeDAO extends DAO {

	private static CoffeeDAO coffeeDao = null;

	private CoffeeDAO() {
	}

	public static CoffeeDAO getInstance() {
		return coffeeDao == null ? coffeeDao = new CoffeeDAO() : coffeeDao;
	}

//	1. 메뉴 조회, 2.상세 조회
//	3.메뉴 등록
//	4.메뉴 삭제
//	5.판매(해당 기능 실행 시 1잔씩 판매되도록 구현)
//	6.매출 기능 (구현 영업한 날짜와 관계없이 총 매출 출력)
//	7.프로그램 종료

//	1.메뉴 조회
	public List<Coffee> getCoffee() {
		List<Coffee> list = new ArrayList<>();
		Coffee coffee = null;
		try {
			conn();
			String sql = "SELECT coffee_menu, coffee_price FROM coffee";
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				coffee = new Coffee();
				coffee.setCoffeeMenu(rs.getString("coffee_menu"));
				coffee.setCoffeePrice(rs.getInt("coffee_price"));
				list.add(coffee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

//	상세 조회
	public List<Coffee> getDetailCoffee(String menu) {
		List<Coffee> list = new ArrayList<>();
		Coffee coffee = null;
		try {
			conn();
			String sql = "SELECT * FROM coffee WHERE coffee_menu = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, menu);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				coffee = new Coffee();
				coffee.setCoffeeMenu(rs.getString("coffee_menu"));
				coffee.setCoffeePrice(rs.getInt("coffee_price"));
				coffee.setCoffeeExplain(rs.getString("coffee_explain"));

				list.add(coffee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

//	메뉴 등록
	public int insertCoffee(Coffee coffee) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO coffee values(?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, coffee.getCoffeeMenu());
			pstmt.setInt(2, coffee.getCoffeePrice());
			pstmt.setString(3, coffee.getCoffeeExplain());
			pstmt.setInt(4, coffee.getCoffeeSales());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

//	메뉴 삭제
	public int delCoffee(String coffeeMenu) {
		int result = 0;
		try {
			conn();
			String sql = "DELETE FROM coffee WHERE coffee_menu = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, coffeeMenu);

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

//	판매 실행당 1잔씩 판매
	public int updateCoffee(Coffee coffee) {
		int result = 0;
		try {
			conn();
			String sql = "UPDATE coffee SET coffee_sales = coffee_sales+1 where coffee_menu = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, coffee.getCoffeeSales());
			pstmt.setString(2, coffee.getCoffeeMenu());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

}
