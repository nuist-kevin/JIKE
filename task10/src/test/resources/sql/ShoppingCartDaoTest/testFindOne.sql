INSERT INTO `shopping`.`role` (`ROLE_ID`, `ROLENAME`) VALUES ('1', 'admin');

INSERT INTO `shopping`.`users` (`USER_ID`, `ROLE_ID`, `USERNAME`, `REALNAME`, `PASSWORD`, `PWD_QUESTION`, `PWD_QUESTION_ANSWER`, `ADDRESS`, `PHONENO`, `EMAIL`) VALUES
 ('1', '1', 'caiwen', '蔡文', '123456', '老婆的名字', '宋晓娇', '南京托乐嘉', '18094200522', 'nuist_kevin@163.com');

 INSERT INTO `shopping`.`category` (`CATEGORY_ID`, `CATEGORY_NAME`) VALUES
('1', '鲜花'),
('2', '手机');

INSERT INTO `shopping`.`goods` (`GOODS_ID`, `GOODS_NAME`, `DESCRIPTION`, `PRICE`, `CATEGORY_ID`, `IMGURL`) VALUES
('1', '玫瑰花', '爱之花', '199.99', '1', 'img/flower/rose.jpg'),
('2', 'iPhone 6s', '苹果最新一代手机', '5688', '2', 'img/cellphone/iphone6s.jpg');

INSERT INTO `shopping`.`shoppingcart` (`SHOPPINGCART_ID`, `USER_ID`, `GOODSNUM`, `SUBTOTAL`) VALUES
('1', '1', '2', '15333.32');

INSERT INTO `shopping`.`shoppingcartdetail` (`SHOPPINGCART_DETAIL_ID`, `SHOPPINGCART_ID`, `GOODS_ID`, `NUM`) VALUES
('1', '1', '1', '1'),
('2', '1', '2', '1');

