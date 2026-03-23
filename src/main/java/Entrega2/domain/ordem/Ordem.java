package Entrega2.domain.ordem;

public class Ordem {

    private final String investidor;
    private final TipoOrdem tipo;
    private final double valor;

    public Ordem(String investidor, TipoOrdem tipo, double valor) {
        this.investidor = investidor;
        this.tipo = tipo;
        this.valor = valor;
    }

    public boolean isCompra() {
        return tipo == TipoOrdem.COMPRA;
    }

    public boolean isVenda() {
        return tipo == TipoOrdem.VENDA;
    }

    public double getValor() {
        return valor;
    }
}