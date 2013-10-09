package br.ufsc.ine5404.Puzzle.visao;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import br.ufsc.ine5404.Puzzle.modelo.Dificuldade;
import br.ufsc.ine5404.Puzzle.modelo.Puzzle;

public class DificuldadeDialog extends JDialog implements ActionListener, Runnable{
        Dificuldade dif = Dificuldade.facil();
        boolean ready = false;
        
        JRadioButton facil, medio, dificil;
        JLabel texto = new JLabel("Escolha a dificuldade:");
        
        Container painel;
        JPanel painelSelecaoDificuldade;
        
        DificuldadeDialog(Frame c){
            super(c, VisaoTabuleiro.TITULO_JOGO);
            this.setSize(400, 100);
            this.setLocationRelativeTo(null);
            
            painel = this.getContentPane();
            
          //Facil:
            facil = new JRadioButton("Fácil");
            facil.setMnemonic(KeyEvent.VK_F);
            facil.setActionCommand(Puzzle.Dificuldade.FACIL.toString());
            facil.setSelected(true);
            
            //Medio:
            medio = new JRadioButton("Médio");
            medio.setMnemonic(KeyEvent.VK_M);
            medio.setActionCommand(Puzzle.Dificuldade.MEDIO.toString());
            medio.setSelected(false);
            
            //Dificil
            dificil = new JRadioButton("Difícil");
            dificil.setMnemonic(KeyEvent.VK_D);
            dificil.setActionCommand(Puzzle.Dificuldade.DIFICIL.toString());
            dificil.setSelected(false);
            
            //Agrupar os botoes:
            ButtonGroup botoesDificuldade = new ButtonGroup();
            botoesDificuldade.add(facil);
            botoesDificuldade.add(medio);
            botoesDificuldade.add(dificil);
            
            facil.addActionListener(this);
            medio.addActionListener(this);
            dificil.addActionListener(this);
            
            painelSelecaoDificuldade = new JPanel(new FlowLayout());
            painelSelecaoDificuldade.add(facil);
            painelSelecaoDificuldade.add(medio);
            painelSelecaoDificuldade.add(dificil);
            
            //Botao OK
            JButton botaoOk = new JButton("OK");
            botaoOk.setActionCommand("OK");
            botaoOk.addActionListener(this);
            
            painel.add(texto, BorderLayout.NORTH);
            painel.add(painelSelecaoDificuldade);
            painel.add(botaoOk, BorderLayout.SOUTH);
        }
        
        public synchronized void actionPerformed(ActionEvent e){
            if(e.getActionCommand().equals(Puzzle.Dificuldade.FACIL.toString())){
                this.dif = Dificuldade.facil();
                return;
            }
            if(e.getActionCommand().equals(Puzzle.Dificuldade.MEDIO.toString())){
                this.dif = Dificuldade.medio();
                return;
            }
            if(e.getActionCommand().equals(Puzzle.Dificuldade.DIFICIL.toString())){
                this.dif = Dificuldade.dificil();
                return;
            }
            if(e.getActionCommand().equals("OK")){
                ready = true;
                notifyAll();
                this.dispose();
            }
        }

        @Override
        public void run() {
            this.setVisible(true);
        }
        
        
    }