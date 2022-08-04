package co.edu.study0804;

public interface Payment {
//	상수필드
/*1) 온라인 결제 할인율 (ONLINE_PAYMENT_RATIO), 5%
  2) 오프라인 결제 할인율 (OFFLINE_PAYMENT_RATIO), 3%  */
	public static final double ONLINE_PAYMENT_RATIO = 0.05;
	public static final double OFFLINE_PAYMENT_RATIO = 0.03;
	
//	추상매서드 abstract추상화 인터페이스에서는 생략해도 되는 단어지만 잊지말라고 써봄
//	인터페이스에서만 쓰든말든 상관ㅇ벗는것 클래스에서는 꼭 쓰자
//	public abstract int online(int price);
	public int online(int price);
	public int offline(int price);
	public void showInfo();
}
