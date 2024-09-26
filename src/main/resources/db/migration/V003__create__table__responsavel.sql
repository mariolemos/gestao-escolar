create table `RESPONSAVEL`(
    ID bigint not null auto_increment primary key,
    NOME VARCHAR(30),
    PARENTESCO VARCHAR(20),
    CONTRATO_ID bigint,
    FOREIGN KEY (CONTRATO_ID) REFERENCES CONTRATO(ID),
    ALUNO_ID bigint,
    FOREIGN KEY (ALUNO_ID) REFERENCES ALUNO(ID)
);

