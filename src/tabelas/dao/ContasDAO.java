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
import tabelas.Contas;

/**
 *
 * @author ferna
 */
public class ContasDAO {

    private final Connection c;
    private PreparedStatement stmt;
    private ResultSet rs;
    public List<Contas> al_contas;

    public ContasDAO() {
        this.c = conn.ConexaoMySQL.conexao;
    }

    public void create(Contas ct) throws SQLException {
        stmt = c.prepareStatement("INSERT INTO personal_finances.contas ("
                + "pessoa, bank, agencia, conta, cidade, economic_group, "
                + "finished, account) "
                + "VALUES (?,?,?,?,?,?,?,?);", stmt.RETURN_GENERATED_KEYS);

        stmt.setInt(1, ct.getPessoa().getId());
        stmt.setInt(2, ct.getBank().getId());
        stmt.setString(3, ct.getAgencia());
        stmt.setString(4, ct.getConta());
        stmt.setInt(5, ct.getCidade().getId());
        stmt.setInt(6, ct.getEconomicGroup().getId());
        stmt.setBoolean(7, ct.getFinished());
        stmt.setInt(8, ct.getAccount().getId());
        stmt.executeUpdate();

        rs = stmt.getGeneratedKeys();
        while (rs.next()) {
            ct.setId(rs.getInt(1));
        }
        stmt.close();
        rs.close();
    }

    public void update(Contas ct) throws SQLException {
        stmt = c.prepareStatement("UPDATE personal_finances.contas "
                + "SET pessoa = ?, bank = ?, agencia = ?, conta = ?, "
                + "cidade = ?, economic_group = ?, finished = ?, account = ? "
                + "WHERE id = ?;");
        stmt.setInt(1, ct.getPessoa().getId());
        stmt.setInt(2, ct.getBank().getId());
        stmt.setString(3, ct.getAgencia());
        stmt.setString(4, ct.getConta());
        stmt.setInt(5, ct.getCidade().getId());
        stmt.setInt(6, ct.getEconomicGroup().getId());
        stmt.setBoolean(7, ct.getFinished());
        stmt.setInt(8, ct.getAccount().getId());
        stmt.setInt(9, ct.getId());
        stmt.executeUpdate();
        stmt.close();

    }

    public void delete(Contas ct) throws SQLException {
        stmt = c.prepareStatement("DELETE FROM personal_finances.contas "
                + "WHERE id = ?;");
        stmt.setInt(1, ct.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    public List<Contas> getContas() {
        return getContasMulti(0);
    }

    public Contas getContas(int id) {
        Contas ct = null;
        for (Contas c : getContasMulti(id)) {
            ct = c;
            break;
        }
        return ct;
    }

    private List<Contas> getContasMulti(int id) {

        try {

            al_contas = new ArrayList<Contas>();

            stmt = c.prepareStatement("SELECT * FROM personal_finances.contas "
                    + "WHERE id like ?;");
            if (id > 0) {
                stmt.setString(1, id + "");
            } else {
                stmt.setString(1, "%");
            }
            rs = stmt.executeQuery();
            while (rs.next()) {
                Contas ct = new Contas();
                BankDAO bDAO = new BankDAO();
                ContasTipoDAO ctDAO = new ContasTipoDAO();
                MunicipiosDAO mDAO = new MunicipiosDAO();
                PessoasDAO pDAO = new PessoasDAO();
                EconomicGroupDAO ecDAO = new EconomicGroupDAO();

                ct.setId(rs.getInt("id"));
                ct.setAgencia(rs.getString("agencia"));
                ct.setConta(rs.getString("conta"));
                ct.setCreatedAt(rs.getTimestamp("created_at"));
                ct.setUpdatedAt(rs.getTimestamp("updated_at"));
                ct.setFinished(rs.getBoolean("finished"));
                ct.setPessoa(pDAO.getPessoas(rs.getInt("pessoa")));
                ct.setBank(bDAO.getBank(rs.getInt("bank")));
                ct.setCidade(mDAO.getMunicipio(rs.getInt("cidade")));
                ct.setAccount(ctDAO.getContasTipo(rs.getInt("account")));
                ct.setEconomicGroup(ecDAO.getEconomicGroup(rs.getInt("economic_group")));
                
                al_contas.add(ct);

            }

        } catch (SQLException e) {
            
        }
        return al_contas;
    }
}
