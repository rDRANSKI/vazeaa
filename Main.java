package TrabalhoArtesanal;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Cliente> clientesCadastrados = new ArrayList<>();
		
		Cliente clienteLogado = null; //Aqui está para podee utilizar para visual perfil.
		
		while (clienteLogado == null) {
			System.out.println("\n=== MENU CADASTRO ===");
			System.out.println("1. Cadastrar");
			System.out.println("2. Login");
			System.out.println("3. Sair");
			System.out.println("Escolha uma opção: ");
			
			int opcaoCadastro = sc.nextInt();
			sc.nextLine();
			
			switch (opcaoCadastro) {
				case 1:
					 System.out.println("Digite o seu nome: ");
				        String nome = sc.nextLine();

				        System.out.println("Digite o seu CPF: ");
				        String cpf = sc.nextLine();

				        System.out.println("Digite o seu email: ");
				        String email = sc.nextLine();

				        System.out.println("Digite a sua senha: ");
				        String senha = sc.nextLine();

				        System.out.println("Digite a sua senha novamente: ");
				        String autenticarSenha = sc.nextLine();

				        while (!autenticarSenha.equals(senha)) {
				            System.out.println("As senhas não coincidem. Tente novamente.");
							System.out.println("\nConfirme sua senha: ");
				            autenticarSenha = sc.nextLine();
				        }

				        System.out.println("Digite sua data de nascimento: DD/MM/AAAA");
				        String dataNasc = sc.nextLine();

				        System.out.println("Digite o seu CEP: ");
				        String cep = sc.nextLine();

				        System.out.println("Digite o seu endereço: ");
				        String endereco = sc.nextLine();

				        System.out.println("Digite o número da casa: ");
				        int numCasa = sc.nextInt();
				        sc.nextLine();

				        System.out.println("Complemento: ");
				        String complemento = sc.nextLine();
				        
				        Cliente novoCliente = new Cliente(nome, cpf, email, senha, autenticarSenha, cep,
				    	endereco, numCasa, dataNasc, complemento);
				        clientesCadastrados.add(novoCliente);
				        
				        System.out.println(novoCliente.cadastrar());
				        break;
				        
				case 2:
					while (clienteLogado == null) {
						System.out.println("Email: ");
						String emailLogin = sc.nextLine();
						
						System.out.println("Senha: ");
						String senhaLogin = sc.nextLine();
						
						for (Cliente clienteAtual : clientesCadastrados) {
							if (clienteAtual.getEmail().equals(emailLogin) && clienteAtual.getSenha().equals(senhaLogin)) {
								System.out.println("Login realizado com sucesso! Seja bem-vindo" + clienteAtual.getNome());
								clienteLogado = clienteAtual; //Armazena o clienteAtual como clienteLogado
								break;
							}
						}
						if (clienteLogado == null) {
							System.out.println("Email ou senha inválidos!");
						}
					}
							
					while (clienteLogado != null) {
						System.out.println("\n=== MENU LOGADO ===");
						System.out.println("1. Visualizar Perfil");
						System.out.println("2. Atualizar Dados");
						System.out.println("3. Modo Vendedor");
						System.out.println("4. Excluir conta");
						System.out.println("Escolha uma opção: ");
						
						int opcaoLogin = sc.nextInt();
						sc.nextLine();
						
						switch (opcaoLogin) {
							case 1:
								clienteLogado.visualizarPerfil();
								break;
								
							case 2:
								clienteLogado.atualizarDados(sc); //sc para chamar o que usario digitou dentro do metodo na Classe Cliente.
								break;
								
							case 3:
								System.out.println("Você está no modo vendedor.");
								while (true) {
									System.out.println("\n=== MENU VENDEDOR ===");
									System.out.println("1. Adicionar item");
									System.out.println("2. Atualizar dados");
									System.out.println("3. Voltar para o menu cliente");
									System.out.println("Escolha uma opção: ");
									
									int opcaoVendedor = sc.nextInt();
									sc.nextLine();
									
									switch (opcaoVendedor) {
										case 1:
											clienteLogado.getModoVendedor().adicionarItem(sc);
											break;
										case 2:
											clienteLogado.atualizarDados(sc);
											break;
										case 3:
											System.out.println("Saindo do modo vendedor...");
											break;
										default:
											System.out.println("Opção inválida.");
									}
									
									if (opcaoVendedor == 3) {
										break;
									}
								}
								break;
								
							case 4:
								String excluirConta = clienteLogado.excluir(sc);
								
								if (excluirConta.equals("sim")) {
									clientesCadastrados.remove(clienteLogado);
									clienteLogado = null;
								}
								break;
						}
					}
					break;//faltava esse brake aqui se nao poderia pular direto para o case 3
					
				case 3:
					System.out.println("Você saiu do Sistema. Até mais!!");
					clienteLogado = null; //Não mostrar o MENU.
					break;
					
				default:
					System.out.println("Está opção é inválida!");
					break;
			}
		}
	}
}
