package model;

import dao.ClienteDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * @author Ricardo Drudi
 */
public class Cliente {
    
    private int codigo = 0;
    private String cpf;
    private String nome;
    private String celular;
    private String email;

    public Cliente(String cpf, String nome, String celular, String email) {
        this(0,cpf,nome,celular,email);
    }
    public Cliente(int codigo, String cpf, String nome, String celular, String email) {
        setCodigo(codigo);
        setCpf(cpf);
        setNome(nome);
        setCelular(celular);
        setEmail(email);
    }
    
    public int gravar() {
        ClienteDAO dao = new ClienteDAO();
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static List<Cliente> getLista() {
        return (new ClienteDAO().selectAll());
    }
    
    public static DefaultTableModel getTableModel() {
        DefaultTableModel tm = new DefaultTableModel();
        tm.addColumn("Código");
        tm.addColumn("Nome");
        tm.addColumn("CPF");
        tm.addColumn("Celular");
        tm.addColumn("Email");
        ClienteDAO dao = new ClienteDAO();
        for (Cliente c: dao.selectAll()) {
            String[] item = new String[] {String.valueOf(c.getCodigo()),c.getNome(),c.getCpf(),c.getCelular(),c.getEmail()};
            tm.addRow(item);
        }
        return tm;
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "codigo=" + codigo + ", nome=" + nome + '}';
    }

}
