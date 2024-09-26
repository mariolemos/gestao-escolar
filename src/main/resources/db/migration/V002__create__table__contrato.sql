create table `CONTRATO`(

    ID bigint not null auto_increment primary key,
    VALOR_CONTRATUAL DOUBLE,
    DATA_PAGAMENTO DATE,
    FORMA_PAGAMENTO VARCHAR(15),
    DATA_INICIAL DATE,
    DATA_FINAL DATE,
    ATIVO BOOLEAN,
    ALUNO_ID bigint,
    FOREIGN KEY (ALUNO_ID) REFERENCES ALUNO(ID)
    );

