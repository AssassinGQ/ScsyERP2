package TestDao;

import cn.AssassinG.ScsyERP.BasicInfo.core.dao.WarehouseDao;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Warehouse;
import cn.AssassinG.ScsyERP.common.page.PageBean;
import cn.AssassinG.ScsyERP.common.page.PageParam;
import cn.AssassinG.ScsyERP.common.utils.StringUtils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-context.xml"})
public class TestWarehouse {
    private static Logger logger = Logger.getLogger(TestWarehouse.class);
    @Autowired
    private WarehouseDao warehouseDao;

    @Test
    public void testGetById() {
        Long warehouse_id = 1L;
        Warehouse warehouse = warehouseDao.getById(warehouse_id);
        if(warehouse == null || warehouse.getId() == null || warehouse.getId().longValue() != warehouse_id.longValue()){
            throw  new RuntimeException("getById failed");
        }else {
            logger.info("GetById success");
        }
    }

    @Test
    public void testInsert() {
        Warehouse warehouse = new Warehouse();
        warehouse.setName("asddf");
        warehouse.setCorporation(1L);
        warehouse.setAddress("浙江绍兴");
        warehouse.setAdmin(1L);
        warehouseDao.insert(warehouse);
        Long id = warehouse.getId();
        if(id == null){
            throw new RuntimeException("insert nothing");
        }else {
            logger.info("Inserted : " + warehouseDao.getById(id));
        }
    }

    @Test
    public void testBatchInsert() {
        Warehouse warehouse = new Warehouse();
        warehouse.setName("asddf3");
        warehouse.setCorporation(1L);
        warehouse.setAddress("浙江绍兴");
        warehouse.setAdmin(1L);
        Warehouse warehouse1 = new Warehouse();
        warehouse1.setName("asddf4");
        warehouse1.setCorporation(1L);
        warehouse1.setAddress("浙江绍兴");
        warehouse1.setAdmin(1L);
        List<Warehouse> warehouses = new ArrayList<Warehouse>();
        warehouses.add(warehouse);
        warehouses.add(warehouse1);
        int result = warehouseDao.insert(warehouses);
        if(result != warehouses.size()){
            throw new RuntimeException("BatchInsert failed " + (warehouses.size()-result) + "s, succeed " + result + "s");
        }else if(warehouse.getId() == null || warehouse1.getId() == null){
            throw new RuntimeException("BatchInsert failed");
        }else{
            logger.info("BatchInserted succeed");
        }
    }

    @Test
    public void testUpdate() {
        Warehouse warehouse = warehouseDao.getById(2);
        String new_name = StringUtils.getRandomStr(6);
        logger.info("Before Update: "+warehouse);
        warehouse.setName(new_name);
        warehouseDao.update(warehouse);
        Warehouse warehouse_check = warehouseDao.getById(2);
        if(!warehouse_check.getName().equals(new_name)){
            throw new RuntimeException("Update failed");
        }else{
            logger.info("Updated succeed");
        }
    }

    @Test
    public void testBatchUpdate() {
        Warehouse warehouse2 = warehouseDao.getById(2);
        Warehouse warehouse4 = warehouseDao.getById(4);
        String new_name_1 = StringUtils.getRandomStr(6);
        String new_name_2 = StringUtils.getRandomStr(6);
        warehouse2.setName(new_name_1);
        warehouse4.setName(new_name_2);
        List<Warehouse> warehouses = new ArrayList<Warehouse>();
        warehouses.add(warehouse2);
        warehouses.add(warehouse4);
        warehouseDao.update(warehouses);
        Warehouse warehouse2_check = warehouseDao.getById(2);
        Warehouse warehouse4_check = warehouseDao.getById(4);
        if(!warehouse2_check.getName().equals(new_name_1)){
            throw new RuntimeException("Warehouse2 update failed");
        }
        if(!warehouse4_check.getName().equals(new_name_2)){
            throw new RuntimeException("Warehouse4 update failed");
        }
        if(warehouse2_check.getName().equals(new_name_1) && warehouse4_check.getName().equals(new_name_2)){
            logger.info("BatchUpdated succeed");
        }
    }

    @Test
    public void testDeleteById() {
        Long delete_id = 2L;
        warehouseDao.delete(delete_id);
        Warehouse warehouse_check = warehouseDao.getById(delete_id);
        if(!warehouse_check.getIfDeleted()){
            throw new RuntimeException("Delete failed");
        }else {
            logger.info("Delete succeed");
        }
    }

    @Test
    public void testDelete() {
        Long delete_id = 4L;
        Warehouse warehouse = warehouseDao.getById(delete_id);
        warehouseDao.delete(warehouse);
        Warehouse warehouse_check = warehouseDao.getById(delete_id);
        if(!warehouse_check.getIfDeleted()){
            throw new RuntimeException("Delete failed");
        }else {
            logger.info("Delete succeed");
        }
    }

    @Test
    public void testListAll() {
        List<Warehouse> warehouses = warehouseDao.listAll();
        for (int i = 0; i < warehouses.size(); i++)
            logger.info("Item" + i + ":" + warehouses.get(i));
    }

    @Test
    public void testGetBy() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ifDeleted", true);
        paramMap.put("Id", 1L);
        Warehouse warehouse = warehouseDao.getBy(paramMap);
        if(warehouse.getId().longValue() != 1L){
            throw new RuntimeException("GetBy failed");
        }else{
            logger.info("GetBy succeed");
        }
    }

    @Test
    public void testListBy() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
//        paramMap.put("IsDeleted", false);
        paramMap.put("WarehouseName", "admi");
        List<Warehouse> warehouses = warehouseDao.listBy(paramMap);
        for (int i = 0; i < warehouses.size(); i++)
            logger.info("Item" + i + ":" + warehouses.get(i));
    }

    @Test
    public void testListPage() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ifDeleted", false);
        PageParam pageParam = new PageParam(2, 2);
        PageBean<Warehouse> pageBean = warehouseDao.listPage(pageParam, paramMap);
        logger.info(pageBean);
        List<Warehouse> warehouses = pageBean.getRecordList();
//        if(warehouses.size() != 2){
//            throw new RuntimeException("ListPage failed");
//        }
        for (int i = 0; i < warehouses.size(); i++)
            logger.info("Item" + i + ":" + warehouses.get(i));
    }
}
