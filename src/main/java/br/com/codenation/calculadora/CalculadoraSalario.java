package br.com.codenation.calculadora;

public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {

		double salarioLiquido = 0.0;

		if(salarioBase >= 1039.00){
			double inss = calcularInss(salarioBase);
			double salarioBruto = calcularSalarioBruto(salarioBase,inss);
			double irrf = calcularIrrf(salarioBruto);
			salarioLiquido = ((salarioBase - inss ) - irrf);
		}
		return Math.round(salarioLiquido);
	}

	private double calcularInss(double salarioBase) {
		double inss = 0.0;
		if(salarioBase <= 1500.00){
			inss =  (8/100.0) * salarioBase;
		}else if(salarioBase > 1500.00 && salarioBase <= 4000 ){
			inss = (9/100.0) * salarioBase;
		}else{
			inss = (11/100.0) * salarioBase;
		}
		return inss;
	}
	public double calcularSalarioBruto(double salarioBase, double inss){
		return salarioBase - inss;
	}
	public double calcularIrrf(double salarioBruto){
		double descontoIrrf = 0.0;
		if(salarioBruto <= 3000.00){
			descontoIrrf = 0.0 ;
		}else if(salarioBruto > 3000.01 && salarioBruto <= 6000.0){
			descontoIrrf = 7.5/100.0 * salarioBruto ;
		}else{
			descontoIrrf = 15.0/100.0 * salarioBruto;
		}
		return descontoIrrf;
	}
}
