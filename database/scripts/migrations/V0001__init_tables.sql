CREATE TABLE IF NOT EXISTS users
(
    id       BIGSERIAL PRIMARY KEY,
    password VARCHAR(50),
    login    VARCHAR(30)
);
