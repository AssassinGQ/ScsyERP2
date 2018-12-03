package TestDao;

import cn.AssassinG.ScsyERP.BasicInfo.core.dao.LiftWorkerDao;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.LiftWorker;
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
public class TestLiftWorker {
    private static Logger logger = Logger.getLogger(TestLiftWorker.class);
    @Autowired
    private LiftWorkerDao liftWorkerDao;

    @Test
    public void testGetById() {
        Long liftWorker_id = 1L;
        LiftWorker liftWorker = liftWorkerDao.getById(liftWorker_id);
        if(liftWorker == null || liftWorker.getId() == null || liftWorker.getId().longValue() != liftWorker_id.longValue()){
            throw  new RuntimeException("getById failed");
        }else {
            logger.info("GetById success");
        }
    }

    @Test
    public void testInsert() {
        LiftWorker liftWorker = new LiftWorker();
        liftWorker.setName("asddf");
        liftWorker.setCorporation(1L);
        liftWorkerDao.insert(liftWorker);
        Long id = liftWorker.getId();
        if(id == null){
            throw new RuntimeException("insert nothing");
        }else {
            logger.info("Inserted : " + liftWorkerDao.getById(id));
        }
    }

    @Test
    public void testBatchInsert() {
        LiftWorker liftWorker = new LiftWorker();
        liftWorker.setName("asddf3");
        liftWorker.setCorporation(1L);
        LiftWorker liftWorker1 = new LiftWorker();
        liftWorker1.setName("asddf4");
        liftWorker1.setCorporation(1L);
        List<LiftWorker> liftWorkers = new ArrayList<LiftWorker>();
        liftWorkers.add(liftWorker);
        liftWorkers.add(liftWorker1);
        int result = liftWorkerDao.insert(liftWorkers);
        if(result != liftWorkers.size()){
            throw new RuntimeException("BatchInsert failed " + (liftWorkers.size()-result) + "s, succeed " + result + "s");
        }else if(liftWorker.getId() == null || liftWorker1.getId() == null){
            throw new RuntimeException("BatchInsert failed");
        }else{
            logger.info("BatchInserted succeed");
        }
    }

    @Test
    public void testUpdate() {
        LiftWorker liftWorker = liftWorkerDao.getById(2);
        String new_name = StringUtils.getRandomStr(6);
        logger.info("Before Update: "+liftWorker);
        liftWorker.setName(new_name);
        liftWorkerDao.update(liftWorker);
        LiftWorker liftWorker_check = liftWorkerDao.getById(2);
        if(!liftWorker_check.getName().equals(new_name)){
            throw new RuntimeException("Update failed");
        }else{
            logger.info("Updated succeed");
        }
    }

    @Test
    public void testBatchUpdate() {
        LiftWorker liftWorker2 = liftWorkerDao.getById(2);
        LiftWorker liftWorker4 = liftWorkerDao.getById(4);
        String new_name_1 = StringUtils.getRandomStr(6);
        String new_name_2 = StringUtils.getRandomStr(6);
        liftWorker2.setName(new_name_1);
        liftWorker4.setName(new_name_2);
        List<LiftWorker> liftWorkers = new ArrayList<LiftWorker>();
        liftWorkers.add(liftWorker2);
        liftWorkers.add(liftWorker4);
        liftWorkerDao.update(liftWorkers);
        LiftWorker liftWorker2_check = liftWorkerDao.getById(2);
        LiftWorker liftWorker4_check = liftWorkerDao.getById(4);
        if(!liftWorker2_check.getName().equals(new_name_1)){
            throw new RuntimeException("LiftWorker2 update failed");
        }
        if(!liftWorker4_check.getName().equals(new_name_2)){
            throw new RuntimeException("LiftWorker4 update failed");
        }
        if(liftWorker2_check.getName().equals(new_name_1) && liftWorker4_check.getName().equals(new_name_2)){
            logger.info("BatchUpdated succeed");
        }
    }

    @Test
    public void testDeleteById() {
        Long delete_id = 2L;
        liftWorkerDao.delete(delete_id);
        LiftWorker liftWorker_check = liftWorkerDao.getById(delete_id);
        if(!liftWorker_check.getIfDeleted()){
            throw new RuntimeException("Delete failed");
        }else {
            logger.info("Delete succeed");
        }
    }

    @Test
    public void testDelete() {
        Long delete_id = 4L;
        LiftWorker liftWorker = liftWorkerDao.getById(delete_id);
        liftWorkerDao.delete(liftWorker);
        LiftWorker liftWorker_check = liftWorkerDao.getById(delete_id);
        if(!liftWorker_check.getIfDeleted()){
            throw new RuntimeException("Delete failed");
        }else {
            logger.info("Delete succeed");
        }
    }

    @Test
    public void testListAll() {
        List<LiftWorker> liftWorkers = liftWorkerDao.listAll();
        for (int i = 0; i < liftWorkers.size(); i++)
            logger.info("Item" + i + ":" + liftWorkers.get(i));
    }

    @Test
    public void testGetBy() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ifDeleted", true);
        paramMap.put("Id", 1L);
        LiftWorker liftWorker = liftWorkerDao.getBy(paramMap);
        if(liftWorker.getId().longValue() != 1L){
            throw new RuntimeException("GetBy failed");
        }else{
            logger.info("GetBy succeed");
        }
    }

    @Test
    public void testListBy() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
//        paramMap.put("IsDeleted", false);
        paramMap.put("LiftWorkerName", "admi");
        List<LiftWorker> liftWorkers = liftWorkerDao.listBy(paramMap);
        for (int i = 0; i < liftWorkers.size(); i++)
            logger.info("Item" + i + ":" + liftWorkers.get(i));
    }

    @Test
    public void testListPage() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ifDeleted", false);
        PageParam pageParam = new PageParam(2, 2);
        PageBean<LiftWorker> pageBean = liftWorkerDao.listPage(pageParam, paramMap);
        logger.info(pageBean);
        List<LiftWorker> liftWorkers = pageBean.getRecordList();
//        if(liftWorkers.size() != 2){
//            throw new RuntimeException("ListPage failed");
//        }
        for (int i = 0; i < liftWorkers.size(); i++)
            logger.info("Item" + i + ":" + liftWorkers.get(i));
    }
}
