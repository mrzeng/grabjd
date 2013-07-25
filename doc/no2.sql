DROP TABLE g_goods;
CREATE TABLE g_goods (id bigint NOT NULL AUTO_INCREMENT, title varchar(200), cost_price bigint, discount_price bigint, PRIMARY KEY (id)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE g_link;
CREATE TABLE g_link (id bigint NOT NULL AUTO_INCREMENT, link_name varchar(100), link_url varchar(200), period bigint, etime bigint, status tinyint, PRIMARY KEY (id)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
