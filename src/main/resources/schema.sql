CREATE TABLE if not exists candidato
(
  id serial primary key ,
  nome varchar(255) not null
);

create table if not exists voto
(
    id serial primary key ,
    id_candidato bigint not null ,
    data_hora timestamp default current_timestamp,
    foreign key (id_candidato) references candidato (id)
);