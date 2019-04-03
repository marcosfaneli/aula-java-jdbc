/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula06.carro;

import aula06.db.Conexao;
import java.sql.PreparedStatement;

/**
 *
 * @author faneli
 */
public class CarroDao {
    
    Conexao conexao;
    
    public CarroDao(Conexao conexao){
        this.conexao = conexao;
    }
    
    public void inserir(Carro carro){
        try{
            String sql = "INSERT INTO carros "
                    + "(modelo, marca, placa, cor, ano_fabricacao, valor)"
                    + "values (?, ?, ?, ?, ?, ?)";
            
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            pst.setString(1, carro.getModelo());
            pst.setString(2, carro.getMarca().toString());
            pst.setString(3, carro.getPlaca());
            pst.setString(4, carro.getCor());
            pst.setInt(5, carro.getAnoFabricacao());
            pst.setDouble(6, carro.getValor());
            pst.executeUpdate();
            
            pst.close();
            
        } catch(Exception ex){
            System.out.println("Erro ao inserir o carro");   
        }
    }
    
}
