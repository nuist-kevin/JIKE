INSERT INTO `shopping`.`category` (`id`, `categoryName`) VALUES (1, '普通花');
INSERT INTO `shopping`.`category` (`id`, `categoryName`) VALUES (2, '普通花2');

INSERT INTO `shopping`.`goods` (`id`, `goodsname`, `description`, `price`, `categoryId`, `imgUrl`)
VALUES (1, '茉莉花1', '花的一种1', 15.31, 1, 'img/flowers/pasm1.jpg');
INSERT INTO `shopping`.`goods` (`id`, `goodsname`, `description`, `price`, `categoryId`, `imgUrl`)
VALUES (2, '茉莉花2', '花的一种2', 15.32, 2, 'img/flowers/pasm2.jpg');
