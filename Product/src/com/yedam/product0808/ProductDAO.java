package com.yedam.product0808;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.common0808.DAO;
import com.yedam.common0808.DAOasdasd;

public class ProductDAO extends DAO {

	private static ProductDAO productDao = null;

	private ProductDAO() {
	}

	public static ProductDAO getInstance() {
		return (productDao == null) ? productDao = new ProductDAO() : productDao;
	}

//	1.상품 조회 -상품 이름과 가격
//	2.상품 상세 조회 - 상품 모든 내용 조회
//	3.점포별 상품 조회
//	4.상품 등록 5.상품 삭제 6.상품별 판매 개수 출력 + 판매 금액
	
//	2-1상품 조회
	public List<Product> getProduct() {
		List<Product> list = new ArrayList<>();
		Product product = null;
		try {
			conn();
			String sql = "SELECT product_name, product_price from product";
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				product = new Product();
				product.setProductName(rs.getString("product_name"));
				product.setProductPrice(rs.getInt("product_price"));
				list.add(product);
			}

		} catch (SQLException e) {
			// ora-00000 : ~~한 이유로 오류 발생
			System.out.println("*** Error! 에러 코드를 확인하세요! ***");
			System.out.println("에러 코드 : " + e.getErrorCode());
			System.out.println("해당 원인 : " + e.getMessage());
			e.getMessage();
			e.getErrorCode();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

//	2-2)전체 상세 조회
	public List<Product> getDetailProduct() {
		List<Product> list = new ArrayList<>();
		Product product = null;
		try {
			conn();
			String sql = "SELECT * from product";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				product = new Product();
				product.setProductName(rs.getString("product_name"));
				product.setProductPrice(rs.getInt("product_price"));
				product.setProductExplain(rs.getString("product_explain"));
				product.setProductId(rs.getString("product_id"));
				product.setProductSales(rs.getInt("product_sales"));
				product.setStores(rs.getString("stores"));
				list.add(product);
			}

		} catch (SQLException e) {
			// ora-00000 : ~~한 이유로 오류 발생
			System.out.println("*** Error! 에러 코드를 확인하세요! ***");
			System.out.println("에러 코드 : " + e.getErrorCode());
			System.out.println("해당 원인 : " + e.getMessage());
			e.getMessage();
			e.getErrorCode();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

//	3점포별 상품 조회
	public List<Product> getStoreProduct(String stores) {
		List<Product> list = new ArrayList<>();
		Product product = null;
		try {
			conn();
			String sql = "SELECT * from product WHERE stores = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stores);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				product = new Product();
				product.setProductName(rs.getString("product_name"));
				product.setProductPrice(rs.getInt("product_price"));
				product.setProductExplain(rs.getString("product_explain"));
				product.setProductId(rs.getString("product_id"));
				product.setProductSales(rs.getInt("product_sales"));
				product.setStores(rs.getString("stores"));

				list.add(product);
			}

		} catch (SQLException e) {
			// ora-00000 : ~~한 이유로 오류 발생
			System.out.println("*** Error! 에러 코드를 확인하세요! ***");
			System.out.println("에러 코드 : " + e.getErrorCode());
			System.out.println("해당 원인 : " + e.getMessage());
			e.getMessage();
			e.getErrorCode();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

//	4상품 등록
	public int insertProduct(Product product) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO product values(?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getProductId());
			pstmt.setString(2, product.getProductName());
			pstmt.setInt(3, product.getProductPrice());
			pstmt.setString(4, product.getProductExplain());
			pstmt.setInt(5, product.getProductSales());
			pstmt.setString(6, product.getStores());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}

//	5상품 삭제
	public int deleteProduct(String productId) {
		int result = 0;
		try {
			conn();
			String sql = "DELETE FROM product WHERE product_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productId);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}
//	6상품별 판매개수 및 판매 금액 출력 따로 만들지않고 위의 메소드 응용할 예정

}