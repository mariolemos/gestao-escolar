create table `CONTATO`(

    ID bigint not null auto_increment primary key,
        TIPO_CONTATO VARCHAR(10),
        CONTATO VARCHAR(100),
        COLEGIO_ID bigint,
        RESPONSAVEL_ID bigint,
        ALUNO_ID bigint,
            FOREIGN KEY (COLEGIO_ID) REFERENCES COLEGIO(ID),
            FOREIGN KEY (ALUNO_ID) REFERENCES ALUNO(ID),
            FOREIGN KEY (RESPONSAVEL_ID) REFERENCES RESPONSAVEL(ID)
    );

