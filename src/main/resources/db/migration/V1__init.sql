create table if not exists students(
    id serial not null primary key,
    firstname varchar(250),
    lastname varchar(250),
    age integer
)