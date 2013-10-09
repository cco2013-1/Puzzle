package br.ufsc.ine5404.Puzzle.modelo;

public interface Puzzle {
    
    public enum Direcao { CIMA, ESQUERDA, BAIXO, DIREITA };
    
    public enum Dificuldade { FACIL, MEDIO, DIFICIL };
    
    public boolean moverPeca(Direcao dir);
    
    public boolean moverPeca(int linha, int coluna);
    
    public boolean fimDeJogo();
    
    public void embaralhar(int vezes);
    
}
