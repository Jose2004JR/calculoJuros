package model.services;

public class PayPalServices  implements OnlinePaymentServices{
	 public Double taxa(Double amount) {
		 return amount * 0.02;
	 }
	 public Double juros(Double amount,Integer mounth) {
		 return (amount * 0.01) * mounth;
	 }
	
}
