package TestService;

import cn.AssassinG.ScsyERP.BasicInfo.core.biz.ProductBiz;
import cn.AssassinG.ScsyERP.BasicInfo.core.dao.ProductDao;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Product;
import cn.AssassinG.ScsyERP.BasicInfo.facade.enums.PacketType;
import cn.AssassinG.ScsyERP.BasicInfo.facade.service.ProductServiceFacade;
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
public class ProductServiceFacadeImplTest {
    private static Logger logger = Logger.getLogger(ProductServiceFacadeImplTest.class);
    @Autowired
    private ProductServiceFacade productService;
    @Autowired
    private ProductBiz productBiz;
    @Autowired
    private ProductDao productDao;

    private Long productId;

    @Before
    public void setUp() throws Exception {
        Product product = new Product();
        product.setCorporation(1L);
        product.setName(StringUtils.getRandomStr(6));
        product.setProject(1L);
        product.setMaterial(1L);
        product.setPacketNumber(StringUtils.getRandomStr(3, StringUtils.StrType.NUMBER));
        product.setWarehouse(1L);
        product.setWarehouseLocation(StringUtils.getRandomStr(5));
        product.setInStorageForm(1L);
        product.setPacketType(PacketType.IronBracket);
        productId = productBiz.create(product);
    }

    @After
    public void tearDown() throws Exception {
        productDao.delete(productId);
    }

    @Test
    public void create() {
        Product product = new Product();
        product.setCorporation(1L);
        product.setName(StringUtils.getRandomStr(8));
        product.setProject(1L);
        product.setMaterial(1L);
        product.setPacketNumber(StringUtils.getRandomStr(3, StringUtils.StrType.NUMBER));
        product.setWarehouse(1L);
//        product.setWarehouseLocation(StringUtils.getRandomStr(5));
        product.setInStorageForm(1L);
        product.setPacketType(PacketType.IronBracket);
        Long id = productService.create(product);
        if(id == null){
            throw new RuntimeException("Create nothing");
        }else {
            logger.info("Created : " + productDao.getById(id));
        }
    }

    @Test
    public void update() {
        Product product = productDao.getById(productId);
        String new_name = StringUtils.getRandomStr(6);
        logger.info("Before Update: "+product);
        product.setName(new_name);
        productService.update(product);
        Product product_check = productDao.getById(productId);
        if(!product_check.getName().equals(new_name)){
            throw new RuntimeException("Update failed");
        }else{
            logger.info("Updated succeed");
        }
    }

    @Test
    public void deleteById() {
        productService.deleteById(productId);
        Product product_check = productDao.getById(productId);
        if(!product_check.getIfDeleted()){
            throw new RuntimeException("Delete failed");
        }else {
            logger.info("Delete succeed");
        }
    }

    @Test
    public void delete() {
        Product product_test = productDao.getById(productId);
        productService.delete(product_test);
        Product product_check = productDao.getById(productId);
        if(!product_check.getIfDeleted()){
            throw new RuntimeException("Delete failed");
        }else {
            logger.info("Delete succeed");
        }
    }

    @Test
    public void getById() {
        Product product = productService.getById(productId);
        if(product == null || product.getIfDeleted()){
            throw new RuntimeException("getById null");
        }else{
            if(product.getId().longValue() != productId.longValue()){
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
        paramMap.put("Id", productId);
        Product product = productService.getBy(paramMap);
        if(product.getId() != productId){
            throw new RuntimeException("getBy failed");
        }else{
            logger.info("getBy succeed");
        }
    }

    @Test
    public void listBy() {
        Product product = productDao.getById(productId);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("IfDeleted", false);
        paramMap.put("Name", product.getName());
        List<Product> products = productService.listBy(paramMap);
        for (int i = 0; i < products.size(); i++)
            logger.info("Item" + i + ":" + products.get(i));
    }

    @Test
    public void listPage() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("IfDeleted", false);
        PageParam pageParam = new PageParam(2, 2);
        PageBean<Product> pageBean = productService.listPage(pageParam, paramMap);
        logger.info(pageBean);
        List<Product> products = pageBean.getRecordList();
        for (int i = 0; i < products.size(); i++)
            logger.info("Item" + i + ":" + products.get(i));
    }

//    @Test
//    public void createWithUser() {
//        Product product = new Product();
//        product.setCorporation(1L);
//        product.setDept(ProductDeptType.FinancialProduct);
//        User user = new User();
//        user.setUserName(StringUtils.getRandomStr(8));
//        user.setPassWord("d123456");
//        user.setPhone("188" + StringUtils.getRandomStr(8, StringUtils.StrType.NUMBER));
//        user.setCorporation(1L);
//        productService.createWithUser(product, user);
//        if(user.getUserType() != UserType.Product || user.getUserInfo().longValue() != product.getId().longValue()){
//            throw new RuntimeException("createWithUser failed");
//        }else {
//            logger.info("createWithUser succeed : ProductID:" + product.getId() + ", userID:" + user.getId());
//        }
//    }

    @Test
    public void updateByMap() {
        String new_name = StringUtils.getRandomStr(6);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("name", new_name);
        productService.updateByMap(productId, paramMap);
        Product product_check = productDao.getById(productId);
        if(!product_check.getName().equals(new_name)){
            throw new RuntimeException("updateByMap failed");
        }else{
            logger.info("updateByMap succeed");
        }
    }

//    @Test
//    public void deleteByUserId() {
//        productService.deleteByUserId(userId);
//        User user_check = userDao.getById(userId);
//        if(user_check == null || !user_check.getIfDeleted() || user_check.getUserType().getValue().intValue() != UserType.Product.getValue().intValue()){
//            throw new RuntimeException("deleteByUserId failed");
//        }
//        Product product_check = productDao.getById(user_check.getUserInfo());
//        if(product_check == null || !product_check.getIfDeleted()){
//            throw new RuntimeException("deleteByUserId failed");
//        }
//        logger.info("deleteByUserId succeed");
//    }
}