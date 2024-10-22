alter table `RESPONSAVEL`
add column ENDERECO_ID bigint,
add foreign key (ENDERECO_ID) references ENDERECO(ID);




