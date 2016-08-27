CREATE SCHEMA `shopping`
  DEFAULT CHARACTER SET utf8;

-- 用户角色表
CREATE TABLE `shopping`.`role` (
  `ROLE_ID`  INT NOT NULL AUTO_INCREMENT,
  `ROLENAME` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`ROLE_ID`)
);

-- 用户表
CREATE TABLE `shopping`.`users` (
  `USER_ID`                INT         NOT NULL AUTO_INCREMENT,
  `ROLE_ID`           INT    NOT NULL,
  `USERNAME`          VARCHAR(30) NOT NULL,
  `REALNAME`          VARCHAR(30) NULL,
  `PASSWORD`          VARCHAR(30) NOT NULL,
  `PWD_QUESTION`       VARCHAR(50) NULL,
  `PWD_QUESTION_ANSWER` VARCHAR(50) NULL,
  `ADDRESS`           VARCHAR(50) NULL,
  `PHONENO`           VARCHAR(50) NULL,
  `EMAIL`             VARCHAR(50) NULL,
  PRIMARY KEY (`USER_ID`),
  UNIQUE INDEX `USERNAME_UNIQUE` (`USERNAME` ASC),
  CONSTRAINT `FK_ROLE`
  FOREIGN KEY (`ROLE_ID`)
  REFERENCES `shopping`.`ROLE` (`ROLE_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- 商品目录表
CREATE TABLE `shopping`.`category` (
  `CATEGORY_ID`           INT         NOT NULL AUTO_INCREMENT,
  `CATEGORY_NAME` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`CATEGORY_ID`)
);

-- 商品表
CREATE TABLE `shopping`.`goods` (
  `GOODS_ID`          INT            NOT NULL AUTO_INCREMENT,
  `GOODS_NAME`   VARCHAR(50)    NOT NULL,
  `DESCRIPTION` VARCHAR(200)   NULL,
  `PRICE`       DECIMAL(10, 2) NOT NULL,
  `CATEGORY_ID`  INT            NOT NULL,
  `IMGURL`      VARCHAR(50)    NULL,
  PRIMARY KEY (`GOODS_ID`)
);
ALTER TABLE `shopping`.`goods`
ADD CONSTRAINT `FK_GOODS_CATEGORY`
FOREIGN KEY (`CATEGORY_ID`)
REFERENCES `shopping`.`category` (`CATEGORY_ID`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

-- 购物车表
CREATE TABLE `shopping`.`shopping_cart` (
  `SHOPPINGCART_ID` INT NOT NULL auto_increment,
  `USER_ID` INT NULL,
  `GOODSNUM` INT NULL,
  `SUBTOTAL` DECIMAL(10,2) NULL,
  PRIMARY KEY (`SHOPPINGCART_ID`),
  UNIQUE INDEX `user_id_UNIQUE` (`USER_ID` ASC));
ALTER TABLE `shopping`.`shopping_cart`
ADD CONSTRAINT `FK_USER`
FOREIGN KEY (`USER_ID`)
REFERENCES `shopping`.`users` (`USER_ID`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

-- 购物车详情表
CREATE TABLE `shopping`.`shopping_cart_detail` (
  `SHOPPINGCART_DETAIL_ID` INT NOT NULL,
  `SHOPPINGCART_ID` INT NOT NULL,
  `GOODS_ID` INT NOT NULL,
  `NUM` INT NOT NULL,
  PRIMARY KEY (`SHOPPINGCART_DETAIL_ID`),
  CONSTRAINT `FK_SHOPPING_CART`
  FOREIGN KEY (`SHOPPINGCART_ID`)
  REFERENCES `shopping`.`shopping_cart` (`SHOPPINGCART_ID`),
  CONSTRAINT `FK_GOODS`
  FOREIGN KEY (`GOODS_ID`)
  REFERENCES `shopping`.`goods` (`GOODS_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- 订单表
CREATE TABLE `shopping`.`orders` (
  `ORDER_ID`   INT            NOT NULL AUTO_INCREMENT,
  `USERNAME`   VARCHAR(30)    NOT NULL,
  `NUM`        INT            NOT NULL,
  `SUM`        DECIMAL(10, 2) NOT NULL,
  `createTime` DATE           NOT NULL,
  PRIMARY KEY (`ORDER_ID`)
);

-- 订单详情表
CREATE TABLE `shopping`.`orders_details` (
  `ORDER_DETAIL_ID`        INT            NOT NULL AUTO_INCREMENT,
  `ORDER_ID`  INT            NOT NULL,
  `GOODS_NAME` VARCHAR(50)    NOT NULL,
  `PRICE`     DECIMAL(10, 2) NOT NULL,
  `NUM`       INT            NOT NULL,
  PRIMARY KEY (`ORDER_DETAIL_ID`)
);

ALTER TABLE `shopping`.`orders_details`
ADD CONSTRAINT `FK_DETAILS_ORDER`
FOREIGN KEY (`ORDER_ID`)
REFERENCES `shopping`.`orders` (`ORDER_ID`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
