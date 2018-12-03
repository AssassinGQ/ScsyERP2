package TestService;

import cn.AssassinG.ScsyERP.BasicInfo.core.biz.WorkshopBiz;
import cn.AssassinG.ScsyERP.BasicInfo.core.dao.WorkshopDao;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Workshop;
import cn.AssassinG.ScsyERP.BasicInfo.facade.service.WorkshopServiceFacade;
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
public class WorkshopServiceFacadeImplTest {
    private static Logger logger = Logger.getLogger(WorkshopServiceFacadeImplTest.class);
    @Autowired
    private WorkshopServiceFacade workshopService;
    @Autowired
    private WorkshopBiz workshopBiz;
    @Autowired
    private WorkshopDao workshopDao;

    private Long workshopId;

    @Before
    public void setUp() throws Exception {
        Workshop workshop = new Workshop();
        workshop.setCorporation(1L);
        workshop.setAddress(StringUtils.getRandomStr(40));
        workshop.setName(StringUtils.getRandomStr(6));
        workshopId = workshopBiz.create(workshop);
    }

    @After
    public void tearDown() throws Exception {
        workshopDao.delete(workshopId);
    }

    @Test
    public void create() {
        Workshop workshop = new Workshop();
        workshop.setCorporation(1L);
        workshop.setAddress(StringUtils.getRandomStr(40));
        workshop.setName(StringUtils.getRandomStr(8));
        Long id = workshopService.create(workshop);
        if(id == null){
            throw new RuntimeException("Create nothing");
        }else {
            logger.info("Created : " + workshopDao.getById(id));
        }
    }

    @Test
    public void update() {
        Workshop workshop = workshopDao.getById(workshopId);
        String new_name = StringUtils.getRandomStr(6);
        logger.info("Before Update: "+workshop);
        workshop.setName(new_name);
        workshopService.update(workshop);
        Workshop workshop_check = workshopDao.getById(workshopId);
        if(!workshop_check.getName().equals(new_name)){
            throw new RuntimeException("Update failed");
        }else{
            logger.info("Updated succeed");
        }
    }

    @Test
    public void deleteById() {
        workshopService.deleteById(workshopId);
        Workshop workshop_check = workshopDao.getById(workshopId);
        if(!workshop_check.getIfDeleted()){
            throw new RuntimeException("Delete failed");
        }else {
            logger.info("Delete succeed");
        }
    }

    @Test
    public void delete() {
        Workshop workshop_test = workshopDao.getById(workshopId);
        workshopService.delete(workshop_test);
        Workshop workshop_check = workshopDao.getById(workshopId);
        if(!workshop_check.getIfDeleted()){
            throw new RuntimeException("Delete failed");
        }else {
            logger.info("Delete succeed");
        }
    }

    @Test
    public void getById() {
        Workshop workshop = workshopService.getById(workshopId);
        if(workshop == null || workshop.getIfDeleted()){
            throw new RuntimeException("getById null");
        }else{
            if(workshop.getId().longValue() != workshopId.longValue()){
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
        paramMap.put("Id", workshopId);
        Workshop workshop = workshopService.getBy(paramMap);
        if(workshop.getId() != workshopId){
            throw new RuntimeException("getBy failed");
        }else{
            logger.info("getBy succeed");
        }
    }

    @Test
    public void listBy() {
        Workshop workshop = workshopDao.getById(workshopId);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("IfDeleted", false);
        paramMap.put("Name", workshop.getName());
        List<Workshop> workshops = workshopService.listBy(paramMap);
        for (int i = 0; i < workshops.size(); i++)
            logger.info("Item" + i + ":" + workshops.get(i));
    }

    @Test
    public void listPage() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("IfDeleted", false);
        PageParam pageParam = new PageParam(2, 2);
        PageBean<Workshop> pageBean = workshopService.listPage(pageParam, paramMap);
        logger.info(pageBean);
        List<Workshop> workshops = pageBean.getRecordList();
        for (int i = 0; i < workshops.size(); i++)
            logger.info("Item" + i + ":" + workshops.get(i));
    }

//    @Test
//    public void createWithUser() {
//        Workshop workshop = new Workshop();
//        workshop.setCorporation(1L);
//        workshop.setDept(WorkshopDeptType.FinancialWorkshop);
//        User user = new User();
//        user.setUserName(StringUtils.getRandomStr(8));
//        user.setPassWord("d123456");
//        user.setPhone("188" + StringUtils.getRandomStr(8, StringUtils.StrType.NUMBER));
//        user.setCorporation(1L);
//        workshopService.createWithUser(workshop, user);
//        if(user.getUserType() != UserType.Workshop || user.getUserInfo().longValue() != workshop.getId().longValue()){
//            throw new RuntimeException("createWithUser failed");
//        }else {
//            logger.info("createWithUser succeed : WorkshopID:" + workshop.getId() + ", userID:" + user.getId());
//        }
//    }

    @Test
    public void updateByMap() {
        String new_name = StringUtils.getRandomStr(6);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("name", new_name);
        workshopService.updateByMap(workshopId, paramMap);
        Workshop workshop_check = workshopDao.getById(workshopId);
        if(!workshop_check.getName().equals(new_name)){
            throw new RuntimeException("updateByMap failed");
        }else{
            logger.info("updateByMap succeed");
        }
    }

//    @Test
//    public void deleteByUserId() {
//        workshopService.deleteByUserId(userId);
//        User user_check = userDao.getById(userId);
//        if(user_check == null || !user_check.getIfDeleted() || user_check.getUserType().getValue().intValue() != UserType.Workshop.getValue().intValue()){
//            throw new RuntimeException("deleteByUserId failed");
//        }
//        Workshop workshop_check = workshopDao.getById(user_check.getUserInfo());
//        if(workshop_check == null || !workshop_check.getIfDeleted()){
//            throw new RuntimeException("deleteByUserId failed");
//        }
//        logger.info("deleteByUserId succeed");
//    }
}