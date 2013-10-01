package br.ufsc.ine5404.Puzzle;

public class Peca {

	private Posicao posicao;
	private Tabuleiro tabuleiro;

	public enum Direcao {
		PARA_CIMA, PARA_DIREITA, PARA_BAIXO, PARA_ESQUERDA
	};

	public Peca(Tabuleiro tabuleiro, Posicao position) {
		this.posicao = position;
		this.tabuleiro = tabuleiro;
	}

	public Posicao getPosicao() {
		// TODO Auto-generated method stub
		return this.posicao;
	}

	public void mover(Direcao para) {
		switch (para) {
		case PARA_CIMA:
			this.posicao = new Posicao(this.posicao.getLine() - 1,
					this.posicao.getColumn());
			break;
		case PARA_DIREITA:
			int novaColuna = Math.min(this.posicao.getColumn() + 1,
					tabuleiro.getNumColunas() - 1);
			this.posicao = new Posicao(this.posicao.getLine(), novaColuna);
			break;
		case PARA_BAIXO:
			int novaLinha = Math.min(this.posicao.getLine() + 1,
					tabuleiro.getNumLinhas() - 1);
			this.posicao = new Posicao(novaLinha, this.posicao.getColumn());
			break;
		case PARA_ESQUERDA:
			this.posicao = new Posicao(this.posicao.getLine(),
					this.posicao.getColumn() - 1);
			break;
		}
	}

	public void mover() {
		if(adjacenteVazia()){
			Peca pAux = new Peca(this.tabuleiro,this.tabuleiro.posicaoVazia());
			this.tabuleiro.posicaoVazia().setPosicao(this.posicao);
			this.posicao=pAux.posicao;
		}
		
		
	}

	private boolean adjacenteVazia() {
		// TODO Auto-generated method stub
		return false;
	}

}
