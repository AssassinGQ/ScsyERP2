package TestService;

import cn.AssassinG.ScsyERP.BasicInfo.core.biz.LiftWorkerBiz;
import cn.AssassinG.ScsyERP.BasicInfo.core.dao.LiftWorkerDao;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.LiftWorker;
import cn.AssassinG.ScsyERP.BasicInfo.facade.service.LiftWorkerServiceFacade;
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
public class LiftWorkerServiceFacadeImplTest {
    private static Logger logger = Logger.getLogger(LiftWorkerServiceFacadeImplTest.class);
    @Autowired
    private LiftWorkerServiceFacade liftWorkerService;
    @Autowired
    private LiftWorkerBiz liftWorkerBiz;
    @Autowired
    private LiftWorkerDao liftWorkerDao;

    private Long liftWorkerId;

    @Before
    public void setUp() throws Exception {
        LiftWorker liftWorker = new LiftWorker();
        liftWorker.setCorporation(1L);
        liftWorker.setName(StringUtils.getRandomStr(6));
        liftWorkerId = liftWorkerBiz.create(liftWorker);
    }

    @After
    public void tearDown() throws Exception {
        liftWorkerDao.delete(liftWorkerId);
    }

    @Test
    public void create() {
        LiftWorker liftWorker = new LiftWorker();
        liftWorker.setCorporation(1L);
        liftWorker.setName(StringUtils.getRandomStr(8));
        Long id = liftWorkerService.create(liftWorker);
        if(id == null){
            throw new RuntimeException("Create nothing");
        }else {
            logger.info("Created : " + liftWorkerDao.getById(id));
        }
    }

    @Test
    public void update() {
        LiftWorker liftWorker = liftWorkerDao.getById(liftWorkerId);
        String new_name = StringUtils.getRandomStr(6);
        logger.info("Before Update: "+liftWorker);
        liftWorker.setName(new_name);
        liftWorkerService.update(liftWorker);
        LiftWorker liftWorker_check = liftWorkerDao.getById(liftWorkerId);
        if(!liftWorker_check.getName().equals(new_name)){
            throw new RuntimeException("Update failed");
        }else{
            logger.info("Updated succeed");
        }
    }

    @Test
    public void deleteById() {
        liftWorkerService.deleteById(liftWorkerId);
        LiftWorker liftWorker_check = liftWorkerDao.getById(liftWorkerId);
        if(!liftWorker_check.getIfDeleted()){
            throw new RuntimeException("Delete failed");
        }else {
            logger.info("Delete succeed");
        }
    }

    @Test
    public void delete() {
        LiftWorker liftWorker_test = liftWorkerDao.getById(liftWorkerId);
        liftWorkerService.delete(liftWorker_test);
        LiftWorker liftWorker_check = liftWorkerDao.getById(liftWorkerId);
        if(!liftWorker_check.getIfDeleted()){
            throw new RuntimeException("Delete failed");
        }else {
            logger.info("Delete succeed");
        }
    }

    @Test
    public void getById() {
        LiftWorker liftWorker = liftWorkerService.getById(liftWorkerId);
        if(liftWorker == null || liftWorker.getIfDeleted()){
            throw new RuntimeException("getById null");
        }else{
            if(liftWorker.getId().longValue() != liftWorkerId.longValue()){
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
        paramMap.put("Id", liftWorkerId);
        LiftWorker liftWorker = liftWorkerService.getBy(paramMap);
        if(liftWorker.getId() != liftWorkerId){
            throw new RuntimeException("getBy failed");
        }else{
            logger.info("getBy succeed");
        }
    }

    @Test
    public void listBy() {
        LiftWorker liftWorker = liftWorkerDao.getById(liftWorkerId);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("IfDeleted", false);
        paramMap.put("Name", liftWorker.getName());
        List<LiftWorker> liftWorkers = liftWorkerService.listBy(paramMap);
        for (int i = 0; i < liftWorkers.size(); i++)
            logger.info("Item" + i + ":" + liftWorkers.get(i));
    }

    @Test
    public void listPage() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("IfDeleted", false);
        PageParam pageParam = new PageParam(2, 2);
        PageBean<LiftWorker> pageBean = liftWorkerService.listPage(pageParam, paramMap);
        logger.info(pageBean);
        List<LiftWorker> liftWorkers = pageBean.getRecordList();
        for (int i = 0; i < liftWorkers.size(); i++)
            logger.info("Item" + i + ":" + liftWorkers.get(i));
    }

//    @Test
//    public void createWithUser() {
//        LiftWorker liftWorker = new LiftWorker();
//        liftWorker.setCorporation(1L);
//        liftWorker.setDept(LiftWorkerDeptType.FinancialLiftWorker);
//        User user = new User();
//        user.setUserName(StringUtils.getRandomStr(8));
//        user.setPassWord("d123456");
//        user.setPhone("188" + StringUtils.getRandomStr(8, StringUtils.StrType.NUMBER));
//        user.setCorporation(1L);
//        liftWorkerService.createWithUser(liftWorker, user);
//        if(user.getUserType() != UserType.LiftWorker || user.getUserInfo().longValue() != liftWorker.getId().longValue()){
//            throw new RuntimeException("createWithUser failed");
//        }else {
//            logger.info("createWithUser succeed : LiftWorkerID:" + liftWorker.getId() + ", userID:" + user.getId());
//        }
//    }

    @Test
    public void updateByMap() {
        String new_name = StringUtils.getRandomStr(6);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("name", new_name);
        liftWorkerService.updateByMap(liftWorkerId, paramMap);
        LiftWorker liftWorker_check = liftWorkerDao.getById(liftWorkerId);
        if(!liftWorker_check.getName().equals(new_name)){
            throw new RuntimeException("updateByMap failed");
        }else{
            logger.info("updateByMap succeed");
        }
    }

//    @Test
//    public void deleteByUserId() {
//        liftWorkerService.deleteByUserId(userId);
//        User user_check = userDao.getById(userId);
//        if(user_check == null || !user_check.getIfDeleted() || user_check.getUserType().getValue().intValue() != UserType.LiftWorker.getValue().intValue()){
//            throw new RuntimeException("deleteByUserId failed");
//        }
//        LiftWorker liftWorker_check = liftWorkerDao.getById(user_check.getUserInfo());
//        if(liftWorker_check == null || !liftWorker_check.getIfDeleted()){
//            throw new RuntimeException("deleteByUserId failed");
//        }
//        logger.info("deleteByUserId succeed");
//    }
}