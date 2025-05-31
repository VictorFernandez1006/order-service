CREATE TABLE orders (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        product_id BIGINT NOT NULL,
                        product_name VARCHAR(255),
                        product_price DOUBLE
);
