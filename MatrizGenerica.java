import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa uma matriz genérica.
 *
 * @param <T> Tipo dos elementos da matriz.
 * @autor Nivea Lins
 */
public class MatrizGenerica<T> {
    private final List<List<T>> matriz;
    private final int tamanho;

    /**
     * Construtor que inicializa a matriz com o tamanho especificado.
     *
     * @param tamanho O tamanho da matriz (NxN).
     * @throws IllegalArgumentException se o tamanho for menor ou igual a zero.
     */
    public MatrizGenerica(int tamanho) {
        if (tamanho <= 0) {
            throw new IllegalArgumentException("Tamanho da matriz deve ser positivo.");
        }
        this.tamanho = tamanho;
        this.matriz = new ArrayList<>(tamanho);
        for (int i = 0; i < tamanho; i++) {
            this.matriz.add(new ArrayList<>(tamanho));
        }
    }

    /**
     * Construtor que inicializa a matriz com os valores fornecidos.
     *
     * @param valores Uma matriz bidimensional com os valores iniciais.
     * @throws IllegalArgumentException se todas as linhas não tiverem o mesmo tamanho.
     */
    public MatrizGenerica(T[][] valores) {
        this.tamanho = valores.length;
        this.matriz = new ArrayList<>(tamanho);
        for (T[] linha : valores) {
            if (linha.length != tamanho) {
                throw new IllegalArgumentException("Todas as linhas devem ter o mesmo tamanho.");
            }
            this.matriz.add(new ArrayList<>(List.of(linha)));
        }
    }

    /**
     * Retorna o tamanho da matriz (NxN).
     *
     * @return O tamanho da matriz.
     */
    public int getTamanho() {
        return tamanho;
    }

    /**
     * Adiciona um elemento na posição especificada da matriz.
     *
     * @param linha A linha onde o elemento será adicionado.
     * @param coluna A coluna onde o elemento será adicionado.
     * @param elemento O elemento a ser adicionado.
     * @throws IndexOutOfBoundsException se os índices estiverem fora dos limites da matriz.
     */
    public void adicionarElemento(int linha, int coluna, T elemento) {
        validarIndices(linha, coluna);
        matriz.get(linha).add(coluna, elemento);
    }

    /**
     * Obtém o elemento na posição especificada da matriz.
     *
     * @param linha A linha do elemento.
     * @param coluna A coluna do elemento.
     * @return O elemento na posição especificada.
     * @throws IndexOutOfBoundsException se os índices estiverem fora dos limites da matriz.
     */
    public T obterElemento(int linha, int coluna) {
        validarIndices(linha, coluna);
        return matriz.get(linha).get(coluna);
    }

    /**
     * Valida os índices para garantir que estejam dentro dos limites da matriz.
     *
     * @param linha A linha a ser validada.
     * @param coluna A coluna a ser validada.
     * @throws IndexOutOfBoundsException se os índices estiverem fora dos limites da matriz.
     */
    private void validarIndices(int linha, int coluna) {
        if (linha < 0 || linha >= tamanho || coluna < 0 || coluna >= tamanho) {
            throw new IndexOutOfBoundsException("Índices fora dos limites da matriz.");
        }
    }

    /**
     * Exibe todos os dados da matriz no console.
     */
    public void listarDados() {
        for (List<T> linha : matriz) {
            for (T elemento : linha) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }
    }

    /**
     * Exibe a diagonal principal da matriz no console.
     */
    public void diagonalPrincipal() {
        for (int i = 0; i < tamanho; i++) {
            System.out.print(matriz.get(i).get(i) + " ");
        }
        System.out.println();
    }

    /**
     * Exibe a matriz transposta no console.
     */
    public void matrizTransposta() {
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                System.out.print(matriz.get(j).get(i) + " ");
            }
            System.out.println();
        }
    }
}
