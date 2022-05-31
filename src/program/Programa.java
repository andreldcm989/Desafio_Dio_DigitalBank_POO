package program;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import entities.Cliente;
import entities.Conta;
import entities.ContaCorrente;
import entities.ContaPoupanca;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Conta> conta = new ArrayList<>();
        List<Cliente> cliente = new ArrayList<>();

        Cliente c1 = new PessoaFisica("Ana", "ana@gmail.com", "3455667788", "PF", 3000.00, "09878900765",
                LocalDate.of(1990, 12, 12));
        Cliente c2 = new PessoaFisica("Maria", "maria@gmail.com", "3498765432", "PF", 10000.00, "87900876544",
                LocalDate.of(1970, 1, 10));
        Cliente c3 = new PessoaFisica("Leonardo", "leo@gmail.com", "3499012345", "PF", 3500.00, "23455167877",
                LocalDate.of(1998, 6, 12));

        Conta a = new ContaCorrente(c1);
        c1.setConta(a);
        Conta b = new ContaCorrente(c2);
        c2.setConta(b);
        Conta d = new ContaCorrente(c3);
        c3.setConta(d);
        conta.addAll(Arrays.asList(a, b, d));
        cliente.addAll(Arrays.asList(c1, c2, c3));

        System.out.println("Olá! Bem-vindo ao Nosso Banco! O que deseja fazer?");
        int r1 = 0;
        do {
            System.out.println("====================================================");
            System.out.println("Digite o NUMERO a opção desejada:");
            System.out.println(
                    "1. Abrir Conta\n2. Consultar sua conta\n3. Contratar um produto\n4. Finalizar atendimento");
            System.out.print("Pode digitar: ");
            r1 = sc.nextInt();
            sc.nextLine();
            System.out.println();

            if (r1 == 1) {
                System.out.println("====================================================");
                System.out.println("Para abrir uma conta, informe os dados abaixo:");
                System.out.print("A conta é para Pessoa Física ou Juridica? (Digite PF ou PJ) ");
                String tipoCliente = sc.nextLine();
                System.out.print("Seu Nome: ");
                String nome = sc.nextLine();
                System.out.print("email: ");
                String email = sc.nextLine();
                System.out.print("Telefone: ");
                String telefone = sc.nextLine();
                if (tipoCliente.equalsIgnoreCase("PJ")) {
                    System.out.print("CNPJ: ");
                    String cnpj = sc.nextLine();
                    System.out.print("Faturamento: R$ ");
                    double faturamento = sc.nextDouble();
                    Cliente c = new PessoaJuridica(nome, email, telefone, tipoCliente, faturamento, cnpj);
                    cliente.add(c);
                    Conta novaConta = new ContaCorrente(c);
                    conta.add(novaConta);
                    c.setConta(novaConta);
                } else {
                    System.out.print("cpf: ");
                    String cpf = sc.nextLine();
                    System.out.print("Data de Nascimento (dd/mm/aaaa): ");
                    LocalDate dtNasc = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    System.out.print("Renda Mensal: ");
                    double renda = sc.nextDouble();
                    sc.nextLine();
                    Cliente c = new PessoaFisica(nome, email, telefone, tipoCliente, renda, cpf, dtNasc);
                    cliente.add(c);
                    System.out.print("Conta corrente ou Poupança? (digite C ou P) ");
                    String tipoConta = sc.nextLine();
                    Conta novaConta;
                    if (tipoConta.equalsIgnoreCase("p")) {
                        novaConta = new ContaPoupanca(c);
                        conta.add(novaConta);
                    } else {
                        novaConta = new ContaCorrente(c);
                        conta.add(novaConta);
                    }
                    System.out.println();
                    System.out.println("Abertura de conta concluída!");
                    System.out.println("Numero da Conta: " + novaConta.getNumero());
                    System.out.println("Nome Cliente: " + novaConta.getCliente().getNome());
                    System.out.println("Saldo: R$ " + String.format("%.2f", novaConta.getSaldo()));
                    
                    System.out.println("Deseja realizar outra operação? (S/N)");
                    String resp = sc.nextLine();
                    if (resp.equalsIgnoreCase("s")) {
                        clearScreen();
                    } else {
                        r1 = 4;
                    }
                }
            }
            if (r1 == 2) {
                System.out.println("====================================================");
                System.out.print("Digite o numero da conta: ");
                Integer numConta = sc.nextInt();
                Optional<Conta> consulta = conta.stream().filter(x -> x.getNumero() == numConta).findFirst();
                if (consulta.isPresent()) {
                    consulta.get().infoConta();
                    System.out.println();
                    String loop = "s";
                    do {
                        System.out.println(
                                "Aqui você pode fazer:\n1. Depósito\n2. Saque\n3. Transferência\nOu digite 4 para voltar ao menu inicial.");
                        System.out.print("Digite o numero da opção desejada: ");
                        int resp = sc.nextInt();
                        sc.nextLine();
                        switch (resp) {
                            case 1:
                                System.out.print("Valor para depósito: R$ ");
                                double deposito = sc.nextDouble();
                                consulta.get().deposito(deposito);
                                System.out.println("Depósito concluído! Seu novo saldo é R$ "
                                        + String.format("%.2f", consulta.get().getSaldo()));
                                System.out.println("Deseja realizar outra operação? (S/N) ");
                                sc.nextLine();
                                loop = sc.nextLine();
                                System.out.println();
                                break;
                            case 2:
                                System.out.print("Valor do saque: R$ ");
                                double saque = sc.nextDouble();
                                if (saque > consulta.get().getSaldo()) {
                                    System.out.println("Valor maior que o disponível em conta. Operação encerrada.");
                                } else {
                                    consulta.get().saque(saque);
                                    System.out.println("Depósito concluído! Seu novo saldo é R$ "
                                            + String.format("%.2f", consulta.get().getSaldo()));
                                }
                                System.out.println("Deseja realizar outra operação? (S/N) ");
                                sc.nextLine();
                                loop = sc.nextLine();
                                System.out.println();
                                break;
                            case 3:
                                System.out.print("Valor da transferência: R$ ");
                                double transf = sc.nextDouble();
                                if (transf > consulta.get().getSaldo()) {
                                    System.out.println("Valor maior que o disponível em conta. Operação encerrada.");
                                } else {
                                    System.out.print("Conta que receberá a transferência: ");
                                    Integer c = sc.nextInt();
                                    Optional<Conta> receptor = conta.stream().filter(x -> x.getNumero() == c)
                                            .findFirst();
                                    if (receptor.isPresent()) {
                                        consulta.get().transferencia(receptor, transf);
                                        System.out.println("Transferência concluída! Seu novo saldo é R$ "
                                                + String.format("%.2f", consulta.get().getSaldo()));
                                    } else {
                                        System.out.println("A conta informada não existe. Operação encerrada.");
                                    }
                                }
                                System.out.println("Deseja realizar outra operação? (S/N) ");
                                sc.nextLine();
                                loop = sc.nextLine();
                                System.out.println();
                                break;
                            default:
                                loop = "n";
                                clearScreen();
                                break;
                        }
                    } while (loop.equalsIgnoreCase("s"));
                    clearScreen();
                } else {
                    System.out.println("Essa conta não existe.");
                    clearScreen();
                }
            }
            if(r1 == 3){
                System.out.println("Este item não está disponível no momento.");
            }
        } while (r1 != 4);
        System.out.println("Operação Finalizada! Obrigado =)");
        sc.close();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
