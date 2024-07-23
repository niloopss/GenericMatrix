import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe UI responsável por interagir com o usuário para obter dados e exibir resultados relacionados às matrizes.
 *
 * @autor Nivea Lins
 */
public class UI {
    final Scanner scanner;

    /**
     * Construtor que inicializa o scanner para entrada de dados do usuário.
     */
    public UI() {
        scanner = new Scanner(System.in);
    }

    /**
     * Solicita ao usuário o tamanho da matriz (NxN) e valida a entrada.
     * O tamanho deve ser um número inteiro positivo.
     *
     * @return O tamanho da matriz.
     */
    public int obterTamanhoMatriz() {
        int tamanho = 0;
        while (tamanho <= 0) {
            try {
                System.out.print("Digite o tamanho da matriz (NxN): ");
                tamanho = scanner.nextInt();
                if (tamanho <= 0) {
                    System.out.println("O tamanho deve ser um número positivo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                scanner.next();
            }
        }
        return tamanho;
    }

    /**
     * Solicita ao usuário os elementos da matriz e preenche a matriz genérica fornecida.
     *
     * @param <T> O tipo de dados dos elementos da matriz.
     * @param matriz A matriz genérica a ser preenchida.
     */
    public <T> void obterElementosMatriz(MatrizGenerica<T> matriz) {
        System.out.println("Digite os elementos da matriz:");
        for (int i = 0; i < matriz.getTamanho(); i++) {
            for (int j = 0; j < matriz.getTamanho(); j++) {
                System.out.printf("Elemento [%d][%d]: ", i, j);
                T elemento = (T) scanner.next();
                matriz.adicionarElemento(i, j, elemento);
            }
        }
    }

    /**
     * Exibe a matriz fornecida.
     *
     * @param <T> O tipo de dados dos elementos da matriz.
     * @param matriz A matriz genérica a ser exibida.
     */
    public <T> void exibirMatriz(MatrizGenerica<T> matriz) {
        System.out.println("\nMatriz:");
        matriz.listarDados();
    }

    /**
     * Exibe a diagonal principal da matriz fornecida.
     *
     * @param <T> O tipo de dados dos elementos da matriz.
     * @param matriz A matriz genérica cuja diagonal principal será exibida.
     */
    public <T> void exibirDiagonal(MatrizGenerica<T> matriz) {
        System.out.println("\nDiagonal Principal:");
        matriz.diagonalPrincipal();
    }

    /**
     * Exibe a matriz transposta da matriz fornecida.
     *
     * @param <T> O tipo de dados dos elementos da matriz.
     * @param matriz A matriz genérica cuja transposta será exibida.
     */
    public <T> void exibirTransposta(MatrizGenerica<T> matriz) {
        System.out.println("\nMatriz Transposta:");
        matriz.matrizTransposta();
    }
}
