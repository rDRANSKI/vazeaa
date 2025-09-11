package catalogoArtesanal;
import java.util.*;

public class ClienteTeste {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Cliente> lista = new ArrayList<>();
        Cliente clienteLogado = null;
        String confSenha;
        int numCasaC = 0;
        boolean logado;

        while (true) {
            System.out.println("\n---MENU---");
            System.out.println("1. Criar conta");
            System.out.println("2. Login");
            System.out.println("0. Sair");
            System.out.println("Escolha uma opção:");
//ja feito tratamento de erros no "main"
            int op = 0;
            try {
                op = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite apenas números.");
                sc.nextLine();
                continue;
            }
            sc.nextLine();

            switch (op) {
                case 1:
                    String nomeC;
                    while (true) {
                        System.out.println("Insira seu nome (somente letras): ");
                        nomeC = sc.nextLine().trim();
                        if (nomeC.matches("[A-Za-zÀ-ÿ ]+")) break;
                        System.out.println("Nome inválido! Use apenas letras e espaços.");
                    }

                    String cpfC;
                    while (true) {
                        System.out.println("CPF (somente números, 11 dígitos): ");
                        cpfC = sc.nextLine().trim();
                        if (cpfC.matches("\\d{11}")) break;
                        System.out.println("CPF inválido! Digite exatamente 11 NUMEROS.");
                    }

                    String emailC;
                    while (true) {
                        System.out.println("Email (deve ser da Google): ");
                        emailC = sc.nextLine().trim();
                        if (emailC.contains("@gmail.com")) break;
                        System.out.println("Email inválido! Deve conter '@gmail.com'.");
                        System.out.println("Excemplo: 'usuario@gmail.com'");
                    }

                    String dataNascC;
                    while (true) {
                        System.out.println("Data de Nascimento (DD/MM/AAAA): ");
                        dataNascC = sc.nextLine().trim();
                        if (dataNascC.matches("\\d{2}/\\d{2}/\\d{4}")) break;
                        System.out.println("Formato inválido! Use DD/MM/AAAA (com barras).");
                    }

                    String cepC;
                    while (true) {
                        System.out.println("CEP (8 números): ");
                        cepC = sc.nextLine().trim();
                        if (cepC.matches("\\d{8}")) break;
                        System.out.println("CEP inválido! Digite exatamente 8 NUMEROS.");
                    }

                    String enderecoC;
                    while (true) {
                        System.out.println("Endereço (somente letras e espaços): ");
                        enderecoC = sc.nextLine().trim();
                        if (enderecoC.matches("[A-Za-zÀ-ÿ ]+")) break;
                        System.out.println("Endereço inválido! Use apenas letras e espaços.");
                    }

                    while (true) {
                        System.out.println("Número da casa: ");
                        String numCasaStr = sc.nextLine().trim();
                        if (numCasaStr.matches("\\d+")) {
                            numCasaC = Integer.parseInt(numCasaStr);
                            break;
                        }
                        System.out.println("Número inválido! Digite apenas NUMEROS.");
                    }

                    System.out.println("Complemento (opcional): ");
                    String complemC = sc.nextLine();

                    String senhaC;
                    while (true) {
                        System.out.println("Crie uma senha (mínimo 6 caracteres): ");
                        senhaC = sc.nextLine();
                        if (senhaC.length() >= 6) break;
                        System.out.println("Senha inválida! Deve ter pelo menos 6 caracteres.");
                    }

                    do {
                        System.out.println("Repita a senha: ");
                        confSenha = sc.nextLine();
                        if (!confSenha.equals(senhaC)) {
                            System.out.println("As senhas não conferem. Tente novamente!");
                        }
                    } while (!confSenha.equals(senhaC));

                    lista.add(new Cliente(nomeC, cpfC, emailC, senhaC, confSenha, cepC, enderecoC, numCasaC, dataNascC, complemC));
                    System.out.println("Usuário criado com sucesso!");
                    break;

                case 2:
                    if (lista.isEmpty()) {
                        System.out.println("Nenhum usuário cadastrado!");
                        break;
                    }

                    System.out.println("E-mail: ");
                    String emailLogin = sc.nextLine();

                    System.out.println("Senha: ");
                    String senhaLogin = sc.nextLine();

                    clienteLogado = null;
                    for (Cliente cliente : lista) {
                        if (cliente.getEmail().equals(emailLogin) && cliente.getSenha().equals(senhaLogin)) {
                            clienteLogado = cliente;
                            break;
                        }
                    }

                    if (clienteLogado == null) {
                        System.out.println("E-mail ou senha incorretos!");
                        break;
                    }

                    System.out.println("Login realizado com sucesso! Bem-vindo, " + clienteLogado.getNome());
                    logado = true;

                    while (logado) {
                        System.out.println("\n---MENU DO CLIENTE---");
                        System.out.println("1. Visualizar Perfil");
                        System.out.println("2. Alterar Dados");
                        System.out.println("3. Modo Vendedor");
                        System.out.println("4. Comprar");
                        System.out.println("5. Excluir Conta");

                        if (clienteLogado.isModoVendedor()) {
                            System.out.println("6. Visualizar meus itens");
                            System.out.println("7. Adicionar item");
                            System.out.println("8. Atualizar item");
                            System.out.println("9. Remover item");
                        }

                        System.out.println("0. Sair");
                        System.out.println("Escolha uma opção:");

                        int opLogin = 0;
                        try {
                            opLogin = sc.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida! Digite apenas números.");
                            sc.nextLine();
                            continue;
                        }
                        sc.nextLine();

                        if (!clienteLogado.isModoVendedor() && (opLogin >= 6 && opLogin <= 9)) {
                            System.out.println("Opção inválida, tente novamente!");
                            break;
                        }

                        switch(opLogin) {
                            case 1:
                                clienteLogado.visualizarPerfil();
                                break;

                            case 2:
                                clienteLogado.alterarDados(sc);
                                break;

                            case 3:
                                System.out.println("Modo Vendedor: ");
                                System.out.println("1. Ativar\n2. Desativar");
                                int opMV = 0;
                                try {
                                    opMV = sc.nextInt();
                                } catch (InputMismatchException e) {
                                    System.out.println("Entrada inválida! Digite apenas números.");
                                    sc.nextLine();
                                    break;
                                }
                                sc.nextLine();
                                if(opMV == 1) {
                                    clienteLogado.ativarModoVendedor(sc);
                                } else if(opMV == 2) {
                                    clienteLogado.desativarModoVendedor(sc);
                                } else {
                                    System.out.println("Opção inválida, tente novamente!");
                                }
                                break;

                            case 4:
                                ArrayList<Item> catalogoPublico = new ArrayList<>();
                                for (Cliente c : lista) {
                                    if (c.isModoVendedor()) {
                                        catalogoPublico.addAll(c.getMeusItens());
                                    }
                                }

                                if (catalogoPublico.isEmpty()) {
                                    System.out.println("Nenhum item disponível para compra!");
                                    break;
                                }

                                Carrinho carrinho = new Carrinho();
                                boolean comprando = true;

                                while (comprando) {
                                    System.out.println("\n--- CATÁLOGO DE ITENS ---");
                                    for (Item item : catalogoPublico) {
                                        item.exibirItens();
                                    }

                                    System.out.println("Digite o id do item que deseja comprar (ou '0' para finalizar): ");
                                    int idCompra = 0;
                                    try {
                                        idCompra = sc.nextInt();
                                    } catch (InputMismatchException e) {
                                        System.out.println("Entrada inválida! Digite apenas números.");
                                        sc.nextLine();
                                        continue;
                                    }

                                    if (idCompra == 0) {
                                        sc.nextLine();
                                        comprando = false;
                                        break;
                                    }

                                    Item itemEscolhido = null;
                                    for (Item item : catalogoPublico) {
                                        if (item.getId() == idCompra) {
                                            itemEscolhido = item;
                                            break;
                                        }
                                    }

                                    if (itemEscolhido == null) {
                                        System.out.println("Item não encontrado!");
                                        sc.nextLine();
                                        continue;
                                    }

                                    System.out.println("Quantidade desejada: ");
                                    int qtdCompra = 0;
                                    try {
                                        qtdCompra = sc.nextInt();
                                    } catch (InputMismatchException e) {
                                        System.out.println("Entrada inválida! Digite apenas números.");
                                        sc.nextLine();
                                        continue;
                                    }
                                    sc.nextLine();

                                    if (qtdCompra > itemEscolhido.getQuantItem()) {
                                        System.out.println("Quantidade indisponível em estoque!");
                                    } else {
                                        carrinho.adicionarItem(itemEscolhido, qtdCompra);
                                        itemEscolhido.setQuantItem(itemEscolhido.getQuantItem() - qtdCompra);
                                        System.out.println("Item adicionado ao carrinho!");
                                    }
                                }

                                if (carrinho.getItens().isEmpty()) {
                                    System.out.println("Carrinho vazio. Compra cancelada!");
                                    break;
                                }
                                System.out.println("\n--- SEU CARRINHO ---");
                                carrinho.visualizarCarrinho();

                                Frete frete = new Frete(clienteLogado.getCep());
                                double valorFrete = frete.calcularFrete();
                                System.out.println("Valor do frete: R$ " + valorFrete);

                                double total = carrinho.calcularTotal() + valorFrete;
                                System.out.println("Total da compra: R$ " + total);

                                System.out.println("\nEscolha a forma de pagamento:");
                                System.out.println("1. Pix");
                                System.out.println("2. Cartão");
                                int opPag = 0;
                                try {
                                    opPag = sc.nextInt();
                                } catch (InputMismatchException e) {
                                    System.out.println("Entrada inválida! Digite apenas números.");
                                    sc.nextLine();
                                    break;
                                }
                                sc.nextLine();

                                Pagamento pagamento;
                                if (opPag == 1) {
                                    pagamento = new Pix();
                                } else {
                                    System.out.println("Número do cartão: ");
                                    String numCartao = sc.nextLine();
                                    System.out.println("Nome do titular: ");
                                    String nomeTitular = sc.nextLine();
                                    System.out.println("CVV: ");
                                    int cvv = 0;
                                    try {
                                        cvv = sc.nextInt();
                                    } catch (InputMismatchException e) {
                                        System.out.println("Entrada inválida! Digite apenas números para o CVV.");
                                        sc.nextLine();
                                        break;
                                    }
                                    sc.nextLine();
                                    pagamento = new Cartao(numCartao, nomeTitular, cvv);
                                }

                                pagamento.processarPagamento(total);
                                System.out.println("Compra finalizada com sucesso!");
                                break;

                            case 5:
                                System.out.println("Deseja mesmo excluir sua conta? \n1.Sim \n2.Não");
                                int opExcluirConta = 0;
                                try {
                                    opExcluirConta = sc.nextInt();
                                } catch (InputMismatchException e) {
                                    System.out.println("Entrada inválida! Digite apenas números.");
                                    sc.nextLine();
                                    break;
                                }
                                sc.nextLine();

                                if(opExcluirConta == 1) {
                                    lista.remove(clienteLogado);
                                    System.out.println("Conta excluída!");
                                    clienteLogado = null;
                                    logado = false;
                                    break;
                                } else {
                                    System.out.println("Exclusão de conta cencelada!");
                                    break;
                                }

                            case 6:
                                if(clienteLogado.getMeusItens().isEmpty()) {
                                    System.out.println("Nenhum item adicionado!");
                                    break;
                                }
                                System.out.println("\n--- Meus Itens ---");
                                for(Item item : clienteLogado.getMeusItens()) {
                                    item.exibirItens();
                                }
                                break;

                            case 7:
                                System.out.println("Nome do item: ");
                                String nomeI = sc.nextLine();
                                System.out.println("Valor: ");
                                double valorI = 0;
                                try {
                                    valorI = sc.nextDouble();
                                } catch (InputMismatchException e) {
                                    System.out.println("Valor inválido! Digite um número.");
                                    sc.nextLine();
                                    break;
                                }
                                System.out.println("Quantidade: ");
                                int quantI = 0;
                                try {
                                    quantI = sc.nextInt();
                                } catch (InputMismatchException e) {
                                    System.out.println("Quantidade inválida! Digite um número.");
                                    sc.nextLine();
                                    break;
                                }
                                sc.nextLine();
                                System.out.println("Descrição: ");
                                String descricaoI = sc.nextLine();
                                String nomeVendI = clienteLogado.nome;
                                clienteLogado.getMeusItens().add(new Item(nomeI, valorI, quantI, descricaoI, nomeVendI));
                                System.out.println("Item criado com sucesso!");
                                break;

                            case 8:
                                if(clienteLogado.getMeusItens().isEmpty()) {
                                    System.out.println("Nenhum item adicionado!");
                                    break;
                                }

                                for(Item item : clienteLogado.getMeusItens()) {
                                    item.exibirItens();
                                }

                                System.out.println("Digite o ID do item que deseja atualizar:");
                                int idAtualizar = 0;
                                try {
                                    idAtualizar = sc.nextInt();
                                } catch (InputMismatchException e) {
                                    System.out.println("Entrada inválida! Digite apenas números.");
                                    sc.nextLine();
                                    break;
                                }
                                sc.nextLine();

                                for (Item item : clienteLogado.getMeusItens()) {
                                    if (item.getId() == idAtualizar) {
                                        item.atualizaritem(sc);
                                    }
                                }
                                break;

                            case 9:
                                if(clienteLogado.getMeusItens().isEmpty()) {
                                    System.out.println("Nenhum item adicionado!");
                                    break;
                                }

                                for(Item item : clienteLogado.getMeusItens()) {
                                    item.exibirItens();
                                }

                                Item i = null;
                                System.out.println("Digite o id do item que deseja excluir: ");
                                int idExcluir = 0;
                                try {
                                    idExcluir = sc.nextInt();
                                } catch (InputMismatchException e) {
                                    System.out.println("Entrada inválida! Digite apenas números.");
                                    sc.nextLine();
                                    break;
                                }
                                sc.nextLine();

                                for (Item item : clienteLogado.getMeusItens()) {
                                    if (item.getId() == idExcluir) {
                                        i = item;
                                        break;
                                    }
                                }
                                if (i != null) {
                                    clienteLogado.getMeusItens().remove(i);
                                    System.out.println("Item excluído com sucesso!");
                                } else {
                                    System.out.println("Item não encontrado.");
                                }
                                break;

                            case 0:
                                System.out.println("Volte sempre!");
                                clienteLogado = null;
                                logado = false;
                                break;

                            default:
                                System.out.println("Opção inválida, tente novamente!");
                                break;
                        }
                    }
                    break;

                case 0:
                    sc.close();
                    return;

                default:
                    System.out.println("Opção inválida, tente novamente!");
                    break;
            }
        }
    }
}
