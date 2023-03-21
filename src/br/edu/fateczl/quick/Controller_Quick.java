package br.edu.fateczl.quick;

public class Controller_Quick {

	public Controller_Quick() {
		super();
	}
	
	public int[] QS(int[] vetor, int inicio, int fim) {
		if(fim > inicio) {
			int PivoFixo = dividir(vetor, inicio, fim);
			QS(vetor, inicio, PivoFixo - 1);
			QS(vetor, PivoFixo + 1, fim);
		}
		return vetor;
	}
	
	private int dividir(int[] vetor, int inicio, int fim) {
		int Esquerda = inicio + 1;
		int Direita = fim;
		int fixo = vetor[inicio];
		
		while(Esquerda <= Direita) {
			while(Esquerda <= Direita && vetor[Esquerda] <= fixo) {
				Esquerda++;
			}
			while(Direita >= Esquerda && vetor[Direita] > fixo) {
				Direita--;
			}
			if(Esquerda < Direita) {
				trocar(vetor, Esquerda, Direita);
				Esquerda++;
				Direita--;
			}
		}
		trocar(vetor, inicio, Direita);
		return Direita;
	}
	
	private void trocar(int[] vetor, int i, int j) {
		int aux = vetor[j];
		vetor[j] = vetor[i];
		vetor[i] = aux;
	}
}
