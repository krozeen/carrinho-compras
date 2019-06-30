package br.com.improving.carrinho;

import java.math.BigDecimal;

/**
 * Classe que representa um item no carrinho de compras.
 */
public class Item {

    private Produto produto;
    private BigDecimal valorUnitario;
    private BigDecimal valor;
    private int quantidade;

    /**
     * Construtor da classe Item.
     *
     * @param produto
     * @param valorUnitario
     * @param quantidade
     */
    public Item(Produto produto, BigDecimal valorUnitario, int quantidade) {
    }

    /**
     * Retorna o produto.
     *
     * @return Produto
     */
    public Produto getProduto() {
        return this.produto;
    }

    /**
     * Retorna o valor unitário do item.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorUnitario() {
        return this.valorUnitario;
    }

    /**
     * Retorna a quantidade dos item.
     *
     * @return int
     */
    public int getQuantidade() {
        return this.quantidade;
    }

    /**
     * Retorna o valor total do item.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorTotal() {
        BigDecimal bd = new BigDecimal(quantidade);
        return this.valorUnitario.multiply(bd);
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Item [Produto=" + produto + ", Valor Unitario=" + valorUnitario + ", Valor=" + valor + ", Quantidade=" + quantidade + "]";
    }
}
