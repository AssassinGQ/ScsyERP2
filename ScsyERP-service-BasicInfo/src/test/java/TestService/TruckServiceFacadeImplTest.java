package TestService;

import cn.AssassinG.ScsyERP.BasicInfo.core.biz.TruckBiz;
import cn.AssassinG.ScsyERP.BasicInfo.core.dao.TruckDao;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Truck;
import cn.AssassinG.ScsyERP.BasicInfo.facade.service.TruckServiceFacade;
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
public class TruckServiceFacadeImplTest {
    private static Logger logger = Logger.getLogger(TruckServiceFacadeImplTest.class);
    @Autowired
    private TruckServiceFacade truckService;
    @Autowired
    private TruckBiz truckBiz;
    @Autowired
    private TruckDao truckDao;

    private Long truckId;

    @Before
    public void setUp() throws Exception {
        Truck truck = new Truck();
        truck.setCorporation(1L);
        truck.setCarNumber(StringUtils.getRandomStr(8));
        truck.setName(StringUtils.getRandomStr(6));
        truckId = truckBiz.create(truck);
    }

    @After
    public void tearDown() throws Exception {
        truckDao.delete(truckId);
    }

    @Test
    public void create() {
        Truck truck = new Truck();
        truck.setCorporation(1L);
        truck.setCarNumber(StringUtils.getRandomStr(8));
        truck.setName(StringUtils.getRandomStr(8));
        Long id = truckService.create(truck);
        if(id == null){
            throw new RuntimeException("Create nothing");
        }else {
            logger.info("Created : " + truckDao.getById(id));
        }
    }

    @Test
    public void update() {
        Truck truck = truckDao.getById(truckId);
        String new_name = StringUtils.getRandomStr(6);
        logger.info("Before Update: "+truck);
        truck.setName(new_name);
        truckService.update(truck);
        Truck truck_check = truckDao.getById(truckId);
        if(!truck_check.getName().equals(new_name)){
            throw new RuntimeException("Update failed");
        }else{
            logger.info("Updated succeed");
        }
    }

    @Test
    public void deleteById() {
        truckService.deleteById(truckId);
        Truck truck_check = truckDao.getById(truckId);
        if(!truck_check.getIfDeleted()){
            throw new RuntimeException("Delete failed");
        }else {
            logger.info("Delete succeed");
        }
    }

    @Test
    public void delete() {
        Truck truck_test = truckDao.getById(truckId);
        truckService.delete(truck_test);
        Truck truck_check = truckDao.getById(truckId);
        if(!truck_check.getIfDeleted()){
            throw new RuntimeException("Delete failed");
        }else {
            logger.info("Delete succeed");
        }
    }

    @Test
    public void getById() {
        Truck truck = truckService.getById(truckId);
        if(truck == null || truck.getIfDeleted()){
            throw new RuntimeException("getById null");
        }else{
            if(truck.getId().longValue() != truckId.longValue()){
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
        paramMap.put("Id", truckId);
        Truck truck = truckService.getBy(paramMap);
        if(truck.getId() != truckId){
            throw new RuntimeException("getBy failed");
        }else{
            logger.info("getBy succeed");
        }
    }

    @Test
    public void listBy() {
        Truck truck = truckDao.getById(truckId);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("IfDeleted", false);
        paramMap.put("Name", truck.getName());
        List<Truck> trucks = truckService.listBy(paramMap);
        for (int i = 0; i < trucks.size(); i++)
            logger.info("Item" + i + ":" + trucks.get(i));
    }

    @Test
    public void listPage() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("IfDeleted", false);
        PageParam pageParam = new PageParam(2, 2);
        PageBean<Truck> pageBean = truckService.listPage(pageParam, paramMap);
        logger.info(pageBean);
        List<Truck> trucks = pageBean.getRecordList();
        for (int i = 0; i < trucks.size(); i++)
            logger.info("Item" + i + ":" + trucks.get(i));
    }

//    @Test
//    public void createWithUser() {
//        Truck truck = new Truck();
//        truck.setCorporation(1L);
//        truck.setDept(TruckDeptType.FinancialTruck);
//        User user = new User();
//        user.setUserName(StringUtils.getRandomStr(8));
//        user.setPassWord("d123456");
//        user.setPhone("188" + StringUtils.getRandomStr(8, StringUtils.StrType.NUMBER));
//        user.setCorporation(1L);
//        truckService.createWithUser(truck, user);
//        if(user.getUserType() != UserType.Truck || user.getUserInfo().longValue() != truck.getId().longValue()){
//            throw new RuntimeException("createWithUser failed");
//        }else {
//            logger.info("createWithUser succeed : TruckID:" + truck.getId() + ", userID:" + user.getId());
//        }
//    }

    @Test
    public void updateByMap() {
        String new_name = StringUtils.getRandomStr(6);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("name", new_name);
        truckService.updateByMap(truckId, paramMap);
        Truck truck_check = truckDao.getById(truckId);
        if(!truck_check.getName().equals(new_name)){
            throw new RuntimeException("updateByMap failed");
        }else{
            logger.info("updateByMap succeed");
        }
    }

//    @Test
//    public void deleteByUserId() {
//        truckService.deleteByUserId(userId);
//        User user_check = userDao.getById(userId);
//        if(user_check == null || !user_check.getIfDeleted() || user_check.getUserType().getValue().intValue() != UserType.Truck.getValue().intValue()){
//            throw new RuntimeException("deleteByUserId failed");
//        }
//        Truck truck_check = truckDao.getById(user_check.getUserInfo());
//        if(truck_check == null || !truck_check.getIfDeleted()){
//            throw new RuntimeException("deleteByUserId failed");
//        }
//        logger.info("deleteByUserId succeed");
//    }
}