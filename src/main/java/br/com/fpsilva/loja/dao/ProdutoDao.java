package br.com.fpsilva.loja.dao;

import br.com.fpsilva.loja.modelo.Produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProdutoDao {

    private EntityManager em;

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Produto produto){
        this.em.persist(produto); // fazendo inserte na tabela de produto
    }

    public Produto buscarPorId(Long id){
        return em.find(Produto.class, id);
    }

    // utilizando JPQL
    public List<Produto> buscarTodos(){
        String jpql = "SELECT p FROM Produto p ";
        return em.createQuery(jpql, Produto.class).getResultList();

    }

    // metodo com namedParameter
    public List<Produto> buscarPorNome(String nomeProduto){
        String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
        return em.createQuery(jpql, Produto.class)
                .setParameter("nome", nomeProduto)
                .getResultList();

    }

    // metodo com interrogação
    public List<Produto> buscarPorNome2(String nomeProduto){
        String jpql = "SELECT p FROM Produto p WHERE p.nome = ?1";
        return em.createQuery(jpql, Produto.class)
                .setParameter(1, nomeProduto)
                .getResultList();

    }


    // consulta com join (o join é automático)
    public List<Produto> buscarPorNomeDaCategoria(String nomeCategoria){
        String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :nome";
        return em.createQuery(jpql, Produto.class)
                .setParameter("nome", nomeCategoria)
                .getResultList();

    }

    // limitando dados em uma consulta
    public BigDecimal buscarPrecoDoProdutoComNome(String nome){
        String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :nome";
        return em.createQuery(jpql, BigDecimal.class)
                .setParameter("nome", nome)
                .getSingleResult();

    }

}
