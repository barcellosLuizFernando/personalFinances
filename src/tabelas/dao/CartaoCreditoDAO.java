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
import tabelas.CartaoCredito;

/**
 *
 * @author ferna
 */
public class CartaoCreditoDAO {
    
    private final Connection c;
    public List<CartaoCredito> al_cartaocredito;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    public CartaoCreditoDAO() {
        this.c = conn.ConexaoMySQL.conexao;
    }
    
    public void create(CartaoCredito cc) throws SQLException {
        stmt = c.prepareStatement("INSERT INTO personal_finances.cartao_credito(id_pessoa, "
                + "id_conta, id_bandeira, numero, dt_vencimento, limite, tipo, "
                + "cancelado) VALUES (?,?,?,?,?,?,?,?) ;", stmt.RETURN_GENERATED_KEYS);
        stmt.setInt(1, cc.getIdPessoa().getId());
        stmt.setInt(2, cc.getIdConta().getId());
        stmt.setInt(3, cc.getIdBandeira().getId());
        stmt.setString(4, cc.getNumero());
        stmt.setDate(5, new java.sql.Date(cc.getDtVencimento().getTime()));
        stmt.setDouble(6, cc.getLimite());
        stmt.setInt(7, cc.getTipo());
        stmt.setBoolean(8, cc.getCancelado());
        stmt.executeUpdate();
        rs = stmt.getGeneratedKeys();
        while (rs.next()) {
            cc.setId(rs.getInt(1));
        }
        rs.close();
        stmt.close();
    }
    
    public void update(CartaoCredito cc) throws SQLException {
        stmt = c.prepareStatement("UPDATE personal_finances.cartao_credito "
                + "SET id_pessoa = ?, id_conta = ?, id_bandeira = ?, "
                + "numero = ?, dt_vencimento = ?, limite = ?,"
                + "tipo = ?, cancelado = ? WHERE id = ?;");
        stmt.setInt(1, cc.getIdPessoa().getId());
        stmt.setInt(2, cc.getIdConta().getId());
        stmt.setInt(3, cc.getIdBandeira().getId());
        stmt.setString(4, cc.getNumero());
        stmt.setDate(5, new java.sql.Date(cc.getDtVencimento().getTime()));
        stmt.setDouble(6, cc.getLimite());
        stmt.setInt(7, cc.getTipo());
        stmt.setBoolean(8, cc.getCancelado());
        stmt.setInt(9, cc.getId());
        stmt.executeUpdate();
        stmt.close();
    }
    
    public void delete(CartaoCredito cc) throws SQLException {
        stmt = c.prepareStatement("UPDATE personal_finances.cartao_credito "
                + "WHERE id = ?;");
        stmt.setInt(1, cc.getId());
        stmt.executeUpdate();
        stmt.close();
    }
    
    public List<CartaoCredito> getCartaoCredito() {
        
        return getCartaoCreditoMulti(0);
    }
    
    public CartaoCredito getCartaoCredito(int id) {
        CartaoCredito cc = null;
        for (CartaoCredito ccx : getCartaoCreditoMulti(id)) {
            cc = ccx;
            break;
        }
        return cc;
    }
    
    private List<CartaoCredito> getCartaoCreditoMulti(int id) {
        al_cartaocredito = new ArrayList<CartaoCredito>();
        try {
            stmt = c.prepareStatement("SELECT * FROM personal_finances.cartao_credito "
                    + "WHERE ID like ?;");
            if (id > 0) {
                stmt.setString(1, id + "");
            } else {
                stmt.setString(1, "%");
            }
            rs = stmt.executeQuery();
            while (rs.next()) {
                CartaoCredito cc = new CartaoCredito();
                cc.setId(rs.getInt("id"));
                cc.setNumero(rs.getString("numero"));
                cc.setTipo(rs.getInt("tipo"));
                cc.setDtVencimento(rs.getDate("dt_vencimento"));
                cc.setLimite(rs.getDouble("limite"));
                cc.setCancelado(rs.getBoolean("cancelado"));
                cc.setCreatedAt(rs.getTimestamp("created_at"));
                cc.setUpdatedAt(rs.getTimestamp("updated_at"));
                cc.setIdPessoa(new PessoasDAO().getPessoas(rs.getInt("id_pessoa")));
                cc.setIdBandeira(new CartaoCredito_BandeirasDAO().getCartaoCreditoBandeiras(rs.getInt("id_bandeira")));
                cc.setIdConta(new ContasDAO().getContas(rs.getInt("id_conta")));
                
                al_cartaocredito.add(cc);
            }
            stmt.close();
            rs.close();
            c.commit();
            
        } catch (Exception e) {
            conn.ConexaoMySQL.finalizarTransacao(false);
            tools.DefaultMsg.errorMsg(e.getMessage());
            
        }
        return al_cartaocredito;
    }
    
}
