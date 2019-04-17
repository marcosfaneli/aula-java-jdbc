/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula06;

import aula06.carro.Carro;
import aula06.carro.CarroDao;
import aula06.carro.Marcas;
import aula06.db.Conexao;
import java.util.List;

/**
 *
 * @author faneli
 */
public class Aula06 {

    public static void main(String[] args) {

        Conexao conexao = new Conexao();
        conexao.conectar();
        
        CarroDao dao = new CarroDao(conexao);
        
        List<Carro> carros = dao.listar();
        
        for(Carro item : carros){
            System.out.println("ID: " + item.getId());
            System.out.println("Placa: " + item.getPlaca());
            System.out.println("Modelo: " + item.getModelo());
            System.out.println("Marca: " + item.getMarca());
            System.out.println("Valor: R$ " + item.getValor());
            System.out.println("Ano fabricação: " + item.getAnoFabricacao());
            System.out.println("Cor: " + item.getCor());
            System.out.println("-----------------------------------");
        }
                        
        conexao.fechar();
        
    }
    
}
