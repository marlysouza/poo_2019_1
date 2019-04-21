import java.util.Scanner;

public class Cal1 {
	int bateria;
	int limiteBateria;
	
	public Cal1 (int bateria, int limiteBateria) { //Construtor
		this.bateria = bateria;
		this.limiteBateria = limiteBateria;
	}
	public void recarregar(int carga) {
		this.bateria += carga;
		if (this.bateria>this.limiteBateria);
		this.bateria = this.limiteBateria;
	}
	public void soma(int a, int b) {
		if (this.bateria>0) {
			this.bateria -= 1;
			System.out.println(a+b);
		}else {
			System.out.println("Bateria insuficiente");
		}	
	}
	public void multi(int a, int b) {
		if (this.bateria>0) {
			this.bateria -= 1;
			System.out.println(a*b);
		}else {
			System.out.println("Bateria insuficiente");
		}
		
	}
	public void divi(int a, int b) {
		if (this.bateria>0 && b!=0){
			this.bateria -= 1;
			System.out.println(a/b);
		}else if (b==0){
			this.bateria -= 1;
			System.out.println("Falha: divisão por zaro");
		}else {
			System.out.println("Bateria insuficiente");
		}
	}
	public String toString () {
		return "Bateria:" + this.bateria + "/" + this.limiteBateria;
		}
	
public static class Controller{
	public static void main (String[] args) {
		
			Scanner scanner = new Scanner(System.in);
			Cal1 cal1 = new Cal1 (0,0);
			System.out.println("end, init, show, charge, soma, multi, divi");
		    
			while (true) {
				String line  = scanner.nextLine();
				String[] ui = line.split(" ");
				
				if (ui[0].equals("end")) {
					break;
				}
				else if (ui[0].equals("init")) {
					cal1 = new Cal1 (Integer.parseInt(ui[1]),Integer.parseInt(ui[2]));
				}
				else if (ui[0].equals("show")) {
					System.out.println(cal1);
				}
				else if (ui[0].equals("charge")) {
					cal1.recarregar(Integer.parseInt(ui[1]));
				}
				else if (ui[0].equals("soma")) {
					cal1.soma(Integer.parseInt(ui[1]),Integer.parseInt(ui[2]));
				}
				else if (ui[0].equals("multi")) {
					cal1.multi(Integer.parseInt(ui[1]),Integer.parseInt(ui[2]));
				}
				else if (ui[0].equals("divi")) {
					cal1.divi(Integer.parseInt(ui[1]),Integer.parseInt(ui[2]));
				}
				else {
					System.out.println("Falha: Comando inválido!");
				}
			}
		}
	}
}
