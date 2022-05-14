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
import java.util.List;

public class CadastroDeProduto {
    public static void main(String[] args) {

        cadastrarProduto();

        // fazendo consultas no banco - ex 1
        EntityManager em = JpaUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        Produto p = produtoDao.buscarPorId(1l);
        System.out.println(p.getPreco());

        // fazendo consulta - ex 2
        List<Produto> todos = produtoDao.buscarTodos();
        todos.forEach(p2 -> System.out.println(p.getNome()));

        // fazendo consultas com filtros
        List<Produto> todos2 = produtoDao.buscarPorNome("Xiaomi Redmi");
        todos.forEach(p2 -> System.out.println(p.getNome()));

        // fazendo consultas com filtros
        List<Produto> todos3 = produtoDao.buscarPorNomeDaCategoria("CELULARES");
        todos.forEach(p2 -> System.out.println(p.getNome()));

        BigDecimal precoDoProduto = produtoDao.buscarPrecoDoProdutoComNome("Xiaomi Redmi");
        System.out.println("Preço do produto: " + precoDoProduto);

    }

    private static void cadastrarProduto() {
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
