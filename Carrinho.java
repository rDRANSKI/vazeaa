package catalogoArtesanal;

import java.util.ArrayList;

public class Carrinho {
    private ArrayList<Item> itens;

    public Carrinho() {
        this.itens = new ArrayList<>();
    }

    // --- MÉTODOS ---
 
    public void adicionarItem(Item item, int qtd) {
        Item itemCarrinho = new Item(
            item.getNomeItem(),
            item.getValorItem(),
            qtd,
            item.getDescricaoItem(),
            item.getVendedor()
        );
        itens.add(itemCarrinho);
    }

    public void removerItem(String nomeItem) {
        itens.removeIf(i -> i.getNomeItem().equalsIgnoreCase(nomeItem));
    }

    public void visualizarCarrinho() {
        if (itens.isEmpty()) {
            System.out.println("Carrinho está vazio!");
            return;
        }
        for (Item item : itens) {
            item.exibirItens();
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.getQuantItem() * item.getValorItem();
        }
        return total;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }
}
