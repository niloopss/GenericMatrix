/**
 * Classe main para execução do programa que manipula matrizes genéricas.
 * O programa permite ao usuário escolher o tipo de dados da matriz (Inteiro, Double, Caractere ou String),
 * solicitar os elementos da matriz e exibir a matriz, sua diagonal e sua transposta.
 *
 * @autor Nivea Lins
 */
public class Main {
    /**
     * Método main que executa o programa.
     * Inicializa a interface do usuário, obtém o tamanho da matriz e o tipo de dados desejado.
     * Em seguida, cria uma matriz genérica com base na escolha do usuário, solicita os elementos,
     * e exibe a matriz, a diagonal e a matriz transposta.
     */
    public static void main(String[] args) {
        UI ui = new UI();

        int tamanho = ui.obterTamanhoMatriz();

        System.out.println("\nEscolha o tipo de dados da matriz:");
        System.out.println("1. Inteiro");
        System.out.println("2. Double");
        System.out.println("3. Caractere");
        System.out.println("4. String");
        int escolhaTipo = ui.scanner.nextInt();

        switch (escolhaTipo) {
            case 1:
                MatrizGenerica<Integer> matrizInt = new MatrizGenerica<>(tamanho);
                ui.obterElementosMatriz(matrizInt);
                ui.exibirMatriz(matrizInt);
                ui.exibirDiagonal(matrizInt);
                ui.exibirTransposta(matrizInt);
                break;
            case 2:
                MatrizGenerica<Double> matrizDouble = new MatrizGenerica<>(tamanho);
                ui.obterElementosMatriz(matrizDouble);
                ui.exibirMatriz(matrizDouble);
                ui.exibirDiagonal(matrizDouble);
                ui.exibirTransposta(matrizDouble);
                break;
            case 3:
                MatrizGenerica<Character> matrizChar = new MatrizGenerica<>(tamanho);
                ui.obterElementosMatriz(matrizChar);
                ui.exibirMatriz(matrizChar);
                ui.exibirDiagonal(matrizChar);
                ui.exibirTransposta(matrizChar);
                break;
            case 4:
                MatrizGenerica<String> matrizString = new MatrizGenerica<>(tamanho);
                ui.obterElementosMatriz(matrizString);
                ui.exibirMatriz(matrizString);
                ui.exibirDiagonal(matrizString);
                ui.exibirTransposta(matrizString);
                break;
            default:
                System.out.println("Escolha inválida.");
        }
    }
}
