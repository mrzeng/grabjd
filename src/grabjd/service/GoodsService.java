/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grabjd.service;

import grabjd.dao.GoodsDAO;
import grabjd.dto.Goods;
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
    
    public void updateGoods(Goods goods){
        goodsDAO.updateGoods(goods);
    }
}
