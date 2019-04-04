/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula06.carro;

import aula06.db.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author faneli
 */
public class CarroDao {

    Conexao conexao;

    public CarroDao(Conexao conexao) {
        this.conexao = conexao;
    }

    public Carro ler(int id) {
        Carro carro = new Carro();

        String sql = "select * from carros where id = ?";

        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();
            if (rs.next() == true) {
                carro.setAnoFabricacao(rs.getInt("ano_fabricacao"));
                carro.setCor(rs.getString("cor"));
                carro.setModelo(rs.getString("modelo"));
                carro.setPlaca(rs.getString("placa"));
                carro.setValor(rs.getDouble("valor"));
                switch (rs.getString("marca")) {
                    case "Fiat":
                        carro.setMarca(Marcas.Fiat);
                        break;
                    case "Volskwagem":
                        carro.setMarca(Marcas.Volskwagem);
                        break;
                    case "Ford":
                        carro.setMarca(Marcas.Ford);
                        break;
                    default:
                        carro.setMarca(Marcas.Chevrolet);
                }
            } else {
                System.out.println("Carro não encontrado");
            }
            pst.close();
            rs.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("Erro ao selecionar o carro");
        }
        return carro;
    }

    public void inserir(Carro carro) {
        try {
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

        } catch (Exception ex) {
            System.out.println("Erro ao inserir o carro");
        }
    }

}
