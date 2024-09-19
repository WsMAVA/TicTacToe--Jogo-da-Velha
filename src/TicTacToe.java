/**
 * Este é um jogo simples de Tic Tac Toe (Jogo da Velha).
 * Dois jogadores se alternam para colocar 'X' ou 'O' no tabuleiro.
 * O objetivo é formar uma linha, coluna ou diagonal com o mesmo símbolo.
 * @author wallace
 *
 */
import java.util.Scanner;
public class TicTacToe {
    /**
     * O método principal (main) onde o jogo acontece.
     * Ele controla o fluxo do jogo, alterna entre jogadores e verifica quem venceu.
     * @param args Argumentos de linha de comando (não utilizados aqui)
     */
    public static void main (String[] args){
        //Scanner permite que o programa leia entradas do teclado
        Scanner scanner = new Scanner(System.in);

        //Tabuleiro 3x3 inicialmente vazio, aqui é onde vai ficar as jogadas
        char[][] board = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};

        //Jogador 'X' começa
        char player = 'X';

        //Variavéis para armazenar linha e coluna escolhida pelo player
        int row,col;

        //Loop principal do jogo que continua até que alguém vença ou haja empate
        while(true){
            /**
             * Exibe o tabuleiro na tela
             * Basicamente indica as linhas e as colunas onde o player possa fazer a jogada
             * @param board O tabuleiro do jogo Tic Tac Toe
             */

            System.out.println(" 0 1 2");
            System.out.println("0 " +board[0][0]+"|"+board[0][1]+"|"+board[0][2]);
            System.out.println(" -+-+-");
            System.out.println("1 "+board[1][0]+"|"+board[1][1]+"|"+board[1][2]);
            System.out.println(" -+-+-");
            System.out.println("2 "+board[2][0]+"|"+board[2][1]+"|"+board[2][2]);

            // Informa de quem é a vez 
            System.out.println("Vez do jogador "+player+".");

            // Pede ao jogador para digitar linha e coluna
            System.out.println("Digite a linha: ");
            row = scanner.nextInt();
            System.out.println("Digite a coluna: ");
            col= scanner.nextInt();

            /**
             * Verifica se a jogada é válida.
             * Uma jogada válida deve estar dentro dos limites do tabuleiro e a posição deve estar vazia.
             *
             * @param row Linha escolhida
             * @param col Coluna escolhida
             * @param board O tabuleiro do jogo
             * @continue true se a jogada for válida, false caso contrário
             */

            if(row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' '){

                //Verifica se a jogada é valida
                System.out.println("Jogada Inválida.");
                continue;
            }

            //Faz a jogada
            board[row][col] = player;

            //Verifica as linhas,colunas e diagonais
            if (board[0][0] == player && board[0][1] == player && board[0][2] == player ||
                board[1][0] == player && board[1][1] == player && board[1][2] == player ||
                board[2][0] == player && board[2][1] == player && board[2][2] == player ||
                board[0][0] == player && board[1][0] == player && board[2][0] == player ||
                board[0][1] == player && board[1][1] == player && board[2][1] == player ||
                board[0][2] == player && board[1][2] == player && board[2][2] == player ||
                board[0][0] == player && board[1][1] == player && board[2][2] == player ||
                board[0][2] == player && board[1][1] == player && board[2][0] == player){
                //Verifica se o jogador atual venceu
                System.out.println("Jogador "+player+" venceu!");
                break;
            }
            //Alterna entre os players 'X' e 'O'
            if (player == 'X'){
                player = 'O';
            } else {
                player = 'X';
            }
        }

        //Fecha o scanner
        scanner.close();
    }
}
