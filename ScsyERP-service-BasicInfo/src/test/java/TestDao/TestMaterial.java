package TestDao;

import cn.AssassinG.ScsyERP.BasicInfo.core.dao.MaterialDao;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Material;
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
public class TestMaterial {
    private static Logger logger = Logger.getLogger(TestMaterial.class);
    @Autowired
    private MaterialDao materialDao;

    @Test
    public void testGetById() {
        Long material_id = 1L;
        Material material = materialDao.getById(material_id);
        if(material == null || material.getId() == null || material.getId().longValue() != material_id.longValue()){
            throw  new RuntimeException("getById failed");
        }else {
            logger.info("GetById success");
        }
    }

    @Test
    public void testInsert() {
        Material material = new Material();
        material.setName("asddf");
        material.setCorporation(1L);
        material.setFigureNumber("th1234");
        materialDao.insert(material);
        Long id = material.getId();
        if(id == null){
            throw new RuntimeException("insert nothing");
        }else {
            logger.info("Inserted : " + materialDao.getById(id));
        }
    }

    @Test
    public void testBatchInsert() {
        Material material = new Material();
        material.setName("asddf3");
        material.setFigureNumber("th1234");
        material.setCorporation(1L);
        Material material1 = new Material();
        material1.setName("asddf4");
        material1.setFigureNumber("th1234");
        material1.setCorporation(1L);
        List<Material> materials = new ArrayList<Material>();
        materials.add(material);
        materials.add(material1);
        int result = materialDao.insert(materials);
        if(result != materials.size()){
            throw new RuntimeException("BatchInsert failed " + (materials.size()-result) + "s, succeed " + result + "s");
        }else if(material.getId() == null || material1.getId() == null){
            throw new RuntimeException("BatchInsert failed");
        }else{
            logger.info("BatchInserted succeed");
        }
    }

    @Test
    public void testUpdate() {
        Material material = materialDao.getById(2);
        String new_name = StringUtils.getRandomStr(6);
        logger.info("Before Update: "+material);
        material.setName(new_name);
        materialDao.update(material);
        Material material_check = materialDao.getById(2);
        if(!material_check.getName().equals(new_name)){
            throw new RuntimeException("Update failed");
        }else{
            logger.info("Updated succeed");
        }
    }

    @Test
    public void testBatchUpdate() {
        Material material2 = materialDao.getById(2);
        Material material4 = materialDao.getById(4);
        String new_name_1 = StringUtils.getRandomStr(6);
        String new_name_2 = StringUtils.getRandomStr(6);
        material2.setName(new_name_1);
        material4.setName(new_name_2);
        List<Material> materials = new ArrayList<Material>();
        materials.add(material2);
        materials.add(material4);
        materialDao.update(materials);
        Material material2_check = materialDao.getById(2);
        Material material4_check = materialDao.getById(4);
        if(!material2_check.getName().equals(new_name_1)){
            throw new RuntimeException("Material2 update failed");
        }
        if(!material4_check.getName().equals(new_name_2)){
            throw new RuntimeException("Material4 update failed");
        }
        if(material2_check.getName().equals(new_name_1) && material4_check.getName().equals(new_name_2)){
            logger.info("BatchUpdated succeed");
        }
    }

    @Test
    public void testDeleteById() {
        Long delete_id = 2L;
        materialDao.delete(delete_id);
        Material material_check = materialDao.getById(delete_id);
        if(!material_check.getIfDeleted()){
            throw new RuntimeException("Delete failed");
        }else {
            logger.info("Delete succeed");
        }
    }

    @Test
    public void testDelete() {
        Long delete_id = 4L;
        Material material = materialDao.getById(delete_id);
        materialDao.delete(material);
        Material material_check = materialDao.getById(delete_id);
        if(!material_check.getIfDeleted()){
            throw new RuntimeException("Delete failed");
        }else {
            logger.info("Delete succeed");
        }
    }

    @Test
    public void testListAll() {
        List<Material> materials = materialDao.listAll();
        for (int i = 0; i < materials.size(); i++)
            logger.info("Item" + i + ":" + materials.get(i));
    }

    @Test
    public void testGetBy() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ifDeleted", true);
        paramMap.put("Id", 1L);
        Material material = materialDao.getBy(paramMap);
        if(material.getId().longValue() != 1L){
            throw new RuntimeException("GetBy failed");
        }else{
            logger.info("GetBy succeed");
        }
    }

    @Test
    public void testListBy() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
//        paramMap.put("IsDeleted", false);
        paramMap.put("MaterialName", "admi");
        List<Material> materials = materialDao.listBy(paramMap);
        for (int i = 0; i < materials.size(); i++)
            logger.info("Item" + i + ":" + materials.get(i));
    }

    @Test
    public void testListPage() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ifDeleted", false);
        PageParam pageParam = new PageParam(2, 2);
        PageBean<Material> pageBean = materialDao.listPage(pageParam, paramMap);
        logger.info(pageBean);
        List<Material> materials = pageBean.getRecordList();
//        if(materials.size() != 2){
//            throw new RuntimeException("ListPage failed");
//        }
        for (int i = 0; i < materials.size(); i++)
            logger.info("Item" + i + ":" + materials.get(i));
    }
}
