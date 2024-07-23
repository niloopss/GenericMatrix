# Atividade #2 - Matriz Genérica
## GenericMatrix
## Descrição
**GenericMatrix** é uma ferramenta interativa para a criação e manipulação de matrizes genéricas em Java. Ele permite ao usuário definir o tamanho da matriz (NxN) e escolher o tipo de dados dos elementos (inteiro, double, caractere ou string). Após a matriz ser preenchida, o programa exibe a matriz original, a diagonal principal e a matriz transposta.


## Como usar
1. Execute o arquivo `Main`
2. Informe o tamanho desejado da matriz (NxN).
3. Escolha o tipo de dados dos elementos da matriz (inteiro, double, caractere ou string).
4. Insira os elementos da matriz, um por vez, seguindo as instruções na tela.
5. O programa exibirá a matriz original, a diagonal principal e a matriz transposta.


## Funcionalidades

- **Criação de matriz genérica**: Permite criar matrizes de qualquer tamanho (NxN) com elementos de diferentes tipos de dados (inteiro, double, caractere ou string).
- **Interação com o usuário**: Interface amigável para obter o tamanho da matriz, o tipo de dados e os elementos da matriz do usuário.
- **Exibição da matriz original**: Imprime a matriz na tela de forma organizada.
- **Exibição da diagonal principal**: Imprime os elementos da diagonal principal da matriz (onde linha = coluna).
- **Exibição da matriz transposta**: Imprime a matriz transposta, onde as linhas se tornam colunas e vice-versa.


## Fluxograma

O fluxograma ilustra o fluxo de execução do programa, desde a obtenção do tamanho da matriz até a exibição dos resultados das operações. Ele demonstra a interação entre as classes **UI** (interface do usuário) e **MatrizGenerica**, mostrando como os dados são obtidos, processados e exibidos.

![Fluxograma - GenericMatrix - Mermaid.png](Fluxograma%20-%20GenericMatrix%20-%20Mermaid.png)

**Código Mermaid**
```
graph TD
    A[Início] --> B[UI.obterTamanhoMatriz]
    B --> C[UI.Escolha do Tipo de Dados]
    C --> D{Tipo de Dados Válido?}
    D -->|Sim| E[Criar MatrizGenerica<T>]
    D -->|Não| F[Exibir Mensagem de Erro]
    F --> A
    E --> G[UI.obterElementosMatriz]
    G --> H[UI.exibirMatriz]
    H --> I[UI.exibirDiagonal]
    I --> J[UI.exibirTransposta]
    J --> K[Fim]

```

## Explicação do Fluxograma

- **A (Início)**: O programa começa.
- **B (UI.obterTamanhoMatriz())**: A interface do usuário solicita o tamanho da matriz.
- **C (UI.Escolha do Tipo de Dados)**: A interface do usuário solicita a escolha do tipo de dados da matriz (inteiro, double, caractere ou string).
- **D (Tipo de Dados Válido?)**: Verifica se o tipo de dados escolhido é válido.
    - **Sim**: Cria uma instância da classe `MatrizGenerica` com o tipo de dados escolhido.
    - **Não**: Exibe uma mensagem de erro e retorna ao início.
- **E (Criar MatrizGenerica<T>)**: Cria uma instância da classe `MatrizGenerica` com o tipo de dados escolhido.
- **F (Exibir Mensagem de Erro)**: Exibe uma mensagem de erro se o tipo de dados for inválido.
- **G (UI.obterElementosMatriz(matriz))**: A interface do usuário solicita os elementos da matriz.
- **H (UI.exibirMatriz(matriz))**: A interface do usuário exibe a matriz.
- **I (UI.exibirDiagonal(matriz))**: A interface do usuário exibe a diagonal principal da matriz.
- **J (UI.exibirTransposta(matriz))**: A interface do usuário exibe a matriz transposta.
- **K (Fim)**: O programa termina.


## Diagrama de Classes

O diagrama de classes representa a estrutura do projeto, mostrando as classes (**MatrizGenerica**, **UI** e **Main**), seus atributos e métodos, e os relacionamentos entre elas. Ele oferece uma visão geral da organização do código e das responsabilidades de cada classe.

![Diagrama de Classes - GenericMatrix - Mermaid.png](Diagrama%20de%20Classes%20-%20GenericMatrix%20-%20Mermaid.png)

**Código Mermaid**
```
classDiagram
    class MatrizGenerica {
        - List<List<T>> matriz
        - int tamanho
        + MatrizGenerica(int tamanho)
        + MatrizGenerica(T[][] valores)
        + int getTamanho()
        + void adicionarElemento(int linha, int coluna, T elemento)
        + T obterElemento(int linha, int coluna)
        - void validarIndices(int linha, int coluna)
        + void listarDados()
        + void diagonalPrincipal()
        + void matrizTransposta()
    }

    class UI {
        - Scanner scanner
        + UI()
        + int obterTamanhoMatriz()
        + <T> void obterElementosMatriz(MatrizGenerica<T> matriz)
        + <T> void exibirMatriz(MatrizGenerica<T> matriz)
        + <T> void exibirDiagonal(MatrizGenerica<T> matriz)
        + <T> void exibirTransposta(MatrizGenerica<T> matriz)
    }

    class Main {
        + static void main(String[] args)
    }

    Main ..> UI
    Main ..> MatrizGenerica
    UI ..> MatrizGenerica

```


## Explicação do Diagrama

### MatrizGenerica\<T\>:
- Atributos:
   - **matriz (privado)**: Armazena os elementos da matriz.
   - **tamanho (privado)**: Armazena o tamanho da matriz.

- Métodos:
   - **MatrizGenerica(int)**: Construtor que inicializa a matriz com um tamanho dado.
   - **MatrizGenerica(T[][])**: Construtor que inicializa a matriz com valores.
   - **getTamanho()**: Retorna o tamanho da matriz.
   - **adicionarElemento(int, int, T)**: Adiciona um elemento à matriz.
   - **obterElemento(int, int)**: Retorna um elemento da matriz.
   - **validarIndices(int, int) (privado)**: Valida os índices da matriz.
   - **listarDados()**: Imprime os elementos da matriz.
   - **diagonalPrincipal()**: Imprime a diagonal principal da matriz.
   - **matrizTransposta()**: Imprime a matriz transposta.

### UI:

- Atributos:
   - **scanner (privado)**: Objeto Scanner para ler a entrada do usuário.

- Métodos:
   - **UI()**: Construtor.
   - **obterTamanhoMatriz()**: Obtém o tamanho da matriz do usuário.
   - **obterElementosMatriz(MatrizGenerica\<T\>)**: Obtém os elementos da matriz do usuário.
   - **exibirMatriz(MatrizGenerica\<T\>)**: Exibe a matriz.
   - **exibirDiagonal(MatrizGenerica\<T\>)**: Exibe a diagonal principal da matriz.
   - **exibirTransposta(MatrizGenerica\<T\>)**: Exibe a matriz transposta.

### Main:

- Métodos:
   - **main(String[])**: Método principal que inicia a execução do programa.

- Relacionamentos:

   - **Main** usa **UI** e **MatrizGenerica**.
   - **UI** usa **MatrizGenerica**.


## Resultados