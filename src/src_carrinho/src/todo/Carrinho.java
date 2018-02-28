package todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import parte.Item;

public class Carrinho {
    private Item item;
    private List<Item> carrinho = new ArrayList();

    public List<Item> addCarrinho(Item item) {
        if(!carrinho.contains(item)){
            System.out.println("O produto possui desconto?");
            System.out.println("1 - Sim");
            System.out.println("2 - Nãõ");
            Scanner input = new Scanner(System.in);
            int da_desconto = input.nextInt();
            if(da_desconto == 1){
                aplicarDesconto(item);
            }else {
                System.out.println("Informe a quantidade do produto:");
                int qtd_produto, qtd_item;
                qtd_item = input.nextInt();
                input.close();
                qtd_produto = item.getP().getQtde_Produto();
                
                if(qtd_produto >= qtd_item){
                    aplicarQtdeItem(item, qtd_item);
                }else{
                    System.out.println("Não foi possivel aplicar o item ao carrio\n"
                            + "quantidade não disponível no estoque.");
                }
            }
        }else{
            System.out.println("Item já cadatrado ao carrinho de compras.");
        }
        return carrinho;
    }

    public void delCarrinho(Item item) {
        if(carrinho.contains(item)){
          boolean remove = carrinho.remove(item);
          System.out.println(remove);
        }
    }

    private void aplicarDesconto(Item item) {
        
        float preco_produto = item.getP().getValor_Produto();
        
        System.out.println("Quantos porcento de desconto para o item?");
        Scanner input = new Scanner(System.in);
        float resposta = input.nextFloat();
        
        float desconto = resposta/100 * preco_produto;
        
        float valor_item = preco_produto - desconto;
        
        item.setValor_Item(valor_item);
        
    }


    private void aplicarQtdeItem(Item item, int qtd_item) {
        int qtd_produto = item.getP().getQtde_Produto();
        item.getP().setQtde_Produto(qtd_produto - qtd_item);
        item.setQtde_Item(qtd_item);
    }
   
    
}
