create table `RESPONSAVEL`(
    ID bigint not null auto_increment primary key,
    NOME VARCHAR(30),
    DATA_NASCIMENTO DATE,
    CPF VARCHAR(15),
    RG VARCHAR(20),
    PARENTESCO VARCHAR(20)
);

