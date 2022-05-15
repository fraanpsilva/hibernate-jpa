package br.com.fpsilva.loja.modelo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data = LocalDate.now();
    private BigDecimal valorTotal;

    @ManyToOne
    private Cliente cliente;

    /* mapeamento manytomany simples, onde a tabela tem apenas duas colunas, das duas tabelas que ela referencia
     * Quando temos um relacionamento manyToMany que precisa de mais de duas colunas, o ideal é criar uma nova
     * entidade para representar essa tabela
    */
//    @ManyToMany
//    @JoinTable(name = "itens_pedido")
//    private List<Produto> produtos;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itens = new ArrayList<>(); // boa prática, inicializar a lista de um relacionamento, para evitar ter que fazer muitas validações
    /*
    * Relacionamento bidirecional: relacionamento nas duas pontas
    * Sempre que isso acontecer, temos que indicar que é um relacionamento bidirecional
    * com o MappedBy="com o nome do atributo que tá do outro lado do relacionamento"
    * */


    public Pedido() {
    }

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // vinculando os dois lados do relacionamento - boa prática
    public void adicionarItem(ItemPedido item){
        item.setPedido(this);
        this.itens.add(item);

    }
}
