CREATE TABLE if not exists candidatos
(
  id serial primary key ,
  nome varchar(255) not null
);

create table if not exists votos
(
    id serial primary key ,
    id_candidato bigint not null ,
    data_hora timestamp default current_timestamp,
    foreign key (id_candidato) references candidatos(id)
);