CREATE SCHEMA `shopping` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE `shopping`.`users` (
  `id` INT NOT NULL autoincrement,
  `userName` VARCHAR(30) NOT NULL,
  `realName` VARCHAR(30) NULL,
  `password` VARCHAR(30) NOT NULL,
  `pwdQuestion` VARCHAR(50) NULL,
  `pwdQuestionAnswer` VARCHAR(50) NULL,
  `address` VARCHAR(50) NULL,
  `phoneNo` VARCHAR(50) NULL,
  `email` VARCHAR(50) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `userName_UNIQUE` (`userName` ASC));
  
 CREATE TABLE `shopping`.`admin` (
  `adminId` INT NOT NULL auto_increment,
  `username` VARCHAR(30) NOT NULL,
  `password` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`adminId`));

  CREATE TABLE `shopping`.`category` (
  `id` INT NOT NULL auto_increment,
  `categoryName` VARCHAR(30) NOT NULL ,
  PRIMARY KEY (`id`));

  CREATE TABLE `shopping`.`goods` (
  `id` INT NOT NULL auto_increment,
  `goodsname` VARCHAR(50) NOT NULL,
  `description` VARCHAR(200) NULL,
  `price` DECIMAL(10,2) NOT NULL,
  `categoryId` INT NOT NULL,
  `imgUrl` VARCHAR(50) NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `shopping`.`orders` (
  `ordersId` INT NOT NULL auto_increment,
  `username` VARCHAR(30) NOT NULL,
  `num` INT NOT NULL,
  `sum` DECIMAL(10,2) NOT NULL,
  `createTime` DATE NOT NULL,
  PRIMARY KEY (`ordersId`));

  CREATE TABLE `shopping`.`orders_details` (
  `id` INT NOT NULL auto_increment,
  `ordersId` INT NOT NULL,
  `goodsName` VARCHAR(50) NOT NULL,
  `Price` DECIMAL(10,2) NOT NULL,
  `num` INT NOT NULL,
  PRIMARY KEY (`id`));

  INSERT INTO `shopping`.`admin` (`adminId`, `username`, `password`) VALUES ('1', 'caiwen', '123456');
