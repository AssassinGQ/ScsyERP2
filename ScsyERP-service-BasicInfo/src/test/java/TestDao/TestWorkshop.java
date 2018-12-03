package TestDao;

import cn.AssassinG.ScsyERP.BasicInfo.core.dao.WorkshopDao;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Workshop;
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
public class TestWorkshop {
    private static Logger logger = Logger.getLogger(TestWorkshop.class);
    @Autowired
    private WorkshopDao workshopDao;

    @Test
    public void testGetById() {
        Long workshop_id = 1L;
        Workshop workshop = workshopDao.getById(workshop_id);
        if(workshop == null || workshop.getId() == null || workshop.getId().longValue() != workshop_id.longValue()){
            throw  new RuntimeException("getById failed");
        }else {
            logger.info("GetById success");
        }
    }

    @Test
    public void testInsert() {
        Workshop workshop = new Workshop();
        workshop.setName("asddf");
        workshop.setCorporation(1L);
        workshop.setAddress("浙江绍兴");
        workshop.setManufacturer(1L);
        workshopDao.insert(workshop);
        Long id = workshop.getId();
        if(id == null){
            throw new RuntimeException("insert nothing");
        }else {
            logger.info("Inserted : " + workshopDao.getById(id));
        }
    }

    @Test
    public void testBatchInsert() {
        Workshop workshop = new Workshop();
        workshop.setName("asddf3");
        workshop.setCorporation(1L);
        workshop.setAddress("浙江绍兴");
        workshop.setManufacturer(1L);
        Workshop workshop1 = new Workshop();
        workshop1.setName("asddf4");
        workshop1.setCorporation(1L);
        workshop1.setAddress("浙江绍兴");
        workshop1.setManufacturer(1L);
        List<Workshop> workshops = new ArrayList<Workshop>();
        workshops.add(workshop);
        workshops.add(workshop1);
        int result = workshopDao.insert(workshops);
        if(result != workshops.size()){
            throw new RuntimeException("BatchInsert failed " + (workshops.size()-result) + "s, succeed " + result + "s");
        }else if(workshop.getId() == null || workshop1.getId() == null){
            throw new RuntimeException("BatchInsert failed");
        }else{
            logger.info("BatchInserted succeed");
        }
    }

    @Test
    public void testUpdate() {
        Workshop workshop = workshopDao.getById(2);
        String new_name = StringUtils.getRandomStr(6);
        logger.info("Before Update: "+workshop);
        workshop.setName(new_name);
        workshopDao.update(workshop);
        Workshop workshop_check = workshopDao.getById(2);
        if(!workshop_check.getName().equals(new_name)){
            throw new RuntimeException("Update failed");
        }else{
            logger.info("Updated succeed");
        }
    }

    @Test
    public void testBatchUpdate() {
        Workshop workshop2 = workshopDao.getById(2);
        Workshop workshop4 = workshopDao.getById(4);
        String new_name_1 = StringUtils.getRandomStr(6);
        String new_name_2 = StringUtils.getRandomStr(6);
        workshop2.setName(new_name_1);
        workshop4.setName(new_name_2);
        List<Workshop> workshops = new ArrayList<Workshop>();
        workshops.add(workshop2);
        workshops.add(workshop4);
        workshopDao.update(workshops);
        Workshop workshop2_check = workshopDao.getById(2);
        Workshop workshop4_check = workshopDao.getById(4);
        if(!workshop2_check.getName().equals(new_name_1)){
            throw new RuntimeException("Workshop2 update failed");
        }
        if(!workshop4_check.getName().equals(new_name_2)){
            throw new RuntimeException("Workshop4 update failed");
        }
        if(workshop2_check.getName().equals(new_name_1) && workshop4_check.getName().equals(new_name_2)){
            logger.info("BatchUpdated succeed");
        }
    }

    @Test
    public void testDeleteById() {
        Long delete_id = 2L;
        workshopDao.delete(delete_id);
        Workshop workshop_check = workshopDao.getById(delete_id);
        if(!workshop_check.getIfDeleted()){
            throw new RuntimeException("Delete failed");
        }else {
            logger.info("Delete succeed");
        }
    }

    @Test
    public void testDelete() {
        Long delete_id = 4L;
        Workshop workshop = workshopDao.getById(delete_id);
        workshopDao.delete(workshop);
        Workshop workshop_check = workshopDao.getById(delete_id);
        if(!workshop_check.getIfDeleted()){
            throw new RuntimeException("Delete failed");
        }else {
            logger.info("Delete succeed");
        }
    }

    @Test
    public void testListAll() {
        List<Workshop> workshops = workshopDao.listAll();
        for (int i = 0; i < workshops.size(); i++)
            logger.info("Item" + i + ":" + workshops.get(i));
    }

    @Test
    public void testGetBy() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ifDeleted", true);
        paramMap.put("Id", 1L);
        Workshop workshop = workshopDao.getBy(paramMap);
        if(workshop.getId().longValue() != 1L){
            throw new RuntimeException("GetBy failed");
        }else{
            logger.info("GetBy succeed");
        }
    }

    @Test
    public void testListBy() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
//        paramMap.put("IsDeleted", false);
        paramMap.put("WorkshopName", "admi");
        List<Workshop> workshops = workshopDao.listBy(paramMap);
        for (int i = 0; i < workshops.size(); i++)
            logger.info("Item" + i + ":" + workshops.get(i));
    }

    @Test
    public void testListPage() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ifDeleted", false);
        PageParam pageParam = new PageParam(2, 2);
        PageBean<Workshop> pageBean = workshopDao.listPage(pageParam, paramMap);
        logger.info(pageBean);
        List<Workshop> workshops = pageBean.getRecordList();
//        if(workshops.size() != 2){
//            throw new RuntimeException("ListPage failed");
//        }
        for (int i = 0; i < workshops.size(); i++)
            logger.info("Item" + i + ":" + workshops.get(i));
    }
}
