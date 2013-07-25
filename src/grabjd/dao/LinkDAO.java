/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grabjd.dao;

import grabjd.dto.Link;
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
@Repository("linkRepository")
public class LinkDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Link> getLink() {
        String sql = "SELECT * FROM g_link";
        return jdbcTemplate.query(sql, new LinkMapper());
    }
    
    
    public void insertLink(Link link){
        String sql = "insert into g_link(link_url,link_name,period,etime,status) values(?,?,?,?,?)";
        Object para[] = new Object[]{link.getLinkUrl(),link.getLinkName(),link.getPeriod(),link.getEtime(),link.getStatus()};
        jdbcTemplate.update(sql, para);
    }
    
    public void delLink(long id){
        String sql = "delete from g_link where id = ?";
        jdbcTemplate.update(sql, new Object[]{id});
    }
    
    public Link getLink(long id){
        String sql = "select * from g_link where id = ?";
        return jdbcTemplate.queryForObject(sql, new LinkMapper(),new Object[]{id});
    }
    
    public List<Link> getLinkByTime(long ctime){
        String sql = "select * from g_link where status = 1 and etime <= ? ";
        return jdbcTemplate.query(sql, new LinkMapper(),new Object[]{ctime});
    }
    
    public void updateLink(Link link){
        String sql = "update g_link set link_name=?,link_url=?,period=?,etime=?,status=? where id=?";
        jdbcTemplate.update(sql,new Object[]{link.getLinkName(),link.getLinkUrl(),link.getPeriod(),link.getEtime(),link.getStatus(),link.getId()});
    }
   
    public void updateLinkeEtime(Link link){
        String sql = "update g_link set etime=? where id=?";
        jdbcTemplate.update(sql,new Object[]{link.getEtime() ,link.getId()});
    }
    private static final class LinkMapper implements RowMapper<Link> {

        @Override
        public Link mapRow(ResultSet rs, int paramInt) throws SQLException {
            // TODO Auto-generated method stub
            Link link = new Link();
            link.setId(rs.getLong("id"));
            link.setLinkName(rs.getString("link_name"));
            link.setLinkUrl(rs.getString("link_url"));
            link.setPeriod(rs.getLong("period"));
            link.setEtime(rs.getLong("etime"));
            link.setStatus(rs.getInt("status"));
            return link;
        }
    }
}
