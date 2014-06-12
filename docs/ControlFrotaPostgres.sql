
    alter table cidade 
        drop constraint FKAEE6572471219D83

    alter table endereco 
        drop constraint FK672D67C96925D8FF

    alter table motorista 
        drop constraint FKE7FA6F0C3F7D7F53

    alter table motoristaVeiculo 
        drop constraint FK37093636D66A401

    alter table motoristaVeiculo 
        drop constraint FK370936388AA8C47

    alter table notaabastecimento 
        drop constraint FK963CCEB9C2C81A07

    alter table notaabastecimento 
        drop constraint FK963CCEB988AA8C47

    alter table perfilusuario 
        drop constraint FKA0A92BE24FF61285

    alter table perfilusuario 
        drop constraint FKA0A92BE2951FFE4F

    alter table pessoa 
        drop constraint FKC4E40FA768142889

    alter table pessoafisica 
        drop constraint FK3D9946DE71219D83

    alter table pessoafisica 
        drop constraint FK3D9946DE95214A05

    alter table pessoajuridica 
        drop constraint FK54FE480C95214A05

    alter table posto 
        drop constraint FK65E7BCFF7373F8A

    alter table rota 
        drop constraint FK35816A89100DD

    alter table usuario 
        drop constraint FKF814F32E3F7D7F53

    drop table cidade

    drop table endereco

    drop table estado

    drop table motorista

    drop table motoristaVeiculo

    drop table notaabastecimento

    drop table perfil

    drop table perfilusuario

    drop table pessoa

    drop table pessoafisica

    drop table pessoajuridica

    drop table posto

    drop table rota

    drop table usuario

    drop table veiculo

    drop sequence enderecoSequence

    drop sequence motoristaSequence

    drop sequence motoristaVeiculoSequence

    drop sequence notaSequence

    drop sequence perfilSequence

    drop sequence pessoaSequence

    drop sequence postoSequence

    drop sequence rotaSequence

    drop sequence usuarioSequence

    drop sequence veiculoSequence

    create table cidade (
        codigoCidade int4 not null,
        nome varchar(255),
        estado int4,
        primary key (codigoCidade)
    )

    create table endereco (
        codigoEndereco int4 not null,
        bairro varchar(255),
        cep int4,
        complemento varchar(255),
        logradouro varchar(255),
        numero varchar(255),
        cidade int4,
        primary key (codigoEndereco)
    )

    create table estado (
        codigoEstado int4 not null,
        nome varchar(255),
        uf varchar(2) unique,
        primary key (codigoEstado)
    )

    create table motorista (
        codigoMotorista int4 not null,
        categoriaCnh varchar(3),
        cnh int8 unique,
        dataAdmissao date,
        dataValidadeCnh date,
        observacao varchar(255),
        pessoaFisica int4,
        primary key (codigoMotorista)
    )

    create table motoristaVeiculo (
        codigoMotoristaVeiculo int4 not null,
        ativo bool,
        dataFim timestamp,
        dataInicio timestamp,
        observacao varchar(255),
        motorista int4,
        veiculo int4,
        primary key (codigoMotoristaVeiculo)
    )

    create table notaabastecimento (
        codigoNota int4 not null,
        combustivel varchar(255),
        dataAbastecimento date,
        kilometragemFinal int8,
        kilometragemInicial int8,
        quantidadeLitro int8,
        valorLitro float8,
        posto int4,
        veiculo int4,
        primary key (codigoNota)
    )

    create table perfil (
        codigoPerfil int4 not null,
        descricao varchar(255),
        primary key (codigoPerfil)
    )

    create table perfilusuario (
        usuario int4 not null,
        perfil int4 not null
    )

    create table pessoa (
        codigoPessoa int4 not null,
        nome varchar(255),
        telefone varchar(255),
        endereco int4,
        primary key (codigoPessoa)
    )

    create table pessoafisica (
        celular varchar(255),
        cpf int8 unique,
        dataExpedicaoRg date,
        dataNascimento date,
        estadoCivil varchar(255),
        orgaoEmissor varchar(255),
        rg numeric(19, 2) unique,
        sexo varchar(1),
        pessoa int4 not null,
        estado int4,
        primary key (pessoa)
    )

    create table pessoajuridica (
        cnpj int8,
        fax varchar(255),
        inscricaoEstadual int8,
        inscricaoMunicipal int8,
        pessoa int4 not null,
        primary key (pessoa)
    )

    create table posto (
        codigoPosto int4 not null,
        registroFuncionamento int8 unique,
        pessoa int4,
        primary key (codigoPosto)
    )

    create table rota (
        codigoRota int4 not null,
        dataAgendada timestamp,
        dataCancelamento timestamp,
        horaFinal timestamp,
        horaInicial timestamp,
        observacao varchar(255),
        realizada bool,
        motoristaVeiculo int4,
        primary key (codigoRota)
    )

    create table usuario (
        codigoUsuario int4 not null,
        ativo bool,
        login varchar(255),
        senha varchar(255),
        pessoaFisica int4,
        primary key (codigoUsuario)
    )

    create table veiculo (
        codigoVeiculo int4 not null,
        ano int4,
        categoria varchar(3),
        cor varchar(45),
        marca varchar(45),
        modelo varchar(45),
        observacao varchar(255),
        placa varchar(7) unique,
        primary key (codigoVeiculo)
    )

    alter table cidade 
        add constraint FKAEE6572471219D83 
        foreign key (estado) 
        references estado

    alter table endereco 
        add constraint FK672D67C96925D8FF 
        foreign key (cidade) 
        references cidade

    alter table motorista 
        add constraint FKE7FA6F0C3F7D7F53 
        foreign key (pessoaFisica) 
        references pessoafisica

    alter table motoristaVeiculo 
        add constraint FK37093636D66A401 
        foreign key (motorista) 
        references motorista

    alter table motoristaVeiculo 
        add constraint FK370936388AA8C47 
        foreign key (veiculo) 
        references veiculo

    alter table notaabastecimento 
        add constraint FK963CCEB9C2C81A07 
        foreign key (posto) 
        references posto

    alter table notaabastecimento 
        add constraint FK963CCEB988AA8C47 
        foreign key (veiculo) 
        references veiculo

    alter table perfilusuario 
        add constraint FKA0A92BE24FF61285 
        foreign key (usuario) 
        references usuario

    alter table perfilusuario 
        add constraint FKA0A92BE2951FFE4F 
        foreign key (perfil) 
        references perfil

    alter table pessoa 
        add constraint FKC4E40FA768142889 
        foreign key (endereco) 
        references endereco

    alter table pessoafisica 
        add constraint FK3D9946DE71219D83 
        foreign key (estado) 
        references estado

    alter table pessoafisica 
        add constraint FK3D9946DE95214A05 
        foreign key (pessoa) 
        references pessoa

    alter table pessoajuridica 
        add constraint FK54FE480C95214A05 
        foreign key (pessoa) 
        references pessoa

    alter table posto 
        add constraint FK65E7BCFF7373F8A 
        foreign key (pessoa) 
        references pessoajuridica

    alter table rota 
        add constraint FK35816A89100DD 
        foreign key (motoristaVeiculo) 
        references motoristaVeiculo

    alter table usuario 
        add constraint FKF814F32E3F7D7F53 
        foreign key (pessoaFisica) 
        references pessoafisica

    create sequence enderecoSequence

    create sequence motoristaSequence

    create sequence motoristaVeiculoSequence

    create sequence notaSequence

    create sequence perfilSequence

    create sequence pessoaSequence

    create sequence postoSequence

    create sequence rotaSequence

    create sequence usuarioSequence

    create sequence veiculoSequence
