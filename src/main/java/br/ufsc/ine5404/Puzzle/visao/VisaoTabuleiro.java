package br.ufsc.ine5404.Puzzle.visao;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import br.ufsc.ine5404.Puzzle.controle.ControleTeclado;
import br.ufsc.ine5404.Puzzle.modelo.Dificuldade;
import br.ufsc.ine5404.Puzzle.modelo.Grade;
import br.ufsc.ine5404.Puzzle.modelo.Peca;
import br.ufsc.ine5404.Puzzle.modelo.Posicao;
import br.ufsc.ine5404.Puzzle.modelo.Puzzle;
import br.ufsc.ine5404.Puzzle.modelo.Tabuleiro;

@SuppressWarnings("serial")
public class VisaoTabuleiro extends JFrame {
    
    //Constantes:
    private static final int LARGURA_PECA = 100;
    private static final int ALTURA_PECA = 100;
    public static final String TITULO_JOGO = "Puzzle";
    
    private Tabuleiro tabuleiro;
    
    //Elementos Gráficos
    private Container painelPrincipal;
    private JPanel areaPecas;
    private Grade<JLabel> rotulos;
    
    public VisaoTabuleiro(){
        super(TITULO_JOGO);
    }
    
    public VisaoTabuleiro(Tabuleiro t){
        super(TITULO_JOGO);
        preparaTabuleiro(t);
        setVisible(true);
    }
    
    public void setTabuleiro(Tabuleiro t){
        preparaTabuleiro(t);
        setVisible(true);
    }
    
    private void preparaTabuleiro(Tabuleiro t){
        tabuleiro = t;
        setSize(tabuleiro.tamanho().height*ALTURA_PECA, tabuleiro.tamanho().width*LARGURA_PECA);
        setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addKeyListener(new ControleTeclado(t,this));
        
        painelPrincipal = getContentPane();
        
        areaPecas = new JPanel(new GridLayout(t.tamanho().height, t.tamanho().width));
        
        rotulos = new Grade<JLabel>(t.tamanho());
        inicializarRotulos();
        
        painelPrincipal.add(areaPecas);
    }

    private void inicializarRotulos() {
        for(int i = 1; i <= tabuleiro.tamanho().height; i++){
            for(int j = 1; j <= tabuleiro.tamanho().width; j++){
                String rotulo = "";
                Posicao pos = new Posicao(i,j);
                if(tabuleiro.pegarPeca(pos) != null) rotulo = tabuleiro.pegarPeca(pos).toString();
                JLabel lbl = new JLabel(rotulo);
                formatarRotulo(lbl);
                rotulos.colocar(lbl, pos);
                areaPecas.add(lbl);
            }
        }
    }

    private void formatarRotulo(JLabel lbl) {
        lbl.setFont(new Font("Serif", Font.BOLD, 32));
        lbl.setHorizontalAlignment(JLabel.CENTER);
        lbl.setVerticalAlignment(JLabel.CENTER);
        if(!lbl.getText().equals(""))
            lbl.setBorder(BorderFactory.createRaisedBevelBorder());
    }
    
    public static void main(String[] args){
        Tabuleiro t = new Tabuleiro(new Dimension(3,3));
        VisaoTabuleiro vt = new VisaoTabuleiro(t);
    }

    public void atualizar() {
        for(int i = 1; i <= tabuleiro.tamanho().height; i++){
            for(int j = 1; j <= tabuleiro.tamanho().width; j++){
                Posicao pos = new Posicao(i,j);
                JLabel lbl = rotulos.pegar(pos);
                Peca p = tabuleiro.pegarPeca(pos);
                String rotulo = "";
                if(p != null){
                    rotulo = p.toString();
                    lbl.setBorder(BorderFactory.createRaisedBevelBorder());
                }
                else{
                    lbl.setBorder(BorderFactory.createEmptyBorder());
                }
                lbl.setText(rotulo);
            }
        }
    }
    
    public synchronized Dificuldade obterDificuldade(){
        DificuldadeDialog dialog = new DificuldadeDialog(this);
        (new Thread(dialog)).run();
        
        while(!dialog.ready){
            try{
                Thread.sleep(100);
            } catch(InterruptedException e) {}
          /*  try{
                wait();
            } catch(Exception e) {}*/
        }
        
        notifyAll();
        
        return dialog.dif;
    }
    
}
