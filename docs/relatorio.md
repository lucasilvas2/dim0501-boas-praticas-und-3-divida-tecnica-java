| ID | Localização | Descrição do problema | Tipo da dívida | Esforço | Impacto | Custo |
|----|-----------------|-----------------|-----------------|-----------------|-----------------|-----------------|
|D01| `Estoque.java` / import da `Date` | Importação sem uso | Marcadores e código morto | 1 | 1 | 1 |
|D02| `Estoque.java` / `SENHA_ADMIN` | Credencial administrativa fixa no código | Configuração | 1 | 4 | 4 |
|D03| `Estoque.java` / `SENHA_ADMIN` | Comentário redundante que apenas repete o nome da constante | Documentação | 1 | 1 | 1 |
|D04| `Estoque.java` / campos globais `produtos` e `hist` | Nome genérico que não explica bem a responsabilidade da estrutura | Código | 2 | 2 | 2 |
|D05| `Estoque.java` / campos globais `produtos` e `hist` | Comentário pouco informativo sobre o papel do atributo | Documentação | 1 | 1 | 1 |
|D06| `Estoque.java` / classe interna `Produto` | Classe interna acoplada à classe principal, reduzindo reuso e organização | Arquitetura / Design | 3 | 2 | 2 |
|D07| `Estoque.java` / classe `Estoque` | Armazenamento dos dados e lógica de manipulação estão concentrados na mesma classe, dificultando manutenção e evolução | Arquitetura / Design | 5 | 4 | 5 |
|D08| `Estoque.java` / `add()` | Comentário que existe para compensar um nome de método pouco explícito | Documentação | 1 | 1 | 1 |
|D09| `Estoque.java` / `add()` | Nome de método e parâmetros pouco descritivos | Código | 2 | 1 | 1 |
|D10| `Estoque.java` / `add()` | Método altera estado global diretamente | Arquitetura / Design | 2 | 3 | 3 |
|D11| `Estoque.java` / `vender()` | Método com várias responsabilidades no mesmo bloco | Código | 4 | 4 | 4 |
|D12| `Estoque.java` / `vender()` | Comentário muleta para explicar regra de negócio | Documentação | 2 | 1 | 1 |
|D13| `Estoque.java` / `vender()` | Número mágico referente ao desconto aplicado | Código | 1 | 2 | 2 |
|D14| `Estoque.java` / `calcular_total()` | Comentário redundante | Documentação | 2 | 1 | 1 |
|D15| `Estoque.java` / `calcular_total()` | Nome de função pouco descritivo para o que realmente faz | Código | 1 | 1 | 1 |
|D16| `Estoque.java` / `calcular_total()` | Variável com nome pouco informativo | Código | 1 | 1 | 1 |
|D17| `Estoque.java` / `calcular_total()` | Números mágicos usados na regra de desconto | Código | 1 | 2 | 2 |
|D18| `Estoque.java` / `calcular_total()` | Comentário muleta para explicar regra de negócio | Documentação | 2 | 1 | 1 |
|D19| `Estoque.java` / `listar()` | Método de listagem acoplado à impressão no console, sem separar obtenção dos dados e apresentação | Arquitetura / Design | 3 | 2 | 2 |
|D20| `Estoque.java` / `relatorio_estoque_baixo()` | Regra de estoque baixo com limiar fixo no código, sem centralização da configuração | Configuração | 1 | 3 | 3 |
|D21| `Estoque.java` / `relatorio_estoque_baixo()` | Método acoplado à impressão no console, sem retornar dados reutilizáveis | Arquitetura / Design | 2 | 3 | 3 |
|D22| `Estoque.java` / `exportar()` | Método antigo totalmente comentado, sem uso no fluxo atual | Marcadores e código morto | 1 | 1 | 1 |
|D23| `Estoque.java` / `relatorio_vendas()` | Método declarado, mas ainda sem implementação | Marcadores e código morto | 1 | 2 | 2 |
|D24| `Estoque.java` / `main()` / leitura de preço e quantidade | Entrada não validada pode gerar exceção e encerrar o programa | Robustez | 2 | 5 | 5 |
|D25| `Estoque.java` / `main()` / cadeia de `if/else` do menu | Fluxo de menu concentrado em um único bloco, dificultando manutenção e evolução | Arquitetura / Design | 3 | 2 | 2 |
|D26| `Estoque.java` / `main()` / autenticação administrativa | Lógica de acesso embutida no fluxo de interface, sem separação de responsabilidades | Arquitetura / Design | 2 | 2 | 2 |
|D27| `Estoque.java` / projeto inteiro | Ausência de testes automatizados para validar cenários de cadastro, venda e relatórios | Testes | 4 | 5 | 5 |
|D28| `Estoque.java` / `vender()` e `calcular_total()` | Regra de desconto duplicada com limiares e percentuais diferentes entre os métodos | Código | 1 | 4 | 4 |
|D29| `Estoque.java` / `main()` | `Scanner` não é fechado ao final do programa | Robustez | 1 | 1 | 1 |
|D30| `Estoque.java` / `main()` | Função principal concentra menu, leitura de entrada, autenticação e despacho de ações em um único bloco | Arquitetura / Design | 5 | 4 | 5 |
|D31| `Estoque.java` / cabeçalho do arquivo | Comentário inicial genérico e pouco útil sobre versão e autoria | Documentação | 1 | 1 | 1 |
|D32| `Estoque.java` / campo `hist` | Estrutura declarada para histórico, mas sem uso funcional relevante no sistema atual | Código | 1 | 2 | 2 |

## 4. Matriz de Priorização

Critério adotado para a ordem de prioridade: `impacto ÷ esforço`, em ordem decrescente. O campo **custo** representa os juros qualitativos de conviver com o débito e ajuda a justificar o item quando a razão ficar próxima.

### Quadrantes da matriz

- **Ganhos rápidos (alto impacto, baixo esforço):** D02, D20, D24, D28
- **Grandes apostas (alto impacto, alto esforço):** D07, D11, D27, D30
- **Preenchimento (baixo impacto, baixo esforço):** D01, D03, D04, D05, D08, D09, D10, D12, D13, D14, D15, D16, D17, D18, D21, D22, D23, D26, D29, D31, D32
- **Adiar / aceitar (baixo impacto, alto esforço):** D06, D19, D25

### Ordem de prioridade resultante

1. D02
2. D28
3. D20
4. D24
5. D27
6. D30
7. D11
8. D07
9. D10
10. D21
11. D13
12. D17
13. D23
14. D26
15. D04
16. D32
17. D01
18. D03
19. D05
20. D08
21. D09
22. D12
23. D14
24. D15
25. D16
26. D18
27. D22
28. D29
29. D31
30. D06
31. D19
32. D25

### Justificativa

O critério `impacto ÷ esforço` favorece primeiro os itens com maior retorno por unidade de trabalho. Assim, D02 permanece no topo por combinar impacto alto com esforço mínimo, seguido de D28, D20 e D24. D27, D30, D11 e D07 entram como grandes apostas porque têm impacto alto e exigem mais trabalho. D13, D17 e D23 foram deslocados para preenchimento porque não atingem impacto alto o suficiente para a faixa de ganhos rápidos. Em caso de empate, a ordem considera primeiro o maior impacto e depois o menor esforço. D06, D19 e D25 foram reclassificados para o quadrante "Adiar / aceitar": após revisão, o impacto real de cada um foi ajustado para 2, pois os três funcionam adequadamente no escopo atual do sistema e exigem esforço de refatoração desproporcional ao benefício imediato.

## 5. Roadmap de Quitação

### Pagar agora

- `D02` - credencial administrativa fixa no código
- `D28` - regra de desconto duplicada entre `vender()` e `calcular_total()`
- `D20` - limite fixo de estoque baixo
- `D24` - entrada sem validação em `main()`
- `D13` - número mágico do desconto em `vender()`
- `D17` - números mágicos da regra de desconto em `calcular_total()`
- `D23` - método declarado sem implementação

### Pagar depois

- `D27` - ausência de testes automatizados
- `D30` - `main()` concentrando várias responsabilidades
- `D07` - classe principal acumulando dados e regra de negócio
- `D11` - método `vender()` com várias responsabilidades
- `D10` - `add()` altera estado global diretamente
- `D21` - relatório de estoque baixo acoplado à impressão

### Aceitar conscientemente

- `D01`, `D03`, `D05`, `D08`, `D09`, `D12`, `D14`, `D15`, `D16`, `D18`, `D22`, `D29`, `D31`, `D32`
- `D04`, `D26` como baixo impacto sem urgência imediata

### Adiar / aceitar (revisar somente se o escopo crescer)

- `D06` — separar `Produto` em arquivo próprio exige refatoração de pacote, mas a classe interna funciona adequadamente no escopo atual
- `D19` — desacoplar `listar()` do console só traz retorno real se o sistema ganhar outras interfaces de saída (GUI, REST etc.)
- `D25` — substituir o `if/else` do menu por padrão Command/Strategy é esforço considerável para um menu que já funciona corretamente

### Critério de pronto

- `D02`: autenticação administrativa deve deixar de expor credencial no código
- `D28`: a regra de desconto deve existir em um único ponto
- `D20`: o limite de estoque baixo deve ser centralizado em constante/configuração
- `D24`: entradas inválidas não devem encerrar o programa
- `D27`: os cenários principais devem ter testes automatizados
- `D30`: o `main()` deve delegar responsabilidades para métodos menores

## 6. Itens Quitados (Antes vs Depois)
### Item 1 — `D02` Credencial administrativa fixa no código

**Localização:** `Estoque.java` / constante `SENHA_ADMIN`

**Antes:**

```java
static final String CHAVE_ENV_SENHA_ADMIN_HASH = "SENHA_ADMIN_HASH";
```

**Depois:**

```java
static final String CHAVE_ENV_SENHA_ADMIN_HASH = "SENHA_ADMIN_HASH";

static String gerarHashSha256(String valor) {
    try {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(valor.getBytes(StandardCharsets.UTF_8));
        StringBuilder hex = new StringBuilder();
        for (byte b : hash) {
            hex.append(String.format("%02x", b));
        }
        return hex.toString();
    } catch (NoSuchAlgorithmException e) {
        throw new IllegalStateException("Algoritmo de hash indisponivel", e);
    }
}
```

**Explicação:**

A senha administrativa deixou de existir em texto puro no código-fonte e passou a ser comparada por hash. O valor esperado agora vem da variável de ambiente `SENHA_ADMIN_HASH`, e o programa calcula o SHA-256 da senha informada pelo usuário para comparar com o valor externo. Se a variável não estiver configurada, o acesso administrativo é bloqueado com mensagem explícita.

Essa solução é uma mitigação intencional para o escopo atual do sistema. Ela reduz a exposição imediata da credencial e melhora a organização da configuração, mas ainda não substitui uma autenticação robusta. A evolução natural é migrar essa responsabilidade para um banco de dados com armazenamento seguro de credenciais, política de acesso e fluxo próprio de autenticação quando o sistema passar a ter essa infraestrutura.
