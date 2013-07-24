DROP TABLE g_link;
CREATE TABLE g_link (id bigint NOT NULL AUTO_INCREMENT, link_name varchar(100), link_url varchar(200), period bigint, etime bigint, PRIMARY KEY (id)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
