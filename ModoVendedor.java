package TrabalhoArtesanal;

import java.util.Scanner;

public class ModoVendedor {
	public String descricao;
	public String[] nichos = {"Crochê", "Tricô", "Costura", "Bijuteria", "Bordado", "Chinelo"};
	public String outro;
	private Cliente clienteDono;
	
	
	public ModoVendedor(String descricao, String[] nichos, String outro, Cliente clienteDono) {
		this.descricao = descricao;
		this.nichos = nichos;
		this.outro = outro;
		this.clienteDono = clienteDono;
	}
	
	public ModoVendedor(Cliente clienteDono) {
		this.clienteDono = clienteDono;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String[] getNichos() {
		return nichos;
	}

	public void setNichos(String[] nichos) {
		this.nichos = nichos;
	}

	public String getOutro() {
		return outro;
	}

	public void setOutro(String outro) {
		this.outro = outro;
	}
	
	public void excluirVendedor() {
		
	}
	
	public void atualizarDadosItens() {							//nome para diferenciar do menu logado
		System.out.println("\n=== Atualizar dados ===");
		
	}
	
	public void adicionarItem(Scanner sc) {
		System.out.println("\n=== Adicionar Item ===");
		
		System.out.println("Nome do item: ");
		String nomeItem = sc.nextLine();
		
		System.out.println("Escolha o nicho: ");
		for (int i = 0; i < nichos.length; i++) {
			System.out.println((i + 1) + ". " + nichos[i]);
		}
		
		System.out.println("Número do nicho (ou digite um número inválido para adicionar outro): ");
		int escolhaNicho = sc.nextInt();
		sc.nextLine();
		
		String nichoSelecionado;
		
		if (escolhaNicho >= 1 && escolhaNicho <= nichos.length) {
			nichoSelecionado = nichos[escolhaNicho - 1];
		} else {
			System.out.println("Digite o nome do seu nicho personalizado: ");
			this.outro = sc.nextLine();
			nichoSelecionado = this.outro;
		}
		
		System.out.println("Descrição do item: ");
		String descricao = sc.nextLine();
		
		System.out.println("Quantidade disponível: ");
		int quantidade = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Valor (R$): ");
		double valor = sc.nextDouble();
		sc.nextLine();
		
		System.out.println("\nItem cadastrado com sucesso!");
		System.out.println("Item: " + nomeItem);
		System.out.println("Nicho: " + nichoSelecionado);
		System.out.println("Descrição: " + descricao);
		System.out.println("Quantidade: " + quantidade);
		System.out.println("Valor: R$" + valor);
	}
}
