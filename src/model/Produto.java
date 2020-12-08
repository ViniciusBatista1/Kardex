package model;


import dao.ProdutoDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * @author Ricardo Drudi
 */
public class Produto {
    
    private int codigo = 0;
    private String descricao;
    private int qtde = 0;
    private double custoMedio = 0;

    public Produto(String descricao, int qtde, double custoMedio) {
        this(0,descricao,qtde,custoMedio);
    }
    public Produto(int codigo, String descricao, int qtde, double custoMedio) {
        setCodigo(codigo);
        setDescricao(descricao);
        setQtde(qtde);
        setCustoMedio(custoMedio);
    }
        public int gravar() {
        ProdutoDAO dao = new ProdutoDAO();
        int id = dao.insert(this);
        setCodigo(id);
        return (id);
     }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public double getCustoMedio() {
        return custoMedio;
    }

    public void setCustoMedio(double custoMedio) {
        this.custoMedio = custoMedio;
    }
    
    public static List<Produto> getLista() {
        return (new ProdutoDAO().selectAll());
    }

    public static DefaultTableModel getTableModel() {
        DefaultTableModel tm = new DefaultTableModel();
        tm.addColumn("Código");
        tm.addColumn("Descricao");
        tm.addColumn("Qtde");
        tm.addColumn("Custo Medio");
        ProdutoDAO dao = new ProdutoDAO();
        for (Produto c: dao.selectAll()) {
            String[] item = new String[] {String.valueOf(c.getCodigo()),c.getDescricao(),
            String.valueOf(c.getQtde()), 
            String.valueOf(c.getCustoMedio())};
            tm.addRow(item);
        }
        return tm;
    }
    
    
    @Override
    public String toString() {
        return "Produto{" + "codigo=" + codigo + ", descricao=" + descricao + ", qtde=" + qtde + '}';
    }
       

}
