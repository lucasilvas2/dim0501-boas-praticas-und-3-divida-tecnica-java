// Sistema de Controle de Estoque e Vendas
// versao 1.0 - feito rapido pra entregar antes do prazo
// autor: equipe antiga

import java.util.ArrayList;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.Date;   // (nao usado)

public class Estoque {

    static final String CHAVE_ENV_SENHA_ADMIN_HASH = "SENHA_ADMIN_HASH";
    static final double LIMITE_DESCONTO_VENDA = 100;
    static final double PERCENTUAL_DESCONTO_VENDA = 0.1;
    static final RegraDesconto REGRA_DESCONTO_VENDA =
            new RegraDesconto(LIMITE_DESCONTO_VENDA, PERCENTUAL_DESCONTO_VENDA);

    static ArrayList<Produto> produtos = new ArrayList<>();
    static ArrayList<String> hist = new ArrayList<>();  // historico

    static class Produto {
        String nome;
        double preco;
        int qtd;
    }

    static class RegraDesconto {
        final double limite;
        final double percentual;

        RegraDesconto(double limite, double percentual) {
            this.limite = limite;
            this.percentual = percentual;
        }
    }

    static double calcular_total_bruto(double precoUnitario, int quantidade) {
        return precoUnitario * quantidade;
    }

    static double aplicar_desconto(double totalBruto, RegraDesconto regraDesconto) {
        if (totalBruto > regraDesconto.limite) {
            return totalBruto - totalBruto * regraDesconto.percentual;
        }
        return totalBruto;
    }

    // funcao que adiciona produto
    static void add(String n, double p, int q) {
        Produto prod = new Produto();
        prod.nome = n;
        prod.preco = p;
        prod.qtd = q;
        produtos.add(prod);
        hist.add(n);
        System.out.println("Produto adicionado!");
    }

    static double vender(String nome, int quantidade) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).nome.equals(nome)) {
                if (produtos.get(i).qtd >= quantidade) {
                    produtos.get(i).qtd = produtos.get(i).qtd - quantidade;
                    double totalBruto = calcular_total_bruto(produtos.get(i).preco, quantidade);
                    double total = aplicar_desconto(totalBruto, REGRA_DESCONTO_VENDA);
                    System.out.println("Venda realizada. Total: " + total);
                    return total;
                } else {
                    System.out.println("Estoque insuficiente");
                    return 0;
                }
            }
        }
        System.out.println("Produto nao encontrado");
        return 0;
    }

    static void listar() {
        System.out.println("=== PRODUTOS ===");
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println(produtos.get(i).nome + " - R$" + produtos.get(i).preco
                    + " - qtd: " + produtos.get(i).qtd);
        }
    }

    static void relatorio_estoque_baixo() {
        System.out.println("=== ESTOQUE BAIXO ===");
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).qtd < 5) {   // estoque baixo
                System.out.println(produtos.get(i).nome + " esta com estoque baixo ("
                        + produtos.get(i).qtd + ")");
            }
        }
    }

    // funcao antiga, nao usamos mais
    // static void exportar() {
    //     try {
    //         FileWriter f = new FileWriter("dados.txt");
    //         for (int i = 0; i < produtos.size(); i++) {
    //             f.write(produtos.get(i).nome + "\n");
    //         }
    //         f.close();
    //     } catch (Exception e) {}
    // }

    static void relatorio_vendas() {
        // TODO: implementar de verdade
    }

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String senhaAdminHash = System.getenv(CHAVE_ENV_SENHA_ADMIN_HASH);
        while (true) {
            System.out.println("\n1-Cadastrar  2-Vender  3-Listar  4-Estoque baixo  5-Admin  0-Sair");
            System.out.print("Opcao: ");
            String op = sc.next();
            if (op.equals("1")) {
                System.out.print("Nome: ");
                String n = sc.next();
                System.out.print("Preco: ");
                double p = Double.parseDouble(sc.next());   // quebra se digitar texto
                System.out.print("Qtd: ");
                int q = Integer.parseInt(sc.next());        // quebra se digitar texto
                add(n, p, q);
            } else if (op.equals("2")) {
                System.out.print("Nome do produto: ");
                String n = sc.next();
                System.out.print("Quantidade: ");
                int q = Integer.parseInt(sc.next());
                vender(n, q);
            } else if (op.equals("3")) {
                listar();
            } else if (op.equals("4")) {
                relatorio_estoque_baixo();
            } else if (op.equals("5")) {
                System.out.print("Senha: ");
                String s = sc.next();
                if (senhaAdminHash == null || senhaAdminHash.isBlank()) {
                    System.out.println("Configuracao administrativa ausente");
                } else if (gerarHashSha256(s).equals(senhaAdminHash)) {
                    System.out.println("Acesso liberado");
                } else {
                    System.out.println("Senha errada");
                }
            } else if (op.equals("0")) {
                break;
            } else {
                System.out.println("Opcao invalida");
            }
        }
    }
}
