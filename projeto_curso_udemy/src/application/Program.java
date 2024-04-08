package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Parcelas;
import model.services.ContractServices;
import model.services.PayPalServices;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre os dados do contrato: ");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Data (dd/mm/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(),fmt);
		System.out.print("Valor do contrato: ");
		Double amount = sc.nextDouble();
		
		Contract contract = new Contract(number,date,amount);
		
		System.out.print("Entre com o número das parcelas: ");
		int n = sc.nextInt();
		
		ContractServices contractServices = new ContractServices(new PayPalServices());
		
		contractServices.processContract(contract, n);
		
		System.out.println("PARCELAS: ");
		
		for(Parcelas p : contract.getParcelas()) {
			System.out.println(p);
		}
		
		sc.close();
		
	}
}
