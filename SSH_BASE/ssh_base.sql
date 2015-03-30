/*
Navicat MySQL Data Transfer

Source Server         : chb
Source Server Version : 50027
Source Host           : localhost:3306
Source Database       : ssh_base

Target Server Type    : MYSQL
Target Server Version : 50027
File Encoding         : 65001

Date: 2015-03-30 17:55:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tauthority`
-- ----------------------------
DROP TABLE IF EXISTS `tauthority`;
CREATE TABLE `tauthority` (
  `ID` varchar(100) NOT NULL,
  `ROLEID` varchar(100) default NULL,
  `MENUID` varchar(100) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tauthority
-- ----------------------------
INSERT INTO `tauthority` VALUES ('402880e449a8664a0149a8791c450003', '402880e449a8664a0149a878c82a0001', '4028fe81495b5a0201495b7804100005');
INSERT INTO `tauthority` VALUES ('402880e449a8664a0149a8791c450004', '402880e449a8664a0149a878c82a0001', '4028fe81495b5a0201495b78b4130006');
INSERT INTO `tauthority` VALUES ('402880e549df90a20149e04dbeec0003', '402880e549df90a20149dff4f89d0002', '402880e449a80ec10149a811ae6d0003');
INSERT INTO `tauthority` VALUES ('402880e549df90a20149e04dbeec0004', '402880e549df90a20149dff4f89d0002', '402880e449a80ec10149a811e8d60004');
INSERT INTO `tauthority` VALUES ('402880e549df90a20149e04dbeec0005', '402880e549df90a20149dff4f89d0002', '402880e449a80ec10149a8120ab60005');
INSERT INTO `tauthority` VALUES ('402880e549df90a20149e04dbeec0006', '402880e549df90a20149dff4f89d0002', '402880e449a80ec10149a8122bac0006');
INSERT INTO `tauthority` VALUES ('402880e549df90a20149e04dbeec0007', '402880e549df90a20149dff4f89d0002', '402880e449a80ec10149a812550d0007');
INSERT INTO `tauthority` VALUES ('402880e549df90a20149e04dbeec0008', '402880e549df90a20149dff4f89d0002', '402880e449a80ec10149a8127aa60008');
INSERT INTO `tauthority` VALUES ('402880e549df90a20149e04dbeed0009', '402880e549df90a20149dff4f89d0002', '402880e449a80ec10149a8129f160009');
INSERT INTO `tauthority` VALUES ('402880e549df90a20149e04dbeed000a', '402880e549df90a20149dff4f89d0002', '402880e449a80ec10149a812c423000a');
INSERT INTO `tauthority` VALUES ('402880e549df90a20149e04dbeed000b', '402880e549df90a20149dff4f89d0002', '402880e449a80ec10149a812e8d1000b');
INSERT INTO `tauthority` VALUES ('402880e549df90a20149e04dbeed000c', '402880e549df90a20149dff4f89d0002', '402880e449a80ec10149a81309b7000c');
INSERT INTO `tauthority` VALUES ('402880e549df90a20149e04dbeed000d', '402880e549df90a20149dff4f89d0002', '402880e449a80ec10149a8132b88000d');
INSERT INTO `tauthority` VALUES ('402880e549df90a20149e04dbeed000e', '402880e549df90a20149dff4f89d0002', '402880e449a80ec10149a81351ec000e');
INSERT INTO `tauthority` VALUES ('402880e549df90a20149e04dbeed000f', '402880e549df90a20149dff4f89d0002', '402880e449a80ec10149a8137785000f');
INSERT INTO `tauthority` VALUES ('402880e549df90a20149e04dbeed0010', '402880e549df90a20149dff4f89d0002', '402880e449a80ec10149a81398f70010');
INSERT INTO `tauthority` VALUES ('402880e549df90a20149e04dbeed0011', '402880e549df90a20149dff4f89d0002', '402880e449a80ec10149a813bc000011');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b8260001', '402880e4497d786401497d79c03d0000', '402880e449a80ec10149a811ae6d0003');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b8260002', '402880e4497d786401497d79c03d0000', '402880e449a80ec10149a811e8d60004');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b8260003', '402880e4497d786401497d79c03d0000', '402880e449a80ec10149a8120ab60005');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b8260004', '402880e4497d786401497d79c03d0000', '402880e449a80ec10149a8122bac0006');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b8260005', '402880e4497d786401497d79c03d0000', '402880e449a80ec10149a812550d0007');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b8260006', '402880e4497d786401497d79c03d0000', '402880e449a80ec10149a8127aa60008');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b8260007', '402880e4497d786401497d79c03d0000', '402880e449a80ec10149a8129f160009');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b8260008', '402880e4497d786401497d79c03d0000', '402880e449a80ec10149a812c423000a');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b8260009', '402880e4497d786401497d79c03d0000', '402880e449a80ec10149a812e8d1000b');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b826000a', '402880e4497d786401497d79c03d0000', '402880e449a80ec10149a81309b7000c');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b826000b', '402880e4497d786401497d79c03d0000', '402880e449a80ec10149a8132b88000d');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b826000c', '402880e4497d786401497d79c03d0000', '402880e449a80ec10149a8137785000f');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b826000d', '402880e4497d786401497d79c03d0000', '402880e449a80ec10149a81398f70010');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b826000e', '402880e4497d786401497d79c03d0000', '402880e449a80ec10149a813bc000011');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b826000f', '402880e4497d786401497d79c03d0000', '402880e44a3bf354014a3c325cd3002e');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b8260010', '402880e4497d786401497d79c03d0000', '402880e44a4c7b57014a4c7e25050000');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b8350011', '402880e4497d786401497d79c03d0000', '402880e44a7503b3014a750556c30001');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b8350012', '402880e4497d786401497d79c03d0000', '402880e44ac83e49014ac85307a80002');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b8350013', '402880e4497d786401497d79c03d0000', '402880e449a80ec10149a8142a0c0012');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b8350014', '402880e4497d786401497d79c03d0000', '402880e449a80ec10149a81463d90013');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b8350015', '402880e4497d786401497d79c03d0000', '402880e449a80ec10149a81483a50014');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b8350016', '402880e4497d786401497d79c03d0000', '402880e449a80ec10149a814a6dd0015');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b8350017', '402880e4497d786401497d79c03d0000', '402880e449a80ec10149a814d2ee0016');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b8350018', '402880e4497d786401497d79c03d0000', '402880e449a80ec10149a814f3470017');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b8350019', '402880e4497d786401497d79c03d0000', '402880e449a80ec10149a81525540018');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b835001a', '402880e4497d786401497d79c03d0000', '402880e449ad21ef0149ad22d4dc0000');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b835001b', '402880e4497d786401497d79c03d0000', '402880e44a6113d9014a6115909a0001');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b835001c', '402880e4497d786401497d79c03d0000', '402880e44a615fee014a616131af0001');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b835001d', '402880e4497d786401497d79c03d0000', '402880e44a75a206014a75ab36150003');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b835001e', '402880e4497d786401497d79c03d0000', '402880e44a9f75cd014a9f78ea3f0000');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b835001f', '402880e4497d786401497d79c03d0000', '402880ee4b0f5c63014b0f5ddafd0001');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b8350020', '402880e4497d786401497d79c03d0000', '402880ee4b4ea251014b4ea3625f0001');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b8350021', '402880e4497d786401497d79c03d0000', '402880e44a36cde4014a3720301f0005');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b8350022', '402880e4497d786401497d79c03d0000', '402880e44a3bf354014a3c1df5bd0004');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b8350023', '402880e4497d786401497d79c03d0000', '402880ee4b2a5bcd014b2a722a500002');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b8350024', '402880e4497d786401497d79c03d0000', '402880ee4b2a5bcd014b2a78551c0008');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b8350025', '402880e4497d786401497d79c03d0000', '402880ee4b2e116f014b2e2ec686000c');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b8350026', '402880e4497d786401497d79c03d0000', '402880ee4b34b7c6014b34badb100001');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b8350027', '402880e4497d786401497d79c03d0000', '402880ee4b34ded3014b34e2b8530000');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b8350028', '402880e4497d786401497d79c03d0000', '402880ee4b5cc931014b5d007b490017');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b8350029', '402880e4497d786401497d79c03d0000', '402880ee4b710552014b71079e190001');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b835002a', '402880e4497d786401497d79c03d0000', '402880ee4b7721c0014b774c31370001');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b835002b', '402880e4497d786401497d79c03d0000', '402880ee4b77c712014b77ccbd9a0001');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b835002c', '402880e4497d786401497d79c03d0000', '402880ee4c692c9f014c69a9f5d4000e');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b835002d', '402880e4497d786401497d79c03d0000', '4028fe81495b5a0201495b7804100005');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b835002e', '402880e4497d786401497d79c03d0000', '402880e449a80ec10149a81058d00000');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b835002f', '402880e4497d786401497d79c03d0000', '402880e449a80ec10149a8109b090001');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b8350030', '402880e4497d786401497d79c03d0000', '402880e449a80ec10149a810ce6d0002');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b8350031', '402880e4497d786401497d79c03d0000', '4028fe81495b5a0201495b78b4130006');
INSERT INTO `tauthority` VALUES ('402880ee4c69b8df014c69c2b8350032', '402880e4497d786401497d79c03d0000', '4028fe814a5bf2cd014a5bf50a230001');

-- ----------------------------
-- Table structure for `tbmenu`
-- ----------------------------
DROP TABLE IF EXISTS `tbmenu`;
CREATE TABLE `tbmenu` (
  `ID` varchar(100) NOT NULL,
  `MNAME` varchar(100) default NULL,
  `URLS` varchar(100) default NULL,
  `MCODE` varchar(50) default NULL,
  `SERIES` int(11) NOT NULL,
  `SCRIPTNAME` varchar(50) default NULL,
  `ICON` varchar(100) default NULL,
  `remark` varchar(100) default NULL,
  `ISACTIVES` char(1) default NULL,
  `SEQ` int(11) default NULL,
  `PID` varchar(100) default NULL,
  `PMCODE` varchar(50) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbmenu
-- ----------------------------
INSERT INTO `tbmenu` VALUES ('402880e449a80ec10149a81058d00000', '前台菜单管理', 'qmenuAction!findList.action', '100101', '2', '', null, '前台菜单管理', '1', '1', '4028fe81495b5a0201495b7804100005', '100');
INSERT INTO `tbmenu` VALUES ('402880e449a80ec10149a8109b090001', '后台用户管理', 'buserAction!findList.action', '100102', '2', '', null, '', '1', '1', '4028fe81495b5a0201495b7804100005', '100');
INSERT INTO `tbmenu` VALUES ('402880e449a80ec10149a810ce6d0002', '角色管理', 'roleAction!findList.action', '100103', '2', '', null, '', '1', '1', '4028fe81495b5a0201495b7804100005', '100');
INSERT INTO `tbmenu` VALUES ('402880e449a80ec10149a811ae6d0003', '基础信息管理', '#', '101', '1', '', null, '', '1', '1', 'root', '0');
INSERT INTO `tbmenu` VALUES ('402880e449a80ec10149a811e8d60004', '数据类型', 'codetypeAction!findList.action', '101100', '2', '', null, '', '1', '1', '402880e449a80ec10149a811ae6d0003', '101');
INSERT INTO `tbmenu` VALUES ('402880e449a80ec10149a8120ab60005', '数据字典', 'codedataAction!main.action', '101101', '2', '', null, '', '1', '1', '402880e449a80ec10149a811ae6d0003', '101');
INSERT INTO `tbmenu` VALUES ('402880e449a80ec10149a8122bac0006', '优惠活动', 'promotionsAction!findList.action', '101102', '2', '', null, '', '1', '1', '402880e449a80ec10149a811ae6d0003', '101');
INSERT INTO `tbmenu` VALUES ('402880e449a80ec10149a812550d0007', '内容管理', 'contentAction!main.action', '101103', '2', '', null, '', '1', '1', '402880e449a80ec10149a811ae6d0003', '101');
INSERT INTO `tbmenu` VALUES ('402880e449a80ec10149a8127aa60008', '代理加盟', 'affiliateAction!findList.action', '101104', '2', '', null, '', '1', '1', '402880e449a80ec10149a811ae6d0003', '101');
INSERT INTO `tbmenu` VALUES ('402880e449a80ec10149a8129f160009', '联系我们', 'contactsAction!findList.action', '101105', '2', '', null, '', '1', '1', '402880e449a80ec10149a811ae6d0003', '101');
INSERT INTO `tbmenu` VALUES ('402880e449a80ec10149a812c423000a', '最新公告', 'noticeAction!findList.action', '101106', '2', '', null, '', '1', '1', '402880e449a80ec10149a811ae6d0003', '101');
INSERT INTO `tbmenu` VALUES ('402880e449a80ec10149a812e8d1000b', '代理占成', 'dlzcAction!findList.action', '101107', '2', '', null, '', '1', '1', '402880e449a80ec10149a811ae6d0003', '101');
INSERT INTO `tbmenu` VALUES ('402880e449a80ec10149a81309b7000c', '投注', 'bettingAction!findList.action', '101108', '2', '', null, '', '1', '1', '402880e449a80ec10149a811ae6d0003', '101');
INSERT INTO `tbmenu` VALUES ('402880e449a80ec10149a8132b88000d', '银行类别', 'banktypeAction!findList.action', '101109', '2', '', null, '', '1', '1', '402880e449a80ec10149a811ae6d0003', '101');
INSERT INTO `tbmenu` VALUES ('402880e449a80ec10149a81351ec000e', '地区', 'areaAction!main.action', '101110', '2', '', null, '', '0', '1', '402880e449a80ec10149a811ae6d0003', '101');
INSERT INTO `tbmenu` VALUES ('402880e449a80ec10149a8137785000f', '后台银行', 'bbankcardAction!findList.action', '101111', '2', '', null, '', '1', '1', '402880e449a80ec10149a811ae6d0003', '101');
INSERT INTO `tbmenu` VALUES ('402880e449a80ec10149a81398f70010', '游戏路线', 'gamerouteAction!findList.action', '101112', '2', '', null, '', '1', '1', '402880e449a80ec10149a811ae6d0003', '101');
INSERT INTO `tbmenu` VALUES ('402880e449a80ec10149a813bc000011', '左浮动', 'leftfloatAction!findList.action', '101113', '2', '', null, '', '1', '1', '402880e449a80ec10149a811ae6d0003', '101');
INSERT INTO `tbmenu` VALUES ('402880e449a80ec10149a8142a0c0012', '业务管理', '#', '102', '1', '', null, '', '1', '1', 'root', '0');
INSERT INTO `tbmenu` VALUES ('402880e449a80ec10149a81463d90013', '代理账号绑定', 'proxybindAction!findProxyList.action', '102100', '2', '', null, '', '1', '1', '402880e449a80ec10149a8142a0c0012', '102');
INSERT INTO `tbmenu` VALUES ('402880e449a80ec10149a81483a50014', '第三方支付信息', 'thirdPayAction!findList.action', '102101', '2', '', null, '', '1', '1', '402880e449a80ec10149a8142a0c0012', '102');
INSERT INTO `tbmenu` VALUES ('402880e449a80ec10149a814a6dd0015', '会员信息管理', 'memberInfoAction!findList.action', '102102', '2', '', null, '', '1', '1', '402880e449a80ec10149a8142a0c0012', '102');
INSERT INTO `tbmenu` VALUES ('402880e449a80ec10149a814d2ee0016', '代理信息管理', 'agentInfoAction!findList.action', '102103', '2', '', null, '', '1', '1', '402880e449a80ec10149a8142a0c0012', '102');
INSERT INTO `tbmenu` VALUES ('402880e449a80ec10149a814f3470017', '审核金额管理', 'orderAction!findList.action', '102104', '2', '', null, '', '1', '1', '402880e449a80ec10149a8142a0c0012', '102');
INSERT INTO `tbmenu` VALUES ('402880e449a80ec10149a81525540018', '取款信息管理', 'withdrawAction!findList.action', '102105', '2', '', null, '', '1', '1', '402880e449a80ec10149a8142a0c0012', '102');
INSERT INTO `tbmenu` VALUES ('402880e449a80ec10149a81547e00019', '前台银行管理', 'qbankcardAction!findList.action', '102106', '2', '', null, '', '0', '1', '402880e449a80ec10149a8142a0c0012', '102');
INSERT INTO `tbmenu` VALUES ('402880e449ad21ef0149ad22d4dc0000', '提交问题管理', 'problemAction!findList.action', '102107', '2', '', null, '', '1', '1', '402880e449a80ec10149a8142a0c0012', '102');
INSERT INTO `tbmenu` VALUES ('402880e44a36cde4014a3720301f0005', '底部连接', '#', '103', '1', '', null, '', '1', '1', 'root', '0');
INSERT INTO `tbmenu` VALUES ('402880e44a36cde4014a372beea70006', '免责声明', 'disclaimerAction!findList.action', '103100', '2', '', null, '', '0', '1', '402880e44a36cde4014a3720301f0005', '103');
INSERT INTO `tbmenu` VALUES ('402880e44a36cde4014a372debbf0007', '规则与条件', 'responsibilityAction!findList.action', '103101', '2', '', null, '', '0', '1', '402880e44a36cde4014a3720301f0005', '103');
INSERT INTO `tbmenu` VALUES ('402880e44a389395014a38955f660000', '隐私权政策', 'privacypolicyAction!findList.action', '103102', '2', '', null, '', '0', '1', '402880e44a36cde4014a3720301f0005', '103');
INSERT INTO `tbmenu` VALUES ('402880e44a389395014a38ac3c4e0028', '餐饮服务', 'diningAction!findList.action', '103103', '2', '', null, '', '0', '1', '402880e44a36cde4014a3720301f0005', '103');
INSERT INTO `tbmenu` VALUES ('402880e44a3bf354014a3c1df5bd0004', '集团简介', 'groupAction!findList.action', '103104', '2', '', null, '', '1', '1', '402880e44a36cde4014a3720301f0005', '103');
INSERT INTO `tbmenu` VALUES ('402880e44a3bf354014a3c1ebdff0005', '旅游观光', 'travelAction!findList.action', '103105', '2', '', null, '', '0', '1', '402880e44a36cde4014a3720301f0005', '103');
INSERT INTO `tbmenu` VALUES ('402880e44a3bf354014a3c23df5a0006', '影视音乐', 'televisionAction!findList.action', '103106', '2', '', null, '', '0', '1', '402880e44a36cde4014a3720301f0005', '103');
INSERT INTO `tbmenu` VALUES ('402880e44a3bf354014a3c24b3820007', '会员咨询', 'consultingAction!findList.action', '103107', '2', '', null, '', '0', '1', '402880e44a36cde4014a3720301f0005', '103');
INSERT INTO `tbmenu` VALUES ('402880e44a3bf354014a3c325cd3002e', '支付类型', 'payTypeAction!main.action', '101114', '2', '', null, '', '1', '1', '402880e449a80ec10149a811ae6d0003', '101');
INSERT INTO `tbmenu` VALUES ('402880e44a4c7b57014a4c7e25050000', '帮助中心', 'helpAction!main.action', '101115', '2', '', null, '', '1', '1', '402880e449a80ec10149a811ae6d0003', '101');
INSERT INTO `tbmenu` VALUES ('402880e44a6113d9014a6115909a0001', '代理商', 'agentsAction!findList.action', '102108', '2', '', null, '', '1', '1', '402880e449a80ec10149a8142a0c0012', '102');
INSERT INTO `tbmenu` VALUES ('402880e44a615fee014a616131af0001', '手动存取款', 'manualaccessAction!findList.action', '102109', '2', '', null, '', '1', '1', '402880e449a80ec10149a8142a0c0012', '102');
INSERT INTO `tbmenu` VALUES ('402880e44a7503b3014a750556c30001', '支付介绍', 'payintroductionAction!findList.action', '101116', '2', '', null, '', '1', '1', '402880e449a80ec10149a811ae6d0003', '101');
INSERT INTO `tbmenu` VALUES ('402880e44a75a206014a75ab36150003', '已审核金额管理', 'orderAction!findListFinish.action', '102110', '2', '', null, '', '1', '1', '402880e449a80ec10149a8142a0c0012', '102');
INSERT INTO `tbmenu` VALUES ('402880e44a9f75cd014a9f78ea3f0000', '第三方充值管理', 'orderAction!findListThree.action', '102111', '2', '', null, '', '1', '1', '402880e449a80ec10149a8142a0c0012', '102');
INSERT INTO `tbmenu` VALUES ('402880e44ab2f147014ab30a40a20002', '客服代码', 'customercodeAction!findList.action', '101117', '2', '', null, '', '0', '1', '402880e449a80ec10149a811ae6d0003', '101');
INSERT INTO `tbmenu` VALUES ('402880e44ac83e49014ac85307a80002', '下载配置', 'loadtempAction!findList.action', '101118', '2', '', null, '', '1', '1', '402880e449a80ec10149a811ae6d0003', '101');
INSERT INTO `tbmenu` VALUES ('402880ee4b0f5c63014b0f5ddafd0001', '统计', 'manualaccessAction!statistics.action', '102112', '2', '', null, '', '1', '1', '402880e449a80ec10149a8142a0c0012', '102');
INSERT INTO `tbmenu` VALUES ('402880ee4b2a5bcd014b2a722a500002', '网站管理', '#', '104', '1', '', null, '', '1', '1', 'root', '0');
INSERT INTO `tbmenu` VALUES ('402880ee4b2a5bcd014b2a78551c0008', '文件管理', 'filemanageAction!redirect.action', '104100', '2', '', null, '', '1', '1', '402880ee4b2a5bcd014b2a722a500002', '104');
INSERT INTO `tbmenu` VALUES ('402880ee4b2e116f014b2e2ec686000c', '导航栏信息', 'navinfoAction!findList.action', '104101', '2', '', null, '', '1', '1', '402880ee4b2a5bcd014b2a722a500002', '104');
INSERT INTO `tbmenu` VALUES ('402880ee4b2ea587014b2ea79f2b0003', '样式管理', 'cssclassAction!findList.action', '104102', '2', '', null, '', '0', '1', '402880ee4b2a5bcd014b2a722a500002', '104');
INSERT INTO `tbmenu` VALUES ('402880ee4b34b7c6014b34badb100001', '轮播管理', 'carouselAction!findList.action', '104103', '2', '', null, '', '1', '1', '402880ee4b2a5bcd014b2a722a500002', '104');
INSERT INTO `tbmenu` VALUES ('402880ee4b34ded3014b34e2b8530000', '页面管理', 'pageAction!findList.action', '104104', '2', '', null, '', '1', '1', '402880ee4b2a5bcd014b2a722a500002', '104');
INSERT INTO `tbmenu` VALUES ('402880ee4b4ea251014b4ea3625f0001', '总统计', 'manualaccessAction!zstatistics.action?qk=1&yh=1&wy=1&sdck=1&sdqk=1&sdcj=1', '102113', '2', '', null, '', '1', '1', '402880e449a80ec10149a8142a0c0012', '102');
INSERT INTO `tbmenu` VALUES ('402880ee4b5cc931014b5d007b490017', 'logo管理', 'logomanageAction!findList.action', '104105', '2', '', null, '', '1', '1', '402880ee4b2a5bcd014b2a722a500002', '104');
INSERT INTO `tbmenu` VALUES ('402880ee4b710552014b71079e190001', '网站标题', 'logomanageAction!findTitle.action', '104106', '2', '', null, '', '1', '1', '402880ee4b2a5bcd014b2a722a500002', '104');
INSERT INTO `tbmenu` VALUES ('402880ee4b7721c0014b774c31370001', '会员注册设置', 'registersiteAction!addxx.action', '104107', '2', '', null, '', '1', '1', '402880ee4b2a5bcd014b2a722a500002', '104');
INSERT INTO `tbmenu` VALUES ('402880ee4b77c712014b77ccbd9a0001', '左下角广告', 'zxadvAction!findList.action', '104108', '2', '', null, '', '1', '1', '402880ee4b2a5bcd014b2a722a500002', '104');
INSERT INTO `tbmenu` VALUES ('402880ee4be86c23014be8b1be190000', '基本页面', '#', '100105', '2', '', null, '', '1', '1', '4028fe81495b5a0201495b7804100005', '100');
INSERT INTO `tbmenu` VALUES ('402880ee4c692c9f014c69a9f5d4000e', '模块搭建', 'zdyAction!findList.action', '104109', '2', '', null, '', '1', '1', '402880ee4b2a5bcd014b2a722a500002', '104');
INSERT INTO `tbmenu` VALUES ('4028fe81495b5a0201495b7804100005', '系统管理', '#', '100', '1', '#', null, '', '1', '1', 'root', '0');
INSERT INTO `tbmenu` VALUES ('4028fe81495b5a0201495b78b4130006', '菜单管理', 'bmenuAction!redirect.action', '100100', '2', '#', null, '', '1', '1', '4028fe81495b5a0201495b7804100005', '100');
INSERT INTO `tbmenu` VALUES ('4028fe814a5bf2cd014a5bf50a230001', '系统日志', 'syslogAction!findlist.action', '100104', '2', '#', null, '', '1', '1', '4028fe81495b5a0201495b7804100005', '100');

-- ----------------------------
-- Table structure for `tbuser`
-- ----------------------------
DROP TABLE IF EXISTS `tbuser`;
CREATE TABLE `tbuser` (
  `ID` varchar(100) NOT NULL,
  `LNAME` varchar(50) default NULL,
  `PASSWORD` varchar(50) default NULL,
  `UNAME` varchar(50) default NULL,
  `SEX` char(2) default NULL,
  `EMAIL` varchar(50) default NULL,
  `TELEPHONE` char(10) default NULL,
  `MOBILE` varchar(20) default NULL,
  `QQ` varchar(20) default NULL,
  `REMARK` varchar(100) default NULL,
  `ISACTIVES` char(1) default NULL,
  `ISSUPERADMIN` char(1) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbuser
-- ----------------------------
INSERT INTO `tbuser` VALUES ('402880e449a8664a0149a87875470000', 'chenhb', '4QrcOUm6Wau+VuBX8g+IPg==', 'chb', null, '', '', '', '', '', '1', null);
INSERT INTO `tbuser` VALUES ('402880e44a615fee014a6165fbc20002', 'admin', '4QrcOUm6Wau+VuBX8g+IPg==', '超级管理员', null, '', '', '', '', '', '1', '1');

-- ----------------------------
-- Table structure for `tbuserrole`
-- ----------------------------
DROP TABLE IF EXISTS `tbuserrole`;
CREATE TABLE `tbuserrole` (
  `ID` varchar(100) NOT NULL,
  `ROLEID` varchar(100) default NULL,
  `BUSERID` varchar(100) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbuserrole
-- ----------------------------
INSERT INTO `tbuserrole` VALUES ('402880e449a8664a0149a8792d2d0005', '402880e449a8664a0149a878c82a0001', '402880e449a8664a0149a87875470000');
INSERT INTO `tbuserrole` VALUES ('402880e44a615fee014a616a3c430007', '402880e4497d786401497d79c03d0000', '402880e44a615fee014a6165fbc20002');

-- ----------------------------
-- Table structure for `trole`
-- ----------------------------
DROP TABLE IF EXISTS `trole`;
CREATE TABLE `trole` (
  `ID` varchar(100) NOT NULL,
  `RNAME` varchar(50) default NULL,
  `CREATOR` varchar(100) default NULL,
  `ISACTIVES` char(1) default NULL,
  `REMARK` varchar(100) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trole
-- ----------------------------
INSERT INTO `trole` VALUES ('402880e4497d786401497d79c03d0000', '系统管理员', '402880e44a615fee014a6165fbc20002', '1', null);
INSERT INTO `trole` VALUES ('402880e449a8664a0149a878c82a0001', '测试', '402880e44a615fee014a6165fbc20002', '1', null);
