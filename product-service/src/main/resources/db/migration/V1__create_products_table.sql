CREATE TABLE products
(
    product_id   BIGSERIAL,
    name         VARCHAR(100)   NOT NULL,
    category     varchar(20)    NOT NULL,
    brand        VARCHAR(100)   NOT NULL,
    size         INT,
    description  TEXT           NOT NULL,
    color        VARCHAR(50),
    price        DECIMAL(10, 2) NOT NULL,
    stock        INT,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP,
    PRIMARY KEY (product_id)
);

CREATE TABLE product_images
(
    image_id   BIGSERIAL,
    image_url  TEXT,
    is_main    BOOLEAN DEFAULT FALSE,
    product_id INT NOT NULL REFERENCES Products (product_id),
    PRIMARY KEY (image_id)
);