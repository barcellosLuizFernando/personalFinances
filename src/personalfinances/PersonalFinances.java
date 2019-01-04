/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalfinances;

import conn.ConexaoMySQL;

/**
 *
 * @author luiz.barcellos
 */
public class PersonalFinances {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        conn.ConexaoMySQL cn = new ConexaoMySQL();
        
        try {
            cn.conecta("localhost", "root", "", 3317);
            
            
        } catch (Exception e) {
            tools.DefaultMsg.errorMsg(e + "");
        }
    }
    
}
