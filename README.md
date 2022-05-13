# hibernate-jpa
Persistência com JPA - Introdução ao Hibernate

Hibernate: biblioteca criada como alternativa ao JDBC/EJB 2
JPA: Especificação para ORM (Object Relational Mapping) </br> em Java e tem Hibernate como uma de suas implementações.

### Persistence.xml
Este arquivo define uma ou mais persistência (Banco de dados) onde você configura coisas como:
* nome de cada unidade de persistência
* Classes de persistência gerenciadas fazem parte de uma unidade persistência
* como criar e validar o esquema de banco de dados, etc

### Atributos que podemos mapear sem a necessidade de configurações adicionais via anotações JPA:
* Tipos primitivos
* Atributos do tipo String
* Algumas classes como: LocalDate e BigDecimal

Atributos como enun precisam da anotação @Enumerated(EnumType.STRING) e a forma como deseja salvar (ordem ou nome)

### Mapeando relacionamentos
Anotações das cardinalidades:
* @ManyToOne - muitos para um
* @ManyToMany - muitos para muitos
* @OneToMany - um para muitos
* @OneToOne - um para um

É obrigatório adicionar alguma anotação de cardinalidade em todos os atributos que representam relacionamentos

### Estado no insert da entidade
* **Transient:** quando o objeto da entidade é instanciado mas não está sendo gerenciado pela JPA
* **Managed:** é quando o objeto da entidade passa a ser gerenciado pela JPA, quando é chamado o método _persist()_
* **BD:** é quando é feito o _commit() ou flush()_, o objeto vai ser salvo no banco de dados
* **Detached:** é quando a conexão do banco de dados é encerrada com o método _close()_ ou _clear()_

## Estado no update da entidade
