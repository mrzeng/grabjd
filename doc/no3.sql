-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- 主机: 127.0.0.1
-- 生成日期: 2013 年 07 月 28 日 09:37
-- 服务器版本: 5.5.16
-- PHP 版本: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `no3`
--

-- --------------------------------------------------------

--
-- 表的结构 `g_goods`
--

CREATE TABLE IF NOT EXISTS `g_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `sales_title` varchar(300) NOT NULL DEFAULT '',
  `cost_price` bigint(20) NOT NULL DEFAULT '0',
  `seckill_price` bigint(20) NOT NULL DEFAULT '0',
  `discount_price` bigint(20) NOT NULL DEFAULT '0',
  `manual_price` bigint(20) NOT NULL DEFAULT '0',
  `diff_price` bigint(20) NOT NULL DEFAULT '0',
  `discount_rate`  bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `id` (`id`),
  KEY `title` (`title`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 转存表中的数据 `g_goods`
--

INSERT INTO `g_goods` (`id`, `title`, `sales_title`, `cost_price`, `seckill_price`, `discount_price`, `manual_price`, `diff_price`) VALUES
(10, 'TOSCASO 北欧风格 五星级酒店 高支高密缎档浴巾 绿色70*140cm', '', 6800, 0, 6800, 7800, 1000);

-- --------------------------------------------------------

--
-- 表的结构 `g_link`
--

CREATE TABLE IF NOT EXISTS `g_link` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `link_name` varchar(200) NOT NULL,
  `link_url` varchar(1000) NOT NULL,
  `period` bigint(20) NOT NULL,
  `etime` bigint(20) NOT NULL,
  `status` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `link_name` (`link_name`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 转存表中的数据 `g_link`
--

INSERT INTO `g_link` (`id`, `link_name`, `link_url`, `period`, `etime`, `status`) VALUES
(4, 'TOSCASO 北欧风格 五星级酒店 高支高密缎档浴巾 绿色70*140cm ', 'http://www.amazon.cn/gp/product/B00CJ32TC8/ref=s9_simh_gw_p201_d0_i5?pf_rd_m=A1AJ19PSB66TGU&pf_rd_s=center-5&pf_rd_r=0EEA7PY9F09JCDG64TD8&pf_rd_t=101&pf_rd_p=58223252&pf_rd_i=899254051', 10, 1374996985049, 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
