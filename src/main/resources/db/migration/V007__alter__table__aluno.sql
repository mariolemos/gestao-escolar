alter table `ALUNO`
add column ENDERECO_ID bigint,
add foreign key (ENDERECO_ID) references ENDERECO(ID);




