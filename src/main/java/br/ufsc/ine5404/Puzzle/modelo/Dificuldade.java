package br.ufsc.ine5404.Puzzle.modelo;

import java.awt.Dimension;

public class Dificuldade {
    
    //Constantes
    private static final int EMBARALHAR_FACIL = 300;
    private static final int EMBARALHAR_MEDIO = 600;
    private static final int EMBARALHAR_DIFICIL = 1200;
    
    private int vezesEmbaralha;
    private Dimension tamanhoTabuleiro;
    
    private Dificuldade(Dimension tamanhoTabuleiro, int vezesEmbaralha){
        this.tamanhoTabuleiro = tamanhoTabuleiro;
        this.vezesEmbaralha = vezesEmbaralha;
    }
    
    public static Dificuldade facil(){
        return new Dificuldade(new Dimension(3,3), EMBARALHAR_FACIL);
    }
    
    public static Dificuldade medio(){
        return new Dificuldade(new Dimension(4,4), EMBARALHAR_MEDIO);
    }
    
    public static Dificuldade dificil(){
        return new Dificuldade(new Dimension(5,5), EMBARALHAR_DIFICIL);
    }

    public Dimension tamanho() {
        return tamanhoTabuleiro;
    }

    public int vezesEmbaralha() {
        return vezesEmbaralha;
    }
}
