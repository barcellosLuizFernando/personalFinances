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
import tabelas.LancamentosTipo;

/**
 *
 * @author ferna
 */
public class LancamentosTipoDAO {

    public static ArrayList<LancamentosTipo> al_LancamentosTipo;
    public final Connection c;
    private PreparedStatement stmt;
    private ResultSet rs;

    public LancamentosTipoDAO() {
        this.c = conn.ConexaoMySQL.conexao;
    }

    public void create(LancamentosTipo l) throws SQLException {
        stmt = c.prepareStatement("INSERT INTO personal_finances.lancamentos_tipo "
                + "(title, description, antecipa_pgto, obriga_bem) VALUES "
                + "(?,?,?,?);", stmt.RETURN_GENERATED_KEYS);
        stmt.setString(1, l.getTitle());
        stmt.setString(2, l.getDescription());
        stmt.setBoolean(3, l.getAntecipaPgto());
        stmt.setBoolean(4, l.getObrigaBem());

        stmt.executeUpdate();

        rs = stmt.getGeneratedKeys();
        while (rs.next()) {
            l.setId(rs.getInt(1));
        }
        stmt.close();
        rs.close();
    }

    public void update(LancamentosTipo l) throws SQLException {

        stmt = c.prepareStatement("UPDATE personal_finances.lancamentos_tipo "
                + "SET title = ?, description = ?, antecipa_pgto = ?, "
                + "obriga_bem = ? "
                + "WHERE id = ?;");
        stmt.setString(1, l.getTitle());
        stmt.setString(2, l.getDescription());
        stmt.setBoolean(3, l.getAntecipaPgto());
        stmt.setBoolean(4, l.getObrigaBem());
        stmt.setInt(5, l.getId());

        stmt.executeUpdate();

        stmt.close();

    }

    public void delete(LancamentosTipo l) throws SQLException {
        stmt = c.prepareStatement("DELETE FROM personal_finances.lancamentos_tipo "
                + "WHERE id = ?;");
        stmt.setInt(1, l.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    public List<LancamentosTipo> getLancamentosTipo() {

        return getLancamentosTipoMulti(0);
    }

    public LancamentosTipo getLancamentosTipo(int id) {

        LancamentosTipo tipo = new LancamentosTipo();

        for (LancamentosTipo l : getLancamentosTipoMulti(id)) {
            tipo = l;
            break;
        }
        return tipo;
    }

    private List<LancamentosTipo> getLancamentosTipoMulti(int id) {
        try {
            al_LancamentosTipo = new ArrayList<LancamentosTipo>();

            stmt = c.prepareStatement("SELECT * FROM personal_finances.lancamentos_tipo "
                    + "WHERE id like ? ORDER BY title, id;");
            if (id > 0) {
                stmt.setString(1, id + "");
            } else {
                stmt.setString(1, "%");
            }
            rs = stmt.executeQuery();

            while (rs.next()) {
                LancamentosTipo l = new LancamentosTipo();

                l.setId(rs.getInt("id"));
                l.setTitle(rs.getString("title"));
                l.setDescription(rs.getString("description"));
                l.setAntecipaPgto(rs.getBoolean("antecipa_pgto"));
                l.setObrigaBem(rs.getBoolean("obriga_bem"));
                l.setCreatedAt(rs.getTimestamp("created_at"));
                l.setUpdatedAt(rs.getTimestamp("updated_at"));

                al_LancamentosTipo.add(l);
            }
            stmt.close();
            rs.close();
            c.commit();

        } catch (SQLException e) {
            conn.ConexaoMySQL.finalizarTransacao(false);
        }

        return al_LancamentosTipo;
    }

}
