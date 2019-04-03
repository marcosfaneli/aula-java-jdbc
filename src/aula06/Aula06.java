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

/**
 *
 * @author faneli
 */
public class Aula06 {

    public static void main(String[] args) {

        Carro uno = new Carro();
        uno.setModelo("Uno Mille");
        uno.setMarca(Marcas.Fiat);
        uno.setCor("Verde Escuro");
        uno.setAnoFabricacao(1995);
        uno.setValor(1500.55);
        uno.setPlaca("GLI2426");
        
        Conexao conexao = new Conexao();
        conexao.conectar();
        
        CarroDao dao = new CarroDao(conexao);
        dao.inserir(uno);
        
        conexao.fechar();
        
    }
    
}
