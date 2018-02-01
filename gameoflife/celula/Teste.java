package elimar.gameoflife.celula;

public class Teste {

	public static void main(String[] args)  {
		Mundo teste = new Mundo(8);
		teste.drawWorld();
		while(true){
			teste.nextPopulation();
			teste.drawWorld();
		}
		
		
	}
}
