package TestService;

import cn.AssassinG.ScsyERP.File.core.biz.MyFileBiz;
import cn.AssassinG.ScsyERP.File.core.dao.MyFileDao;
import cn.AssassinG.ScsyERP.File.facade.entity.MyFile;
import cn.AssassinG.ScsyERP.File.facade.enums.FileType;
import cn.AssassinG.ScsyERP.File.facade.service.MyFileServiceFacade;
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
public class MyFileServiceFacadeImplTest {
    private static Logger logger = Logger.getLogger(MyFileServiceFacadeImplTest.class);
    @Autowired
    private MyFileServiceFacade myFileService;
    @Autowired
    private MyFileBiz myFileBiz;
    @Autowired
    private MyFileDao myFileDao;

    private Long myFileId;

    @Before
    public void setUp() throws Exception {
        MyFile myFile = new MyFile();
        myFile.setCorporation(1L);
        myFile.setType(FileType.IMAGE);
        myFile.setName(StringUtils.getRandomStr(6));
        myFile.setExtension("jpg");
        myFile.setContent(StringUtils.getRandomStr(100));
        myFileId = myFileBiz.create(myFile);
    }

    @After
    public void tearDown() throws Exception {
        myFileDao.delete(myFileId);
    }

    @Test
    public void create() {
        MyFile myFile = new MyFile();
        myFile.setCorporation(1L);
        myFile.setType(FileType.IMAGE);
        myFile.setName(StringUtils.getRandomStr(6));
        myFile.setExtension("jpg");
        myFile.setContent(StringUtils.getRandomStr(100));
        Long id = myFileService.create(myFile);
        if(id == null){
            throw new RuntimeException("Create nothing");
        }else {
            logger.info("Created : " + myFileDao.getById(id));
        }
    }

    @Test
    public void update() {
        MyFile myFile = myFileDao.getById(myFileId);
        String new_name = StringUtils.getRandomStr(6);
        logger.info("Before Update: "+myFile);
        myFile.setName(new_name);
        myFileService.update(myFile);
        MyFile myFile_check = myFileDao.getById(myFileId);
        if(!myFile_check.getName().equals(new_name)){
            throw new RuntimeException("Update failed");
        }else{
            logger.info("Updated succeed");
        }
    }

    @Test
    public void deleteById() {
        myFileService.deleteById(myFileId);
        MyFile myFile_check = myFileDao.getById(myFileId);
        if(myFile_check != null){
            throw new RuntimeException("Delete failed");
        }else {
            logger.info("Delete succeed");
        }
    }

    @Test
    public void delete() {
        MyFile myFile_test = myFileDao.getById(myFileId);
        myFileService.delete(myFile_test);
        MyFile myFile_check = myFileDao.getById(myFileId);
        if(myFile_check != null){
            throw new RuntimeException("Delete failed");
        }else {
            logger.info("Delete succeed");
        }
    }

    @Test
    public void getById() {
        MyFile myFile = myFileService.getById(myFileId);
        if(myFile == null || myFile.getIfDeleted()){
            throw new RuntimeException("getById null");
        }else{
            if(myFile.getId().longValue() != myFileId.longValue()){
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
        paramMap.put("Id", myFileId);
        MyFile myFile = myFileService.getBy(paramMap);
        if(myFile.getId() != myFileId){
            throw new RuntimeException("getBy failed");
        }else{
            logger.info("getBy succeed");
        }
    }

    @Test
    public void listBy() {
        MyFile myFile = myFileDao.getById(myFileId);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("IfDeleted", false);
        paramMap.put("Name", myFile.getName());
        List<MyFile> myFiles = myFileService.listBy(paramMap);
        for (int i = 0; i < myFiles.size(); i++)
            logger.info("Item" + i + ":" + myFiles.get(i));
    }

    @Test
    public void listPage() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("IfDeleted", false);
        PageParam pageParam = new PageParam(2, 2);
        PageBean<MyFile> pageBean = myFileService.listPage(pageParam, paramMap);
        logger.info(pageBean);
        List<MyFile> myFiles = pageBean.getRecordList();
        for (int i = 0; i < myFiles.size(); i++)
            logger.info("Item" + i + ":" + myFiles.get(i));
    }

//    @Test
//    public void createWithUser() {
//        MyFile myFile = new MyFile();
//        myFile.setCorporation(1L);
//        myFile.setDept(MyFileDeptType.FinancialMyFile);
//        User user = new User();
//        user.setUserName(StringUtils.getRandomStr(8));
//        user.setPassWord("d123456");
//        user.setPhone("188" + StringUtils.getRandomStr(8, StringUtils.StrType.NUMBER));
//        user.setCorporation(1L);
//        myFileService.createWithUser(myFile, user);
//        if(user.getUserType() != UserType.MyFile || user.getUserInfo().longValue() != myFile.getId().longValue()){
//            throw new RuntimeException("createWithUser failed");
//        }else {
//            logger.info("createWithUser succeed : MyFileID:" + myFile.getId() + ", userID:" + user.getId());
//        }
//    }

    @Test
    public void updateByMap() {
        String new_name = StringUtils.getRandomStr(6);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("Name", new_name);
        myFileService.updateByMap(myFileId, paramMap);
        MyFile myFile_check = myFileDao.getById(myFileId);
        if(!myFile_check.getName().equals(new_name)){
            throw new RuntimeException("updateByMap failed");
        }else{
            logger.info("updateByMap succeed");
        }
    }

//    @Test
//    public void deleteByUserId() {
//        myFileService.deleteByUserId(userId);
//        User user_check = userDao.getById(userId);
//        if(user_check == null || !user_check.getIfDeleted() || user_check.getUserType().getValue().intValue() != UserType.MyFile.getValue().intValue()){
//            throw new RuntimeException("deleteByUserId failed");
//        }
//        MyFile myFile_check = myFileDao.getById(user_check.getUserInfo());
//        if(myFile_check == null || !myFile_check.getIfDeleted()){
//            throw new RuntimeException("deleteByUserId failed");
//        }
//        logger.info("deleteByUserId succeed");
//    }
}