package TestDao;

import cn.AssassinG.ScsyERP.BasicInfo.core.dao.TruckDao;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Truck;
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
public class TestTruck {
    private static Logger logger = Logger.getLogger(TestTruck.class);
    @Autowired
    private TruckDao truckDao;

    @Test
    public void testGetById() {
        Long truck_id = 1L;
        Truck truck = truckDao.getById(truck_id);
        if(truck == null || truck.getId() == null || truck.getId().longValue() != truck_id.longValue()){
            throw  new RuntimeException("getById failed");
        }else {
            logger.info("GetById success");
        }
    }

    @Test
    public void testInsert() {
        Truck truck = new Truck();
        truck.setName("asddf");
        truck.setCorporation(1L);
        truck.setCarNumber("浙A3456");
        truckDao.insert(truck);
        Long id = truck.getId();
        if(id == null){
            throw new RuntimeException("insert nothing");
        }else {
            logger.info("Inserted : " + truckDao.getById(id));
        }
    }

    @Test
    public void testBatchInsert() {
        Truck truck = new Truck();
        truck.setName("asddf3");
        truck.setCorporation(1L);
        truck.setCarNumber("浙A3456");
        Truck truck1 = new Truck();
        truck1.setName("asddf4");
        truck1.setCarNumber("浙A3456");
        truck1.setCorporation(1L);
        List<Truck> trucks = new ArrayList<Truck>();
        trucks.add(truck);
        trucks.add(truck1);
        int result = truckDao.insert(trucks);
        if(result != trucks.size()){
            throw new RuntimeException("BatchInsert failed " + (trucks.size()-result) + "s, succeed " + result + "s");
        }else if(truck.getId() == null || truck1.getId() == null){
            throw new RuntimeException("BatchInsert failed");
        }else{
            logger.info("BatchInserted succeed");
        }
    }

    @Test
    public void testUpdate() {
        Truck truck = truckDao.getById(2);
        String new_name = StringUtils.getRandomStr(6);
        logger.info("Before Update: "+truck);
        truck.setName(new_name);
        truckDao.update(truck);
        Truck truck_check = truckDao.getById(2);
        if(!truck_check.getName().equals(new_name)){
            throw new RuntimeException("Update failed");
        }else{
            logger.info("Updated succeed");
        }
    }

    @Test
    public void testBatchUpdate() {
        Truck truck2 = truckDao.getById(2);
        Truck truck4 = truckDao.getById(4);
        String new_name_1 = StringUtils.getRandomStr(6);
        String new_name_2 = StringUtils.getRandomStr(6);
        truck2.setName(new_name_1);
        truck4.setName(new_name_2);
        List<Truck> trucks = new ArrayList<Truck>();
        trucks.add(truck2);
        trucks.add(truck4);
        truckDao.update(trucks);
        Truck truck2_check = truckDao.getById(2);
        Truck truck4_check = truckDao.getById(4);
        if(!truck2_check.getName().equals(new_name_1)){
            throw new RuntimeException("Truck2 update failed");
        }
        if(!truck4_check.getName().equals(new_name_2)){
            throw new RuntimeException("Truck4 update failed");
        }
        if(truck2_check.getName().equals(new_name_1) && truck4_check.getName().equals(new_name_2)){
            logger.info("BatchUpdated succeed");
        }
    }

    @Test
    public void testDeleteById() {
        Long delete_id = 2L;
        truckDao.delete(delete_id);
        Truck truck_check = truckDao.getById(delete_id);
        if(!truck_check.getIfDeleted()){
            throw new RuntimeException("Delete failed");
        }else {
            logger.info("Delete succeed");
        }
    }

    @Test
    public void testDelete() {
        Long delete_id = 4L;
        Truck truck = truckDao.getById(delete_id);
        truckDao.delete(truck);
        Truck truck_check = truckDao.getById(delete_id);
        if(!truck_check.getIfDeleted()){
            throw new RuntimeException("Delete failed");
        }else {
            logger.info("Delete succeed");
        }
    }

    @Test
    public void testListAll() {
        List<Truck> trucks = truckDao.listAll();
        for (int i = 0; i < trucks.size(); i++)
            logger.info("Item" + i + ":" + trucks.get(i));
    }

    @Test
    public void testGetBy() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ifDeleted", true);
        paramMap.put("Id", 1L);
        Truck truck = truckDao.getBy(paramMap);
        if(truck.getId().longValue() != 1L){
            throw new RuntimeException("GetBy failed");
        }else{
            logger.info("GetBy succeed");
        }
    }

    @Test
    public void testListBy() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
//        paramMap.put("IsDeleted", false);
        paramMap.put("TruckName", "admi");
        List<Truck> trucks = truckDao.listBy(paramMap);
        for (int i = 0; i < trucks.size(); i++)
            logger.info("Item" + i + ":" + trucks.get(i));
    }

    @Test
    public void testListPage() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ifDeleted", false);
        PageParam pageParam = new PageParam(2, 2);
        PageBean<Truck> pageBean = truckDao.listPage(pageParam, paramMap);
        logger.info(pageBean);
        List<Truck> trucks = pageBean.getRecordList();
//        if(trucks.size() != 2){
//            throw new RuntimeException("ListPage failed");
//        }
        for (int i = 0; i < trucks.size(); i++)
            logger.info("Item" + i + ":" + trucks.get(i));
    }
}
