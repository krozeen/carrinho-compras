package br.com.improving.carrinho;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Classe responsável pela criação e recuperação dos carrinhos de compras.
 */
public class CarrinhoComprasFactory {


    private Map<String, CarrinhoCompras> carrinhoDeCompras = new HashMap<>();

    /**
     * Cria e retorna um novo carrinho de compras para o cliente passado como parâmetro.
     *
     * Caso já exista um carrinho de compras para o cliente passado como parâmetro, este carrinho deverá ser retornado.
     *
     * @param identificacaoCliente
     * @return CarrinhoCompras
     */
    public CarrinhoCompras criar(String identificacaoCliente) {
        CarrinhoCompras carrinho = new CarrinhoCompras();

        if(!(carrinhoDeCompras.containsKey(identificacaoCliente))){
            carrinhoDeCompras.put(identificacaoCliente, carrinho);
        }else{
            carrinho = null;
        }
        return carrinho;
    }

    /**
     * Retorna o valor do ticket médio no momento da chamada ao método.
     * O valor do ticket médio é a soma do valor total de todos os carrinhos de compra dividido
     * pela quantidade de carrinhos de compra.
     * O valor retornado deverá ser arredondado com duas casas decimais, seguindo a regra:
     * 0-4 deve ser arredondado para baixo e 5-9 deve ser arredondado para cima.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorTicketMedio() {

        List<CarrinhoCompras> carrinhos = new ArrayList<>(this.carrinhoDeCompras.values());

        BigDecimal valorTicketMedio = (BigDecimal) valorTicket(carrinhos);
        return valorTicketMedio.setScale(2, RoundingMode.HALF_EVEN);
    }



    /**
     * Invalida um carrinho de compras quando o cliente faz um checkout ou sua sessão expirar.
     * Deve ser efetuada a remoção do carrinho do cliente passado como parâmetro da listagem de carrinhos de compras.
     *
     * @param identificacaoCliente
     * @return Retorna um boolean, tendo o valor true caso o cliente passado como parämetro tenha um carrinho de compras e
     * e false caso o cliente não possua um carrinho.
     */
    public boolean invalidar(String identificacaoCliente) {
        carrinhoDeCompras.remove(identificacaoCliente);
        return true;

    }

    private Object valorTicket(List<CarrinhoCompras> carrinhos) {
        carrinhos.stream()
                .forEach(s -> s.getValorTotal()
                        .plus()
                        .divide(new BigDecimal(carrinhos.size())));
        return carrinhos;
    }
}
