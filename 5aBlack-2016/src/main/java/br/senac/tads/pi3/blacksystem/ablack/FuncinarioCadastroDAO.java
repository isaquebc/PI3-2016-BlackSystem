package br.senac.tads.pi3.blacksystem.ablack;

import br.senac.tads.pi3.blacksystem.entity.Filial;
import br.senac.tads.pi3.blacksystem.entity.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Rafael
 */
public class FuncinarioCadastroDAO extends Conexao {

String QUERY_INSERT_FUNCIORARIO = "insert into FUNCIONARIO(CPF_FUNC, NOME_FUNC,SOBRENOME_FUNC, SEXO_FUNC, NASC_FUNC,TEL_FUNC,"
+ " CEL_FUNC, EMAIL_FUNC, STATUS_FUNC, SENHA_FUNC, CARGO_FUNC, SALARIO_FUNC, ID_FILIAL)"+"values(?,?,?,?,?,?,?,?,?,?,?, ?, ?)";

    public void cadastrarFuncionario(Funcionario func)
            throws ClassNotFoundException {

        String testeSenha="";
        Connection conn = null;
        PreparedStatement stm = null;
        
        try {
            testeSenha= func.getSenha();
            conn = getConexao();
            String sql= QUERY_INSERT_FUNCIORARIO;
            stm = conn.prepareStatement(sql);
            stm.setString(1, func.getCpf());
            stm.setString(2, func.getNome());
            stm.setString(3, func.getSobrenome());
            stm.setString(4, func.getSexo());
            stm.setDate(5, new java.sql.Date(1009 - 03 - 03));
            stm.setString(6, func.getTelefone());
            stm.setString(7, func.getCelular());
            stm.setString(8, func.getEmail());
            stm.setString(9, "ATIVO");
            stm.setString(10, func.getSenha());
            stm.setString(11, func.getCargo());
            stm.setDouble(12, func.getSalario());
            stm.setInt(13, func.getFilial());
            
            stm.executeUpdate();
            stm.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (NullPointerException e) {
            System.out.println("Dao não inicializado");
        }

    }
    
    public int buscarFilial(String filial)
            throws ClassNotFoundException {

        String query="SELECT ID_FILIAL FROM FILIAL WHERE CIDADE_FILIAL = '"+ filial.toUpperCase() +"'";
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            
            conn = getConexao();
            stm = conn.createStatement();
            rs  = stm.executeQuery(query);
            int id = 0;
            if (rs.next()) {
                id = rs.getInt("ID_FILIAL");
            }
        
            stm.close();
            conn.close();
            rs.close();
            return id;
        } catch (SQLException e) {
            System.err.println(e.toString() + " " + filial);
        } catch (NullPointerException e) {
            System.out.println("Dao não inicializado");
        }
        return 0;
    }
    
    
    

}
