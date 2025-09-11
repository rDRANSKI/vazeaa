package catalogoArtesanal;
import java.util.ArrayList;
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
	private String complem;
	private ModoVendedor vendedor;
	
	 private ArrayList<Item> meusItens = new ArrayList<>();
	 private String descricaoVendedor;
	
	public Cliente(String nome, String cpf, String email, String senha, String autenticarSenha, String cep, String endereco, int numCasa, String dataNasc, String complem) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.autenticarSenha = autenticarSenha;
		this.cep = cep;
		this.endereco = endereco;
		this.numCasa = numCasa;
		this.dataNasc = dataNasc;
		this.complem = complem;
		this.vendedor = null; 
	}
	
	public ArrayList<Item> getMeusItens() {
	    return meusItens;
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

	public String getComplem() {
		return complem;
	}

	public void setComplem(String complem) {
		this.complem = complem;
	}
	
	
	// --- MÉTODOS ---
	
	public boolean isModoVendedor() {
	    return vendedor != null;
	}
	
	
	//VISUALIZAR PERFIL
	public void visualizarPerfil() {
		System.out.println("\n--- PERFIL ---");
		System.out.println("Nome: " + nome);
		System.out.println("E-mail: " + email);
		System.out.println("CPF: " + cpf);
		System.out.println("Data de nascimento: " + (dataNasc != null ? email : "Não informado"));
		System.out.println("CEP: " + cep);
		System.out.println("Endereço: " + endereco + ", " + numCasa);
		System.out.println("Complemento: " + (complem != null ? complem : "Não informado"));
	    if (isModoVendedor()) {
	        System.out.println("Modo vendedor: Ativado");
	        System.out.println("Descrição: " + vendedor.getDescricao());
	    } else {
	        System.out.println("Modo vendedor: Desativado");
	    }
	}
		

	//ALTERAR DADOS
	public void alterarDados(Scanner sc) {
		try {
			System.out.println("\n---DIGITE A OPÇÃO QUE DESEJA ALTERAR:---");
			System.out.println("1. Alterar Nome");
			System.out.println("2. Alterar Email");
			System.out.println("3. Alterar Data de Nascimento");
			System.out.println("4. Alterar Endereço");
			System.out.println("5. Alterar Senha");
			if (isModoVendedor()) {
				System.out.println("6. Alterar Descrição: ");
			}
			System.out.println("Escolha uma opção:");
			int opAlterar= sc.nextInt();
			sc.nextLine();
			
			if (!isModoVendedor() && (opAlterar == 6)) {
			    System.out.println("Opção inválida, tente novamente!");
			    return; 
			}
			
			switch(opAlterar) {
			case 1: 
				System.out.println("\nNovo nome: ");
				this.nome = sc.nextLine();
				System.out.println("Nome alterado com sucesso!");
				break;
			
			case 2:
				System.out.println("Novo email: ");
				this.email = sc.nextLine();
				System.out.println("Email alterado com sucesso!");
				break;
			
			case 3:
				System.out.println("Nova data de nascimento(DD/MM/AAAA): ");
				this.dataNasc = sc.nextLine();
				System.out.println("Data alterada com sucesso!");
				break;
				
			case 4:
				System.out.println("Novo CEP: ");
				this.cep = sc.nextLine(); 
				
				System.out.println("Novo endereço: ");
				this.endereco = sc.nextLine();							
				
				System.out.println("Número da casa: ");
				this.numCasa = sc.nextInt();
				sc.nextLine();
				
				System.out.println("Complemento: ");
				this.complem = sc.nextLine();
				break;
			case 5: 
				System.out.println("Crie uma nova senha: ");
				String novaSenha = sc.nextLine();
				
				String confNovaSenha;
				do {
					System.out.println("Repita a senha: ");
					confNovaSenha = sc.nextLine();
					if(!confNovaSenha.equals(novaSenha)) {
						System.out.println("As senhas não conferem. Tente novamente!");
					}
				} while(!confNovaSenha.equals(novaSenha));
				
				if(novaSenha.equals(confNovaSenha)) {
					this.senha = novaSenha;
				}
				break;
				
			case 6:
				vendedor.alterarDescricao(sc);
			default:
				System.out.println("Essa opção não existe, tente novamente!");
				break;
			}
		} catch (Exception e) {
	        System.out.println("Erro de entrada: digite um valor válido. " + e.getMessage());
	        sc.nextLine(); 
	    }
	}
	
	
	// MODO VENDEDOR 
	public void ativarModoVendedor(Scanner sc) {
        if (vendedor == null) {
        	if(descricaoVendedor == null || descricaoVendedor.trim().isEmpty()) {
	        	System.out.println("Crie uma descrição da sua página: ");
				descricaoVendedor = sc.nextLine();
				if (descricaoVendedor == null || descricaoVendedor.trim().isEmpty()) {
		            System.out.println("Descrição inválida. Tente novamente!");
		            return;
		        }
        	}
            vendedor = new ModoVendedor(descricaoVendedor);
            System.out.println("Modo vendedor ativado!");
        } else {
            System.out.println("Você já está no modo vendedor.");
        }
    }

    public void desativarModoVendedor(Scanner sc) {
        if (vendedor != null) {
        	System.out.println("Certeza que quer sair do Modo Vendedor? (S/N)");
        	String sairMV = sc.nextLine();
        	if(sairMV.equalsIgnoreCase("S")) {
        		vendedor = null;
        		System.out.println("Modo vendedor desativado.");
        	} else if (sairMV.equalsIgnoreCase("N")){
        		System.out.println("Desativação cancelada!");
        	} else {
                System.out.println("Resposta inválida. Digite apenas S ou N.");
            }
        } else {
            System.out.println("Você não está no modo vendedor.");
        }
    }

    public ModoVendedor getVendedor() {
        return vendedor;
    }
}
	
	
