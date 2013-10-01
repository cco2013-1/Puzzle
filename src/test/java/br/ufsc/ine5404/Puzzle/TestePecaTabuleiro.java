package br.ufsc.ine5404.Puzzle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Dimension;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import br.ufsc.ine5404.Puzzle.Peca.Direcao;

@RunWith(JUnit4.class)
public class TestePecaTabuleiro {

	@Test
	public void limitesTabuleiro() {

		Tabuleiro t = new Tabuleiro(new Dimension(3, 3));
		Peca p = new Peca(t, new Posicao(0, 0));

		for (int i = 0; i < 10; i++)
			p.mover(Direcao.PARA_BAIXO);
		for (int i = 0; i < 10; i++)
			p.mover(Direcao.PARA_DIREITA);

		assertTrue(p.getPosicao().getLine() < t.getNumLinhas());
		assertTrue(p.getPosicao().getColumn() < t.getNumColunas());
	}
}
