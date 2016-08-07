CREATE SCHEMA `shopping`
  DEFAULT CHARACTER SET utf8;

CREATE TABLE `shopping`.`users` (
  `id`                INT         NOT NULL AUTO_INCREMENT,
  `userName`          VARCHAR(30) NOT NULL,
  `realName`          VARCHAR(30) NULL,
  `password`          VARCHAR(30) NOT NULL,
  `pwdQuestion`       VARCHAR(50) NULL,
  `pwdQuestionAnswer` VARCHAR(50) NULL,
  `address`           VARCHAR(50) NULL,
  `phoneNo`           VARCHAR(50) NULL,
  `email`             VARCHAR(50) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `userName_UNIQUE` (`userName` ASC)
);

CREATE TABLE `shopping`.`admin` (
  `adminId`  INT         NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(30) NOT NULL,
  `password` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`adminId`)
);

CREATE TABLE `shopping`.`category` (
  `id`           INT         NOT NULL AUTO_INCREMENT,
  `categoryName` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `shopping`.`goods` (
  `id`          INT            NOT NULL AUTO_INCREMENT,
  `goodsname`   VARCHAR(50)    NOT NULL,
  `description` VARCHAR(200)   NULL,
  `price`       DECIMAL(10, 2) NOT NULL,
  `categoryId`  INT            NOT NULL,
  `imgUrl`      VARCHAR(50)    NULL,
  PRIMARY KEY (`id`)
);

ALTER TABLE `shopping`.`goods`
ADD INDEX `FK_GOODS_CATGORY_idx` (`categoryId` ASC);

ALTER TABLE `shopping`.`goods`
ADD CONSTRAINT `FK_GOODS_CATGORY`
FOREIGN KEY (`categoryId`)
REFERENCES `shopping`.`category` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

CREATE TABLE `shopping`.`orders` (
  `ordersId`   INT            NOT NULL AUTO_INCREMENT,
  `username`   VARCHAR(30)    NOT NULL,
  `num`        INT            NOT NULL,
  `sum`        DECIMAL(10, 2) NOT NULL,
  `createTime` DATE           NOT NULL,
  PRIMARY KEY (`ordersId`)
);

CREATE TABLE `shopping`.`orders_details` (
  `id`        INT            NOT NULL AUTO_INCREMENT,
  `ordersId`  INT            NOT NULL,
  `goodsName` VARCHAR(50)    NOT NULL,
  `Price`     DECIMAL(10, 2) NOT NULL,
  `num`       INT            NOT NULL,
  PRIMARY KEY (`id`)
);

ALTER TABLE `shopping`.`orders_details`
ADD INDEX `FK_DETAILS_ORDER_idx` (`ordersId` ASC);

ALTER TABLE `shopping`.`orders_details`
ADD CONSTRAINT `FK_DETAILS_ORDER`
FOREIGN KEY (`ordersId`)
REFERENCES `shopping`.`goods` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

INSERT INTO `shopping`.`admin` (`adminId`, `username`, `password`) VALUES ('1', 'caiwen', '123456');
