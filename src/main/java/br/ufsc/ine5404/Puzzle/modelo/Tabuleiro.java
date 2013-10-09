package br.ufsc.ine5404.Puzzle.modelo;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tabuleiro implements Puzzle {
    private Grade<Peca> grade;
    private Posicao posicaoVazia;
    
    public Tabuleiro(Dimension tamanho){
        this.grade = new Grade<Peca>(tamanho);
        criarPecas();
    }

    private void criarPecas() {
        int numLinhas = grade.tamanho().height;
        int numColunas = grade.tamanho().width;
        int numPecas = numLinhas * numColunas - 1;
        
        int contPecas = 0;
        for(int i = 1; i <= numLinhas; i++){
            for(int j = 1; j <= numColunas; j++){
                Posicao pos = new Posicao(i,j);
                if(contPecas < numPecas){
                    grade.colocar(new Peca(++contPecas, pos), pos);
                }
                else{
                    grade.colocar(null, pos);
                    posicaoVazia = pos;
                    return;
                }
            }
        }
    }
    
    public Dimension tamanho(){
        return grade.tamanho();
    }
    
    public Peca pegarPeca(Posicao pos){
        return grade.pegar(pos);
    }
    
    @Override
    public String toString(){
        String result = "";
        for(int i = 1; i <= grade.tamanho().height; i++){
            for(int j = 1; j <= grade.tamanho().width; j++){
                Peca p = grade.pegar(new Posicao(i,j));
                if(p == null) result += "0 ";
                else result += p.rotulo() + " ";
            }
            result += "\n";
        }
        return result;
    }

    @Override
    public boolean moverPeca(Direcao para) {
        Posicao pos;
        
        switch(para){
            case BAIXO:
                if(posicaoVazia.linha() == 1) return false;
                pos = new Posicao(posicaoVazia.linha()-1, posicaoVazia.coluna());
                break;
            case CIMA:
                if(posicaoVazia.linha() == grade.tamanho().height) return false;
                pos = new Posicao(posicaoVazia.linha()+1, posicaoVazia.coluna());
                break;
            case ESQUERDA:
                if(posicaoVazia.coluna() == grade.tamanho().width) return false;
                pos = new Posicao(posicaoVazia.linha(), posicaoVazia.coluna()+1);
                break;
            default:
                if(posicaoVazia.coluna() == 1) return false;
                pos = new Posicao(posicaoVazia.linha(), posicaoVazia.coluna()-1);
                break;
        }
        grade.trocar(pos, posicaoVazia);
        posicaoVazia = pos;
        return true;
    }

    @Override
    public boolean moverPeca(int linha, int coluna) {
        Direcao dir = direcaoVazioAdjacente(linha, coluna);
        if(dir != null){
            return moverPeca(dir);
        }
        return false;
    }

    private Direcao direcaoVazioAdjacente(int linha, int coluna) {
        if(coluna == posicaoVazia.coluna()){
            if(linha == posicaoVazia.linha() + 1) return Direcao.CIMA;
            else if ( linha == posicaoVazia.linha() - 1) return Direcao.BAIXO;
        }
        else if ( linha == posicaoVazia.linha() ){
            if(coluna == posicaoVazia.coluna() + 1) return Direcao.ESQUERDA;
            else if ( coluna == posicaoVazia.coluna() - 1) return Direcao.DIREITA;
        }
        return null;
    }

    @Override
    public boolean fimDeJogo() {
        for(int i = 1; i <= grade.tamanho().height; i++){
            for (int j = 1; j<= grade.tamanho().width; j++ ){
                Posicao pos = new Posicao(i,j);
                Peca p = grade.pegar(pos);
                if(p!= null)
                    if(!p.posicaoCorreta().equals(pos))
                        return false;
            }
        }
        return true;
    }

    @Override
    public void embaralhar(int vezes) {
        List<Direcao> direcoes = new ArrayList<Direcao>();
        direcoes.add(Direcao.BAIXO);
        direcoes.add(Direcao.CIMA);
        direcoes.add(Direcao.DIREITA);
        direcoes.add(Direcao.ESQUERDA);
        for(int i = 0; i < vezes; i++){
            Collections.shuffle(direcoes);
            moverPeca(direcoes.get(0));
        }
    }
}
