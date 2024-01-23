create table if not exists businesses
(
    id  bigserial primary key,
    name text not null,
    description text ,
    phone_number text not null,
    address text not null,
    business_ownerID bigint references business_owners(id)

);

create table if not exists business_owners(
    id  bigserial primary key  ,
    name text not null,
    last_name text not null ,
    national_code text not null unique ,
    phone_number text not null
);

create table if not exists users(
    id bigserial primary key ,
    user_name text unique not null  ,
    password text not null,
    first_name text not null,
    last_name text not null ,
    phone_number  text not null
);

create table if not exists advertising
(
    id  bigserial primary key,
    title text not null,
    description text ,
    price decimal not null,
    business_id bigint references businesses(id)

);

create table if not exists articles
(
    id bigserial primary key ,
    title text not null,
    description text not null,
    writer  text not null,
    created_at timestamp not null

);

create table if not exists business_articles
(
    id bigserial primary key ,
    business_id bigint references businesses(id),
    article_id bigint references articles(id)
);

create table if not exists categories(
    id bigserial primary key,
    title text not null,
    tag text not null
);

create table if not exists business_categories
(
    id bigserial primary key ,
    business_id bigint references businesses(id),
    category_id bigint references categories(id)
);


create table if not exists comments
(
    id bigserial primary key,
    description text not null,
    uploaded_at timestamp not null,
    business_id bigint references businesses(id),
    user_id bigint references users(id)
);



create table if not exists items
(
    id bigserial primary key,
    title text not null,
    quantity integer,
    status bool not null,
    tag text,
    business_id bigint references businesses(id)
);




create table if not exists working_hours(
    id bigserial primary key,
    start_time time not null,
    end_time time not null,
    holy_days bool not null,
    full_time bool not null,
    business_id bigint references businesses(id)

);



create table if not exists article_categories
(
    id bigserial primary key ,
    article_id bigint references articles(id),
    category_id bigint references categories(id)
    );


create table if not exists item_categories
(
    id bigserial primary key ,
    item_id bigint references items(id),
    category_id bigint references categories(id)
);