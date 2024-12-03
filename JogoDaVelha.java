class JogoDaVelha {
    private char[][] tabuleiro;
    private char jogadorAtual;

    // Construtor
    public JogoDaVelha() {
        tabuleiro = new char[3][3];
        inicializarTabuleiro();
        jogadorAtual = 'X';
    }

    // Inicializa o tabuleiro com espaços vazios
    private void inicializarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

    // Exibe o tabuleiro
    public void mostrarTabuleiro() {
        System.out.println("  0   1   2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println(" ---+---+---");
        }
    }

    // Faz uma jogada
    public boolean fazerJogada(int linha, int coluna) {
        if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro[linha][coluna] == ' ') {
            tabuleiro[linha][coluna] = jogadorAtual;
            return true;
        }
        return false;
    }

    // Alterna entre os jogadores
    public void trocarJogador() {
        jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
    }

    // Verifica se há um vencedor
    public boolean verificarVencedor() {
        // Linhas e colunas
        for (int i = 0; i < 3; i++) {
            if ((tabuleiro[i][0] == jogadorAtual && tabuleiro[i][1] == jogadorAtual && tabuleiro[i][2] == jogadorAtual) ||
                (tabuleiro[0][i] == jogadorAtual && tabuleiro[1][i] == jogadorAtual && tabuleiro[2][i] == jogadorAtual)) {
                return true;
            }
        }
        // Diagonais
        if ((tabuleiro[0][0] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][2] == jogadorAtual) ||
            (tabuleiro[0][2] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][0] == jogadorAtual)) {
            return true;
        }
        return false;
    }

    // Verifica se o tabuleiro está cheio
    public boolean tabuleiroCheio() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public char getJogadorAtual() {
        return jogadorAtual;
    }
}
