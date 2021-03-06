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
        String sql = "insert into g_goods(title,sales_title,cost_price,seckill_price,discount_price,manual_price,diff_price,link_url) "
                + "values(?,?,?,?,?,?,?,?)";
        Object para[] = new Object[]{goods.getTitle(),goods.getSalesTitle(),goods.getCostPrice(),
            goods.getSeckillPrice(),goods.getDiscountPrice(),goods.getManualPrice(),goods.getDiffPrice(),goods.getLink()};
        jdbcTemplate.update(sql, para);
    }
    
    public void updateGoods(Goods goods){
        String sql ="update g_goods set cost_price=?,discount_price=?,diff_price=?,link_url=? where id=?";
        Object para[] = new Object[]{goods.getCostPrice(),goods.getDiscountPrice(),goods.getDiffPrice(),goods.getLink(),goods.getId()};
        jdbcTemplate.update(sql,para);
    }
    
    public void updateGoodsManualPrice(Goods goods){
        String sql = "update g_goods set manual_price = ? where id=?";
        jdbcTemplate.update(sql,new Object[]{goods.getManualPrice(),goods.getId()});
    }
    
    public void updateAllGoods(Goods goods){
        String sql = "update g_goods set discount_price=?,manual_price=?,diff_price=?,discount_rate=? where id=? ";
        Object para[] = new Object[]{goods.getDiscountPrice(),goods.getManualPrice(),goods.getDiffPrice(),goods.getDiscountRate(),goods.getId()};
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
        String sql = "select * from g_goods";
        return jdbcTemplate.query(sql,new GoodsMapper());
    }
    
    public List<Goods> getlGoods(String title){
        String sql = "select * from g_goods where title like " + "'%"+title+"%'";
        return jdbcTemplate.query(sql,new GoodsMapper());
    }
    
    public void delGoods(long id){
        String sql = "delete from g_goods where id = ?";
        jdbcTemplate.update(sql,new Object[]{id});
    }
    
     private static final class GoodsMapper implements RowMapper<Goods> {
        @Override
        public Goods mapRow(ResultSet rs, int paramInt) throws SQLException {
            // TODO Auto-generated method stub
            Goods goods = new Goods();
            goods.setId(rs.getLong("id"));
            goods.setTitle(rs.getString("title"));
            goods.setSalesTitle(rs.getString("sales_title"));
            goods.setCostPrice(rs.getLong("cost_price"));
            goods.setSeckillPrice(rs.getLong("seckill_price"));
            goods.setDiscountPrice(rs.getLong("discount_price"));
            goods.setManualPrice(rs.getLong("manual_price"));
            goods.setDiffPrice(rs.getLong("diff_price"));
            goods.setDiscountRate(rs.getLong("discount_rate"));
            goods.setLink(rs.getString("link_url"));
            return goods;
        }
    }
     
     
     
    
}
