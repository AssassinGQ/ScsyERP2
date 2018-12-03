package TestService;

import cn.AssassinG.ScsyERP.BasicInfo.core.biz.DriveWorkerBiz;
import cn.AssassinG.ScsyERP.BasicInfo.core.dao.DriveWorkerDao;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.DriveWorker;
import cn.AssassinG.ScsyERP.BasicInfo.facade.service.DriveWorkerServiceFacade;
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
public class DriveWorkerServiceFacadeImplTest {
    private static Logger logger = Logger.getLogger(DriveWorkerServiceFacadeImplTest.class);
    @Autowired
    private DriveWorkerServiceFacade driveWorkerService;
    @Autowired
    private DriveWorkerBiz driveWorkerBiz;
    @Autowired
    private DriveWorkerDao driveWorkerDao;

    private Long driveWorkerId;

    @Before
    public void setUp() throws Exception {
        DriveWorker driveWorker = new DriveWorker();
        driveWorker.setCorporation(1L);
        driveWorker.setName(StringUtils.getRandomStr(6));
        driveWorkerId = driveWorkerBiz.create(driveWorker);
    }

    @After
    public void tearDown() throws Exception {
        driveWorkerDao.delete(driveWorkerId);
    }

    @Test
    public void create() {
        DriveWorker driveWorker = new DriveWorker();
        driveWorker.setCorporation(1L);
        driveWorker.setName(StringUtils.getRandomStr(8));
        Long id = driveWorkerService.create(driveWorker);
        if(id == null){
            throw new RuntimeException("Create nothing");
        }else {
            logger.info("Created : " + driveWorkerDao.getById(id));
        }
    }

    @Test
    public void update() {
        DriveWorker driveWorker = driveWorkerDao.getById(driveWorkerId);
        String new_name = StringUtils.getRandomStr(6);
        logger.info("Before Update: "+driveWorker);
        driveWorker.setName(new_name);
        driveWorkerService.update(driveWorker);
        DriveWorker driveWorker_check = driveWorkerDao.getById(driveWorkerId);
        if(!driveWorker_check.getName().equals(new_name)){
            throw new RuntimeException("Update failed");
        }else{
            logger.info("Updated succeed");
        }
    }

    @Test
    public void deleteById() {
        driveWorkerService.deleteById(driveWorkerId);
        DriveWorker driveWorker_check = driveWorkerDao.getById(driveWorkerId);
        if(!driveWorker_check.getIfDeleted()){
            throw new RuntimeException("Delete failed");
        }else {
            logger.info("Delete succeed");
        }
    }

    @Test
    public void delete() {
        DriveWorker driveWorker_test = driveWorkerDao.getById(driveWorkerId);
        driveWorkerService.delete(driveWorker_test);
        DriveWorker driveWorker_check = driveWorkerDao.getById(driveWorkerId);
        if(!driveWorker_check.getIfDeleted()){
            throw new RuntimeException("Delete failed");
        }else {
            logger.info("Delete succeed");
        }
    }

    @Test
    public void getById() {
        DriveWorker driveWorker = driveWorkerService.getById(driveWorkerId);
        if(driveWorker == null || driveWorker.getIfDeleted()){
            throw new RuntimeException("getById null");
        }else{
            if(driveWorker.getId().longValue() != driveWorkerId.longValue()){
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
        paramMap.put("Id", driveWorkerId);
        DriveWorker driveWorker = driveWorkerService.getBy(paramMap);
        if(driveWorker.getId() != driveWorkerId){
            throw new RuntimeException("getBy failed");
        }else{
            logger.info("getBy succeed");
        }
    }

    @Test
    public void listBy() {
        DriveWorker driveWorker = driveWorkerDao.getById(driveWorkerId);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("IfDeleted", false);
        paramMap.put("Name", driveWorker.getName());
        List<DriveWorker> driveWorkers = driveWorkerService.listBy(paramMap);
        for (int i = 0; i < driveWorkers.size(); i++)
            logger.info("Item" + i + ":" + driveWorkers.get(i));
    }

    @Test
    public void listPage() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("IfDeleted", false);
        PageParam pageParam = new PageParam(2, 2);
        PageBean<DriveWorker> pageBean = driveWorkerService.listPage(pageParam, paramMap);
        logger.info(pageBean);
        List<DriveWorker> driveWorkers = pageBean.getRecordList();
        for (int i = 0; i < driveWorkers.size(); i++)
            logger.info("Item" + i + ":" + driveWorkers.get(i));
    }

//    @Test
//    public void createWithUser() {
//        DriveWorker driveWorker = new DriveWorker();
//        driveWorker.setCorporation(1L);
//        driveWorker.setDept(DriveWorkerDeptType.FinancialDriveWorker);
//        User user = new User();
//        user.setUserName(StringUtils.getRandomStr(8));
//        user.setPassWord("d123456");
//        user.setPhone("188" + StringUtils.getRandomStr(8, StringUtils.StrType.NUMBER));
//        user.setCorporation(1L);
//        driveWorkerService.createWithUser(driveWorker, user);
//        if(user.getUserType() != UserType.DriveWorker || user.getUserInfo().longValue() != driveWorker.getId().longValue()){
//            throw new RuntimeException("createWithUser failed");
//        }else {
//            logger.info("createWithUser succeed : DriveWorkerID:" + driveWorker.getId() + ", userID:" + user.getId());
//        }
//    }

    @Test
    public void updateByMap() {
        String new_name = StringUtils.getRandomStr(6);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("name", new_name);
        driveWorkerService.updateByMap(driveWorkerId, paramMap);
        DriveWorker driveWorker_check = driveWorkerDao.getById(driveWorkerId);
        if(!driveWorker_check.getName().equals(new_name)){
            throw new RuntimeException("updateByMap failed");
        }else{
            logger.info("updateByMap succeed");
        }
    }

//    @Test
//    public void deleteByUserId() {
//        driveWorkerService.deleteByUserId(userId);
//        User user_check = userDao.getById(userId);
//        if(user_check == null || !user_check.getIfDeleted() || user_check.getUserType().getValue().intValue() != UserType.DriveWorker.getValue().intValue()){
//            throw new RuntimeException("deleteByUserId failed");
//        }
//        DriveWorker driveWorker_check = driveWorkerDao.getById(user_check.getUserInfo());
//        if(driveWorker_check == null || !driveWorker_check.getIfDeleted()){
//            throw new RuntimeException("deleteByUserId failed");
//        }
//        logger.info("deleteByUserId succeed");
//    }
}