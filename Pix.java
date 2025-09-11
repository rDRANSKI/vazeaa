package catalogoArtesanal;

public class Pix extends Pagamento {
    private String chavePix;

    public Pix() {
        this.chavePix = "alecrimDourado";
    }

    @Override
    public void processarPagamento(double valor) {
    	System.out.println("Chave PIX: " + chavePix + "\n");
        System.out.println("Pagamento via PIX realizado!");
        System.out.println("Valor pago: R$ " + valor + "\n");
    }
} 
