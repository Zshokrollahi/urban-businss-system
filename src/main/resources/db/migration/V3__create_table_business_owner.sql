
create table business_owner(
    id bigserial primary key ,
    name text not null ,
    last_name text not null ,
    national_code text not null ,
    phone_number text not null
);