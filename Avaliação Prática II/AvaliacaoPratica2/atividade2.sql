--drop table cliente
CREATE TABLE cliente(
id_cliente serial,
nome varchar(50),
rua varchar(50),
numero integer,
bairro varchar(50),
cidade varchar(50),
estado varchar(2),
cep varchar(9),
cpf varchar(14)unique,
telefone varchar(9),	
idade integer,	
tipoCnh varchar(3),	
tipoCnhAtual varchar(6),	
rg varchar(15),
CONSTRAINT pk_cliente PRIMARY KEY(id_cliente)
)

select * from cliente;

----------------------------------------------------------------------------------------------------

--drop table instrutor
CREATE TABLE instrutor(
id_instrutor serial,
nomeInstrutor varchar(50),
cpfInstrutor varchar(14)unique,
emailInstrutor varchar(50),	
telefoneInstrutor varchar(9),		
CONSTRAINT pk_instrutor PRIMARY KEY(id_instrutor)
)

select * from instrutor;

----------------------------------------------------------------------------------------------------

--drop table veiculo
CREATE TABLE veiculo(
placa varchar(7),
modelo varchar(50),
tipo varchar(50),
CONSTRAINT pk_veiculo PRIMARY KEY(placa)
)


select * from veiculo;

----------------------------------------------------------------------------------------------------

--drop table veiculoinstrutor
CREATE TABLE veiculoinstrutor(
id_instrutor serial,
placa varchar(7),
FOREIGN KEY (id_instrutor) references instrutor (id_instrutor),
FOREIGN KEY (placa) references veiculo (placa),
CONSTRAINT pk_veiculoinstrutor PRIMARY KEY(id_instrutor,placa)	
)

select * from veiculoinstrutor

