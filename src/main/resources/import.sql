
insert into Pessoa (tipo_pessoa, id, email, nome, telefone, cnpj, inscricaoestadual, inscricaomunicipal, razaosocial ) values ('PJ', 101, 'teste2@teste.com', 'testenome-PJ', '(54)9 3444-9000', '0001000019000', '08880000008808880', '444445554555', 'razaosocial');
insert into Pessoa (tipo_pessoa, id, email, nome, telefone, cnpj, inscricaoestadual, inscricaomunicipal, razaosocial ) values ('PJ', 102, 'teste2@teste.com', 'testenome-PJ', '(54)9 3444-9000', '0001000019000', '08880000008808880', '444445554555', 'razaosocial');
insert into Pessoa (tipo_pessoa, id, email, nome, telefone, cpf, dataNascimento, rg, sexo, cnpj, inscricaoestadual, inscricaomunicipal, endereco_id) values ('PF', 103, 'john.smith@mailinator.com', 'John', '54999999999', '11111111111', current_date(), '1111111111', 'M', '', '', '', null);
insert into Pessoa (tipo_pessoa, id, email, nome, telefone, cpf, dataNascimento, rg, sexo, cnpj, inscricaoestadual, inscricaomunicipal, endereco_id) values ('PF', 304, 'fulano.bitcho@mailinator.com', 'Fulano', '54888888888', '22222222222', current_date(), '2222222222', 'M', '', '', '', null);
insert into Pessoa (tipo_pessoa, id, email, nome, telefone, cpf, dataNascimento, rg, sexo, cnpj, inscricaoestadual, inscricaomunicipal, endereco_id) values ('PF', 405, 'edgar.dti@mailinator.com', 'Edgar', '54333333333', '33333333333', current_date(), '3333333333', 'M', '', '', '', null);
insert into Pessoa (tipo_pessoa, id, email, nome, telefone, cpf, dataNascimento, rg, sexo, cnpj, inscricaoestadual, inscricaomunicipal, endereco_id) values ('PJ', 506, 'john.smith@mailinator.com', 'John', '54999999999', '', current_date(), '1111111111', 'M', '11111111111111', '', '', null);
insert into Pessoa (tipo_pessoa, id, email, nome, telefone, cpf, dataNascimento, rg, sexo, cnpj, inscricaoestadual, inscricaomunicipal, endereco_id) values ('PJ', 607, 'fulano.bitcho@mailinator.com', 'Fulano', '54888888888', '', current_date(), '2222222222', 'M', '22222222222222', '', '', null);

insert into Pessoa (tipo_pessoa, id, email, nome, telefone, cpf, sexo) values ('PF', 908, 'teste@teste.com', 'testenome', '(54)9 9999-9999', '02107505020', 'M');
insert into Pessoa (tipo_pessoa, id, email, nome, telefone, cpf, sexo) values ('PF', 809, 'teste@teste.com', 'testenome', '(54)9 9999-9999', '02107505020', 'M');

insert into Quarto (id, numero, tipo, disponivel) values (101, 'A201', 'STANDARD', true);
insert into Quarto (id, numero, tipo, disponivel) values (102, 'A301', 'STANDARD', false);
insert into Quarto (id, numero, tipo, disponivel) values (103, 'A201', 'STANDARD', true);
insert into Quarto (id, numero, tipo, disponivel) values (104, 'A301', 'STANDARD', false);
insert into Quarto (id, numero, tipo, disponivel) values (105, 'A401', 'MASTER', false);
insert into Quarto (id, numero, tipo, disponivel) values (106, 'A601', 'STANDARD', true);
insert into Quarto (id, numero, tipo, disponivel) values (107, 'A401', 'STANDARD', false);
insert into Quarto (id, numero, tipo, disponivel) values (108, 'A501', 'STANDARD', true);

insert into Usuario (id, nome, email, senha, sobrenome) values (0, 'John', 'john.smith@mailinator.com', '1234#567', ' Smith');

insert into Diaria (id, tipo_diaria, data, quarto_id, reserva_id, cliente_id) values (101, 'AVULSA', '2018-04-17', 104, null, 101); 
insert into Diaria (id, tipo_diaria, data, quarto_id, reserva_id, cliente_id) values (102, 'AVULSA', '2018-04-17', 105, null, 102);
insert into Diaria (id, tipo_diaria, data, quarto_id, reserva_id, cliente_id) values (103, 'AVULSA', '2018-04-17', 101, null, 103);
