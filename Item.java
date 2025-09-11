package catalogoArtesanal;

import java.util.Scanner;

public class Item {
    private static int contador = 1;
    private int id;
	public String nomeItem;
	public double valorItem;
	public int quantItem;
	public String descricaoItem;
	public String vendedor;
	
	public Item (String nomeItem, double valorItem, int quantItem, String descricaoItem, String vendedor) {
		this.id = contador++;
		this.nomeItem = nomeItem;
		this.valorItem = valorItem;
		this.quantItem = quantItem;
		this.descricaoItem = descricaoItem;
		this.vendedor = vendedor;	
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNomeItem() {
		return nomeItem;
	}

	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}

	public double getValorItem() {
		return valorItem;
	}

	public void setValorItem(double valorItem) {
		this.valorItem = valorItem;
	}

	public int getQuantItem() {
		return quantItem;
	}

	public void setQuantItem(int quantItem) {
		this.quantItem = quantItem;
	}

	public String getDescricaoItem() {
		return descricaoItem;
	}

	public void setDescricaoItem(String descricao) {
		this.descricaoItem = descricao;
	}
	
	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}
	
	
	// --- MÉTODOS ---
	
	public void exibirItens() {
		System.out.println("Id: "+ id);
		System.out.println("Nome: "+ nomeItem);
		System.out.println("Valor: R$"+ valorItem);
		System.out.println("Quantidade: "+ quantItem);
		System.out.println("Descrição: "+ descricaoItem +"\n");
	}
	
	public void atualizaritem(Scanner sc) {
		System.out.println("\n---DIGITE O QUE DESEJA ALTERAR:---");
		System.out.println("1. Alterar Nome");
		System.out.println("2. Alterar Valor");
		System.out.println("3. Alterar Quantidade");
		System.out.println("4. Alterar Descrição");
		System.out.println("Escolha uma opção:");
		int opAlterar= sc.nextInt();
		sc.nextLine();
		
		switch(opAlterar) {
			case 1: 
				System.out.println("Novo nome: ");
				this.nomeItem = sc.nextLine();
				break;
			case 2:
				System.out.println("Novo valor: ");
				this.valorItem = sc.nextDouble();
				break;
			case 3:
				System.out.println("Quantidade: ");
				this.quantItem = sc.nextInt();
				break;
			case 4:
				System.out.println("Nova descrição: ");
				this.descricaoItem = sc.nextLine();
			default:
				System.out.println("Essa opção não existe, tente novamente!");
				break;
		}
	}
}	
