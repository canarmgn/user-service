create table public.users(
    id bigint auto_increment primary key not null,
    name varchar(255),
    surname varchar(255),
    email varchar(255),
    phone varchar(255)
)