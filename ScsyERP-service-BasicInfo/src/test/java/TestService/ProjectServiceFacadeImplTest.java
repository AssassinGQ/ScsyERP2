package TestService;

import cn.AssassinG.ScsyERP.BasicInfo.core.biz.ProjectBiz;
import cn.AssassinG.ScsyERP.BasicInfo.core.dao.ProjectDao;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Project;
import cn.AssassinG.ScsyERP.BasicInfo.facade.service.ProjectServiceFacade;
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
public class ProjectServiceFacadeImplTest {
    private static Logger logger = Logger.getLogger(ProjectServiceFacadeImplTest.class);
    @Autowired
    private ProjectServiceFacade projectService;
    @Autowired
    private ProjectBiz projectBiz;
    @Autowired
    private ProjectDao projectDao;

    private Long projectId;

    @Before
    public void setUp() throws Exception {
        Project project = new Project();
        project.setCorporation(1L);
        project.setName(StringUtils.getRandomStr(6));
        project.setProjectNumber(StringUtils.getRandomStr(9));
        project.setCustomer(1L);
        project.setManufacturer(1L);
        project.setConsignee(1L);
        project.setAdmin(1L);
        projectId = projectBiz.create(project);
    }

    @After
    public void tearDown() throws Exception {
        projectDao.delete(projectId);
    }

    @Test
    public void create() {
        Project project = new Project();
        project.setCorporation(1L);
        project.setName(StringUtils.getRandomStr(8));
        project.setProjectNumber(StringUtils.getRandomStr(9));
        project.setCustomer(1L);
        project.setManufacturer(1L);
        project.setConsignee(1L);
        project.setAdmin(1L);
        Long id = projectService.create(project);
        if(id == null){
            throw new RuntimeException("Create nothing");
        }else {
            logger.info("Created : " + projectDao.getById(id));
        }
    }

    @Test
    public void update() {
        Project project = projectDao.getById(projectId);
        String new_name = StringUtils.getRandomStr(6);
        logger.info("Before Update: "+project);
        project.setName(new_name);
        projectService.update(project);
        Project project_check = projectDao.getById(projectId);
        if(!project_check.getName().equals(new_name)){
            throw new RuntimeException("Update failed");
        }else{
            logger.info("Updated succeed");
        }
    }

    @Test
    public void deleteById() {
        projectService.deleteById(projectId);
        Project project_check = projectDao.getById(projectId);
        if(!project_check.getIfDeleted()){
            throw new RuntimeException("Delete failed");
        }else {
            logger.info("Delete succeed");
        }
    }

    @Test
    public void delete() {
        Project project_test = projectDao.getById(projectId);
        projectService.delete(project_test);
        Project project_check = projectDao.getById(projectId);
        if(!project_check.getIfDeleted()){
            throw new RuntimeException("Delete failed");
        }else {
            logger.info("Delete succeed");
        }
    }

    @Test
    public void getById() {
        Project project = projectService.getById(projectId);
        if(project == null || project.getIfDeleted()){
            throw new RuntimeException("getById null");
        }else{
            if(project.getId().longValue() != projectId.longValue()){
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
        paramMap.put("Id", projectId);
        Project project = projectService.getBy(paramMap);
        if(project.getId() != projectId){
            throw new RuntimeException("getBy failed");
        }else{
            logger.info("getBy succeed");
        }
    }

    @Test
    public void listBy() {
        Project project = projectDao.getById(projectId);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("IfDeleted", false);
        paramMap.put("Name", project.getName());
        List<Project> projects = projectService.listBy(paramMap);
        for (int i = 0; i < projects.size(); i++)
            logger.info("Item" + i + ":" + projects.get(i));
    }

    @Test
    public void listPage() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("IfDeleted", false);
        PageParam pageParam = new PageParam(2, 2);
        PageBean<Project> pageBean = projectService.listPage(pageParam, paramMap);
        logger.info(pageBean);
        List<Project> projects = pageBean.getRecordList();
        for (int i = 0; i < projects.size(); i++)
            logger.info("Item" + i + ":" + projects.get(i));
    }

//    @Test
//    public void createWithUser() {
//        Project project = new Project();
//        project.setCorporation(1L);
//        project.setDept(ProjectDeptType.FinancialProject);
//        User user = new User();
//        user.setUserName(StringUtils.getRandomStr(8));
//        user.setPassWord("d123456");
//        user.setPhone("188" + StringUtils.getRandomStr(8, StringUtils.StrType.NUMBER));
//        user.setCorporation(1L);
//        projectService.createWithUser(project, user);
//        if(user.getUserType() != UserType.Project || user.getUserInfo().longValue() != project.getId().longValue()){
//            throw new RuntimeException("createWithUser failed");
//        }else {
//            logger.info("createWithUser succeed : ProjectID:" + project.getId() + ", userID:" + user.getId());
//        }
//    }

    @Test
    public void updateByMap() {
        String new_name = StringUtils.getRandomStr(6);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("name", new_name);
        projectService.updateByMap(projectId, paramMap);
        Project project_check = projectDao.getById(projectId);
        if(!project_check.getName().equals(new_name)){
            throw new RuntimeException("updateByMap failed");
        }else{
            logger.info("updateByMap succeed");
        }
    }

//    @Test
//    public void deleteByUserId() {
//        projectService.deleteByUserId(userId);
//        User user_check = userDao.getById(userId);
//        if(user_check == null || !user_check.getIfDeleted() || user_check.getUserType().getValue().intValue() != UserType.Project.getValue().intValue()){
//            throw new RuntimeException("deleteByUserId failed");
//        }
//        Project project_check = projectDao.getById(user_check.getUserInfo());
//        if(project_check == null || !project_check.getIfDeleted()){
//            throw new RuntimeException("deleteByUserId failed");
//        }
//        logger.info("deleteByUserId succeed");
//    }
}