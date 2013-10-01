package br.ufsc.ine5404.Puzzle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Dimension;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import br.ufsc.ine5404.Puzzle.Peca.Direcao;

@RunWith(JUnit4.class)
public class TestePeca {
	
	@Test
	public void posicaoPositiva(){
		Posicao p = new Posicao(0,0);
		assertTrue(p.getLine() >= 0 && p.getColumn() >= 0);
		p = new Posicao(-4,-3);
		assertTrue(p.getLine() >= 0 && p.getColumn() >= 0);
	}
	
	@Test
	public void moverPeca(){
		Peca p = new Peca(new Tabuleiro(new Dimension(3,3)), new Posicao(0,0));
		p.mover(Direcao.PARA_BAIXO);
		assertEquals(new Posicao(1,0), p.getPosicao());
		p.mover(Direcao.PARA_DIREITA);
		assertEquals(new Posicao(1,1), p.getPosicao());
		p.mover(Direcao.PARA_CIMA);
		assertEquals(new Posicao(0,1), p.getPosicao());
		p.mover(Direcao.PARA_ESQUERDA);
		assertEquals(new Posicao(0,0), p.getPosicao());
		p.mover(Direcao.PARA_CIMA);
		assertEquals(new Posicao(0,0), p.getPosicao());
		p.mover(Direcao.PARA_ESQUERDA);
		assertEquals(new Posicao(0,0), p.getPosicao());
	}
	
	@Test
	public void moverPeca5vezes(){
		Peca p = new Peca(null, new Posicao(0,0));
		for(int i = 0; i < 5; i++) p.mover(Direcao.PARA_BAIXO);
		assertEquals(new Posicao(5,0), p.getPosicao());
		for(int i = 0; i < 5; i++) p.mover(Direcao.PARA_DIREITA);
		assertEquals(new Posicao(5,5), p.getPosicao());
	}
	
}
