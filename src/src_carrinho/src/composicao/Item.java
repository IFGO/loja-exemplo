package parte;

import java.util.Objects;

public class Item {
    private Produto p;
    private float Valor_Item;
    private int Qtde_Item;

    public Item(Produto p) {
        this.p = p;
    }

    public Produto getP() {
        return p;
    }

    public void setP(Produto p) {
        this.p = p;
    }

    public float getValor_Item() {
        return Valor_Item;
    }

    public void setValor_Item(float Valor_Item) {
        this.Valor_Item = Valor_Item;
    }

    public int getQtde_Item() {
        return Qtde_Item;
    }

    public void setQtde_Item(int Qtde_Item) {
        this.Qtde_Item = Qtde_Item;
    }

    @Override
    public String toString() {
        return "Item{" + "p=" + p + ", Valor_Item=" + Valor_Item + ", Qtde_Item=" + Qtde_Item + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (Float.floatToIntBits(this.Valor_Item) != Float.floatToIntBits(other.Valor_Item)) {
            return false;
        }
        if (!Objects.equals(this.p, other.p)) {
            return false;
        }
        return true;
    }
    
    
    
}
