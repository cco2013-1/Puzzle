package br.ufsc.ine5404.Puzzle.controle;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import br.ufsc.ine5404.Puzzle.modelo.Puzzle.Direcao;
import br.ufsc.ine5404.Puzzle.modelo.Tabuleiro;
import br.ufsc.ine5404.Puzzle.visao.VisaoTabuleiro;

public class ControleTeclado implements KeyListener {

    private Tabuleiro tabuleiro;
    private VisaoTabuleiro visao;

    public ControleTeclado(Tabuleiro t, VisaoTabuleiro vt) {
        tabuleiro = t;
        visao = vt;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int tecla = e.getKeyCode();
        switch (tecla) {
            case KeyEvent.VK_UP:
                mover(Direcao.CIMA);
                break;
            case KeyEvent.VK_DOWN:
                mover(Direcao.BAIXO);
                break;
            case KeyEvent.VK_LEFT:
                mover(Direcao.ESQUERDA);
                break;
            case KeyEvent.VK_RIGHT:
                mover(Direcao.DIREITA);
                break;
        }
        visao.atualizar();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    private void mover(Direcao para) {
        tabuleiro.moverPeca(para);
    }

}
