package cn.AssassinG.ScsyERP.BasicInfo.core.biz.impl;

import cn.AssassinG.ScsyERP.BasicInfo.core.biz.ProductBiz;
import cn.AssassinG.ScsyERP.BasicInfo.core.dao.ProductDao;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Product;
import cn.AssassinG.ScsyERP.BasicInfo.facade.enums.PacketType;
import cn.AssassinG.ScsyERP.BasicInfo.facade.exceptions.ProductBizException;
import cn.AssassinG.ScsyERP.common.core.biz.impl.UnLoginableBizImpl;
import cn.AssassinG.ScsyERP.common.core.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Component("ProductBiz")
public class ProductBizImpl extends UnLoginableBizImpl<Product> implements ProductBiz {
    @Autowired
    private ProductDao productDao;
    protected BaseDao<Product> getDao() {
        return this.productDao;
    }

    /**
     * @param entityId
     * @param paramMap 货物基本信息字段(material,name,packetNumber,warehouse,warehouseLocation,out_storage,packetType,width,length,height,weight,volume)
     */
    @Override
    @Transactional
    public void updateByMap(Long entityId, Map<String, String> paramMap) {
        if(entityId == null){
            throw new ProductBizException(ProductBizException.PRODUCTBIZ_PARAMS_ILLEGAL, "货物基本信息主键不能为空");
        }
        Product product = this.getById(entityId);
        if(product == null || product.getIfDeleted()){
            throw new ProductBizException(ProductBizException.PRODUCTBIZ_NOSUIT_RESULT, "没有符合条件的货物基本信息，entityId: %d", entityId);
        }
        try {
            Long material = paramMap.get("material") == null ? null : Long.parseLong(paramMap.get("material"));
            String name = paramMap.get("name");
            String packetNumber = paramMap.get("packetNumber");
            Long warehouse = paramMap.get("warehouse") == null ? null : Long.parseLong(paramMap.get("warehouse"));
            String warehouseLocation = paramMap.get("warehouseLocation");
            Long out_storage = paramMap.get("out_storage") == null ? null : Long.parseLong(paramMap.get("out_storage"));
            PacketType packetType = PacketType.getEnum(paramMap.get("packetType"));
            Double width = paramMap.get("width") == null ? null : Double.parseDouble(paramMap.get("width"));
            Double length = paramMap.get("length") == null ? null : Double.parseDouble(paramMap.get("length"));
            Double height = paramMap.get("height") == null ? null : Double.parseDouble(paramMap.get("height"));
            Double weight = paramMap.get("weight") == null ? null : Double.parseDouble(paramMap.get("weight"));
            Double volume = paramMap.get("volume") == null ? null : Double.parseDouble(paramMap.get("volume"));
            boolean flag = false;
            if(material != null) {
                product.setMaterial(material);
                flag = true;
            }
            if(name != null && !name.isEmpty()) {
                product.setName(name);
                flag = true;
            }
            if(packetNumber != null && !packetNumber.isEmpty()) {
                product.setPacketNumber(packetNumber);
                flag = true;
            }
            if(warehouse != null) {
                product.setWarehouse(warehouse);
                flag = true;
            }
            if(warehouseLocation != null && !warehouseLocation.isEmpty()) {
                product.setWarehouseLocation(warehouseLocation);
                flag = true;
            }
            if(out_storage != null) {
                product.setOutStorageForm(out_storage);
                flag = true;
            }
            if(packetType != null) {
                product.setPacketType(packetType);
                flag = true;
            }
            if(width != null) {
                product.setWidth(width);
                flag = true;
            }
            if(length != null) {
                product.setLength(length);
                flag = true;
            }
            if(height != null) {
                product.setHeight(height);
                flag = true;
            }
            if(weight != null) {
                product.setWeight(weight);
                flag = true;
            }
            if(volume != null) {
                product.setVolume(volume);
                flag = true;
            }
            if (flag) {
                this.update(product);
            }
        }catch(NumberFormatException e){
            throw new ProductBizException(ProductBizException.PRODUCTBIZ_PARAMS_ILLEGAL, "参数格式错误："+e.getMessage());
        }
    }
}
