package br.com.improving.carrinho;

import java.util.Objects;

/**
 * Classe que representa um produto que pode ser adicionado
 * como item ao carrinho de compras.
 *
 * Importante: Dois produtos são considerados iguais quando ambos possuem o
 * mesmo código.
 */
public class Produto {

    private Long codigo;
    private String descricao;

    /**
     * Construtor da classe Produto.
     *
     * @param codigo
     * @param descricao
     */
    public Produto(Long codigo, String descricao) {
    }

    /**
     * Retorna o código da produto.
     *
     * @return Long
     */
    public Long getCodigo() {
        return this.codigo;
    }

    /**
     * Retorna a descrição do produto.
     *
     * @return String
     */
    public String getDescricao() {
        return this.descricao;
    }

    @Override
    public String toString() {
        return "Produto [descricao=" + descricao + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;
        Produto produto = (Produto) o;
        return getCodigo().equals(produto.getCodigo()) &&
                getDescricao().equals(produto.getDescricao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigo(), getDescricao());
    }
}