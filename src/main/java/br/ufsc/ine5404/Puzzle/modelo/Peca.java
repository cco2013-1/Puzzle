package br.ufsc.ine5404.Puzzle.modelo;


public class Peca {
    
    private Posicao posicaoCorreta;
    private Object rotulo;
    
    public Peca(Object rotulo, Posicao posicaoCorreta){
        this.rotulo = rotulo;
        this.posicaoCorreta = posicaoCorreta;
    }
    
    public Object rotulo(){
        return rotulo;
    }
    
    @Override
    public boolean equals(Object peca){
        if(!(peca instanceof Peca)) return false;
        Peca p = (Peca) peca;
        return this.rotulo.equals(p.rotulo);
    }
    
    @Override
    public String toString(){
        return rotulo.toString();
    }

    public Posicao posicaoCorreta() {
        return posicaoCorreta;
    }
}
