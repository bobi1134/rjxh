/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80001
Source Host           : localhost:3306
Source Database       : data_rjxh

Target Server Type    : MYSQL
Target Server Version : 80001
File Encoding         : 65001

Date: 2017-07-21 19:29:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_associationintroduce
-- ----------------------------
DROP TABLE IF EXISTS `t_associationintroduce`;
CREATE TABLE `t_associationintroduce` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) DEFAULT NULL,
  `content` varchar(9999) DEFAULT NULL,
  `image` varchar(9999) DEFAULT NULL,
  `imgtitle` varchar(9999) DEFAULT NULL,
  `flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_associationintroduce
-- ----------------------------
INSERT INTO `t_associationintroduce` VALUES ('1', '协会简介', '四川农业大学软件协会，英文名SiChuan Agricultural University software Association ， 简称Sicau SA 。', null, null, '1');
INSERT INTO `t_associationintroduce` VALUES ('2', '协会性质', '本协会是四川农业大学学生自愿报名参加并组建的学生社团，是受校团委、社团联合会和院团总支监督和引导的非营利性学生社团组织。本协会贯彻党的基本路线，遵守宪法、法律、法规和学校的规章制度、遵守社会道德风尚，维护校园环境和社会秩序的稳定。', null, null, '1');
INSERT INTO `t_associationintroduce` VALUES ('3', '协会目标', '加强大学校园学生社团工作的发展；普及计算机和互联网基础知识，提高我校学生的计算机应用水平，满足广大电脑爱好者的求知欲，培养同学们的创新能力和计算机软硬件开发能力，提升同学们的就业能力；继承和弘扬校园的精神文明建设，丰富同学们的校园文化生活，提高同学们的综合素质。', null, null, '1');
INSERT INTO `t_associationintroduce` VALUES ('4', '协会口号', '交流经验，传承技术。实现每一个热爱计算机软件成员的梦想！', null, null, '1');
INSERT INTO `t_associationintroduce` VALUES ('5', null, null, '1.jpg', '协会第一次合影', '2');
INSERT INTO `t_associationintroduce` VALUES ('6', null, null, '2.jpg', '协会培训', '2');
INSERT INTO `t_associationintroduce` VALUES ('7', null, null, '3.jpg', '2015-2016学年第一次见面会', '2');
INSERT INTO `t_associationintroduce` VALUES ('8', null, null, '4.jpg', '2015-2016学年招新', '2');
INSERT INTO `t_associationintroduce` VALUES ('9', null, null, '5.jpg', '知识竞赛活动', '2');
INSERT INTO `t_associationintroduce` VALUES ('10', null, null, '6.jpg', '黑板报设计', '2');
INSERT INTO `t_associationintroduce` VALUES ('11', '协会原则', '我们的技术永久免费传承，公开交流，无任何盈利性质，公益到底。', null, null, '1');

-- ----------------------------
-- Table structure for t_bbs_remark
-- ----------------------------
DROP TABLE IF EXISTS `t_bbs_remark`;
CREATE TABLE `t_bbs_remark` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(999) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `tzId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  KEY `tzId` (`tzId`),
  CONSTRAINT `t_bbs_remark_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `t_user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_bbs_remark_ibfk_2` FOREIGN KEY (`tzId`) REFERENCES `t_bbs_tz` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_bbs_remark
-- ----------------------------
INSERT INTO `t_bbs_remark` VALUES ('3', '<img src=\"/rx/images/face/02.gif\" width=\"18\" height=\"18\">', '2016-05-09 15:30:36', '14', '27');
INSERT INTO `t_bbs_remark` VALUES ('5', '&lt;alert&gt;alert(1)&lt;/alert&gt;', '2016-07-16 13:07:20', '20', '27');
INSERT INTO `t_bbs_remark` VALUES ('6', '&lt;script&gt;alert(1)&lt;/script&gt;', '2016-07-16 13:08:25', '20', '27');
INSERT INTO `t_bbs_remark` VALUES ('7', '爱你', '2017-01-17 21:28:30', '1', '39');
INSERT INTO `t_bbs_remark` VALUES ('8', '<img src=\"/rjxh/rx/images/face/03.gif\" width=\"18\" height=\"18\"><img src=\"/rjxh/rx/images/face/03.gif\" width=\"18\" height=\"18\"><img src=\"/rjxh/rx/images/face/03.gif\" width=\"18\" height=\"18\">', '2017-01-17 21:29:14', '1', '39');

-- ----------------------------
-- Table structure for t_bbs_subremark
-- ----------------------------
DROP TABLE IF EXISTS `t_bbs_subremark`;
CREATE TABLE `t_bbs_subremark` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(999) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `remarkUser` varchar(999) DEFAULT NULL,
  `remarkUserId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `remarkId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  KEY `remarkId` (`remarkId`),
  CONSTRAINT `t_bbs_subremark_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `t_user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_bbs_subremark_ibfk_2` FOREIGN KEY (`remarkId`) REFERENCES `t_bbs_remark` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_bbs_subremark
-- ----------------------------

-- ----------------------------
-- Table structure for t_bbs_tz
-- ----------------------------
DROP TABLE IF EXISTS `t_bbs_tz`;
CREATE TABLE `t_bbs_tz` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(999) DEFAULT NULL,
  `content` mediumtext,
  `date` datetime DEFAULT NULL,
  `zd` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `t_bbs_tz_ibfk_1` (`userId`),
  CONSTRAINT `t_bbs_tz_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `t_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_bbs_tz
-- ----------------------------
INSERT INTO `t_bbs_tz` VALUES ('27', '欢迎大家来到软件协会官网', '<p style=\"line-height: 1.5em; white-space: normal;\"><span style=\"font-size: 16px;\">&nbsp; &nbsp;</span><span style=\"font-size: 16px; text-decoration: underline; color: rgb(255, 0, 0);\">无论你是否是本协会的成员，你都可以在这里发帖。你在这里可以随便玩，也可以在这里关于计算机，电脑问题，网络问题，以及专业软件问题，专业技术问题进行咨询。也可以把你实验不懂的问题，发上来供我们向您解答。</span></p><p style=\"line-height: 1.5em; white-space: normal;\"><span style=\"font-size: 16px; text-decoration: underline; color: rgb(255, 0, 0);\">不过请大家尊重论坛规则，禁止色情，暴力，和一切广告</span></p><ol class=\" list-paddingleft-2\" style=\"width: 867.344px; white-space: normal;\"><li><p><strong><span style=\"font-size: 16px;\">一旦发现色情，暴力，和一切广告，第一次删帖处理，第二次删除用户</span></strong></p></li><li><p><strong><span style=\"font-size: 16px;\">大家此处发帖时需要账号注册</span></strong></p><p><img src=\"http://www.xsrjxh.com/rjxh/rx/images/AllUpdateImages/20160508/1462719257750002002.png\" title=\"1462719257750002002.png\" alt=\"blob.png\"/></p><p>然后登录方可进行发帖，评论操作</p><p><img src=\"http://www.xsrjxh.com/rjxh/rx/images/AllUpdateImages/20160508/1462719318841088270.png\" title=\"1462719318841088270.png\" alt=\"blob.png\"/></p><p><img src=\"http://www.xsrjxh.com/rjxh/rx/images/AllUpdateImages/20160508/1462719398342049604.png\" title=\"1462719398342049604.png\" alt=\"blob.png\"/></p></li><li><p><strong><span style=\"font-size: 16px;\">如果大家对网站有什么建议或意见，或者是关于协会要咨询的可直接点击网页下方“技术咨询”连接，即可和负责人进行聊天</span></strong></p><p><img src=\"http://www.xsrjxh.com/rjxh/rx/images/AllUpdateImages/20160508/1462719564491043461.png\" title=\"1462719564491043461.png\" alt=\"blob.png\"/></p><p>然后就会直接发起聊天窗口（<strong><span style=\"color: rgb(255, 0, 0);\">手机也支持此功能</span></strong>）</p><p><img src=\"http://www.xsrjxh.com/rjxh/rx/images/AllUpdateImages/20160508/1462719687004008062.png\" title=\"1462719687004008062.png\" alt=\"blob.png\"/></p></li><li><p><strong><span style=\"font-size: 16px;\">本网站还有一个网站地图，很好玩哦</span></strong><img src=\"http://img.baidu.com/hi/jx2/j_0059.gif\"/></p><p><img src=\"http://www.xsrjxh.com/rjxh/rx/images/AllUpdateImages/20160508/1462719758728014939.png\" title=\"1462719758728014939.png\" alt=\"blob.png\"/></p><p><img src=\"http://www.xsrjxh.com/rjxh/rx/images/AllUpdateImages/20160508/1462719801443046736.png\" title=\"1462719801443046736.png\" alt=\"blob.png\"/><br/></p><p>（<span style=\"color: rgb(255, 0, 0);\">此地图功能转自四川农业大学信息与教育技术中心</span>）</p></li></ol><p><br/></p>', '2016-05-08 23:08:23', '1', '1');
INSERT INTO `t_bbs_tz` VALUES ('37', '大家把会费给交一下！', '<p>负责人：周师兄</p><p>电话号码：632222</p><p>地址：老区食堂！</p><p><br/></p><p><img src=\"/rjxh/rx/images/AllUpdateImages/20161215/1481799595959092220.png\" title=\"1481799595959092220.png\" alt=\"首页-四川农业大学校车购票系统.png\"/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p>', '2016-12-15 19:00:04', '1', '1');
INSERT INTO `t_bbs_tz` VALUES ('38', '我爱你麻痹！', '<p><img src=\"/rjxh/rx/images/AllUpdateImages/20161215/1481799674542006440.png\" title=\"1481799674542006440.png\" alt=\"D79041A6D21067CE1FA80C7D0E6D5EAF.png\"/></p>', '2016-12-15 19:01:35', '2', '1');
INSERT INTO `t_bbs_tz` VALUES ('39', '董璇', '<p style=\"text-align:center\"><img src=\"/rjxh/rx/images/AllUpdateImages/20170117/1484659592156010164.jpg\" title=\"1484659592156010164.jpg\" alt=\"timg.jpg\"/></p><p><br/></p><p><br/></p><p style=\"text-align:center\"><img src=\"/rjxh/rx/images/AllUpdateImages/20170117/1484659607608093378.jpg\" title=\"1484659607608093378.jpg\" alt=\"timg (1).jpg\"/></p>', '2017-01-17 21:27:00', '2', '1');

-- ----------------------------
-- Table structure for t_contact
-- ----------------------------
DROP TABLE IF EXISTS `t_contact`;
CREATE TABLE `t_contact` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_contact
-- ----------------------------
INSERT INTO `t_contact` VALUES ('1', '领导介绍');
INSERT INTO `t_contact` VALUES ('2', '联系方式');
INSERT INTO `t_contact` VALUES ('3', '友情链接');

-- ----------------------------
-- Table structure for t_contact_sub
-- ----------------------------
DROP TABLE IF EXISTS `t_contact_sub`;
CREATE TABLE `t_contact_sub` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `content` varchar(9999) DEFAULT NULL,
  `belongId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `belongId` (`belongId`),
  CONSTRAINT `t_contact_sub_ibfk_1` FOREIGN KEY (`belongId`) REFERENCES `t_contact` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_contact_sub
-- ----------------------------
INSERT INTO `t_contact_sub` VALUES ('1', '前任会长', '鲁忠祥，研究生学历，擅长于网站建设。\r\n精通html+css布局，框架。网站。现在在成都从事与网站开发建设', '1');
INSERT INTO `t_contact_sub` VALUES ('2', '前任会长', '邓文俊，计算机科学与技术（教育）专业，学习网站前台，Java。', '1');
INSERT INTO `t_contact_sub` VALUES ('3', '前任副会长', '邓双惠，计算机科学与技术（教育）专业', '1');
INSERT INTO `t_contact_sub` VALUES ('6', '协会QQ群', '310461247', '2');
INSERT INTO `t_contact_sub` VALUES ('7', '协会地址', ' 四川农业大学雅安校区', '2');
INSERT INTO `t_contact_sub` VALUES ('8', '四川农业大学官网', 'http://www.sicau.edu.cn/', '3');
INSERT INTO `t_contact_sub` VALUES ('9', '四川农业大学教务处', 'jiaowu.sicau.edu.cn', '3');
INSERT INTO `t_contact_sub` VALUES ('22', '现任会长', '蒋长旭，计算机科学与技术专业', '1');
INSERT INTO `t_contact_sub` VALUES ('23', '现任副会长', '陈安邦，文化产业管理', '1');
INSERT INTO `t_contact_sub` VALUES ('24', '现任团支书', '孔露露，生物科学', '1');

-- ----------------------------
-- Table structure for t_departmentstyle
-- ----------------------------
DROP TABLE IF EXISTS `t_departmentstyle`;
CREATE TABLE `t_departmentstyle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `about` varchar(9999) DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  `introduce` varchar(9999) DEFAULT NULL,
  `belong` varchar(20) DEFAULT NULL,
  `flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_departmentstyle
-- ----------------------------
INSERT INTO `t_departmentstyle` VALUES ('1', '四川农业大学学生软件协会，成立于2013年12月1日，由一群计算机软件的狂热爱好者组建，本着交流软件经验，传承软件技术的理念诞生，很快就吸引了大批喜欢计算机软件热爱者及编程开发人员，技术团队迅速成长起来', null, null, 'xhjj', '1');
INSERT INTO `t_departmentstyle` VALUES ('2', null, '协会宗旨', '在这里可以实现每一个热爱计算机软件成员的梦想！', 'xhjj', '2');
INSERT INTO `t_departmentstyle` VALUES ('3', null, '协会承诺', '我们的技术永久免费传承，公开交流，无任何商业盈利性质，公益到底。', 'xhjj', '2');
INSERT INTO `t_departmentstyle` VALUES ('4', null, '协会理念', '热爱、支持我们家族的每一个成员，无论今后你走到哪里，只要你曾经是我们的家族成员，你都可以从大家庭获得帮助和信赖。', 'xhjj', '2');
INSERT INTO `t_departmentstyle` VALUES ('5', '四川农业大学学生软件协会——办公室', null, null, 'bgs', '1');
INSERT INTO `t_departmentstyle` VALUES ('6', null, '主要工作', '配合会长副会长工作，统一进行社团财务分配、监督、审核、管理。组织会员学习office等办公软件，并进行协会档案管理、会议记录、联系成员、办公室值班、工作报告等工作。', 'bgs', '2');
INSERT INTO `t_departmentstyle` VALUES ('7', '四川农业大学学生软件协会——技术部', null, null, 'jsb', '1');
INSERT INTO `t_departmentstyle` VALUES ('8', null, '主要工作', '对协会成员进行软件培训，同时也其他部门进行技术支持。', 'jsb', '2');
INSERT INTO `t_departmentstyle` VALUES ('9', '四川农业大学学生软件协会——外联部，，', null, null, 'wlb', '1');
INSERT INTO `t_departmentstyle` VALUES ('10', null, '主要工作', '加强与各企业间的联络，为社团的优秀活动争取商业赞助以及人力和智力的支持。负责社团日常活动所用场地的申请以及宣传所需的展板等申请。加强与其他社团的联系，为社团的团结发展做出贡献。', 'wlb', '2');
INSERT INTO `t_departmentstyle` VALUES ('11', '四川农业大学学生软件协会——组织部', null, '四川农业大学学生软件协会——组织部，，', 'zzb', '1');
INSERT INTO `t_departmentstyle` VALUES ('12', null, '主要工作', '负责协会各类讲座、交流大会及比赛活动的筹划、组织和宣传，以及每次活动总结。', 'zzb', '2');
INSERT INTO `t_departmentstyle` VALUES ('21', null, '现任干部', '部长：黄显翠     QQ：1010341550\r\n副部长：李冬梅   QQ：1366845180', 'zzb', '2');
INSERT INTO `t_departmentstyle` VALUES ('22', null, '现任干部', '部长：朱传芳   QQ:1483415146    副部长：张香明     QQ：547279782', 'wlb', '2');
INSERT INTO `t_departmentstyle` VALUES ('23', null, '现任干部', '部长：夏朋     QQ:769522836      副部长：李俊      QQ：490717909', 'jsb', '2');
INSERT INTO `t_departmentstyle` VALUES ('24', null, '现任干部', '部长：明海育      QQ:1845277825    副部长：龚健一      QQ：1102218182', 'bgs', '2');

-- ----------------------------
-- Table structure for t_homepage_banner
-- ----------------------------
DROP TABLE IF EXISTS `t_homepage_banner`;
CREATE TABLE `t_homepage_banner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `image` varchar(100) DEFAULT NULL,
  `title` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_homepage_banner
-- ----------------------------
INSERT INTO `t_homepage_banner` VALUES ('1', 'banner01.jpg', '与你同行');
INSERT INTO `t_homepage_banner` VALUES ('2', 'banner02.jpg', '见面会');
INSERT INTO `t_homepage_banner` VALUES ('3', 'banner03.jpg', '计算机比赛');
INSERT INTO `t_homepage_banner` VALUES ('4', 'banner04.jpg', '技术交流');

-- ----------------------------
-- Table structure for t_homepage_hotanswering
-- ----------------------------
DROP TABLE IF EXISTS `t_homepage_hotanswering`;
CREATE TABLE `t_homepage_hotanswering` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) DEFAULT NULL,
  `content` mediumtext,
  `date` datetime DEFAULT NULL,
  `sy` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_homepage_hotanswering
-- ----------------------------
INSERT INTO `t_homepage_hotanswering` VALUES ('1', '怎样加入我们？', '<p style=\"line-height: 1.5em;\"><span style=\"font-size: 16px; color: rgb(84, 141, 212);\">问：&nbsp;怎样加入我们？</span></p><p style=\"line-height: 1.5em;\"><span style=\"font-size: 16px; line-height: 1em; color: rgb(255, 0, 0);\">答：1.如果你想加入我们，可直接加入协会官方QQ群：310461247</span></p><p style=\"line-height: 1.5em;\"><span style=\"line-height: 1em; font-size: 16px; color: rgb(255, 0, 0);\">或者是直接点击网页下方的“技术咨询”链接咨询负责人</span></p><p style=\"line-height: 1.5em;\"><span style=\"font-size: 16px; color: rgb(255, 0, 0);\">2.然后我们会组织面试，面试结束后进行会员的资料更新</span></p><p style=\"line-height: 1.5em;\"><span style=\"line-height: 1em;\"><br/></span></p><p>&nbsp;</p><p><br/></p><p><br/></p>', '2016-04-09 01:02:00', '1');
INSERT INTO `t_homepage_hotanswering` VALUES ('4', '协会有哪些培训活动？', '<p style=\"line-height: 1.5em;\"><span style=\"color: rgb(141, 179, 226); font-size: 16px;\">问：协会有哪些培训活动？</span></p><p style=\"line-height: 1.5em;\"><span style=\"color: rgb(255, 0, 0); font-size: 16px;\">答：我们会根据大家的兴趣，来决定培训科目？一般我们会以</span></p><p style=\"line-height: 1.5em;\"><span style=\"color: rgb(255, 0, 0); font-size: 16px;\">PS,office作为大众的基础课程。而C，C++,PHP,JAVA以网站前台</span></p><p style=\"line-height: 1.5em;\"><span style=\"color: rgb(255, 0, 0); font-size: 16px;\">这些专业方向来针对式培训。</span></p>', null, '1');
INSERT INTO `t_homepage_hotanswering` VALUES ('5', '协会培训会收费吗？', '<p style=\"line-height: 1.5em;\"><span style=\"font-size: 16px; color: rgb(141, 179, 226);\">问：协会培训会收费吗？</span></p><p style=\"line-height: 1.5em;\"><span style=\"font-size: 16px; color: rgb(255, 0, 0);\">答：我们做培训师不收取大家一分钱的？</span></p><p style=\"line-height: 1.5em;\"><span style=\"font-size: 16px; color: rgb(141, 179, 226);\">问：那会费是干什么的？</span></p><p style=\"line-height: 1.5em;\"><span style=\"font-size: 16px; color: rgb(255, 0, 0);\">答：会费的收取，是作为协会的经费开支。不过协会的会费我们</span></p><p style=\"line-height: 1.5em;\"><span style=\"font-size: 16px; color: rgb(255, 0, 0);\">都是取之于民用之于民。在协会开办活动为大家买吃的，买奖励</span></p><p style=\"line-height: 1.5em;\"><span style=\"font-size: 16px; color: rgb(255, 0, 0);\">物品所用。</span></p>', null, '1');

-- ----------------------------
-- Table structure for t_homepage_skilltalk
-- ----------------------------
DROP TABLE IF EXISTS `t_homepage_skilltalk`;
CREATE TABLE `t_homepage_skilltalk` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) DEFAULT NULL,
  `image` varchar(100) DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_homepage_skilltalk
-- ----------------------------
INSERT INTO `t_homepage_skilltalk` VALUES ('1', '办公软件', 'office.jpg', 'word,excel,ppt,精品教程,软件下载');
INSERT INTO `t_homepage_skilltalk` VALUES ('2', '平面设计', 'design.jpg', 'Photoshop CS5,基础教程');
INSERT INTO `t_homepage_skilltalk` VALUES ('3', '影视后期', 'after.jpg', 'After Effects cs6,Premiere Pro CS5,Flash CS5,会声会影,技术交流');
INSERT INTO `t_homepage_skilltalk` VALUES ('4', '网站开发', 'web.jpg', 'Photoshop页面美工,Dreamweaver CS6,Div+CSS布局,Javascript特效');

-- ----------------------------
-- Table structure for t_homepage_trainingactivities
-- ----------------------------
DROP TABLE IF EXISTS `t_homepage_trainingactivities`;
CREATE TABLE `t_homepage_trainingactivities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) DEFAULT NULL,
  `content` mediumtext,
  `date` datetime DEFAULT NULL,
  `sy` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_homepage_trainingactivities
-- ----------------------------
INSERT INTO `t_homepage_trainingactivities` VALUES ('2', '每周周末培训课', '<p style=\"line-height: 1.5em;\"><span style=\"color: rgb(0, 112, 192); font-size: 24px;\">我们每周周五与周六分别在机房和多媒体教室对大家进行课程培训</span></p><p><img src=\"/rjxh/rx/images/AllUpdateImages/20160508/1462717598418038770.jpg\" title=\"1462717598418038770.jpg\" alt=\"IMG_20151030_202956.jpg\"/></p><p><img src=\"/rjxh/rx/images/AllUpdateImages/20160508/1462717754334040305.jpg\" title=\"1462717754334040305.jpg\" alt=\"IMG_20151030_202956.jpg\"/></p><p><br/></p>', null, '1');
INSERT INTO `t_homepage_trainingactivities` VALUES ('3', '知识竞赛活动', '<p style=\"line-height: 1.5em;\"><span style=\"font-size: 24px;\">2015.4.10我们软件协会成功举办《<span style=\"font-family: 微软雅黑; line-height: 14px;\">知识竞赛</span>》活动，受到同学们的积极参与</span></p><p><img src=\"http://img.baidu.com/hi/jx2/j_0001.gif\"/></p>', null, '1');

-- ----------------------------
-- Table structure for t_news
-- ----------------------------
DROP TABLE IF EXISTS `t_news`;
CREATE TABLE `t_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `content` mediumtext,
  `date` datetime DEFAULT NULL,
  `ip` varchar(9999) DEFAULT NULL,
  `zan_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_news
-- ----------------------------
INSERT INTO `t_news` VALUES ('1', '协会第一次合影', '<p>2014年</p>', '2016-04-10 22:44:45', '10.10.10.10,10.6.11.17,10.6.11.15,10.6.11.14,10.6.11.10,10.6.11.19,0:0:0:0:0:0:0:1,221.10.76.190,183.222.165.83,182.132.133.13', '10');
INSERT INTO `t_news` VALUES ('4', '2015-2016学年招新', '..', '2016-03-29 00:00:00', 'null,10.6.11.19,182.132.133.13', '2');
INSERT INTO `t_news` VALUES ('5', '知识竞赛活动', '..', '2016-03-29 00:00:00', 'null,10.6.11.19,182.132.135.34', '2');
INSERT INTO `t_news` VALUES ('6', '黑板报设计', '..', '2016-03-29 00:00:00', 'null,10.6.34.190,0:0:0:0:0:0:0:1', '2');
INSERT INTO `t_news` VALUES ('7', '本学期的内部建设和发展我们开了一系列会议', '..', '2016-03-16 00:00:00', 'null,10.6.34.190,0:0:0:0:0:0:0:1,183.222.165.83,182.146.49.250,218.6.135.166', '5');
INSERT INTO `t_news` VALUES ('10', '总结上学期培训情况及培训时间安排的一系列问题', '..', '2016-03-25 00:00:00', 'null,10.6.34.190,171.95.157.144', '2');
INSERT INTO `t_news` VALUES ('20', '给软件协会所有师弟师妹的一封信', '<p style=\"line-height: 1.5em;\"><span style=\"font-size: 16px;\"><span style=\"font-family: 微软雅黑; line-height: 14px;\">&nbsp;&nbsp;&nbsp;&nbsp;hello！大家好我是邓文俊，到这里又是要和大家说再见的时候咯！</span>学年又要结束咯，真的是舍不得。真的是很短暂，不过现在又到了你们SHOW time咯，不管对于你们了来说有没有收获，我们都在努力着。现在协会换届咯，希望大家能够积极来参加竞选，在这里你可能不是技术最强的，但是能够站上讲台的你一定是最棒的。不和你们说那么多，群里我上传的文件，想给自己一个锻炼的机会和展示的舞台，就积极报名吧。最后再说一句，无论师兄师姐在哪里，以后大家有问题还是会一如既往的帮助大家。</span></p><p style=\"line-height: 1.5em;\"><span style=\"font-size: 16px;\">&nbsp;&nbsp;&nbsp;&nbsp;不知道来到我们协会你们到底有没有收获，但是师兄师姐能做的也就是尽力帮助大家。其实无论你们在哪里，最重要的是自己的努力，别人也最多是起一个引导作用。我也是从大一过来的，大一的自己很迷茫，也不知道以后毕业咯干什么。但是在后来自己会在自己的生活中去寻找目标，慢慢的有了自己的目标。也有了明确的方向，其实在这里，我想把自己懂的都交给大家去解决生活中的问题，但是时间真的过的很快。还是那句话，在这里师兄师姐不是最牛B的那个人，但是我们是最热心的那个人。<br/></span></p><p style=\"line-height: 1.5em;\"><span style=\"font-size: 16px;\">&nbsp;&nbsp;&nbsp;&nbsp;有人说，协会学不到什么东西?协会没什么用？其实在这里，我告诉大家，我感谢自己曾经待过的协会，无论是技术和人际，为人处事的道理都是很有收获的。最重要的是打开你自己，抱着什么样子的心态。我也感谢帮助我的师兄师姐，感谢他（她）们对我的帮助与鼓励。<br/></span></p><p style=\"line-height: 1.5em;\"><span style=\"font-size: 16px;\">&nbsp;&nbsp;&nbsp;&nbsp;这学期，可能也对不住一些师弟师妹。在培训安排的时间和通知不到位，导致咯大家不能学习。但是我相信下届的你们会越来越好，我们的软件协会也会越来越好。<br/></span></p><p style=\"line-height: 1.5em;\"><span style=\"font-size: 16px;\">&nbsp;&nbsp;&nbsp;&nbsp;希望大家找到自己的目标，在未来的日子里天天开心<img src=\"http://img.baidu.com/hi/jx2/j_0059.gif\"/><img src=\"http://img.baidu.com/hi/jx2/j_0059.gif\"/><img src=\"http://img.baidu.com/hi/jx2/j_0059.gif\"/></span></p><p style=\"line-height: 1.5em;\"><span style=\"font-size: 16px;\"><img src=\"/rjxh/rx/images/AllUpdateImages/20160508/1462713994097030044.png\" title=\"1462713994097030044.png\" alt=\"DSC_0467.png\"/></span></p><p style=\"line-height: 1.5em;\"><span style=\"font-size: 16px; color: rgb(255, 0, 0);\">PS:话说我还没和大家一起合过影呢。下次一定</span></p><p style=\"line-height: 1.5em;\"><span style=\"font-size: 16px;\"><br/></span></p>', '2016-05-08 21:13:32', 'null,182.132.133.150,171.208.90.38,183.222.165.63,183.222.165.51,183.222.165.28,218.6.135.166,183.222.165.54,171.208.90.78,171.208.90.104,182.132.133.13,183.222.165.144', '11');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(10) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `nickname` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `academe` varchar(30) DEFAULT NULL,
  `grade` varchar(30) DEFAULT NULL,
  `hobby` varchar(100) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', '111111', '邓文俊', '534451834@qq.cm', '1', '信息工程学院', '大三', '球类,唱歌,软件', '阳光，自信，这就是我！', '1');
INSERT INTO `t_user` VALUES ('6', 'deng123', null, '邓双惠', '1205692065@qq.com', '2', '信息工程学院', '大三', '运动，看书。', '共交流，同学习', '2');
INSERT INTO `t_user` VALUES ('7', 'minghaiyu', '123456', '明海育', '1845277825@qq.com', '2', '信息工程学院', '大二', '写字，画画，羽毛球，旅游，爱文学', '四川农业大学大二在校生', '1');
INSERT INTO `t_user` VALUES ('10', 'lalala', '111111', null, null, null, null, null, null, null, '2');
INSERT INTO `t_user` VALUES ('11', '58555', '123456789', null, null, null, null, null, null, null, '2');
INSERT INTO `t_user` VALUES ('12', 'xiapeng', '147258369', null, null, null, null, null, null, null, '2');
INSERT INTO `t_user` VALUES ('13', 'JoeyChou', 'sky12345', '程序猴', '729039337@qq.com', '2', '信息工程学院', '大三', '前端', '不编程也当程序员', '2');
INSERT INTO `t_user` VALUES ('14', 'abc123', '123456789', '谭鹏', '22222@qq.com', '2', '咳咳咳', '大一', 'ff', 'f ', '2');
INSERT INTO `t_user` VALUES ('15', 'xiaochen', '654321', null, null, null, null, null, null, null, '2');
INSERT INTO `t_user` VALUES ('16', '20158426', 'a826765', '蒋长旭', '11111@QQ', '1', '信息工程学院', '大一', '   ', '  ', '1');
INSERT INTO `t_user` VALUES ('17', 'nihao', 'nihao123', null, null, null, null, null, null, null, '2');
INSERT INTO `t_user` VALUES ('18', 'w3cw3c', 'w3cw3c', null, null, null, null, null, null, null, '2');
INSERT INTO `t_user` VALUES ('19', '20158424', '20158424', null, null, null, null, null, null, null, '2');
INSERT INTO `t_user` VALUES ('20', 'abcde', 'abcde', '谭鹏', 'abcde@qq.com', '2', '心公园', '大一', '我爱女生', '大家好', '2');
INSERT INTO `t_user` VALUES ('21', 'deng1234', 'deng1234', null, null, null, null, null, null, null, '2');
