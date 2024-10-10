update budget set type = 'Расход' where type = 'Комиссия';
create table author
(
    id serial primary key,
    fio varchar(256) not null,
    creation_date timestamp not null
);
alter table budget add column author_id integer;
alter table budget add constraint FK_author_id foreign key (author_id) references author (id);
