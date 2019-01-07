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
import tabelas.Pessoas;

/**
 *
 * @author ferna
 */
public class PessoasDAO {

    public Connection c;
    private PreparedStatement stmt;
    private ResultSet rs;
    public ArrayList<Pessoas> al_Pessoas;

    public PessoasDAO() {
        this.c = conn.ConexaoMySQL.conexao;
    }

    public void create(tabelas.Pessoas pessoa) throws SQLException {
        System.out.println("Criando Statement INCLUIR");

        stmt = c.prepareStatement("INSERT INTO personal_finances.pessoas(nome, "
                + "cpf, identidade, orgao_emissor, data_emissao, endereco, "
                + "bairro, complemento, cep, cidade) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?);", stmt.RETURN_GENERATED_KEYS);
        System.out.println("Inserindo valores das Variáveis");
        stmt.setString(1, pessoa.getNome());
        stmt.setString(2, pessoa.getCpf());
        stmt.setString(3, pessoa.getIdentidade());
        stmt.setString(4, pessoa.getOrgaoEmissor());

        if (pessoa.getDataEmissao() == null) {
            stmt.setDate(5, null);
        } else {
            stmt.setDate(5, new java.sql.Date(pessoa.getDataEmissao().getTime()));
        }
        stmt.setString(6, pessoa.getEndereco());
        stmt.setString(7, pessoa.getBairro());
        stmt.setString(8, pessoa.getComplemento());
        stmt.setString(9, pessoa.getCep());
        stmt.setInt(10, pessoa.getCidade().getId());
        stmt.executeUpdate();

        rs = stmt.getGeneratedKeys();

        while (rs.next()) {
            pessoa.setId(rs.getInt(1));
        }

        stmt.close();

    }

    public void deleteById(tabelas.Pessoas pessoa) throws SQLException {
        System.out.println("Criando Statement EXCLUIR");
        stmt = c.prepareStatement("DELETE FROM personal_finances.pessoas "
                + "WHERE id = ?;");
        stmt.setInt(1, pessoa.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    public void update(Pessoas pessoa) throws SQLException {
        System.out.println("Criando Statement ALTERAR");
        stmt = c.prepareStatement("UPDATE `personal_finances`.`pessoas` "
                + "SET `nome` = ?, "
                + "`cpf` = ?, "
                + "`identidade` = ?, "
                + "`orgao_emissor` = ? , "
                + "`data_emissao` = ?, "
                + "`endereco` = ?, "
                + "`bairro` = ?, "
                + "`complemento` = ?, "
                + "`cep` = ?, "
                + "`cidade` = ? "
                + "WHERE `id` = ?;");
        stmt.setString(1, pessoa.getNome());
        stmt.setString(2, pessoa.getCpf());
        stmt.setString(3, pessoa.getIdentidade());
        stmt.setString(4, pessoa.getOrgaoEmissor());
        if (pessoa.getDataEmissao() == null) {
            stmt.setDate(5, null);
        } else {
            stmt.setDate(5, new java.sql.Date(pessoa.getDataEmissao().getTime()));
        }
        stmt.setString(6, pessoa.getEndereco());
        stmt.setString(7, pessoa.getBairro());
        stmt.setString(8, pessoa.getComplemento());
        stmt.setString(9, pessoa.getCep());
        stmt.setInt(10, pessoa.getCidade().getId());
        stmt.setInt(11, pessoa.getId());

        stmt.executeUpdate();

        stmt.close();
    }

    public List<Pessoas> getPessoas() {

        return getPessoasMulti(0, "");
    }

    public List<Pessoas> getPessoasMulti(int pessoa, String cpf) {

        al_Pessoas = new ArrayList<Pessoas>();
        try {
            stmt = c.prepareStatement("SELECT * FROM personal_finances.pessoas "
                    + "where id like ? and cpf like ? "
                    + "ORDER BY nome;");

            if (pessoa > 0) {
                stmt.setString(1, pessoa + "");
            } else {
                stmt.setString(1, "%");
            }

            stmt.setString(2, "%" + cpf + "%");

            rs = stmt.executeQuery();
            while (rs.next()) {
                Pessoas p = new Pessoas();
                MunicipiosDAO m = new MunicipiosDAO();

                //System.out.println("Pessoa Encontrada: " + rs.getString("nome"));
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setCpf(rs.getString("cpf"));
                p.setIdentidade(rs.getString("identidade"));
                p.setOrgaoEmissor(rs.getString("orgao_emissor"));
                p.setDataEmissao(rs.getDate("data_emissao"));
                p.setEndereco(rs.getString("endereco"));
                p.setBairro(rs.getString("bairro"));
                p.setComplemento(rs.getString("complemento"));
                p.setCep(rs.getString("cep"));
                p.setCidade(m.getMunicipio(rs.getInt("cidade")));
                p.setCreatedAt(rs.getTimestamp("created_at"));
                p.setUpdatedAt(rs.getTimestamp("updated_at"));

                al_Pessoas.add(p);

            }
            stmt.close();
            rs.close();
            c.commit();
        } catch (Exception e) {
            tools.DefaultMsg.errorMsg("Não foi possível executar a consulta.");
        } finally {
        }

        return al_Pessoas;
    }

    public Pessoas getPessoas(int pessoa) {
        Pessoas p = null;

        for (Pessoas x : getPessoasMulti(pessoa, "")) {
            p = x;
            break;
        }

        return p;
    }

    public Pessoas getPessoas(String cpf) {
        System.out.println("Pesquisando pelo CPF / CNPJ");
        Pessoas p = new Pessoas();

        for (Pessoas x : getPessoasMulti(0, cpf)) {
            p = x;
            break;
        }

        return p;
    }

}
