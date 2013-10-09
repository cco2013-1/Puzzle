package br.ufsc.ine5404.Puzzle;

import static org.junit.Assert.*;

import java.awt.Dimension;

import org.junit.runners.JUnit4;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.ufsc.ine5404.Puzzle.modelo.Grade;
import br.ufsc.ine5404.Puzzle.modelo.Peca;
import br.ufsc.ine5404.Puzzle.modelo.Posicao;
import br.ufsc.ine5404.Puzzle.modelo.Tabuleiro;
import br.ufsc.ine5404.Puzzle.modelo.Puzzle.Direcao;

@RunWith(JUnit4.class)
public class TesteJogo {

    private Tabuleiro t;

    @Before
    public void criaTabuleiro() {
        t = new Tabuleiro(new Dimension(3, 3));
    }

    @Test
    public void criarPecaComNumero() {
        Peca p = new Peca(1, new Posicao(1, 1));
        assertEquals(1, p.rotulo());
    }

    @Test
    public void criarGrade() {
        Grade<Peca> g = new Grade<Peca>(new Dimension(3, 3));
        Peca p = new Peca(1, new Posicao(1, 1));
        Posicao pos = new Posicao(1, 1);
        g.colocar(p, pos);
        Posicao pos2 = new Posicao(1, 2);
        Peca p2 = new Peca(2, new Posicao(1, 1));
        g.colocar(p2, pos2);
        assertEquals(p, g.pegar(pos));
        assertEquals(p2, g.pegar(pos2));
    }

    @Test
    public void dimensaoGrade() {
        Grade<Peca> g = new Grade<Peca>(new Dimension(3, 2));
        assertEquals(new Dimension(3, 2), g.tamanho());
    }

    @Test
    public void verificaTabuleiro() {
        assertEquals("1 2 3 \n" 
                   + "4 5 6 \n" 
                   + "7 8 0 \n", t.toString());
    }

    @Test
    public void naoMoveQuandoNaoPode() {
        assertFalse(t.moverPeca(Direcao.CIMA));
        assertFalse(t.moverPeca(Direcao.ESQUERDA));
    }

    @Test
    public void moverParaBaixo() {
        assertTrue(t.moverPeca(Direcao.BAIXO));
        assertEquals("1 2 3 \n" 
                   + "4 5 0 \n" 
                   + "7 8 6 \n", t.toString());
    }

    @Test
    public void moverPecaEspecifica() {
        assertFalse(t.moverPeca(1, 1));
        assertTrue(t.moverPeca(2, 3));
        assertEquals("1 2 3 \n" 
                   + "4 5 0 \n" 
                   + "7 8 6 \n", t.toString());
        assertTrue(t.moverPeca(2, 2));
        assertEquals("1 2 3 \n" 
                   + "4 0 5 \n" 
                   + "7 8 6 \n", t.toString());
        assertTrue(t.moverPeca(1, 2));
        assertEquals("1 0 3 \n" 
                   + "4 2 5 \n" 
                   + "7 8 6 \n", t.toString());
    }

    @Test
    public void testeFimJogo() {
        t.moverPeca(Direcao.BAIXO);
        t.moverPeca(Direcao.CIMA);
        assertTrue(t.fimDeJogo());
    }
}
