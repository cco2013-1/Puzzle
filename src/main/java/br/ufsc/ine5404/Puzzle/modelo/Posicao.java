package br.ufsc.ine5404.Puzzle.modelo;

public class Posicao {
	
	private int linha;
	private int coluna;

	public Posicao(int line, int column) {
		this.linha = line >= 1 ? line : 1;
		this.coluna = column >= 1 ? column : 1;
	}
	
	public int linha(){
		return this.linha;
	}

	public int coluna() {
		return this.coluna;
	}
	
	@Override
	public boolean equals(Object object){
		if( object instanceof Posicao){
			Posicao p = (Posicao) object;
			return (this.linha == p.linha && this.coluna == p.coluna);
		}
		return false;
	}
	
	@Override
	public String toString(){
		return "(" + linha + ", " + coluna + ")";
	}

}
