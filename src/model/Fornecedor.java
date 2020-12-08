package model;

import dao.FornecedorDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * @author Ricardo Drudi
 */
public class Fornecedor {
    
    private int codigo = 0;
    private String cnpj;
    private String nome;
    private String telefone;
    private String email;

   public Fornecedor(String cnpj, String nome, String telefone, String email) {
        this(0,cnpj,nome,telefone,email);
    }
    
    /**
     *
     * @param codigo
     * @param cnpj
     * @param nome
     * @param telefone
     * @param email
     */
    public Fornecedor(int codigo, String cnpj, String nome, String telefone, String email) {
        setCodigo(codigo);
        setCnpj(cnpj);
        setNome(nome);
        setTelefone(telefone);
        setEmail(email);
    }
    
   
    
    public int gravar() {
        FornecedorDAO dao = new FornecedorDAO();
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Fornecedor{" + "codigo=" + codigo + ", nome=" + nome + '}';
    }

    public static List<Fornecedor> getLista() {
        return (new FornecedorDAO().selectAll());
    }
    
    public static DefaultTableModel getTableModel() {
        DefaultTableModel tm = new DefaultTableModel();
        tm.addColumn("Código");
        tm.addColumn("Nome");
        tm.addColumn("CNPJ");
        tm.addColumn("Telefone");
        tm.addColumn("Email");
        FornecedorDAO dao = new FornecedorDAO();
        for (Fornecedor c: dao.selectAll()) {
            String[] item = new String[] {String.valueOf(c.getCodigo()),c.getNome(),c.getCnpj(),c.getTelefone(),c.getEmail()};
            tm.addRow(item);
        }
        return tm;
    }    
}
