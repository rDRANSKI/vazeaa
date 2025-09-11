package catalogoArtesanal;
import java.util.*;

public class ModoVendedor {
	public String descricao;
	
	public ModoVendedor(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	// --- MÉTODOS ---
	
	public void alterarDescricao(Scanner sc) {
		System.out.println("Nova descrição: ");
		this.descricao = sc.nextLine();
	}
}
