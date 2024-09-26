create table `ALUNO`(

    ID bigint not null auto_increment primary key,
    TURNO varchar(15),
    SERIE VARCHAR(15),
    TURMA VARCHAR(10),
    NOME_DO_PAI varchar(30),
    NOME_DA_MAE VARCHAR(30),
    CONVENIO_MEDICO VARCHAR(20),
    ATIVO boolean
    );

