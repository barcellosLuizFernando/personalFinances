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
import tabelas.LancamentosOrcamento;

/**
 *
 * @author ferna
 */
public class LancamentosOrcamentoDAO {

    private final Connection c;
    private PreparedStatement stmt;
    private ResultSet rs;
    public ArrayList<LancamentosOrcamento> al_orcamento;

    public LancamentosOrcamentoDAO() {
        this.c = conn.ConexaoMySQL.conexao;
    }

    public void create(LancamentosOrcamento l) throws SQLException {

        stmt = c.prepareStatement("INSERT INTO personal_finances.lancamentos_orcamento "
                + "(id_pessoa, id_tipo_lancamento, descricao, dt_inicio, "
                + "dt_fim, valor, fluxo, repeat_at, duplic_at) "
                + "VALUES (?,?,?,?,?,?,?,?,?);", stmt.RETURN_GENERATED_KEYS);
        stmt.setInt(1, l.getIdPessoa().getId());
        stmt.setInt(2, l.getIdTipoLancamento().getId());
        stmt.setString(3, l.getDescricao());
        stmt.setDate(4, new java.sql.Date(l.getDtInicio().getTime()));
        try {
            stmt.setDate(5, new java.sql.Date(l.getDtFim().getTime()));
        } catch (Exception e) {
            stmt.setDate(5, null);
        }
        stmt.setDouble(6, l.getValor());
        stmt.setBoolean(7, l.getFluxo());
        stmt.setString(8, l.getRepeatAt());
        stmt.setString(9, l.getDuplicAt());
        stmt.executeUpdate();
        rs = stmt.getGeneratedKeys();
        while (rs.next()) {
            l.setId(rs.getInt(1));
        }
        stmt.close();
        rs.close();
    }

    public void update(LancamentosOrcamento l) throws SQLException {
        stmt = c.prepareStatement("UPDATE personal_finances.lancamentos_orcamento "
                + "SET id_pessoa = ?, id_tipo_lancamento = ?, "
                + "descricao = ?, dt_inicio = ?, dt_fim = ?, "
                + "valor = ?, fluxo = ?, repeat_at = ?, "
                + "duplic_at = ? WHERE id = ?;");

        stmt.setInt(1, l.getIdPessoa().getId());
        stmt.setInt(2, l.getIdTipoLancamento().getId());
        stmt.setString(3, l.getDescricao());
        stmt.setDate(4, new java.sql.Date(l.getDtInicio().getTime()));
        try {
            stmt.setDate(5, new java.sql.Date(l.getDtFim().getTime()));
        } catch (Exception e) {
            stmt.setDate(5, null);
        }
        stmt.setDouble(6, l.getValor());
        stmt.setBoolean(7, l.getFluxo());
        stmt.setString(8, l.getRepeatAt());
        stmt.setString(9, l.getDuplicAt());
        stmt.setInt(10, l.getId());
        stmt.executeUpdate();
        stmt.close();

    }

    public void delete(LancamentosOrcamento l) throws SQLException {
        stmt = c.prepareStatement("DELETE FROM personal_finances.lancamentos_orcamento "
                + "WHERE id = ? ;");
        stmt.setInt(1, l.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    public List<LancamentosOrcamento> getOrcamento() {

        return getOrcamentoMulti(0);
    }

    public LancamentosOrcamento getOrcamento(int id) {
        LancamentosOrcamento l = null;
        if (id > 0) {
            for (LancamentosOrcamento ll : getOrcamentoMulti(id)) {
                l = ll;
                break;
            }
        }

        return l;
    }

    private List<LancamentosOrcamento> getOrcamentoMulti(int id) {
        al_orcamento = new ArrayList<LancamentosOrcamento>();

        try {
            stmt = c.prepareStatement("SELECT * FROM personal_finances.lancamentos_orcamento "
                    + "WHERE id LIKE ?;");
            if (id > 0) {
                stmt.setString(1, id + "");
            } else {
                stmt.setString(1, "%");
            }
            System.out.println("Stmt: " + stmt.toString());
            rs = stmt.executeQuery();
            while (rs.next()) {
                LancamentosOrcamento l = new LancamentosOrcamento();
                l.setId(rs.getInt("id"));
                l.setCreatedAt(rs.getTimestamp("created_at"));
                l.setDescricao(rs.getString("descricao"));
                l.setDtFim(rs.getDate("dt_fim"));
                l.setDtInicio(rs.getDate("dt_inicio"));
                l.setDuplicAt(rs.getString("duplic_at"));
                l.setFluxo(rs.getBoolean("fluxo"));
                l.setIdPessoa(new PessoasDAO().getPessoas(rs.getInt("id_pessoa")));
                l.setIdTipoLancamento(new LancamentosTipoDAO().getLancamentosTipo(rs.getInt("id_tipo_lancamento")));
                l.setRepeatAt(rs.getString("repeat_at"));
                l.setUpdatedAt(rs.getTimestamp("updated_at"));
                l.setValor(rs.getDouble("valor"));
                al_orcamento.add(l);
            }
            stmt.close();
            rs.close();

            conn.ConexaoMySQL.finalizarTransacao(true);
        } catch (Exception e) {
            tools.DefaultMsg.errorMsg(e.getMessage());
            conn.ConexaoMySQL.finalizarTransacao(false);
        }

        return al_orcamento;
    }

}
