package br.com.fpsilva.loja.testes;

import br.com.fpsilva.loja.dao.ProdutoDao;
import br.com.fpsilva.loja.modelo.Produto;
import br.com.fpsilva.loja.util.JpaUtil;

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


        EntityManager em = JpaUtil.getEntityManager();
        ProdutoDao dao = new ProdutoDao(em);


        em.getTransaction().begin(); // chamando a transação
        dao.cadastrar(p1);
        em.getTransaction().commit(); // fazendo commit no banco

        em.close(); // fechando a conexão


        //


    }
}
