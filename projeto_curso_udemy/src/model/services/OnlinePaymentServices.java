package model.services;

public interface OnlinePaymentServices {
	public Double taxa(Double amount);
	public Double juros(Double amount, Integer mounth);
}
