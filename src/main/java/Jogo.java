import javax.swing.JOptionPane;

import br.ufsc.ine5404.Puzzle.modelo.Dificuldade;
import br.ufsc.ine5404.Puzzle.modelo.Tabuleiro;
import br.ufsc.ine5404.Puzzle.visao.VisaoTabuleiro;

public class Jogo {
    private Tabuleiro tabuleiro;
    private VisaoTabuleiro visaoTabuleiro;
    private Dificuldade dificuldade;

    public Jogo() {
        visaoTabuleiro = new VisaoTabuleiro();
    }

    public void jogar() {
        while (true) {
            obterDificuldade();
            criarTabuleiro();
            visaoTabuleiro.setTabuleiro(tabuleiro);
            visaoTabuleiro.setVisible(true);
            while(!tabuleiro.fimDeJogo()){}
            JOptionPane.showMessageDialog(visaoTabuleiro, "Parabens, você ganhou!");
            if (!novoJogo()) break;
            dificuldade = null;
        }
    }
    
    private void criarTabuleiro(){
        //Espera até a dificuldade ser definida
  /*      while(dificuldade == null){
            try{
                wait();
            } catch (InterruptedException e){}
        }*/
        tabuleiro = new Tabuleiro(dificuldade.tamanho());
        tabuleiro.embaralhar(dificuldade.vezesEmbaralha());
    }

    private void obterDificuldade() {
        dificuldade = visaoTabuleiro.obterDificuldade();
        
    }

    private static boolean novoJogo() {
        String opcao;
        try {
            opcao = JOptionPane.showInputDialog(null,
                    "Jogar novamente?");
        }
        catch (NullPointerException e) {
            return false;
        }
        opcao = opcao.toUpperCase();
        if (opcao.equals("SIM") || opcao.equals("S")) return true;
        return false;
    }

    public static void main(String[] args) {
        Jogo j = new Jogo();
        j.jogar();
    }
}
