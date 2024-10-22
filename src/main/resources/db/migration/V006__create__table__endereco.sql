create table `ENDERECO`(

    ID bigint not null auto_increment primary key,
    LOGRADOURO VARCHAR(100),
    NUMERO VARCHAR(10),
    COMPLEMENTO VARCHAR(100),
    BAIRRO VARCHAR(50),
    CEP VARCHAR(15),
    CIDADE VARCHAR(50),
    ESTADO VARCHAR(30)
    );

