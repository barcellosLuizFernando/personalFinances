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
import tabelas.CadMunic;

/**
 *
 * @author ferna
 */
public class MunicipiosDAO {

    public Connection c;
    private PreparedStatement stmt;
    private ResultSet rs;
    public ArrayList<CadMunic> al_Munic;

    public MunicipiosDAO() {
        this.c = conn.ConexaoMySQL.conexao;
    }

    /**
     * RETORNA TODOS OS MUNICÍPIOS DA BASE.
     *
     * @return
     */
    public List<CadMunic> getMunicipio() {

        return getMunicipioMulti(0, "", "");
    }

    public CadMunic getMunicipio(int id) {
        CadMunic m = new CadMunic();

        for (CadMunic mun : getMunicipioMulti(id, "", "")) {
            m = mun;
            break;
        }

        return m;
    }

    /**
     * RETORNA APENAS O MUNICÍPIO INFORMADO.
     *
     * @param id
     * @return
     */
    private List<CadMunic> getMunicipioMulti(int id, String nome_mun, String uf) {
        try {

            stmt = c.prepareStatement("SELECT * FROM personal_finances.cad_munic "
                    + "WHERE id like ? and upper(nome) like ? and upper(uf) like ? "
                    + "ORDER BY nome, uf;");

            /**
             * SE TIVER UMA ID INFORMADA, PESQUISA SÓ ELA;
             */
            if (id > 0) {
                stmt.setString(1, id + "");
            } else {
                stmt.setString(1, "%");
            }

            /**
             * SE TIVER UM NOME INFORMADO, PESQUISA POR ELE
             */
            stmt.setString(2, "%" + nome_mun.toUpperCase() + "%");
            stmt.setString(3, "%" + uf.toUpperCase() + "%");
            /*System.out.println("Municipio ID: " + id);
            System.out.println("Municipio NOME: <" + nome_mun + ">");
            System.out.println("Municipio UF: <" + uf + ">");
            System.out.println("" + stmt.toString());*/

            rs = stmt.executeQuery();

            al_Munic = new ArrayList<CadMunic>();

            while (rs.next()) {
                CadMunic m = new CadMunic();
                m.setId(rs.getInt("id"));
                m.setUf(rs.getString("uf"));
                m.setCodIbge(rs.getInt("cod_ibge"));
                m.setNome(rs.getString("nome"));

                al_Munic.add(m);
            }
            stmt.close();
            rs.close();
            c.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return al_Munic;
    }

    public CadMunic getMunicipio(String nome_mun, String uf) {

        CadMunic m = new CadMunic();

        for (CadMunic mun : getMunicipioMulti(0, nome_mun, uf)) {
            m = mun;
            break;
        }

        return m;

    }

}
