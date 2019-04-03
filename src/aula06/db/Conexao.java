/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula06.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author faneli
 */
public class Conexao {

    private String usuario = "root";
    private String senha = "123";
    private String url = "jdbc:mariadb://localhost:3306/aula06";
    private Connection conexao;

    public Connection getConexao() {
        return conexao;
    }

    public void conectar() {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
        } catch (Exception ex) {
            System.out.println("Não foi possível conectar ao banco de dados");
        }
    }

    public void fechar() {
        try {
            this.conexao.close();
        } catch (Exception ex) {
            System.out.println("Conexão não pode ser encerrada");
        }
    }
}
