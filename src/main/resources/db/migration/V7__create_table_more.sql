create table item(
                         id bigserial primary key ,
                         title text not null ,
                         type text not null ,
                         status  bool not null ,
                         amount bigint not null
);
create table photo(
                         id bigserial primary key ,
                         name text not null ,
                         description text not null
);
create table comment(
                      id bigserial primary key ,
                      uploaded_date pg_catalog.timestamp not null ,
                      description text not null
);
create table advertising(
                        id bigserial primary key ,
                        title text  not null ,
                        description text not null,
                        price bigint not null
);

create table working_hours(
                        start_time  time primary key ,
                        end_time time  not null ,
                        holidays bool not null,
                        fulltime bool not null
);