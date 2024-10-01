CREATE TABLE products
(
    product_id   BIGSERIAL,
    product_code varchar(100)   NOT NULL UNIQUE,
    name         VARCHAR(100)   NOT NULL,
    category     varchar(20)    NOT NULL,
    brand        VARCHAR(100)   NOT NULL,
    size         FLOAT          NOT NULL,
    description  TEXT           NOT NULL,
    color        VARCHAR(50)    NOT NULL,
    price        DECIMAL(10, 2) NOT NULL,
    stock        INT CHECK (stock >= 0),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP,
    PRIMARY KEY (product_id)
);

CREATE TABLE product_images
(
    image_id     BIGSERIAL,
    image_url    TEXT NOT NULL,
    is_main      BOOLEAN DEFAULT FALSE,
    product_id   INT  NOT NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP,
    FOREIGN KEY (product_id) REFERENCES products (product_id) ON DELETE CASCADE,
    PRIMARY KEY (image_id)
);