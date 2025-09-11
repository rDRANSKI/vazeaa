package catalogoArtesanal;

public class Frete {
    private String cepDestino;

    public Frete(String cepDestino) {
        this.cepDestino = cepDestino;
    }

    public double calcularFrete() {
        if (cepDestino.startsWith("0") || cepDestino.startsWith("1") || cepDestino.startsWith("9")) {
            return 20.0;
        } else if (cepDestino.startsWith("8")) { 
            return 15.0;
        }
        return 25.0;
    }
}
