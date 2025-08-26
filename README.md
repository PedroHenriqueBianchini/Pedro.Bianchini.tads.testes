# Pedro.Bianchini.tads.testesSistema de Cadastro com Persistência em JSON
O sistema tem como objetivo cadastrar pessoas, armazenar seus dados em arquivos no formato JSON e permitir a recuperação posterior, garantindo persistência dos dados.
3. Diagrama de Contexto (A-0)
Entrada (I): Dados do usuário (nome, idade).
Controle (C): Regras de cadastro (campos obrigatórios, formato do JSON).
Mecanismo (M): Programa em Java, usuário que fornece dados, arquivos no disco.
Saída (O): Arquivo pessoas.json atualizado e listagem de cadastros.
 
4. Descrição dos Processos (Decomposição em funções A0, A1, A2...)
Função A1 – Cadastrar Pessoa
•	I: Nome, idade digitados pelo usuário.
•	C: Regras de validação (idade > 0).
•	M: Usuário + sistema Java.
•	O: Pessoa adicionada à lista.
Função A2 – Salvar em Arquivo
•	I: Lista de pessoas em memória.
•	C: Estrutura JSON padronizada.
•	M: Módulo de escrita em arquivo.
•	O: Arquivo pessoas.json atualizado.
Função A3 – Carregar Pessoas
•	I: Arquivo pessoas.json.
•	C: Sintaxe JSON correta.
•	M: Módulo de leitura em arquivo.
•	O: Lista de pessoas carregada na memória.
Função A4 – Listar Pessoas
•	I: Lista de pessoas em memória.
•	C: Opção do usuário no menu.
•	M: Programa Java + console.
•	O: Exibição das pessoas cadastradas.
UML-Case
     +-------------------+
     |     Usuário       |
     +-------------------+
           /     \
          /       \
         v         v
   [Cadastrar Pessoa]      [Listar Pessoas]
             |                   |
             v                   v
       [Salvar Dados]        [Carregar Dados]

 

Diagrama de classe em UML:

+-------------------+        1..*    +-------------------+
|      Cadastro     |----------------|       Pessoa      |
+-------------------+                 +-------------------+
| - pessoas: List   |                 | - nome: String    |
| - ARQUIVO: String |                 | - idade: int      |
+-------------------+                 +-------------------+
| + adicionar()     |                 | + toJson()        |
| + listar()        |                 | + fromJson()      |
| - salvar()        |
| - carregar()      |
+-------------------+

+-------------------+
|       Main        |
+-------------------+
| + main()          |
+-------------------+

+-------------------+
|   ArquivoManager  |
+-------------------+
| + escrever()      |
| + ler()           |
+-------------------+

+-------------------+
|     Validador     |
+-------------------+
| + validarIdade()  |
+-------------------+

 
