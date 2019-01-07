/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tabelas.Bank;

/**
 *
 * @author ferna
 */
public class BankDAO {

    private final Connection c;
    public static List<Bank> al_bank;
    private PreparedStatement stmt;
    private ResultSet rs;

    public BankDAO() {
        this.c = conn.ConexaoMySQL.conexao;
    }

    private List<Bank> getBankMulti(int id) {
        try {

            al_bank = new ArrayList<Bank>();

            stmt = c.prepareStatement("SELECT * FROM personal_finances.bank "
                    + "WHERE id like ? ORDER BY title, id;");
            if (id > 0) {
                stmt.setString(1, id + "");
            } else {
                stmt.setString(1, "%");
            }
            rs = stmt.executeQuery();
            while (rs.next()) {
                Bank b = new Bank();
                b.setId(rs.getInt("id"));
                b.setCode(rs.getString("code"));
                b.setTitle(rs.getString("title"));
                b.setDocument(rs.getString("document"));
                b.setSite(rs.getString("site"));
                b.setCreatedAt(rs.getTimestamp("created_at"));
                b.setUpdatedAt(rs.getTimestamp("updated_at"));
                b.setStatus(rs.getBoolean("status"));

                System.out.println("Banco: " + rs.getString("title"));

                al_bank.add(b);
            }
            stmt.close();
            rs.close();
            c.commit();

        } catch (SQLException e) {
            conn.ConexaoMySQL.finalizarTransacao(false);

        }

        return al_bank;
    }
    
     public List<Bank> getBank() {
         return getBankMulti(0);
     } 

    public Bank getBank(int id) {
        Bank b = new Bank();
        for (Bank bk : getBankMulti(id)) {
            b = bk;
            break;
        }

        return b;
    }

}
