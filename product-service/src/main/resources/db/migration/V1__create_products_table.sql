CREATE TABLE products
(
    id          bigint not null,
    name        text   not null,
    description text   not null,
    images_url  text[], -- This should not reference the image table directly
    size        numeric,
    genders      text[], -- You might want to use an enum or a separate table for gender
    price       numeric,
    created_at  timestamp,
    updated_at  timestamp,
    primary key (id)
);

CREATE TABLE images
(
    id         bigint not null,
    image_url  text   not null,
    product_id bigint,
    foreign key (product_id) references products (id) on delete cascade,
    primary key (id)
);
