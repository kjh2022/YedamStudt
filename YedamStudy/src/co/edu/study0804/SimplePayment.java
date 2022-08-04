package co.edu.study0804;

/*3.Simple Payment 클래스*/
public class SimplePayment implements Payment {
//	필드 - 필드로 간편결제 할인율(simplePaymentRatio)을 가진다.
	public double simplePaymentRaito;

//	생성자 - 생성자를 통해 매개변수로 값을 받아 필드를 초기화 한다.
//	생성자 매개변수로 만들어둔 필드를 입력
	public SimplePayment(double simplePaymentRaito) {
		this.simplePaymentRaito = simplePaymentRaito;
	}

//	메소드 - 아래의 실행코드와 실행결과를 참조하여 Payment 인터페이스 메서드를 오버라이딩 한다.
	@Override
	public int online(int price) {
//		간편 결제에 대한 할인율 simplePaymentRaito
//		온라인 결제에 대한 할인율 online_payment_ratio
//		간편 결제 할인율 + 온라인 결제 할인율은 = ?
//		price금액에 대해 할인율을 적용하고 거기에대한 가격을 표시해 주는것.
//		price(가격), pirce에 대한 할인율이 존재
//		원가 - 원가*할인율 = 할인된 금액
//		ex)10,000 - 10000*0.1 = 9,000원
//		price - (price * (simplePaymentRatio + online_payment_ratio)) = 할인 후 price
		int pay = (int) (price - (price * (simplePaymentRaito + ONLINE_PAYMENT_RATIO)));
//		할인 된 금액 반환(어디로?)
		return pay;
	}

//	호출된 메소드는 서로 모르는 관계
	@Override
	public int offline(int price) {
		int pay = (int) (price - (price * (simplePaymentRaito + OFFLINE_PAYMENT_RATIO)));
		return pay;
	}

	@Override
	public void showInfo() {
		System.out.println("*** 간편결제 시 할인정보");
		System.out.println("온라인 결제 시 총 할인율 : " + // +연산자는 stirng과 만나면 뒤의 정수도 문자로 인식
				(simplePaymentRaito + ONLINE_PAYMENT_RATIO)*100 + "%");
		System.out.println("오프라인 결제 시 총 할인율 : " + //
				(simplePaymentRaito + OFFLINE_PAYMENT_RATIO)* 100 + "%");
	}

}
