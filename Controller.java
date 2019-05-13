import java.util.Scanner;


class Pet {
	private boolean vivo;
	private int energia; //Privadas para não serem acessadas diretamente fora da classe
	private int saciedade;
	private int limpeza;
	private int energiaMax;
	private int saciedadeMax;
	private int limpezaMax;
	private int diamante;
	private int idade;
	
	public int getEnergia() { //Get: Pegar o valor da variavel privada
		return energia;
	}

	public void setEnergia(int energia) { //Set: muda o valor
		if (energia >= this.energiaMax) //Os limites de energia
			this.energia = energiaMax;
		else if (energia<=0) {
			this.energia = 0;
			this.vivo = false; //Ele morre
	    }else
			this.energia = energia;		
	}

	public int getSaciedade() {
		return saciedade;
	}

	public void setSaciedade(int saciedade) {
		if (saciedade >= this.saciedadeMax) //Os limites de saciedade
			this.saciedade = saciedade;
		else if (saciedade<0) {
			this.saciedade = 0;
			this.vivo = false; //Ele morre
	}else
			this.saciedade = saciedade;
	}

	public int getLimpeza() {
		return limpeza;
	}

	public void setLimpeza(int limpeza) {
		if(limpeza>this.limpezaMax)
			this.limpeza = this.limpezaMax;
		else if (limpeza<0) {
			this.limpeza = 0;
			this.vivo = false; //Ele morre
		}else 
			this.limpeza = limpeza;
	}
	public boolean testvivo () {//Teste para saber se ele ta vivo
		if (this.vivo)
			return true;
		System.out.println("Falha: O Pet está morto!");
		return false;
	}
	public void jogar () { //Não retorna. Altera -2 eng, -1 sac, -3 lim, +1 d, +1 id
		if (!this.testvivo())//Se ele não estiver vivo retorna
			return;
		this.setEnergia(this.getEnergia()-2);
		this.setSaciedade(this.getSaciedade()-1);
		this.setLimpeza(this.getLimpeza()-3);
		this.diamante += 1; //toda vez que joga ganha +1
		this.idade += 1;
	}
	public void comer () { //Não retorna. -1 a eng, +4 sac, -2  lim, +0 d, +1 id
		if (!this.testvivo())
			return;
		this.setEnergia(this.getEnergia()-1);
		this.setSaciedade(this.getSaciedade()+4);
		this.setLimpeza(this.getLimpeza()-2);
		this.idade += 1;
		//this.diamante += 0; Não ganha diamantes
	}
	public void dormir () {//Não retorna.-3 en, -1 sac, MAX na limpeza, +0 d, +2 id
		if (!this.testvivo())
			return;
		if (this.energiaMax - this.energia < 5) {//Teste do sono
			System.out.println("Falha: Não está com sono!");
			return;
	} 
		this.idade += this.energiaMax - this.energia;
		this.setEnergia(this.getEnergiaMax());
	
	}
	public void banho () {//Não retorna.-3 ener, -1 sac, MAX na lim, +0 d, +2 id
		if (!this.testvivo())
			return;
		this.setEnergia(this.getEnergia()-3);
		this.setSaciedade(this.getSaciedade()-1);
		this.setLimpeza(this.getLimpezaMax());
		this.idade += 2;
		// +0 diamantes
	}
	
	public int getLimpezaMax() {
		return limpezaMax;
	}

	public void setLimpezaMax(int limpezaMax) {
		this.limpezaMax = limpezaMax;
	}

	public int getEnergiaMax() {
		return energiaMax;
	}

	public void setEnergiaMax(int energiaMax) {
		this.energiaMax = energiaMax;
	}


	public Pet (int energia, int saciedade, int limpeza) { //Construtor
			this.energia = energia;
			this.saciedade = saciedade;
			this.limpeza = limpeza;
			this.energiaMax = energia;
			this.saciedadeMax = saciedade;
			this.limpezaMax = limpeza;
			this.diamante = 0;
			this.idade = 0;
			this.vivo = true; //Verificar se ele ta vivo
	}
	
	public String toString () { //Transformar em String
		return "Energia: " + this.energia + "/" + this.energiaMax + " " +
				"Saciedade: " + this.saciedade + "/" + this.saciedadeMax + " " +
				"Limpeza: " + this.limpeza + "/" + this.limpezaMax + " " + 
				"Diamante: " + this.diamante + " " + "Idade: " + this.idade;		
	}

}
public class Controller {
	public static void main (String []args){ //Inicializador! Publico, statico, e não restorno
		Scanner scanner = new Scanner(System.in);
		Pet pet = new Pet (0,0,0);
		System.out.println("end, init, show, comer, jogar, dormir, banho");
		
		while(true){
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
            if(ui[0].equals("end")) {
                break;
            }else if(ui[0].equals("init")){ //Toda vez inicia um novo pet
                pet = new Pet(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]), Integer.parseInt(ui[3]));
            }else if(ui[0].equals("show")){
                System.out.println(pet); //Mostra os parametros ex: Energia/Max
            }else if(ui[0].equals("comer")){
                pet.comer();
            }else if(ui[0].equals("jogar")){
                pet.jogar();
            }else if(ui[0].equals("dormir")){
                pet.dormir();
            }else if(ui[0].equals("banho")){
                pet.banho();
            }else {
            	System.out.println("Comando não encontrado!");
		}	
	}
} 
}


