
CREATE DATABASE IF NOT EXISTS `students` ;
USE `students`;

-- Dumping structure for table ttscouts.tzj_pub_province
CREATE TABLE IF NOT EXISTS `pub_province` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '省份名称\\n',
  `code` int(11) DEFAULT NULL,
  `parent_code` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `parent_code` (`parent_code`),
  KEY `code` (`code`),
  KEY `parent_code_2` (`parent_code`)
) ENGINE=InnoDB AUTO_INCREMENT=32;


INSERT INTO `pub_province` (`id`, `name`, `code`, `parent_code`) VALUES
	(1, '北京市', 110000, NULL),
	(2, '天津市', 120000, NULL),
	(3, '河北省', 130000, NULL),
	(4, '山西省', 140000, NULL),
	(5, '内蒙古自治区', 150000, NULL),
	(6, '辽宁省', 210000, NULL),
	(7, '吉林省', 220000, NULL),
	(8, '黑龙江省', 230000, NULL),
	(9, '上海市', 310000, NULL),
	(10, '江苏省', 320000, NULL),
	(11, '浙江省', 330000, NULL),
	(12, '安徽省', 340000, NULL),
	(13, '福建省', 350000, NULL),
	(14, '江西省', 360000, NULL),
	(15, '山东省', 370000, NULL),
	(16, '河南省', 410000, NULL),
	(17, '湖北省', 420000, NULL),
	(18, '湖南省', 430000, NULL),
	(19, '广东省', 440000, NULL),
	(20, '广西壮族自治区', 450000, NULL),
	(21, '海南省', 460000, NULL),
	(22, '重庆市', 500000, NULL),
	(23, '四川省', 510000, NULL),
	(24, '贵州省', 520000, NULL),
	(25, '云南省', 530000, NULL),
	(26, '西藏自治区', 540000, NULL),
	(27, '陕西省', 610000, NULL),
	(28, '甘肃省', 620000, NULL),
	(29, '青海省', 630000, NULL),
	(30, '宁夏回族自治区', 640000, NULL),
	(31, '新疆维吾尔自治区', 650000, NULL);
