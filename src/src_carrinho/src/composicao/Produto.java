package parte;

public class Produto {
    private float Valor_Produto;
    private int Qtde_Produto;

    public float getValor_Produto() {
        return Valor_Produto;
    }

    public void setValor_Produto(float Valor_Produto) {
        this.Valor_Produto = Valor_Produto;
    }

    public int getQtde_Produto() {
        return Qtde_Produto;
    }

    public void setQtde_Produto(int Qtde_Produto) {
        this.Qtde_Produto = Qtde_Produto;
    }

    @Override
    public String toString() {
        return "Produto{" + "Valor_Produto=" + Valor_Produto + ", Qtde_Produto=" + Qtde_Produto + '}';
    }
    
    
}
