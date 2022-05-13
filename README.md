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
* @ManyToOne
* @ManyToMany
* @OneToMany
* @OneToOne