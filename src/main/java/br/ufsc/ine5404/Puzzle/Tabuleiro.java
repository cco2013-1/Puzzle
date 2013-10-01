package br.ufsc.ine5404.Puzzle;

import java.awt.Dimension;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Tabuleiro {

	private Dimension dimensao;
	private Posicao posicaoVazia;
	private Set<Peca> pecas;

	public Tabuleiro(Dimension dimensao) {
		this.dimensao = dimensao;
		int numPecas = dimensao.height * dimensao.width - 1;
		pecas = new HashSet<Peca>();
		criarPecas(numPecas);
		posicaoVazia = new Posicao(dimensao.height - 1, dimensao.width - 1);
	}

	private void criarPecas(int numPecas) {
		int contPecas = 0;
		for (int i = 0; i < dimensao.height; i++) {
			for (int j = 0; j < dimensao.width; i++) {
				if(contPecas >= numPecas) return;
				Peca p = new Peca(this, new Posicao(i,j));
				pecas.add(p);
				contPecas++;
			}
		}
	}

	public int getNumLinhas() {
		return dimensao.height;
	}

	public int getNumColunas() {
		return dimensao.width;
	}

	public int numPecas() {
		return pecas.size();
	}

	public Posicao posicaoVazia() {
		return posicaoVazia;
	}

	public Peca peca(Posicao pos) {
		
		for(Peca peca : pecas){
			if(peca.getPosicao().equals(pos)) return peca;
		}
		return null;
	}

}
