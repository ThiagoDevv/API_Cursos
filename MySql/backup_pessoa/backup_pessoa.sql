/* backup lógivo de pessoa */


DELIMITER $
Create trigger backup_pessoa
before delete
on pessoa
for each row
begin 

	insert into bkp_pessoa values(null, old.IdPessoa, old.nome, old.cpf );
	
end $
DELIMITER ;

CREATE table bkp_pessoa(
	Idbkp_pessoa int Primary key auto_increment,
	nome varchar(30) not null,
        cpf varchar(14) unique not null
);
