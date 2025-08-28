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
					String nome;
					while (true) {
					 System.out.println("Digite o seu nome (somente letras): ");
				        nome = sc.nextLine().trim();
				        if (nome.matches("[A-Za-zÀ-ÿ ]+")) {//SELEÇÃO DE SOMENTE LETRAS
				        		break;
				        	}else {
				        		System.out.println("Nome inválido!!!n USE SOMENTE LETRAS E ESPAÇOS!!!");
				        	}
				        }
				        String cpf;
				        while (true) {
				        System.out.println("Digite o seu CPF: ");
				        cpf = sc.nextLine().trim();
				        if(cpf.matches("\\d{11}")) break;//APENAS 11 DIGITOS DE NUMERO
				        System.out.println("CPF inválido! Digite novamente exatamente 11 NUMEROS...");
				        }
				        
				        String email;
				        while (true) {
				        System.out.println("Digite o seu email (deve conter @): ");//DA PARA ADICIONAR UM @GMAIL.COM SE QUISER
				        email = sc.nextLine().trim();
				        if (email.contains("@")|| email.length()<5) break;
				        	System.out.println("Email inválido!!!");
				        }
				        

				        System.out.println("Digite a sua senha: ");
				        String senha = sc.nextLine();

				        System.out.println("Digite a sua senha novamente: ");
				        String autenticarSenha = sc.nextLine();

				        while (!autenticarSenha.equals(senha)) {
				            System.out.println("As senhas não coincidem. Tente novamente.");
							System.out.println("\nConfirme sua senha: ");
				            autenticarSenha = sc.nextLine();
				        }
				        String dataNasc;
				        while (true) {
				        System.out.println("Digite sua data de nascimento: DD/MM/AAAA");
				        dataNasc = sc.nextLine().trim();
				        if (dataNasc.matches("\\d{2}/\\d{2}/\\d{4}"))break;
				        System.out.println("Formato inválido. Use DD/MM/AAAA");
				        }
				        

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
						System.out.println("5. Sair da conta");
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
							
							case 5:
								System.out.println("Voce saiu da sua conta. Até mais "+ clienteLogado.getNome()+"!");
								clienteLogado = null;
								break;
								
							default:
								System.out.println("Opção invalida");//adicionado case 5, para sair da conta se o cliente preferir 
						}
					}
					break;
					
				case 3:
					System.out.println("Você encerrou o Sistema. Até mais!!");
					sc.close();
					System.exit(0);//adicionado para encerrar o codigo, pois estava printando "voce saiu...."
					//sem mesmo estar logado. então é uma opção, quando nao logado, no menu cadastro, encerrar codigo.
					break;
					
				default:
					System.out.println("Está opção é inválida!");
					break;
			}
		}
	}
}
