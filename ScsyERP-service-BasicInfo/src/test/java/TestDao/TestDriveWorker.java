package TestDao;

import cn.AssassinG.ScsyERP.BasicInfo.core.dao.DriveWorkerDao;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.DriveWorker;
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
public class TestDriveWorker {
    private static Logger logger = Logger.getLogger(TestDriveWorker.class);
    @Autowired
    private DriveWorkerDao driveWorkerDao;

    @Test
    public void testGetById() {
        Long driveWorker_id = 1L;
        DriveWorker driveWorker = driveWorkerDao.getById(driveWorker_id);
        if(driveWorker == null || driveWorker.getId() == null || driveWorker.getId().longValue() != driveWorker_id.longValue()){
            throw  new RuntimeException("getById failed");
        }else {
            logger.info("GetById success");
        }
    }

    @Test
    public void testInsert() {
        DriveWorker driveWorker = new DriveWorker();
        driveWorker.setName("asddf");
        driveWorker.setCorporation(1L);
        driveWorkerDao.insert(driveWorker);
        Long id = driveWorker.getId();
        if(id == null){
            throw new RuntimeException("insert nothing");
        }else {
            logger.info("Inserted : " + driveWorkerDao.getById(id));
        }
    }

    @Test
    public void testBatchInsert() {
        DriveWorker driveWorker = new DriveWorker();
        driveWorker.setName("asddf3");
        driveWorker.setCorporation(1L);
        DriveWorker driveWorker1 = new DriveWorker();
        driveWorker1.setName("asddf4");
        driveWorker1.setCorporation(1L);
        List<DriveWorker> driveWorkers = new ArrayList<DriveWorker>();
        driveWorkers.add(driveWorker);
        driveWorkers.add(driveWorker1);
        int result = driveWorkerDao.insert(driveWorkers);
        if(result != driveWorkers.size()){
            throw new RuntimeException("BatchInsert failed " + (driveWorkers.size()-result) + "s, succeed " + result + "s");
        }else if(driveWorker.getId() == null || driveWorker1.getId() == null){
            throw new RuntimeException("BatchInsert failed");
        }else{
            logger.info("BatchInserted succeed");
        }
    }

    @Test
    public void testUpdate() {
        DriveWorker driveWorker = driveWorkerDao.getById(2);
        String new_name = StringUtils.getRandomStr(6);
        logger.info("Before Update: "+driveWorker);
        driveWorker.setName(new_name);
        driveWorkerDao.update(driveWorker);
        DriveWorker driveWorker_check = driveWorkerDao.getById(2);
        if(!driveWorker_check.getName().equals(new_name)){
            throw new RuntimeException("Update failed");
        }else{
            logger.info("Updated succeed");
        }
    }

    @Test
    public void testBatchUpdate() {
        DriveWorker driveWorker2 = driveWorkerDao.getById(2);
        DriveWorker driveWorker4 = driveWorkerDao.getById(4);
        String new_name_1 = StringUtils.getRandomStr(6);
        String new_name_2 = StringUtils.getRandomStr(6);
        driveWorker2.setName(new_name_1);
        driveWorker4.setName(new_name_2);
        List<DriveWorker> driveWorkers = new ArrayList<DriveWorker>();
        driveWorkers.add(driveWorker2);
        driveWorkers.add(driveWorker4);
        driveWorkerDao.update(driveWorkers);
        DriveWorker driveWorker2_check = driveWorkerDao.getById(2);
        DriveWorker driveWorker4_check = driveWorkerDao.getById(4);
        if(!driveWorker2_check.getName().equals(new_name_1)){
            throw new RuntimeException("DriveWorker2 update failed");
        }
        if(!driveWorker4_check.getName().equals(new_name_2)){
            throw new RuntimeException("DriveWorker4 update failed");
        }
        if(driveWorker2_check.getName().equals(new_name_1) && driveWorker4_check.getName().equals(new_name_2)){
            logger.info("BatchUpdated succeed");
        }
    }

    @Test
    public void testDeleteById() {
        Long delete_id = 2L;
        driveWorkerDao.delete(delete_id);
        DriveWorker driveWorker_check = driveWorkerDao.getById(delete_id);
        if(!driveWorker_check.getIfDeleted()){
            throw new RuntimeException("Delete failed");
        }else {
            logger.info("Delete succeed");
        }
    }

    @Test
    public void testDelete() {
        Long delete_id = 4L;
        DriveWorker driveWorker = driveWorkerDao.getById(delete_id);
        driveWorkerDao.delete(driveWorker);
        DriveWorker driveWorker_check = driveWorkerDao.getById(delete_id);
        if(!driveWorker_check.getIfDeleted()){
            throw new RuntimeException("Delete failed");
        }else {
            logger.info("Delete succeed");
        }
    }

    @Test
    public void testListAll() {
        List<DriveWorker> driveWorkers = driveWorkerDao.listAll();
        for (int i = 0; i < driveWorkers.size(); i++)
            logger.info("Item" + i + ":" + driveWorkers.get(i));
    }

    @Test
    public void testGetBy() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ifDeleted", true);
        paramMap.put("Id", 1L);
        DriveWorker driveWorker = driveWorkerDao.getBy(paramMap);
        if(driveWorker.getId().longValue() != 1L){
            throw new RuntimeException("GetBy failed");
        }else{
            logger.info("GetBy succeed");
        }
    }

    @Test
    public void testListBy() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
//        paramMap.put("IsDeleted", false);
        paramMap.put("DriveWorkerName", "admi");
        List<DriveWorker> driveWorkers = driveWorkerDao.listBy(paramMap);
        for (int i = 0; i < driveWorkers.size(); i++)
            logger.info("Item" + i + ":" + driveWorkers.get(i));
    }

    @Test
    public void testListPage() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ifDeleted", false);
        PageParam pageParam = new PageParam(2, 2);
        PageBean<DriveWorker> pageBean = driveWorkerDao.listPage(pageParam, paramMap);
        logger.info(pageBean);
        List<DriveWorker> driveWorkers = pageBean.getRecordList();
//        if(driveWorkers.size() != 2){
//            throw new RuntimeException("ListPage failed");
//        }
        for (int i = 0; i < driveWorkers.size(); i++)
            logger.info("Item" + i + ":" + driveWorkers.get(i));
    }
}
