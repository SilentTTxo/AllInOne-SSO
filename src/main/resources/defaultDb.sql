CREATE TABLE `USER` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` char(30) NOT NULL COMMENT '用户名',
  `password` char(100) NOT NULL COMMENT '密码',
  `auth` int(11) NOT NULL DEFAULT '-1' COMMENT '角色权限',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

