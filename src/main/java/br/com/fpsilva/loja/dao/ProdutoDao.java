package br.com.fpsilva.loja.dao;

import br.com.fpsilva.loja.modelo.Produto;

import javax.persistence.EntityManager;

public class ProdutoDao {

    private EntityManager em;

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Produto produto){
        this.em.persist(produto); // fazendo inserte na tabela de produto
    }
}
