/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grabjd.dao;

import grabjd.dto.Goods;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cz
 */
@Repository("goodsRepository")
public class GoodsDAO {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    
    public void insertGoods(Goods goods){
        String sql = "insert into g_goods(title,cost_price,discount_price) values(?,?,?)";
        Object para[] = new Object[]{goods.getTitle(),goods.getCostprice(),goods.getDiscountPrice()};
        jdbcTemplate.update(sql, para);
    }
    
    public void updateGoods(Goods goods){
        String sql ="update g_goods set cost_price=? ,discount_price=? where id=?";
        Object para[] = new Object[]{goods.getCostprice(),goods.getDiscountPrice(),goods.getId()};
        jdbcTemplate.update(sql,para);
    }
    
    public Goods getGoods(String title){
        String sql ="select * from g_goods where title = ?";
        Object[] para = new Object[]{title};
        List<Goods> goodsList = jdbcTemplate.query(sql, para, new GoodsMapper());
        if(goodsList != null && !goodsList.isEmpty()){
            return goodsList.get(0);
        }
        return null;
    }
    
    public List<Goods> getGoods(){
        String sql = "select * from g_goods ";
        return jdbcTemplate.query(sql,new GoodsMapper());
    }
    
    public List<Goods> getlGoods(String title){
        String sql = "select * from g_goods where title like " + "'%"+title+"%'";
        return jdbcTemplate.query(sql,new GoodsMapper());
    }
    
    
     private static final class GoodsMapper implements RowMapper<Goods> {
        @Override
        public Goods mapRow(ResultSet rs, int paramInt) throws SQLException {
            // TODO Auto-generated method stub
            Goods goods = new Goods();
            goods.setId(rs.getLong("id"));
            goods.setTitle(rs.getString("title"));
            goods.setCostprice(rs.getLong("cost_price"));
            goods.setDiscountPrice(rs.getLong("discount_price"));
            return goods;
        }
    }
    
}
