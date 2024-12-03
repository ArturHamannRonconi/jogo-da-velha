import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JogoDaVelha jogo = new JogoDaVelha();
        boolean jogoTerminado = false;

        System.out.println("Bem-vindo ao Jogo da Velha!");
        jogo.mostrarTabuleiro();

        while (!jogoTerminado) {
            System.out.println("Jogador " + jogo.getJogadorAtual() + ", faça sua jogada (linha e coluna):");
            int linha = scanner.nextInt();
            int coluna = scanner.nextInt();

            if (jogo.fazerJogada(linha, coluna)) {
                jogo.mostrarTabuleiro();
                if (jogo.verificarVencedor()) {
                    System.out.println("Parabéns! Jogador " + jogo.getJogadorAtual() + " venceu!");
                    jogoTerminado = true;
                } else if (jogo.tabuleiroCheio()) {
                    System.out.println("Empate! O tabuleiro está cheio.");
                    jogoTerminado = true;
                } else {
                    jogo.trocarJogador();
                }
            } else {
                System.out.println("Jogada inválida! Tente novamente.");
            }
        }

        scanner.close();
    }
}
