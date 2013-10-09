package br.ufsc.ine5404.Puzzle.modelo;

import java.awt.Dimension;

public class Grade<E> {
    
    private E[][] grade;
    
    @SuppressWarnings("unchecked")
    public Grade(Dimension tamanho) {
        grade = (E[][]) new Object[tamanho.height][tamanho.width];
    }

    public void colocar(E elem, Posicao pos) {
        grade[pos.linha()-1][pos.coluna()-1] = elem;
    }

    public E pegar(Posicao pos) {
        return grade[pos.linha()-1][pos.coluna()-1];
    }
    
    public Dimension tamanho(){
        return new Dimension(grade[0].length, grade.length);
    }

    public void trocar(Posicao pos1, Posicao pos2) {
        E elem1 = pegar(pos1);
        E elem2 = pegar(pos2);
        colocar(elem1, pos2);
        colocar(elem2, pos1);
    }
}
