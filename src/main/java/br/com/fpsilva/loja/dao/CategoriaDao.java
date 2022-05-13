package br.com.fpsilva.loja.dao;

import br.com.fpsilva.loja.modelo.Categoria;
import br.com.fpsilva.loja.modelo.Produto;

import javax.persistence.EntityManager;

public class CategoriaDao {

    private EntityManager em;

    public CategoriaDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Categoria categoria){
        this.em.persist(categoria); // fazendo inserte na tabela de produto
    }
}
