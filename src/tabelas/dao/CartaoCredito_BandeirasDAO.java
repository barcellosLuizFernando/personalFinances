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
import tabelas.CartaoCreditoBandeiras;

/**
 *
 * @author ferna
 */
public class CartaoCredito_BandeirasDAO {

    private final Connection c;
    public List<CartaoCreditoBandeiras> al_ccB;
    private PreparedStatement stmt;
    private ResultSet rs;

    public CartaoCredito_BandeirasDAO() {
        this.c = conn.ConexaoMySQL.conexao;
    }

    public void create(CartaoCreditoBandeiras ccB) throws SQLException {
        stmt = c.prepareStatement("INSERT INTO personal_finances.cartao_credito_bandeiras "
                + "(title) VALUES (?);", stmt.RETURN_GENERATED_KEYS);
        stmt.setString(1, ccB.getTitle());
        stmt.executeUpdate();
        rs = stmt.getGeneratedKeys();
        while (rs.next()) {
            ccB.setId(rs.getInt(1));
        }
        stmt.close();
        rs.close();
    }

    public void update(CartaoCreditoBandeiras ccB) throws SQLException {
        stmt = c.prepareStatement("UPDATE personal_finances.cartao_credito_bandeiras "
                + "SET title = ? WHERE id = ?;");
        stmt.setString(1, ccB.getTitle());
        stmt.setInt(2, ccB.getId());
        stmt.executeUpdate();
        stmt.close();

    }

    public void delete(CartaoCreditoBandeiras ccB) throws SQLException {
        stmt = c.prepareStatement("DELETE FROM personal_finances.cartao_credito_bandeiras "
                + "WHERE id = ?;");
        stmt.setInt(1, ccB.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    public CartaoCreditoBandeiras getCartaoCreditoBandeiras(int id) {
        CartaoCreditoBandeiras ccB = null;

        for (CartaoCreditoBandeiras cc : getCartaoCreditoBandeirasMulti(id)) {
            ccB = cc;
            break;
        }

        return ccB;
    }

    public List<CartaoCreditoBandeiras> getCartaoCreditoBandeiras() {
        return getCartaoCreditoBandeirasMulti(0);
    }

    private List<CartaoCreditoBandeiras> getCartaoCreditoBandeirasMulti(int id) {
        al_ccB = new ArrayList<CartaoCreditoBandeiras>();
        try {
            stmt = c.prepareStatement("SELECT * FROM personal_finances.cartao_credito_bandeiras "
                    + "WHERE id LIKE ? ORDER BY title;");
            if (id > 0) {
                stmt.setString(1, id + "");
            } else {
                stmt.setString(1, "%");
            }
            rs = stmt.executeQuery();
            while (rs.next()) {
                CartaoCreditoBandeiras ccB = new CartaoCreditoBandeiras();
                ccB.setId(rs.getInt("id"));
                ccB.setTitle(rs.getString("title"));
                ccB.setCreatedAt(rs.getTimestamp("created_at"));
                ccB.setUpdatedAt(rs.getTimestamp("updated_at"));

                al_ccB.add(ccB);
            }
            stmt.close();
            rs.close();
            c.commit();

        } catch (SQLException e) {
            tools.DefaultMsg.errorMsg("Não foi possível consultas as Bandeiras de Cartões de Crédito.\n" + e.getMessage());
            conn.ConexaoMySQL.finalizarTransacao(false);
        }
        
        return al_ccB;
    }
}
