package TestService;

import cn.AssassinG.ScsyERP.BasicInfo.core.biz.MaterialBiz;
import cn.AssassinG.ScsyERP.BasicInfo.core.dao.MaterialDao;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Material;
import cn.AssassinG.ScsyERP.BasicInfo.facade.service.MaterialServiceFacade;
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
public class MaterialServiceFacadeImplTest {
    private static Logger logger = Logger.getLogger(MaterialServiceFacadeImplTest.class);
    @Autowired
    private MaterialServiceFacade materialService;
    @Autowired
    private MaterialBiz materialBiz;
    @Autowired
    private MaterialDao materialDao;

    private Long materialId;

    @Before
    public void setUp() throws Exception {
        Material material = new Material();
        material.setCorporation(1L);
        material.setFigureNumber(StringUtils.getRandomStr(10));
        material.setName(StringUtils.getRandomStr(6));
        materialId = materialBiz.create(material);
    }

    @After
    public void tearDown() throws Exception {
        materialDao.delete(materialId);
    }

    @Test
    public void create() {
        Material material = new Material();
        material.setCorporation(1L);
        material.setFigureNumber(StringUtils.getRandomStr(10));
        material.setName(StringUtils.getRandomStr(8));
        Long id = materialService.create(material);
        if(id == null){
            throw new RuntimeException("Create nothing");
        }else {
            logger.info("Created : " + materialDao.getById(id));
        }
    }

    @Test
    public void update() {
        Material material = materialDao.getById(materialId);
        String new_name = StringUtils.getRandomStr(6);
        logger.info("Before Update: "+material);
        material.setName(new_name);
        materialService.update(material);
        Material material_check = materialDao.getById(materialId);
        if(!material_check.getName().equals(new_name)){
            throw new RuntimeException("Update failed");
        }else{
            logger.info("Updated succeed");
        }
    }

    @Test
    public void deleteById() {
        materialService.deleteById(materialId);
        Material material_check = materialDao.getById(materialId);
        if(!material_check.getIfDeleted()){
            throw new RuntimeException("Delete failed");
        }else {
            logger.info("Delete succeed");
        }
    }

    @Test
    public void delete() {
        Material material_test = materialDao.getById(materialId);
        materialService.delete(material_test);
        Material material_check = materialDao.getById(materialId);
        if(!material_check.getIfDeleted()){
            throw new RuntimeException("Delete failed");
        }else {
            logger.info("Delete succeed");
        }
    }

    @Test
    public void getById() {
        Material material = materialService.getById(materialId);
        if(material == null || material.getIfDeleted()){
            throw new RuntimeException("getById null");
        }else{
            if(material.getId().longValue() != materialId.longValue()){
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
        paramMap.put("Id", materialId);
        Material material = materialService.getBy(paramMap);
        if(material.getId() != materialId){
            throw new RuntimeException("getBy failed");
        }else{
            logger.info("getBy succeed");
        }
    }

    @Test
    public void listBy() {
        Material material = materialDao.getById(materialId);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("IfDeleted", false);
        paramMap.put("Name", material.getName());
        List<Material> materials = materialService.listBy(paramMap);
        for (int i = 0; i < materials.size(); i++)
            logger.info("Item" + i + ":" + materials.get(i));
    }

    @Test
    public void listPage() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("IfDeleted", false);
        PageParam pageParam = new PageParam(2, 2);
        PageBean<Material> pageBean = materialService.listPage(pageParam, paramMap);
        logger.info(pageBean);
        List<Material> materials = pageBean.getRecordList();
        for (int i = 0; i < materials.size(); i++)
            logger.info("Item" + i + ":" + materials.get(i));
    }

//    @Test
//    public void createWithUser() {
//        Material material = new Material();
//        material.setCorporation(1L);
//        material.setDept(MaterialDeptType.FinancialMaterial);
//        User user = new User();
//        user.setUserName(StringUtils.getRandomStr(8));
//        user.setPassWord("d123456");
//        user.setPhone("188" + StringUtils.getRandomStr(8, StringUtils.StrType.NUMBER));
//        user.setCorporation(1L);
//        materialService.createWithUser(material, user);
//        if(user.getUserType() != UserType.Material || user.getUserInfo().longValue() != material.getId().longValue()){
//            throw new RuntimeException("createWithUser failed");
//        }else {
//            logger.info("createWithUser succeed : MaterialID:" + material.getId() + ", userID:" + user.getId());
//        }
//    }

    @Test
    public void updateByMap() {
        String new_name = StringUtils.getRandomStr(6);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("name", new_name);
        materialService.updateByMap(materialId, paramMap);
        Material material_check = materialDao.getById(materialId);
        if(!material_check.getName().equals(new_name)){
            throw new RuntimeException("updateByMap failed");
        }else{
            logger.info("updateByMap succeed");
        }
    }

//    @Test
//    public void deleteByUserId() {
//        materialService.deleteByUserId(userId);
//        User user_check = userDao.getById(userId);
//        if(user_check == null || !user_check.getIfDeleted() || user_check.getUserType().getValue().intValue() != UserType.Material.getValue().intValue()){
//            throw new RuntimeException("deleteByUserId failed");
//        }
//        Material material_check = materialDao.getById(user_check.getUserInfo());
//        if(material_check == null || !material_check.getIfDeleted()){
//            throw new RuntimeException("deleteByUserId failed");
//        }
//        logger.info("deleteByUserId succeed");
//    }
}