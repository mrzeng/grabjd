/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grabjd.service;

import grabjd.dao.LinkDAO;
import grabjd.dto.Link;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author cz
 */

@Service("linkService")
public class LinkService {
    
    @Resource
    private LinkDAO linkDAO;
    
    public List<Link> getLink(){
        List<Link> linkList = linkDAO.getLink();
        return linkList;
    }
    
    public void delLink(long[] ids){
        for(long delId : ids){
            linkDAO.delLink(delId);
        }
    }
    
    public Link getLinkById(long id){
        return linkDAO.getLink(id);
    }
    
    public void updateLink(Link link){
        linkDAO.updateLink(link);
    }
    
   public void saveLink(Link link){
       linkDAO.insertLink(link);
   }
   
   public List<Link> getExeLink(){
      return linkDAO.getLinkByTime(System.currentTimeMillis());
   }
    
}
