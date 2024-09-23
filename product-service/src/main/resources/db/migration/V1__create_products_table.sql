CREATE TABLE products
(
    id          bigint not null,
    name        text   not null,
    description text   not null,
    images_url  text[],
    size        numeric,
    gender      text[],
    price       numeric,
    created_at  timestamp,
    updated_at  timestamp,
    primary key (id)
)

CREATE TABLE image
(
    id         bigint not null,
    image_url  text   not null,
    product_id bigint,
    foreign key (id) references products (id) on delete cascade,
    primary key (id)
)