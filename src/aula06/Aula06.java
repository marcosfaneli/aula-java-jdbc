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

        Conexao c = new Conexao();
        c.conectar();
        
        CarroDao dao = new CarroDao(c);
        
        Carro uno = dao.ler(999);
        
        System.out.println(uno.getPlaca());
        
        c.fechar();
        
    }
    
}
