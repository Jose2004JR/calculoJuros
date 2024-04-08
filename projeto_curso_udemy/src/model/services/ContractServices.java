package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Parcelas;

public class ContractServices {
	private OnlinePaymentServices onlinePaymentServices;
	
	public ContractServices(OnlinePaymentServices onlinePaymentServices) {
		this.onlinePaymentServices = onlinePaymentServices;
	}

	public void processContract(Contract contract,Integer mounth) {
		
		double basicQuota = contract.getTotalValue()/ mounth;
		
		for(int i = 1 ; i <= mounth;i++) {
			LocalDate dueDate = contract.getDate().plusMonths(i);
			
			double juro = onlinePaymentServices.juros(basicQuota, i);
			double taxe = onlinePaymentServices.taxa(basicQuota + juro);
			double quota = basicQuota + juro + taxe;
			
			contract.getParcelas().add(new Parcelas(dueDate, quota));
		}
	}
	
}
