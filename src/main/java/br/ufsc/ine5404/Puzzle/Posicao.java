package br.ufsc.ine5404.Puzzle;

public class Posicao {
	
	private int line;
	private int column;

	public Posicao(int line, int column) {
		this.line = line >= 0 ? line : 0;
		this.column = column >= 0 ? column : 0;
	}
	
	public int getLine(){
		return this.line;
	}

	public int getColumn() {
		return this.column;
	}
	
	@Override
	public boolean equals(Object object){
		if( object instanceof Posicao){
			Posicao p = (Posicao) object;
			return (this.line == p.line && this.column == p.column);
		}
		return false;
	}
	
	@Override
	public String toString(){
		return "(" + line + ", " + column + ")";
	}

}
