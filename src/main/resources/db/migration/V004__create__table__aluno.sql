create table `ALUNO`(

    ID bigint not null auto_increment primary key,
    NOME VARCHAR(30),
    DATA_NASCIMENTO DATE,
    CPF VARCHAR(15),
    RG VARCHAR(15),
    TURNO varchar(15),
    SERIE VARCHAR(15),
    TURMA VARCHAR(10),
    NOME_DO_PAI varchar(30),
    NOME_DA_MAE VARCHAR(30),
    CONVENIO_MEDICO VARCHAR(20),
    ATIVO boolean,
    COLEGIO_ID bigint,
    RESPONSAVEL_ID bigint,
    FOREIGN KEY (COLEGIO_ID) REFERENCES COLEGIO(ID),
    FOREIGN KEY (RESPONSAVEL_ID) REFERENCES RESPONSAVEL(ID)
    );

