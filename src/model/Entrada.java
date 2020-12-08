package model;

import java.util.Date;
import dao.EntradaDAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 * @author vinni
 */
public class Entrada extends Kardex {

    private Fornecedor fornecedor;
    private static SimpleDateFormat dmy = new SimpleDateFormat("dd/MM/yy");
    
    public Entrada(Date data, Produto produto, Fornecedor fornecedor, int qtde, double valor) {
       this(0,data,produto,fornecedor,qtde,valor);
    }

    public Entrada(int codigo, Date data, Produto produto, Fornecedor fornecedor, int qtde, double valor) {
        super(codigo,data,produto,qtde,valor);
        setFornecedor(fornecedor);
    }
    
     public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    public int gravar() {
        return (new EntradaDAO().insert(this));
    }
    
    public static DefaultTableModel getTableModel() {
        DefaultTableModel tm = new DefaultTableModel();
        tm.addColumn("Código");
        tm.addColumn("Data");
        tm.addColumn("Produto");
        tm.addColumn("Fornecedor");
        tm.addColumn("Qtde");
        tm.addColumn("Valor");
        for (Entrada i: new EntradaDAO().selectAll()) {
            String[] item = new String[] {String.valueOf(i.getCodigo()),
                                          dmy.format(i.getData()),
                                          i.getProduto().getDescricao(),
                                          i.getFornecedor().getNome(),
                                          String.valueOf(i.getQtde()),
                                          String.valueOf(i.getValor())};
            tm.addRow(item);
        }
        return tm;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Entrada{" + "codigo=" + getCodigo() + ", Data=" + getData() + ", Qtde=" + getQtde() + ", Valor=" + getValor() + " }";
    }
    
    
}
