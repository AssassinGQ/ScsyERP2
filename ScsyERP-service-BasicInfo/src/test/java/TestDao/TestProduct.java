package TestDao;

import cn.AssassinG.ScsyERP.BasicInfo.core.dao.ProductDao;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Product;
import cn.AssassinG.ScsyERP.BasicInfo.facade.enums.PacketType;
import cn.AssassinG.ScsyERP.BasicInfo.facade.enums.ProductStatus;
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
public class TestProduct {
    private static Logger logger = Logger.getLogger(TestProduct.class);
    @Autowired
    private ProductDao productDao;

    @Test
    public void testGetById() {
        Long product_id = 1L;
        Product product = productDao.getById(product_id);
        if(product == null || product.getId() == null || product.getId().longValue() != product_id.longValue()){
            throw  new RuntimeException("getById failed");
        }else {
            logger.info("GetById success");
        }
    }

    @Test
    public void testInsert() {
        Product product = new Product();
        product.setName("asddf");
        product.setProject(1L);
        product.setInStorageForm(1L);
        product.setMaterial(1L);
        product.setPacketNumber("hwh12345");
        product.setStatus(ProductStatus.DCK);
        product.setWarehouse(1L);
        product.setPacketType(PacketType.IronBox);
        product.setCorporation(1L);
        productDao.insert(product);
        Long id = product.getId();
        if(id == null){
            throw new RuntimeException("insert nothing");
        }else {
            logger.info("Inserted : " + productDao.getById(id));
        }
    }

    @Test
    public void testBatchInsert() {
        Product product = new Product();
        product.setName("asddf3");
        product.setCorporation(1L);
        product.setProject(1L);
        product.setInStorageForm(1L);
        product.setMaterial(1L);
        product.setPacketNumber("hwh12345");
        product.setStatus(ProductStatus.DCK);
        product.setWarehouse(1L);
        product.setPacketType(PacketType.IronBox);
        Product product1 = new Product();
        product1.setName("asddf4");
        product1.setCorporation(1L);
        product1.setProject(1L);
        product1.setInStorageForm(1L);
        product1.setMaterial(1L);
        product1.setPacketNumber("hwh12345");
        product1.setStatus(ProductStatus.DCK);
        product1.setWarehouse(1L);
        product1.setPacketType(PacketType.IronBox);
        List<Product> products = new ArrayList<Product>();
        products.add(product);
        products.add(product1);
        int result = productDao.insert(products);
        if(result != products.size()){
            throw new RuntimeException("BatchInsert failed " + (products.size()-result) + "s, succeed " + result + "s");
        }else if(product.getId() == null || product1.getId() == null){
            throw new RuntimeException("BatchInsert failed");
        }else{
            logger.info("BatchInserted succeed");
        }
    }

    @Test
    public void testUpdate() {
        Product product = productDao.getById(2);
        String new_name = StringUtils.getRandomStr(6);
        logger.info("Before Update: "+product);
        product.setName(new_name);
        productDao.update(product);
        Product product_check = productDao.getById(2);
        if(!product_check.getName().equals(new_name)){
            throw new RuntimeException("Update failed");
        }else{
            logger.info("Updated succeed");
        }
    }

    @Test
    public void testBatchUpdate() {
        Product product2 = productDao.getById(2);
        Product product4 = productDao.getById(4);
        String new_name_1 = StringUtils.getRandomStr(6);
        String new_name_2 = StringUtils.getRandomStr(6);
        product2.setName(new_name_1);
        product4.setName(new_name_2);
        List<Product> products = new ArrayList<Product>();
        products.add(product2);
        products.add(product4);
        productDao.update(products);
        Product product2_check = productDao.getById(2);
        Product product4_check = productDao.getById(4);
        if(!product2_check.getName().equals(new_name_1)){
            throw new RuntimeException("Product2 update failed");
        }
        if(!product4_check.getName().equals(new_name_2)){
            throw new RuntimeException("Product4 update failed");
        }
        if(product2_check.getName().equals(new_name_1) && product4_check.getName().equals(new_name_2)){
            logger.info("BatchUpdated succeed");
        }
    }

    @Test
    public void testDeleteById() {
        Long delete_id = 2L;
        productDao.delete(delete_id);
        Product product_check = productDao.getById(delete_id);
        if(!product_check.getIfDeleted()){
            throw new RuntimeException("Delete failed");
        }else {
            logger.info("Delete succeed");
        }
    }

    @Test
    public void testDelete() {
        Long delete_id = 4L;
        Product product = productDao.getById(delete_id);
        productDao.delete(product);
        Product product_check = productDao.getById(delete_id);
        if(!product_check.getIfDeleted()){
            throw new RuntimeException("Delete failed");
        }else {
            logger.info("Delete succeed");
        }
    }

    @Test
    public void testListAll() {
        List<Product> products = productDao.listAll();
        for (int i = 0; i < products.size(); i++)
            logger.info("Item" + i + ":" + products.get(i));
    }

    @Test
    public void testGetBy() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ifDeleted", true);
        paramMap.put("Id", 1L);
        Product product = productDao.getBy(paramMap);
        if(product.getId().longValue() != 1L){
            throw new RuntimeException("GetBy failed");
        }else{
            logger.info("GetBy succeed");
        }
    }

    @Test
    public void testListBy() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
//        paramMap.put("IsDeleted", false);
        paramMap.put("ProductName", "admi");
        List<Product> products = productDao.listBy(paramMap);
        for (int i = 0; i < products.size(); i++)
            logger.info("Item" + i + ":" + products.get(i));
    }

    @Test
    public void testListPage() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ifDeleted", false);
        PageParam pageParam = new PageParam(2, 2);
        PageBean<Product> pageBean = productDao.listPage(pageParam, paramMap);
        logger.info(pageBean);
        List<Product> products = pageBean.getRecordList();
//        if(products.size() != 2){
//            throw new RuntimeException("ListPage failed");
//        }
        for (int i = 0; i < products.size(); i++)
            logger.info("Item" + i + ":" + products.get(i));
    }
}
