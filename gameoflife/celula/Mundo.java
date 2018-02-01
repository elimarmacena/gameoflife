package elimar.gameoflife.celula;

import java.util.concurrent.TimeUnit;

public class Mundo implements ControleMundo {
	private int dimension; //dimencoes usadas para a construcao da celula
	private boolean[][] world; //arry do ambiente de vida da celula
	private int geration; //geracao que a celula atualmente se encontra

	public Mundo(int dimension) { //o mundo eh inicializado atraves da dimencao declarada ao  criar um novo mundo
		this.dimension = dimension;
		this.geration = 0;
		createWorld(); //iniciando o ambiente da celula
	}

	private void createWorld() { //toda a celula tem sua vida criada de maneira aleatoria
		boolean[][] nWorld = new boolean[dimension][dimension];
		for (int lin = 0; lin < nWorld.length; lin++) {
			for (int col = 0; col < nWorld[lin].length; col++) {
				nWorld[lin][col] = (Math.random() < 0.3); //Math.random gera valores de 0 ate 0.99, tendo assim um true ou false	
			}
		}
		world = nWorld;
	}

	public void drawWorld() { //exibe o celula na tela
		System.out.print("\n\n\n"); //usados apenas para estabelezer um padrao na minha maquina
		for (int lin = 0; lin < world.length; lin++) {
			for (int col = 0; col < world[lin].length; col++) {
				System.out.print(world[lin][col] ? '+' : '-');
				System.out.print(' ');
			}
			System.out.println();
		}
		System.out.println("GERACAO " + geration); //geracao na qual se encontra o mundo exibido
	}

	public void nextPopulation() { //controle de vida para a proxima geracao
		boolean liveWorld = false; //variavel usada para saber se ainda existe vida na celula, evitando que fique em um loop quando nao existe mais possibilidade de vida
		boolean[][] nextPopulation = new boolean[dimension][dimension]; //novo array para a elaboracao da nova geracao da celula
		for (int lin = 0; lin < world.length; lin++) {
			for (int col = 0; col < world[lin].length; col++) {
				if (isAlive(lin, col)) { //verificacao de celula feita por uma outra funcao
					nextPopulation[lin][col] = true;
					liveWorld = true;
				} else {
					nextPopulation[lin][col] = false;
				}
			}
		}
		world = nextPopulation; // a celula eh atualizada com a nova geracao
		if (liveWorld) {
			geration++;
			clearScreen();
		} else {//caso nao tenha mais vida na celula o programa eh abortado
			clearScreen();
			drawWorld();
			System.out.println("A vida da celula acabou.");
			System.exit(1);
		}

	}

	private boolean isAlive(int lin, int col) {//verifica se a celula ganhara vida na proxima geracao ou ira morrer
		boolean celulaAtual = world[lin][col];
		int countVizinho = 0; //contador de vizinhos vivos
		for (int l = -1; l <= 1; l++) { //controle de verificacao dos vizinhos por linha
			//variavel L para indicar controle de linha
			int linhaAtual = lin + l;
			//---
			for (int c = -1; c <= 1; c++) {
				//variavel C para indicar controle de coluna
				int colunaAtual = col + c;
				//---
				try {// usado devido as possibilidade de outrange 
					if (world[linhaAtual][colunaAtual]) { // caso a casa atual seja uma celula viva
						countVizinho++;
					}
				} catch (java.lang.ArrayIndexOutOfBoundsException outrange) {
					//usado apenas para pegar o erro de range do array
					//usado sem tratamento pois a exception nao causa danos no funcionamento do codigo.	
				}
			}
		}
		//o laco usado percorre ate mesmo a celula principal e caso ela seja viva eh necessario decrementar o contador de vizinhos
		if (celulaAtual) {
			countVizinho--;
		}

		//regras para manter ou nao a vida da celula
		if (countVizinho == 2 && celulaAtual) {
			return true;
		} else if (countVizinho == 3) {
			return true;
		} else {
			return false;
		}
	}

	private static void clearScreen() { //funcao improvisada para criar um efeito de limpeza de tela, dando assim a impressao de uma animacao
		//usei este meio pois comando de limpeza de tela variam de sistema operacional 
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException interrupcao) {
			// TODO Auto-generated catch block
		}
		System.out.print("\n\n\n\n");
	}

}
