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
import tabelas.LancamentosCentroCusto;

/**
 *
 * @author ferna
 */
public class LancamentosCentroCustoDAO {

    private final Connection c;
    private PreparedStatement stmt;
    private ResultSet rs;
    public List<LancamentosCentroCusto> al_cc;

    public LancamentosCentroCustoDAO() {
        this.c = conn.ConexaoMySQL.conexao;
    }

    public void create(LancamentosCentroCusto cc) throws SQLException {
        stmt = c.prepareStatement("INSERT INTO personal_finances.lancamentos_centro_custo "
                + "(title, descricao) VALUES (?,?);", stmt.RETURN_GENERATED_KEYS);
        stmt.setString(1, cc.getTitle());
        stmt.setString(2, cc.getDescricao());
        stmt.executeUpdate();
        rs = stmt.getGeneratedKeys();
        while (rs.next()) {
            cc.setId(rs.getInt(1));
        }
        stmt.close();
        rs.close();
    }

    public void update(LancamentosCentroCusto cc) throws SQLException {
        stmt = c.prepareStatement("UPDATE personal_finances.lancamentos_centro_custo "
                + "SET title = ?, descricao = ? WHERE id = ?;");
        stmt.setString(1, cc.getTitle());
        stmt.setString(2, cc.getDescricao());
        stmt.setInt(3, cc.getId());
        stmt.executeUpdate();
        stmt.close();

    }

    public void delete(LancamentosCentroCusto cc) throws SQLException {
        stmt = c.prepareStatement("DELETE FROM personal_finances.lancamentos_centro_custo "
                + "WHERE id = ?");
        stmt.setInt(1, cc.getId());
        stmt.executeUpdate();
    }

    public LancamentosCentroCusto getCC(int id) {
        LancamentosCentroCusto cc = null;
        if (id > 0) {
            for (LancamentosCentroCusto c : getCCMulti(id)) {
                cc = c;
                break;
            }
        }
        return cc;
    }

    public List<LancamentosCentroCusto> getCC() {
        return getCCMulti(0);
    }

    private List<LancamentosCentroCusto> getCCMulti(int id) {
        al_cc = new ArrayList<LancamentosCentroCusto>();
        try {
            stmt = c.prepareStatement("SELECT * FROM personal_finances.lancamentos_centro_custo "
                    + "WHERE id like ?;");
            if (id > 0) {
                stmt.setString(1, id + "");
            } else {
                stmt.setString(1, "%");
            }
            rs = stmt.executeQuery();
            while (rs.next()) {
                LancamentosCentroCusto cc = new LancamentosCentroCusto();
                cc.setId(rs.getInt("id"));
                cc.setTitle(rs.getString("title"));
                cc.setDescricao(rs.getString("descricao"));
                cc.setCreatedAt(rs.getTimestamp("created_at"));
                cc.setUpdatedAt(rs.getTimestamp("updated_at"));
                al_cc.add(cc);
            }
            rs.close();
            stmt.close();
            conn.ConexaoMySQL.finalizarTransacao(true);
        } catch (Exception e) {
            conn.ConexaoMySQL.finalizarTransacao(false);
            tools.DefaultMsg.errorMsg(e.getMessage());
        }
        return al_cc;
    }

}
