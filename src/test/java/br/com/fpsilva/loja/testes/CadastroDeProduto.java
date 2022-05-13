package br.com.fpsilva.loja.testes;

import br.com.fpsilva.loja.dao.CategoriaDao;
import br.com.fpsilva.loja.dao.ProdutoDao;
import br.com.fpsilva.loja.modelo.Categoria;
import br.com.fpsilva.loja.modelo.Produto;
import br.com.fpsilva.loja.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CadastroDeProduto {
    public static void main(String[] args) {

        Categoria categoria1 = new Categoria("CELULARES");
        Produto p1 = new Produto("Xiaomi Redmi",
                "Muito Legal", new BigDecimal("800"), categoria1);

        EntityManager em = JpaUtil.getEntityManager();
        CategoriaDao categoriaDao = new CategoriaDao(em);
        ProdutoDao produtoDao = new ProdutoDao(em);

        em.getTransaction().begin(); // chamando a transação
        categoriaDao.cadastrar(categoria1); // cadastrando a categoria
        produtoDao.cadastrar(p1);// cadastrando um produto
        em.getTransaction().commit(); // fazendo commit no banco

        em.close(); // fechando a conexão

    }
}
