INSERT INTO role (name)
VALUES
    ('ADMIN'),
    ('COMMERCANT'),
    ('CLIENT');


INSERT INTO permission (name)
VALUES
    ('USER_READ'),
    ('USER_CREATE'),
    ('USER_UPDATE'),
    ('USER_DELETE'),

    ('PRODUCT_READ'),
    ('PRODUCT_CREATE'),
    ('PRODUCT_UPDATE'),
    ('PRODUCT_DELETE'),

    ('ORDER_READ'),
    ('ORDER_CREATE'),
    ('ORDER_UPDATE'),
    ('ORDER_DELETE');
