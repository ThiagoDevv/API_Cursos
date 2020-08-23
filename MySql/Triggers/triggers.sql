/* triggers */


DELIMITER $
create trigger Pessoa_Curso after insert
on Pessoa
for each row
begin
    
	insert into Pessoa_Cursos values(new.IdPessoa, new.IdCursos);
    
end $

DELIMITER ;