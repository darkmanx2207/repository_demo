CREATE SCHEMA IF NOT EXISTS shoppinglist DEFAULT CHARACTER SET utf8;
USE shoppinglist;

CREATE TABLE IF NOT EXISTS products
(
  id              BIGINT not null auto_increment primary key,
  name            varchar(255),
  price           decimal(19, 2),
  actualPrice     decimal(19, 2),
  description     varchar(255),
  discount        decimal(19, 2),
  productCategory varchar(255)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1002;