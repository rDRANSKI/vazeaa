package TrabalhoArtesanal;

import java.util.Scanner;

public class Cliente {
	public String nome;
	private String cpf;
	private String email;
	private String senha;
	private String autenticarSenha;
	public String cep;
	public String endereco;
	public int numCasa;
	private String dataNasc;
	private String complemento;
	private ModoVendedor modoVendedor;
	
	public Cliente(String nome, String cpf, String email, String senha, String autenticarSenha, String cep,
			String endereco, int numCasa, String dataNasc, String complemento) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.autenticarSenha = autenticarSenha;
		this.cep = cep;
		this.endereco = endereco;
		this.numCasa = numCasa;
		this.dataNasc = dataNasc;
		this.complemento = complemento;
		this.modoVendedor = new ModoVendedor(this);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getAutenticarSenha() {
		return autenticarSenha;
	}

	public void setAutenticarSenha(String autenticarSenha) {
		this.autenticarSenha = autenticarSenha;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getNumCasa() {
		return numCasa;
	}

	public void setNumCasa(int numCasa) {
		this.numCasa = numCasa;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public ModoVendedor getModoVendedor() {
		return modoVendedor;
	}
	
	public String cadastrar() {
        return "Seu cadastro foi realizado: " + this.nome;
    }
	
	public void atualizarDados(Scanner sc) {				// Troquei de STRING para VOID.
		
		int opcaoAtualizarDados = -1;
		
		while (opcaoAtualizarDados != 0) {
			System.out.println("\n=== ATUALIZAR DADOS ===");
			System.out.println("1. Alterar email");
			System.out.println("2. Alterar senha");
			System.out.println("3. Alterar endereço");
			System.out.println("4. Alterar CEP");
			System.out.println("5. Alterar número da casa");
			System.out.println("6. Alterar complemento");
			System.out.println("0. Voltar");
			
			opcaoAtualizarDados = sc.nextInt();
			sc.nextLine();
			
			switch (opcaoAtualizarDados) {
				case 1:
					System.out.println("Digite o seu novo email: ");
					String novoEmail = sc.nextLine();
					
					if (novoEmail.equals(this.email)) {
						System.out.println("O email digitado é igual ao seu email atual. Por favor, insira um email diferente.");
					} else {
						this.email = novoEmail;
						System.out.println("Email atualizado com sucesso para: " + novoEmail);
					}
					break;
					
				case 2:
					System.out.println("Digite sua nova senha: ");
					String novaSenha = sc.nextLine();
					
					if (novaSenha.equals(this.senha)) {
						System.out.println("A senha digitada é igual a anterior. Por favor, insira uma senha diferente.");
					} else {
						this.senha = novaSenha;
						System.out.println("Senha atualizado com sucesso!");
					}
					break;
					
				case 3:
					System.out.println("Digite seu novo endereço: ");
					String novoEndereco = sc.nextLine();
					
					this.endereco = novoEndereco;
					System.out.println("Endereço atualizado com sucesso!");
					break;
					
				case 4: 
					System.out.println("Digite o seu novo CEP: ");
					String novoCEP = sc.nextLine();
					
					this.cep = novoCEP;
					System.out.println("CEP atualizado com sucesso!");
					break;
					
				case 5:
					System.out.println("Digite o novo número da casa: ");
					int novoNumCasa = sc.nextInt();
					
					this.numCasa = novoNumCasa;
					System.out.println("Número da casa atualizado com sucesso!");
					break;
					
				case 6:
					System.out.println("Digite o novo complemento: ");
					String novoComplemento = sc.nextLine();
					
					this.complemento = novoComplemento;
					System.out.println("Complemento atualizado com sucesso!");
					break;
					
				case 0:
					break;
					
				default:
					System.out.println("Está opçõa é inválida");
					break;
			}
		}
	}
	
	public void visualizarPerfil() {				
		System.out.println("=== PERFIL DO CLIENTE ===");
		System.out.println("Nome: " + this.nome);
		System.out.println("Email: " + this.email);
		System.out.println("Endereço: " + this.endereco);
		System.out.println("CEP: " + this.cep);
		System.out.println("Número da Casa: " + this.numCasa);
		System.out.println("Complemento: " + this.complemento);
	}
	
	public String excluir(Scanner sc) {
		System.out.println("Tem certeza que deseja excluir sua conta? [S/N]");
		String excluirConta = sc.nextLine();
		
		if (excluirConta.equalsIgnoreCase("s")) {
			System.out.println("Conta exclúida com sucesso.");
			return "sim"; //posso remover
		} else {
			System.out.println("Exclusão cancelada.");
			return "nao"; //não remover
		}
	}
	
	public void entrarModoVendedor(Scanner sc) {
		
	}
}
