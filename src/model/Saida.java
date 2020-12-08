package model;

import dao.SaidaDAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 * @author Ricardo Drudi
 */
public class Saida extends Kardex {
    
    private Cliente cliente;
    private static SimpleDateFormat dmy = new SimpleDateFormat("dd/MM/yy");
    
    public Saida(Date data, Produto produto, Cliente cliente, int qtde, double valor) {
        this(0,data,produto,cliente,qtde,valor);
    }
    public Saida(int codigo, Date data, Produto produto, Cliente cliente, int qtde, double valor) {
        super(codigo,data,produto,qtde,valor);
        setCliente(cliente);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int gravar() {
        return (new SaidaDAO().insert(this));
    }
    
    public static DefaultTableModel getTableModel() {
        DefaultTableModel tm = new DefaultTableModel();
        tm.addColumn("Código");
        tm.addColumn("Data");
        tm.addColumn("Produto");
        tm.addColumn("Cliente");
        tm.addColumn("Qtde");
        tm.addColumn("Valor");
        for (Saida i: new SaidaDAO().selectAll()) {
            String[] item = new String[] {String.valueOf(i.getCodigo()),
                                          dmy.format(i.getData()),
                                          i.getProduto().getDescricao(),
                                          i.getCliente().getNome(),
                                          String.valueOf(i.getQtde()),
                                          String.valueOf(i.getValor())};
            tm.addRow(item);
        }
        return tm;
    }
    
    @Override
    public String toString() {
        return "Saida{" + "codigo=" + getCodigo() + ", Data=" + getData() + ", Qtde=" + getQtde() + ", Valor=" + getValor() + " }";
    }
    
}
