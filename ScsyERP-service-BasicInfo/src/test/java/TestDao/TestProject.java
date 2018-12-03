package TestDao;

import cn.AssassinG.ScsyERP.BasicInfo.core.dao.ProjectDao;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Project;
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
public class TestProject {
    private static Logger logger = Logger.getLogger(TestProject.class);
    @Autowired
    private ProjectDao projectDao;

    @Test
    public void testGetById() {
        Long project_id = 1L;
        Project project = projectDao.getById(project_id);
        if(project == null || project.getId() == null || project.getId().longValue() != project_id.longValue()){
            throw  new RuntimeException("getById failed");
        }else {
            logger.info("GetById success");
        }
    }

    @Test
    public void testInsert() {
        Project project = new Project();
        project.setName("asddf");
        project.setCorporation(1L);
        project.setProjectNumber("gch123456");
        project.setCustomer(1L);
        project.setManufacturer(1L);
        project.setConsignee(1L);
        project.setAdmin(1L);
        projectDao.insert(project);
        Long id = project.getId();
        if(id == null){
            throw new RuntimeException("insert nothing");
        }else {
            logger.info("Inserted : " + projectDao.getById(id));
        }
    }

    @Test
    public void testBatchInsert() {
        Project project = new Project();
        project.setName("asddf3");
        project.setCorporation(1L);
        project.setProjectNumber("gch123456");
        project.setCustomer(1L);
        project.setManufacturer(1L);
        project.setConsignee(1L);
        project.setAdmin(1L);
        Project project1 = new Project();
        project1.setName("asddf4");
        project1.setCorporation(1L);
        project1.setProjectNumber("gch123456");
        project1.setCustomer(1L);
        project1.setManufacturer(1L);
        project1.setConsignee(1L);
        project1.setAdmin(1L);
        List<Project> projects = new ArrayList<Project>();
        projects.add(project);
        projects.add(project1);
        int result = projectDao.insert(projects);
        if(result != projects.size()){
            throw new RuntimeException("BatchInsert failed " + (projects.size()-result) + "s, succeed " + result + "s");
        }else if(project.getId() == null || project1.getId() == null){
            throw new RuntimeException("BatchInsert failed");
        }else{
            logger.info("BatchInserted succeed");
        }
    }

    @Test
    public void testUpdate() {
        Project project = projectDao.getById(2);
        String new_name = StringUtils.getRandomStr(6);
        logger.info("Before Update: "+project);
        project.setName(new_name);
        projectDao.update(project);
        Project project_check = projectDao.getById(2);
        if(!project_check.getName().equals(new_name)){
            throw new RuntimeException("Update failed");
        }else{
            logger.info("Updated succeed");
        }
    }

    @Test
    public void testBatchUpdate() {
        Project project2 = projectDao.getById(2);
        Project project4 = projectDao.getById(4);
        String new_name_1 = StringUtils.getRandomStr(6);
        String new_name_2 = StringUtils.getRandomStr(6);
        project2.setName(new_name_1);
        project4.setName(new_name_2);
        List<Project> projects = new ArrayList<Project>();
        projects.add(project2);
        projects.add(project4);
        projectDao.update(projects);
        Project project2_check = projectDao.getById(2);
        Project project4_check = projectDao.getById(4);
        if(!project2_check.getName().equals(new_name_1)){
            throw new RuntimeException("Project2 update failed");
        }
        if(!project4_check.getName().equals(new_name_2)){
            throw new RuntimeException("Project4 update failed");
        }
        if(project2_check.getName().equals(new_name_1) && project4_check.getName().equals(new_name_2)){
            logger.info("BatchUpdated succeed");
        }
    }

    @Test
    public void testDeleteById() {
        Long delete_id = 2L;
        projectDao.delete(delete_id);
        Project project_check = projectDao.getById(delete_id);
        if(!project_check.getIfDeleted()){
            throw new RuntimeException("Delete failed");
        }else {
            logger.info("Delete succeed");
        }
    }

    @Test
    public void testDelete() {
        Long delete_id = 4L;
        Project project = projectDao.getById(delete_id);
        projectDao.delete(project);
        Project project_check = projectDao.getById(delete_id);
        if(!project_check.getIfDeleted()){
            throw new RuntimeException("Delete failed");
        }else {
            logger.info("Delete succeed");
        }
    }

    @Test
    public void testListAll() {
        List<Project> projects = projectDao.listAll();
        for (int i = 0; i < projects.size(); i++)
            logger.info("Item" + i + ":" + projects.get(i));
    }

    @Test
    public void testGetBy() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ifDeleted", true);
        paramMap.put("Id", 1L);
        Project project = projectDao.getBy(paramMap);
        if(project.getId().longValue() != 1L){
            throw new RuntimeException("GetBy failed");
        }else{
            logger.info("GetBy succeed");
        }
    }

    @Test
    public void testListBy() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
//        paramMap.put("IsDeleted", false);
        paramMap.put("ProjectName", "admi");
        List<Project> projects = projectDao.listBy(paramMap);
        for (int i = 0; i < projects.size(); i++)
            logger.info("Item" + i + ":" + projects.get(i));
    }

    @Test
    public void testListPage() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ifDeleted", false);
        PageParam pageParam = new PageParam(2, 2);
        PageBean<Project> pageBean = projectDao.listPage(pageParam, paramMap);
        logger.info(pageBean);
        List<Project> projects = pageBean.getRecordList();
//        if(projects.size() != 2){
//            throw new RuntimeException("ListPage failed");
//        }
        for (int i = 0; i < projects.size(); i++)
            logger.info("Item" + i + ":" + projects.get(i));
    }
}
