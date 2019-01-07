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
import tabelas.EconomicGroup;

/**
 *
 * @author ferna
 */
public class EconomicGroupDAO {

    private final Connection c;
    private PreparedStatement stmt;
    private ResultSet rs;
    public static ArrayList<EconomicGroup> al_economicGroup;

    public EconomicGroupDAO() {
        this.c = conn.ConexaoMySQL.conexao;
    }

    public void create(EconomicGroup ec) throws SQLException {
        stmt = c.prepareStatement("INSERT INTO personal_finances.economic_group "
                + "(title, descricao) VALUES (?,?);", stmt.RETURN_GENERATED_KEYS);
        stmt.setString(1, ec.getTitle());
        stmt.setString(2, ec.getDescricao());
        stmt.executeUpdate();
        rs = stmt.getGeneratedKeys();
        while (rs.next()) {
            ec.setId(rs.getInt(1));
        }
        stmt.close();
        rs.close();

    }

    public void update(EconomicGroup ec) throws SQLException {

        stmt = c.prepareStatement("UPDATE personal_finances.economic_group "
                + "SET title = ?, descricao = ? WHERE id = ?;");
        stmt.setString(1, ec.getTitle());
        stmt.setString(2, ec.getDescricao());
        stmt.setInt(3, ec.getId());

        stmt.executeUpdate();
        stmt.close();

    }

    public void delete(EconomicGroup ec) throws SQLException {

        stmt = c.prepareStatement("DELETE FROM personal_finances.economic_group "
                + "WHERE id = ?;");
        stmt.setInt(1, ec.getId());
        stmt.executeUpdate();
        stmt.close();

    }

    public List<EconomicGroup> getEconomicGroup() {

        return getEconomicGroupMulti(0);
    }

    public EconomicGroup getEconomicGroup(int id) {
        EconomicGroup ec = null;

        for (EconomicGroup e : getEconomicGroupMulti(id)) {
            ec = e;
            break;
        }

        return ec;
    }

    private List<EconomicGroup> getEconomicGroupMulti(int id) {

        try {

            al_economicGroup = new ArrayList<EconomicGroup>();

            stmt = c.prepareStatement("SELECT * FROM personal_finances.economic_group "
                    + "WHERE id like ?;");
            if (id > 0) {
                stmt.setString(1, id + "");
            } else {
                stmt.setString(1, "%");
            }
            System.out.println("Executando query: " + stmt.toString());
            rs = stmt.executeQuery();
            while (rs.next()) {
                EconomicGroup ec = new EconomicGroup();
                ec.setId(rs.getInt("id"));
                ec.setTitle(rs.getString("title"));
                ec.setDescricao(rs.getString("descricao"));
                ec.setCreatedAt(rs.getTimestamp("created_at"));
                ec.setUpdatedAt(rs.getTimestamp("updated_at"));

                al_economicGroup.add(ec);
            }
            stmt.close();
            rs.close();

        } catch (SQLException e) {
            tools.DefaultMsg.errorMsg("Não foi possível consultar os Grupos Econômicos.\n" + e.getMessage());
        }
        return al_economicGroup;
    }

}
