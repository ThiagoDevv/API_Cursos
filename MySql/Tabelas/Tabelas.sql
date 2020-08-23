create database cursos;

use cursos;

create table Pessoa(
	IdPessoa int primary key auto_increment,
    nome varchar(30) not null,
    cpf varchar(14) unique not null
);

/* creiei uma tabela só para telefones pois uma pessoa pode ter mais de 1 */

create table Telefones(
	IdTelefones int primary key auto_increment,
    tipo char(3), 			/* podendo ser celular(cel); comercial(com); residencial(res)*/
    numero varchar(15),
    Id_Pessoa int 			/*chave estrangeira de telefones_Pessoa */
);

create table Cursos(
	IdCursos int primary key auto_increment,
    nome varchar(30) not null
);

create table Pessoa_Cursos(
	IdPessoa int,
    IdCursos int,
    
    CONSTRAINT PK_Pessoa_Cursos PRIMARY KEY(IdPessoa, IdCursos)
);

/* criando as F.K */

alter table Pessoa_Cursos ADD CONSTRAINT
FK_Pessoa_Cursos foreign KEY(IdPessoa)
references Pessoa(IdPessoa);

alter table Pessoa_Cursos ADD CONSTRAINT
FK_Pessoa_Cursos2 foreign KEY(IdCursos)
references cursos(IdCursos);

alter table Telefones ADD constraint
 FK_Telefones_Pessoa foreign key(Id_Pessoa)
 references pessoa(IdPessoa);
 
 



















