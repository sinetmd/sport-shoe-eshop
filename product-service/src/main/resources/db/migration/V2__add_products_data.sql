INSERT INTO products(product_code, name, category, brand, size, description, color, price, stock)
VALUES ('NIKE-PEG-38-BLACK-42', 'Nike Pegasus', 'MALE', 'Nike', 42,
        'Nike Pegasus running shoes, ideal for everyday running.', 'Black', 119.99, 200),
       ('ADIDAS-UB-40-WHITE-42', 'Adidas Ultraboost', 'MALE', 'Adidas', 42,
        'Stylish and comfortable Adidas Ultraboost shoes.', 'White', 179.99, 120),
       ('PUMA-RSX-36-GREY-38', 'Puma RS-X', 'FEMALE', 'Puma', 38, 'Trendy Puma RS-X sneakers for casual wear.', 'Grey',
        99.99, 150),
       ('REEBOK-CLASSIC-37-BEIGE-39', 'Reebok Classic', 'UNISEX', 'Reebok', 39,
        'Classic Reebok sneakers for all seasons.', 'Beige', 69.99, 180),
       ('ASICS-GK-39-BLUE-41', 'Asics Gel-Kayano', 'MALE', 'Asics', 41, 'Supportive Asics Gel-Kayano running shoes.',
        'Blue', 149.99, 130),
       ('NEWBALANCE-FF-41-RED-40', 'New Balance Fresh Foam', 'FEMALE', 'New Balance', 40,
        'Lightweight Fresh Foam shoes for superior comfort.', 'Red', 129.99, 110);

INSERT INTO product_images(image_url, is_main, product_id)
VALUES ('https://example.com/images/nikeshoes-black.jpg', TRUE, 1),          -- Nike Pegasus
       ('https://example.com/images/nikeshoes-black-side.jpg', FALSE, 1),
       ('https://example.com/images/adidas-ultraboost-white.jpg', TRUE, 2),  -- Adidas Ultraboost
       ('https://example.com/images/adidas-ultraboost-white-back.jpg', FALSE, 2),
       ('https://example.com/images/puma-rsx-grey.jpg', TRUE, 3),            -- Puma RS-X
       ('https://example.com/images/puma-rsx-grey-side.jpg', FALSE, 3),
       ('https://example.com/images/reebok-classic-beige.jpg', TRUE, 4),     -- Reebok Classic
       ('https://example.com/images/reebok-classic-beige-side.jpg', FALSE, 4),
       ('https://example.com/images/asics-gel-kayano-blue.jpg', TRUE, 5),    -- Asics Gel-Kayano
       ('https://example.com/images/asics-gel-kayano-blue-back.jpg', FALSE, 5),
       ('https://example.com/images/newbalance-freshfoam-red.jpg', TRUE, 6), -- New Balance Fresh Foam
       ('https://example.com/images/newbalance-freshfoam-red-side.jpg', FALSE, 6);
