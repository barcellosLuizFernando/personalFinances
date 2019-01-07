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
import tabelas.ContasTipo;

/**
 *
 * @author ferna
 */
public class ContasTipoDAO {

    private final Connection c;
    private PreparedStatement stmt;
    private ResultSet rs;
    public static List<ContasTipo> al_contasTipo;

    public ContasTipoDAO() {
        this.c = conn.ConexaoMySQL.conexao;
    }

    public void create(ContasTipo ct) throws SQLException {

        stmt = c.prepareStatement("INSERT INTO personal_finances.contas_tipo "
                + "(title, description, investment) "
                + "VALUES (?,?,?);", stmt.RETURN_GENERATED_KEYS);

        stmt.setString(1, ct.getTitle());
        stmt.setString(2, ct.getDescription());
        stmt.setBoolean(3, ct.getInvestiment());

        stmt.executeUpdate();

        rs = stmt.getGeneratedKeys();
        while (rs.next()) {
            ct.setId(rs.getInt(1));
        }
        stmt.close();
        rs.close();
    }

    public void update(ContasTipo ct) throws SQLException {
        stmt = c.prepareStatement("UPDATE personal_finances.contas_tipo "
                + "SET title = ?, description = ?, investment = ? "
                + "WHERE id = ? ;");
        stmt.setString(1, ct.getTitle());
        stmt.setString(2, ct.getDescription());
        stmt.setBoolean(3, ct.getInvestiment());
        stmt.setInt(4, ct.getId());

        stmt.executeUpdate();
        stmt.close();
    }

    public void delete(ContasTipo ct) throws SQLException {
        stmt = c.prepareStatement("DELETE FROM personal_finances.contas_tipo "
                + "WHERE id = ?;");
        stmt.setInt(1, ct.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    public List<ContasTipo> getContasTipos() {

        return getContasTipoMulti(0);
    }

    public ContasTipo getContasTipo(int id) {
        ContasTipo ct = new ContasTipo();

        for (ContasTipo cx : getContasTipoMulti(id)) {
            ct = cx;
            break;
        }
        return ct;
    }

    private List<ContasTipo> getContasTipoMulti(int id) {

        try {
            al_contasTipo = new ArrayList<ContasTipo>();
            stmt = c.prepareStatement("SELECT * FROM personal_finances.contas_tipo "
                    + "WHERE ID like ? ORDER BY title, id;");

            if (id > 0) {
                stmt.setString(1, id + "");
            } else {
                stmt.setString(1, "%");
            }

            System.out.println("Executando Statement: " + stmt.toString());
            rs = stmt.executeQuery();
            while (rs.next()) {
                ContasTipo ct = new ContasTipo();
                ct.setId(rs.getInt("id"));
                ct.setTitle(rs.getString("title"));
                ct.setDescription(rs.getString("description"));
                ct.setInvestiment(rs.getBoolean("investment"));
                ct.setCreatedAt(rs.getTimestamp("created_At"));
                ct.setUpdatedAt(rs.getTimestamp("updated_At"));

                al_contasTipo.add(ct);
            }
            stmt.close();
            rs.close();

        } catch (SQLException e) {
            conn.ConexaoMySQL.finalizarTransacao(false);
        }

        return al_contasTipo;
    }

}
