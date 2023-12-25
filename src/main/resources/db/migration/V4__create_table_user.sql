
create table if not exists users(
    id bigserial primary key ,
    user_name text not null ,
    name text not null ,
    last_name text not null ,
    phone_number text not null
);