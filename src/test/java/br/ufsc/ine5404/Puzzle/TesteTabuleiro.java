package br.ufsc.ine5404.Puzzle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.awt.Dimension;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TesteTabuleiro {
	
	private Tabuleiro t;
	
	@Before
	public void setUp(){
		t = new Tabuleiro(new Dimension(3,3));
	}
	
	@Test
	public void numeroPecas(){
		assertEquals(t.numPecas(), 3 * 3 - 1);
	}
	
	@Test
	public void posicaoVazia(){
		assertEquals(t.posicaoVazia(), new Posicao(2,2));
		assertEquals(t.peca(new Posicao(2,2)), null);
	}
	
	@Test
	public void existePeca(){
		assertFalse(t.peca(new Posicao(0,0)) == null);
	}
	@Test
	public void moverPeca(){
		Peca p = t.peca(new Posicao(1,2));
		p.mover();
		assertEquals(p.getPosicao(),new Posicao(2,2));
	}
}
