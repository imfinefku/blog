
-- ----------------------------
-- Table structure for `authority_department`
-- ----------------------------
DROP TABLE IF EXISTS `authority_department`;
CREATE TABLE `authority_department` (
  `id` varchar(36) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `masterid` varchar(36) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `blog_friend`
-- ----------------------------
DROP TABLE IF EXISTS `blog_friend`;
CREATE TABLE `blog_friend` (
  `id` varchar(36) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `url` varchar(500) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_friend
-- ----------------------------
INSERT INTO `blog_friend` VALUES ('646e33bc-876d-43b4-b2ec-fbc9e95dd77b', 'Java十点半B站首页', 'https://space.bilibili.com/142398862?spm_id_from=333.1007.0.0', '2023-06-16 14:17:32');
INSERT INTO `blog_friend` VALUES ('7752682b-f79c-4f33-a30e-6ed13287e836', 'Java十点半gitee首页', 'https://gitee.com/xd12345', '2023-04-10 17:30:33');
INSERT INTO `blog_friend` VALUES ('7b5aa806-82e9-4ebf-b8c1-f58faf8e26c3', 'Java十点半github首页', 'https://github.com/imfinefku', '2023-04-10 17:30:11');
INSERT INTO `blog_friend` VALUES ('da98666d-6782-4d6e-b71b-3d64315c47db', 'Java十点半知乎首页', 'https://www.zhihu.com/people/wo-zhi-hui-crud', '2023-06-16 14:18:05');


-- ----------------------------
-- Table structure for `blog_tag`
-- ----------------------------
DROP TABLE IF EXISTS `blog_tag`;
CREATE TABLE `blog_tag` (
  `id` varchar(36) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_tag
-- ----------------------------
INSERT INTO `blog_tag` VALUES ('1a20300e-153f-4d52-b712-53fcd522348a', '微信小程序', '2023-06-21 08:52:01');
INSERT INTO `blog_tag` VALUES ('ec93b89b-ffd1-4642-bd8e-144c9af8e54c', '毕业设计', '2023-04-10 17:05:09');
