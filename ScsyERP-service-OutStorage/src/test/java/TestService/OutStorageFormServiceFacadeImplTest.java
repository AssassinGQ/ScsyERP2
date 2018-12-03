package TestService;

import cn.AssassinG.ScsyERP.OutStorage.core.biz.OutStorageFormBiz;
import cn.AssassinG.ScsyERP.OutStorage.core.dao.OutStorageFormDao;
import cn.AssassinG.ScsyERP.OutStorage.facade.entity.OutStorageForm;
import cn.AssassinG.ScsyERP.OutStorage.facade.enums.OutStorageFormStatus;
import cn.AssassinG.ScsyERP.OutStorage.facade.service.OutStorageFormServiceFacade;
import cn.AssassinG.ScsyERP.common.enums.AccountStatus;
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

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-context.xml"})
public class OutStorageFormServiceFacadeImplTest {
    private static Logger logger = Logger.getLogger(OutStorageFormServiceFacadeImplTest.class);
    @Autowired
    private OutStorageFormServiceFacade outStorageFormService;
    @Autowired
    private OutStorageFormBiz outStorageFormBiz;
    @Autowired
    private OutStorageFormDao outStorageFormDao;

    private Long outStorageFormId;

    @Before
    public void setUp() throws Exception {
        OutStorageForm outStorageForm = new OutStorageForm();
        outStorageForm.setCorporation(1L);
        outStorageForm.setProject(1L);
        outStorageForm.setOutStorageStatus(OutStorageFormStatus.Workging);
        outStorageForm.setOutStorageNumber(StringUtils.getRandomStr(8));
        outStorageForm.setOutStorageTime(new Date());
        outStorageForm.setWarehouse(1L);
        outStorageForm.setTruck(1L);
        outStorageForm.setPickWorker(1L);
        outStorageForm.setLister(1L);
        outStorageForm.setAccountStatus(AccountStatus.WRZ);
        outStorageFormId = outStorageFormBiz.create(outStorageForm);
    }

    @After
    public void tearDown() throws Exception {
        outStorageFormDao.delete(outStorageFormId);
    }

    @Test
    public void create() {
        OutStorageForm outStorageForm = new OutStorageForm();
        outStorageForm.setCorporation(1L);
        outStorageForm.setProject(1L);
        outStorageForm.setOutStorageStatus(OutStorageFormStatus.Workging);
        outStorageForm.setOutStorageNumber(StringUtils.getRandomStr(8));
        outStorageForm.setOutStorageTime(new Date());
        outStorageForm.setWarehouse(1L);
        outStorageForm.setTruck(1L);
        outStorageForm.setPickWorker(1L);
        outStorageForm.setLister(1L);
        Long id = outStorageFormService.create(outStorageForm);
        if(id == null){
            throw new RuntimeException("Create nothing");
        }else {
            logger.info("Created : " + outStorageFormDao.getById(id));
        }
    }

    @Test
    public void update() {
        OutStorageForm outStorageForm = outStorageFormDao.getById(outStorageFormId);
        Long new_truck = outStorageForm.getTruck() + 1;
        logger.info("Before Update: "+outStorageForm);
        outStorageForm.setTruck(new_truck);
        outStorageFormService.update(outStorageForm);
        OutStorageForm outStorageForm_check = outStorageFormDao.getById(outStorageFormId);
        if(outStorageForm_check.getTruck().longValue() != new_truck.longValue()){
            throw new RuntimeException("Update failed");
        }else{
            logger.info("Updated succeed");
        }
    }

    @Test
    public void deleteById() {
        outStorageFormService.deleteById(outStorageFormId);
        OutStorageForm outStorageForm_check = outStorageFormDao.getById(outStorageFormId);
        if(!outStorageForm_check.getIfDeleted()){
            throw new RuntimeException("Delete failed");
        }else {
            logger.info("Delete succeed");
        }
    }

    @Test
    public void delete() {
        OutStorageForm outStorageForm_test = outStorageFormDao.getById(outStorageFormId);
        outStorageFormService.delete(outStorageForm_test);
        OutStorageForm outStorageForm_check = outStorageFormDao.getById(outStorageFormId);
        if(!outStorageForm_check.getIfDeleted()){
            throw new RuntimeException("Delete failed");
        }else {
            logger.info("Delete succeed");
        }
    }

    @Test
    public void getById() {
        OutStorageForm outStorageForm = outStorageFormService.getById(outStorageFormId);
        if(outStorageForm == null || outStorageForm.getIfDeleted()){
            throw new RuntimeException("getById null");
        }else{
            if(outStorageForm.getId().longValue() != outStorageFormId.longValue()){
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
        paramMap.put("Id", outStorageFormId);
        OutStorageForm outStorageForm = outStorageFormService.getBy(paramMap);
        if(outStorageForm.getId() != outStorageFormId){
            throw new RuntimeException("getBy failed");
        }else{
            logger.info("getBy succeed");
        }
    }

    @Test
    public void listBy() {
        OutStorageForm outStorageForm = outStorageFormDao.getById(outStorageFormId);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("IfDeleted", false);
        paramMap.put("OutStorageNumber", outStorageForm.getOutStorageNumber());
        List<OutStorageForm> outStorageForms = outStorageFormService.listBy(paramMap);
        for (int i = 0; i < outStorageForms.size(); i++)
            logger.info("Item" + i + ":" + outStorageForms.get(i));
    }

    @Test
    public void listPage() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("IfDeleted", false);
        PageParam pageParam = new PageParam(2, 2);
        PageBean<OutStorageForm> pageBean = outStorageFormService.listPage(pageParam, paramMap);
        logger.info(pageBean);
        List<OutStorageForm> outStorageForms = pageBean.getRecordList();
        for (int i = 0; i < outStorageForms.size(); i++)
            logger.info("Item" + i + ":" + outStorageForms.get(i));
    }

//    @Test
//    public void createWithUser() {
//        OutStorageForm outStorageForm = new OutStorageForm();
//        outStorageForm.setCorporation(1L);
//        outStorageForm.setDept(OutStorageFormDeptType.FinancialOutStorageForm);
//        User user = new User();
//        user.setUserName(StringUtils.getRandomStr(8));
//        user.setPassWord("d123456");
//        user.setPhone("188" + StringUtils.getRandomStr(8, StringUtils.StrType.NUMBER));
//        user.setCorporation(1L);
//        outStorageFormService.createWithUser(outStorageForm, user);
//        if(user.getUserType() != UserType.OutStorageForm || user.getUserInfo().longValue() != outStorageForm.getId().longValue()){
//            throw new RuntimeException("createWithUser failed");
//        }else {
//            logger.info("createWithUser succeed : OutStorageFormID:" + outStorageForm.getId() + ", userID:" + user.getId());
//        }
//    }

    @Test
    public void updateByMap() {
        AccountStatus accountStatus;
        OutStorageForm outStorageForm_check = outStorageFormDao.getById(outStorageFormId);
        if(outStorageForm_check.getAccountStatus().getValue().intValue() == AccountStatus.WRZ.getValue().intValue()){
            accountStatus = AccountStatus.YRZ;
        }else{
            accountStatus = AccountStatus.WRZ;
        }
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("accountStatus", accountStatus);
        outStorageFormService.updateByMap(outStorageFormId, paramMap);
        outStorageForm_check = outStorageFormDao.getById(outStorageFormId);
        if(outStorageForm_check.getAccountStatus().getValue().intValue() != accountStatus.getValue().intValue()){
            throw new RuntimeException("updateByMap failed");
        }else{
            logger.info("updateByMap succeed");
        }
    }

//    @Test
//    public void deleteByUserId() {
//        outStorageFormService.deleteByUserId(userId);
//        User user_check = userDao.getById(userId);
//        if(user_check == null || !user_check.getIfDeleted() || user_check.getUserType().getValue().intValue() != UserType.OutStorageForm.getValue().intValue()){
//            throw new RuntimeException("deleteByUserId failed");
//        }
//        OutStorageForm outStorageForm_check = outStorageFormDao.getById(user_check.getUserInfo());
//        if(outStorageForm_check == null || !outStorageForm_check.getIfDeleted()){
//            throw new RuntimeException("deleteByUserId failed");
//        }
//        logger.info("deleteByUserId succeed");
//    }
}