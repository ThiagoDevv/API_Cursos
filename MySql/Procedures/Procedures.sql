/* procedimentos */


/* CADASTRO DE UMA PESSOA EM UM CURSO */

DELIMITER &
CREATE PROCEDURE add_pessoa_telefone_curso (in id int, in IdCurso int, in nome varchar(30),
											in cpf varchar(14), in tipo char(3),
                                            in numero varchar(15), in curso varchar(30))
	begin
		Insert into pessoa value(id, nome, cpf);
		insert into Telefones values(null, tipo, numero, id);
        insert into cursos values(IdCurso, curso);
        insert into Pessoa_Cursos values(id, IdCurso);
	End &
 DELIMITER ;
 
 
 drop procedure add_pessoa_telefone_curso;
 
 
call add_pessoa_telefone_curso(1, 1, 'Thiago', '4324257232', 'cel', '42354464578', 'Computação');
 
 
 /* SELECIONAR O IDPESSOA, NOME E CPF DE PESSOA */ 
 
DELIMITER $
CREATE PROCEDURE Select_Todas_Pessoas()
begin

	select IdPessoa, nome, cpf
    from pessoa;

end $
DELIMITER ;

/* FAZER UM UPDATE EM PESSOA */


DELIMITER $
CREATE PROCEDURE Update_Pessoas(P_IdPessoa int,
								novo_nome varchar(30),
                                novo_cpf varchar(15),
                                P_IdTelefones int,
                                novo_numero varchar(30),
                                novo_tipo char(3))
begin

	update pessoa 
    set nome = novo_nome, cpf = novo_cpf
    where IdPessoa = P_IdPessoa;
    
    update telefones
    set numero = novo_numero, tipo = novo_tipo
    where IdTelefones = P_IdTelefones;

end $
DELIMITER ;


/* DELETAR UMA PESSOA PELO ID */

DELIMITER $
CREATE PROCEDURE Delete_Pessoa(P_IdPessoa int)
begin
	
	delete from Pessoa_Cursos
    where IdPessoa = P_IdPessoa;
    
    delete from telefones
    where Id_Pessoa = P_IdPessoa;
    
    delete from pessoa
    where IdPessoa = P_IdPessoa;
    
    delete from cursos
    where P_IdPessoa = IdCursos;
	

end $
DELIMITER ;


call Delete_Pessoa(1);

DELIMITER $
create procedure select_cursos()
begin
	select IdCursos, nome
    from cursos;

end $
DELIMITER ;



select * from pessoa;
 
select * from Pessoa_Cursos; 
 
select * from cursos;
  
select * from telefones;
 
 
 delete from Pessoa_Cursos;
 
 delete from pessoa;
 
 delete from telefones;
 
 delete from cursos;

 
 


 
 
 
 
 
 
 
 
 
 
 
 
 