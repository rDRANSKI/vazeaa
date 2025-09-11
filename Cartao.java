package catalogoArtesanal;

public class Cartao extends Pagamento {
    private String numeroCartao;
    private String nomeTitular;
    private int cvv;

    public Cartao(String numeroCartao, String nomeTitular, int cvv) {
        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
        this.cvv = cvv;
    }

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Pagamento via Cartão realizado!");
        System.out.println("Titular: " + nomeTitular);
        System.out.println("Número do cartão: **** **** **** ");
        System.out.println("Valor pago: R$ " + valor);
    }
}
