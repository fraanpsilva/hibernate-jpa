package br.com.fpsilva.loja.testes;

import br.com.fpsilva.loja.modelo.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CadastroDeProduto {
    public static void main(String[] args) {

        Produto p1 = new Produto();
        p1.setNome("Xiaomi Redmi");
        p1.setDescricao("Muito Legal");
        p1.setPreco(new BigDecimal("800"));

        // fazendo a conexão com o banco de dados
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("loja"); // o parametro é o que está la no persistence-unity
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin(); // chamando a transação
        em.persist(p1); // fazendo inserte na tabela de produto
        em.getTransaction().commit(); // fazendo commit no banco

        em.close(); // fechando a conexão


        //


    }
}
