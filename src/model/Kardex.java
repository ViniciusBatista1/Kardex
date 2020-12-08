package model;

import java.util.Date;

/**
 * @author Ricardo Drudi
 */
public abstract class Kardex {
    
    private int codigo = 0;
    private Date data;
    private int qtde = 0;
    private double valor = 0;
    private Produto produto;

    public Kardex(Date data, Produto produto, int qtde, double valor) {
        this(0,data,produto,qtde,valor);
    }
    public Kardex(int codigo, Date data, Produto produto, int qtde, double valor) {
        setCodigo(codigo);
        setData(data);
        setProduto(produto);
        setQtde(qtde);
        setValor(valor);
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return "Kardex{" + "codigo=" + codigo + ", data=" + data + ", qtde=" + qtde + ", valor=" + valor + '}';
    }
    
}
