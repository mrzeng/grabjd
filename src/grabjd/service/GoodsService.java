/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grabjd.service;

import grabjd.dao.GoodsDAO;
import grabjd.dto.Goods;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cz
 */

@Service("goodsService")
public class GoodsService {
    
    @Autowired
    private GoodsDAO goodsDAO;
    
    public void saveGoods(Goods goods){
        goodsDAO.insertGoods(goods);
    }
    
    public Goods getGoods(String title){
        return goodsDAO.getGoods(title);
    }
    
    public List<Goods> getlGoods(String title){
        return goodsDAO.getlGoods(title);
    }
    
    public List<Goods> getGoods(){
        return goodsDAO.getGoods();
    }
    public void updateGoods(Goods goods){
        goodsDAO.updateGoods(goods);
    }
}
