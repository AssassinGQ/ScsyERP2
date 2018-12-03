package TestService;

import cn.AssassinG.ScsyERP.BasicInfo.core.biz.WarehouseBiz;
import cn.AssassinG.ScsyERP.BasicInfo.core.dao.WarehouseDao;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Warehouse;
import cn.AssassinG.ScsyERP.BasicInfo.facade.service.WarehouseServiceFacade;
import cn.AssassinG.ScsyERP.common.page.PageBean;
import cn.AssassinG.ScsyERP.common.page.PageParam;
import cn.AssassinG.ScsyERP.common.utils.StringUtils;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-context.xml"})
public class WarehouseServiceFacadeImplTest {
    private static Logger logger = Logger.getLogger(WarehouseServiceFacadeImplTest.class);
    @Autowired
    private WarehouseServiceFacade warehouseService;
    @Autowired
    private WarehouseBiz warehouseBiz;
    @Autowired
    private WarehouseDao warehouseDao;

    private Long warehouseId;

    @Before
    public void setUp() throws Exception {
        Warehouse warehouse = new Warehouse();
        warehouse.setCorporation(1L);
        warehouse.setAddress(StringUtils.getRandomStr(40));
        warehouse.setAdmin(1L);
        warehouse.setName(StringUtils.getRandomStr(6));
        warehouseId = warehouseBiz.create(warehouse);
    }

    @After
    public void tearDown() throws Exception {
        warehouseDao.delete(warehouseId);
    }

    @Test
    public void create() {
        Warehouse warehouse = new Warehouse();
        warehouse.setCorporation(1L);
        warehouse.setAddress(StringUtils.getRandomStr(40));
        warehouse.setAdmin(1L);
        warehouse.setName(StringUtils.getRandomStr(8));
        Long id = warehouseService.create(warehouse);
        if(id == null){
            throw new RuntimeException("Create nothing");
        }else {
            logger.info("Created : " + warehouseDao.getById(id));
        }
    }

    @Test
    public void update() {
        Warehouse warehouse = warehouseDao.getById(warehouseId);
        String new_name = StringUtils.getRandomStr(6);
        logger.info("Before Update: "+warehouse);
        warehouse.setName(new_name);
        warehouseService.update(warehouse);
        Warehouse warehouse_check = warehouseDao.getById(warehouseId);
        if(!warehouse_check.getName().equals(new_name)){
            throw new RuntimeException("Update failed");
        }else{
            logger.info("Updated succeed");
        }
    }

    @Test
    public void deleteById() {
        warehouseService.deleteById(warehouseId);
        Warehouse warehouse_check = warehouseDao.getById(warehouseId);
        if(!warehouse_check.getIfDeleted()){
            throw new RuntimeException("Delete failed");
        }else {
            logger.info("Delete succeed");
        }
    }

    @Test
    public void delete() {
        Warehouse warehouse_test = warehouseDao.getById(warehouseId);
        warehouseService.delete(warehouse_test);
        Warehouse warehouse_check = warehouseDao.getById(warehouseId);
        if(!warehouse_check.getIfDeleted()){
            throw new RuntimeException("Delete failed");
        }else {
            logger.info("Delete succeed");
        }
    }

    @Test
    public void getById() {
        Warehouse warehouse = warehouseService.getById(warehouseId);
        if(warehouse == null || warehouse.getIfDeleted()){
            throw new RuntimeException("getById null");
        }else{
            if(warehouse.getId().longValue() != warehouseId.longValue()){
                throw new RuntimeException("getById failed");
            }else{
                logger.info("getById succeed");
            }
        }
    }

    @Test
    public void getBy() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("IfDeleted", false);
        paramMap.put("Id", warehouseId);
        Warehouse warehouse = warehouseService.getBy(paramMap);
        if(warehouse.getId() != warehouseId){
            throw new RuntimeException("getBy failed");
        }else{
            logger.info("getBy succeed");
        }
    }

    @Test
    public void listBy() {
        Warehouse warehouse = warehouseDao.getById(warehouseId);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("IfDeleted", false);
        paramMap.put("Name", warehouse.getName());
        List<Warehouse> warehouses = warehouseService.listBy(paramMap);
        for (int i = 0; i < warehouses.size(); i++)
            logger.info("Item" + i + ":" + warehouses.get(i));
    }

    @Test
    public void listPage() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("IfDeleted", false);
        PageParam pageParam = new PageParam(2, 2);
        PageBean<Warehouse> pageBean = warehouseService.listPage(pageParam, paramMap);
        logger.info(pageBean);
        List<Warehouse> warehouses = pageBean.getRecordList();
        for (int i = 0; i < warehouses.size(); i++)
            logger.info("Item" + i + ":" + warehouses.get(i));
    }

//    @Test
//    public void createWithUser() {
//        Warehouse warehouse = new Warehouse();
//        warehouse.setCorporation(1L);
//        warehouse.setDept(WarehouseDeptType.FinancialWarehouse);
//        User user = new User();
//        user.setUserName(StringUtils.getRandomStr(8));
//        user.setPassWord("d123456");
//        user.setPhone("188" + StringUtils.getRandomStr(8, StringUtils.StrType.NUMBER));
//        user.setCorporation(1L);
//        warehouseService.createWithUser(warehouse, user);
//        if(user.getUserType() != UserType.Warehouse || user.getUserInfo().longValue() != warehouse.getId().longValue()){
//            throw new RuntimeException("createWithUser failed");
//        }else {
//            logger.info("createWithUser succeed : WarehouseID:" + warehouse.getId() + ", userID:" + user.getId());
//        }
//    }

    @Test
    public void updateByMap() {
        String new_name = StringUtils.getRandomStr(6);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("name", new_name);
        warehouseService.updateByMap(warehouseId, paramMap);
        Warehouse warehouse_check = warehouseDao.getById(warehouseId);
        if(!warehouse_check.getName().equals(new_name)){
            throw new RuntimeException("updateByMap failed");
        }else{
            logger.info("updateByMap succeed");
        }
    }

//    @Test
//    public void deleteByUserId() {
//        warehouseService.deleteByUserId(userId);
//        User user_check = userDao.getById(userId);
//        if(user_check == null || !user_check.getIfDeleted() || user_check.getUserType().getValue().intValue() != UserType.Warehouse.getValue().intValue()){
//            throw new RuntimeException("deleteByUserId failed");
//        }
//        Warehouse warehouse_check = warehouseDao.getById(user_check.getUserInfo());
//        if(warehouse_check == null || !warehouse_check.getIfDeleted()){
//            throw new RuntimeException("deleteByUserId failed");
//        }
//        logger.info("deleteByUserId succeed");
//    }
}