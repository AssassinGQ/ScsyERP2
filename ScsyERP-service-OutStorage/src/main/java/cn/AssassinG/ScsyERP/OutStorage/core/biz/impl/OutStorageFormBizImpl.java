package cn.AssassinG.ScsyERP.OutStorage.core.biz.impl;

import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.DriveWorker;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.LiftWorker;
import cn.AssassinG.ScsyERP.BasicInfo.facade.entity.Product;
import cn.AssassinG.ScsyERP.BasicInfo.facade.service.DriveWorkerServiceFacade;
import cn.AssassinG.ScsyERP.BasicInfo.facade.service.LiftWorkerServiceFacade;
import cn.AssassinG.ScsyERP.BasicInfo.facade.service.ProductServiceFacade;
import cn.AssassinG.ScsyERP.Fee.facade.entity.OnTruckForm;
import cn.AssassinG.ScsyERP.Fee.facade.entity.TransportContract;
import cn.AssassinG.ScsyERP.Fee.facade.service.OnTruckFormServiceFacade;
import cn.AssassinG.ScsyERP.Fee.facade.service.TransportContractServiceFacade;
import cn.AssassinG.ScsyERP.OutStorage.core.biz.OutStorageFormBiz;
import cn.AssassinG.ScsyERP.OutStorage.core.dao.OutStorageFormDao;
import cn.AssassinG.ScsyERP.OutStorage.facade.entity.OutStorageForm;
import cn.AssassinG.ScsyERP.OutStorage.facade.exceptions.OutStorageFormBizException;
import cn.AssassinG.ScsyERP.common.core.biz.impl.FormBizImpl;
import cn.AssassinG.ScsyERP.common.core.dao.BaseDao;
import cn.AssassinG.ScsyERP.common.enums.AccountStatus;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Component("OutStorageFormBiz")
public class OutStorageFormBizImpl extends FormBizImpl<OutStorageForm> implements OutStorageFormBiz {
    @Autowired
    private OutStorageFormDao outStorageFormDao;
    protected BaseDao<OutStorageForm> getDao() {
        return this.outStorageFormDao;
    }

//    public void update(OutStorageForm outStorageForm) {
//        ValidUtils.ValidationWithExp(outStorageForm);
//        OutStorageForm outStorageForm_check = this.getById(outStorageForm.getId());
//        if(outStorageForm_check == null || outStorageForm_check.getIfDeleted()){
//            throw new OutStorageFormBizException(OutStorageFormBizException.OUTSTORAGEFORMBIZ_NOSUIT_RESULT, "该出库单已被删除，entityId: %d", outStorageForm.getId());
//        }
//        if(outStorageForm_check.getIfCompleted()){
//            throw new OutStorageFormBizException(OutStorageFormBizException.OUTSTORAGEFORMBIZ_PARAMS_ILLEGAL, "该出库单已经完成，不能更新");
//        }
//        getDao().update(outStorageForm);
//    }

    /**
     * @param entityId
     * @param paramMap 出库单基本信息字段(warehouse,truck,pickWorker,lister,accountStatus,totalAmount,totalVolume,totalWeight,realOutStorageWeight)
     */
    @Transactional
    public void updateByMap(Long entityId, Map<String, String> paramMap) {
        if(entityId == null){
            throw new OutStorageFormBizException(OutStorageFormBizException.OUTSTORAGEFORMBIZ_PARAMS_ILLEGAL, "出库单基本信息主键不能为空");
        }
        OutStorageForm outStorageForm = this.getById(entityId);
        if(outStorageForm == null || outStorageForm.getIfDeleted()){
            throw new OutStorageFormBizException(OutStorageFormBizException.OUTSTORAGEFORMBIZ_NOSUIT_RESULT, "没有符合条件的出库单基本信息，entityId: %d", entityId);
        }
        try {
            Long warehouse = paramMap.get("warehouse") == null ? null : Long.valueOf(paramMap.get("warehouse"));
            Long truck = paramMap.get("truck") == null ? null : Long.valueOf(paramMap.get("truck"));
            Long pickWorker = paramMap.get("pickWorker") == null ? null : Long.valueOf(paramMap.get("pickWorker"));
            Long lister = paramMap.get("lister") == null ? null : Long.valueOf(paramMap.get("lister"));
            AccountStatus accountStatus = AccountStatus.getEnum(paramMap.get("accountStatus"));
            Integer totalAmount = paramMap.get("totalAmount") == null ? null : Integer.valueOf(paramMap.get("totalAmount"));
            Double totalVolume = paramMap.get("totalVolume") == null ? null : Double.valueOf(paramMap.get("totalVolume"));
            Double totalWeight = paramMap.get("totalWeight") == null ? null : Double.valueOf(paramMap.get("totalWeight"));
            Double realOutStorageWeight = paramMap.get("realOutStorageWeight") == null ? null : Double.valueOf(paramMap.get("realOutStorageWeight"));
            boolean flag = false;
            if(warehouse != null) {
                outStorageForm.setWarehouse(warehouse);
                flag = true;
            }
            if(truck != null) {
                outStorageForm.setWarehouse(truck);
                flag = true;
            }
            if(pickWorker != null) {
                outStorageForm.setWarehouse(pickWorker);
                flag = true;
            }
            if(lister != null) {
                outStorageForm.setWarehouse(lister);
                flag = true;
            }
            if(accountStatus != null) {
                outStorageForm.setAccountStatus(accountStatus);
                flag = true;
            }
            if(totalAmount != null) {
                outStorageForm.setTotalAmount(totalAmount);
                flag = true;
            }
            if(totalVolume != null) {
                outStorageForm.setTotalVolume(totalVolume);
                flag = true;
            }
            if(totalWeight != null) {
                outStorageForm.setTotalWeight(totalWeight);
                flag = true;
            }
            if(realOutStorageWeight != null) {
                outStorageForm.setRealOutStorageWeight(realOutStorageWeight);
                flag = true;
            }
            if (flag) {
                this.update(outStorageForm);
            }
        }catch(NumberFormatException e){
            throw new OutStorageFormBizException(OutStorageFormBizException.OUTSTORAGEFORMBIZ_NOSUIT_RESULT, "参数格式错误："+e.getMessage());
        }
    }

    @Autowired
    private DriveWorkerServiceFacade driveWorkerServiceFacade;

    @Transactional
    public void addDriveWorkers(Long entityId, String jsonArrayStr) {
        if(entityId == null){
            throw new OutStorageFormBizException(OutStorageFormBizException.OUTSTORAGEFORMBIZ_PARAMS_ILLEGAL, "出库单基本信息主键不能为空");
        }
        if(jsonArrayStr == null || jsonArrayStr.isEmpty()){
            throw new OutStorageFormBizException(OutStorageFormBizException.OUTSTORAGEFORMBIZ_PARAMS_ILLEGAL, "行车工基本信息主键不能为空");
        }
        JSONArray jsonArray;
        try{
            jsonArray = JSONArray.parseArray(jsonArrayStr);
        }catch(Exception e){
            throw new OutStorageFormBizException(OutStorageFormBizException.OUTSTORAGEFORMBIZ_PARAMS_ILLEGAL, "行车工基本信息主键格式不正确");
        }
        OutStorageForm outStorageForm = this.getById(entityId);
        if(outStorageForm == null || outStorageForm.getIfDeleted()){
            throw new OutStorageFormBizException(OutStorageFormBizException.OUTSTORAGEFORMBIZ_NOSUIT_RESULT, "没有符合条件的出库单基本信息，entityId: %d", entityId);
        }
        boolean flag = true;
        for(int i = 0; i < jsonArray.size(); i++){
            DriveWorker driveWorker_tmp = driveWorkerServiceFacade.getById(jsonArray.getLong(i));
            if(driveWorker_tmp == null || driveWorker_tmp.getIfDeleted()){
                flag = false;
            }else{
                outStorageForm.getDriveWorkers().add(driveWorker_tmp.getId());
            }
        }
        this.update(outStorageForm);
        if(!flag){
            throw new OutStorageFormBizException(OutStorageFormBizException.OUTSTORAGEFORMBIZ_UNKNOWN_ERROR, "一部分行车工主键没有对应的记录导致这部分主键没有添加到", entityId);
        }
    }

    @Transactional
    public void removeDriveWorker(Long entityId, Long driveWorkerId) {
        if(entityId == null){
            throw new OutStorageFormBizException(OutStorageFormBizException.OUTSTORAGEFORMBIZ_PARAMS_ILLEGAL, "出库单基本信息主键不能为空");
        }
        if(driveWorkerId == null){
            throw new OutStorageFormBizException(OutStorageFormBizException.OUTSTORAGEFORMBIZ_PARAMS_ILLEGAL, "行车工基本信息主键不能为空");
        }
        OutStorageForm outStorageForm = this.getById(entityId);
        if(outStorageForm == null || outStorageForm.getIfDeleted()){
            throw new OutStorageFormBizException(OutStorageFormBizException.OUTSTORAGEFORMBIZ_NOSUIT_RESULT, "没有符合条件的出库单基本信息，entityId: %d", entityId);
        }
        DriveWorker driveWorker = driveWorkerServiceFacade.getById(driveWorkerId);
        if(driveWorker == null || driveWorker.getIfDeleted()){
            throw new OutStorageFormBizException(OutStorageFormBizException.OUTSTORAGEFORMBIZ_NOSUIT_RESULT, "没有符合条件的行车工基本信息，entityId: %d", entityId);
        }
        outStorageForm.getDriveWorkers().remove(driveWorker.getId());
        this.update(outStorageForm);
    }

    @Autowired
    private LiftWorkerServiceFacade liftWorkerServiceFacade;

    @Transactional
    public void addLiftWorkers(Long entityId, String jsonArrayStr) {
        if(entityId == null){
            throw new OutStorageFormBizException(OutStorageFormBizException.OUTSTORAGEFORMBIZ_PARAMS_ILLEGAL, "出库单基本信息主键不能为空");
        }
        if(jsonArrayStr == null || jsonArrayStr.isEmpty()){
            throw new OutStorageFormBizException(OutStorageFormBizException.OUTSTORAGEFORMBIZ_PARAMS_ILLEGAL, "起重工基本信息主键不能为空");
        }
        JSONArray jsonArray;
        try{
            jsonArray = JSONArray.parseArray(jsonArrayStr);
        }catch(Exception e){
            throw new OutStorageFormBizException(OutStorageFormBizException.OUTSTORAGEFORMBIZ_PARAMS_ILLEGAL, "起重工基本信息主键格式不正确");
        }
        OutStorageForm outStorageForm = this.getById(entityId);
        if(outStorageForm == null || outStorageForm.getIfDeleted()){
            throw new OutStorageFormBizException(OutStorageFormBizException.OUTSTORAGEFORMBIZ_NOSUIT_RESULT, "没有符合条件的出库单基本信息，entityId: %d", entityId);
        }
        boolean flag = true;
        for(int i = 0; i < jsonArray.size(); i++){
            LiftWorker liftWorker_tmp = liftWorkerServiceFacade.getById(jsonArray.getLong(i));
            if(liftWorker_tmp == null || liftWorker_tmp.getIfDeleted()){
                flag = false;
            }else{
                outStorageForm.getLiftWorkers().add(liftWorker_tmp.getId());
            }
        }
        this.update(outStorageForm);
        if(!flag){
            throw new OutStorageFormBizException(OutStorageFormBizException.OUTSTORAGEFORMBIZ_UNKNOWN_ERROR, "一部分起重工主键没有对应的记录导致这部分主键没有添加到", entityId);
        }
    }

    @Transactional
    public void removeLiftWorker(Long entityId, Long liftWorkerId) {
        if(entityId == null){
            throw new OutStorageFormBizException(OutStorageFormBizException.OUTSTORAGEFORMBIZ_PARAMS_ILLEGAL, "出库单基本信息主键不能为空");
        }
        if(liftWorkerId == null){
            throw new OutStorageFormBizException(OutStorageFormBizException.OUTSTORAGEFORMBIZ_PARAMS_ILLEGAL, "起重工基本信息主键不能为空");
        }
        OutStorageForm outStorageForm = this.getById(entityId);
        if(outStorageForm == null || outStorageForm.getIfDeleted()){
            throw new OutStorageFormBizException(OutStorageFormBizException.OUTSTORAGEFORMBIZ_NOSUIT_RESULT, "没有符合条件的出库单基本信息，entityId: %d", entityId);
        }
        LiftWorker liftWorker = liftWorkerServiceFacade.getById(liftWorkerId);
        if(liftWorker == null || liftWorker.getIfDeleted()){
            throw new OutStorageFormBizException(OutStorageFormBizException.OUTSTORAGEFORMBIZ_NOSUIT_RESULT, "没有符合条件的起重工基本信息，entityId: %d", entityId);
        }
        outStorageForm.getLiftWorkers().remove(liftWorker.getId());
        this.update(outStorageForm);
    }

    @Autowired
    private ProductServiceFacade productServiceFacade;

    @Transactional
    public void addProduct(Long entityId, Long productId) {
        if(entityId == null){
            throw new OutStorageFormBizException(OutStorageFormBizException.OUTSTORAGEFORMBIZ_PARAMS_ILLEGAL, "出库单基本信息主键不能为空");
        }
        if(productId == null){
            throw new OutStorageFormBizException(OutStorageFormBizException.OUTSTORAGEFORMBIZ_PARAMS_ILLEGAL, "货物基本信息主键不能为空");
        }
        OutStorageForm outStorageForm = this.getById(entityId);
        if(outStorageForm == null || outStorageForm.getIfDeleted()){
            throw new OutStorageFormBizException(OutStorageFormBizException.OUTSTORAGEFORMBIZ_NOSUIT_RESULT, "没有符合条件的出库单基本信息，entityId: %d", entityId);
        }
        Product product = productServiceFacade.getById(productId);
        if(product == null || product.getIfDeleted()){
            throw new OutStorageFormBizException(OutStorageFormBizException.OUTSTORAGEFORMBIZ_NOSUIT_RESULT, "没有符合条件的货物基本信息，entityId: %d", entityId);
        }
        outStorageForm.getProducts().add(product.getId());
        this.update(outStorageForm);
    }

    @Transactional
    public void removeProduct(Long entityId, Long productId) {
        if(entityId == null){
            throw new OutStorageFormBizException(OutStorageFormBizException.OUTSTORAGEFORMBIZ_PARAMS_ILLEGAL, "出库单基本信息主键不能为空");
        }
        if(productId == null){
            throw new OutStorageFormBizException(OutStorageFormBizException.OUTSTORAGEFORMBIZ_PARAMS_ILLEGAL, "货物基本信息主键不能为空");
        }
        OutStorageForm outStorageForm = this.getById(entityId);
        if(outStorageForm == null || outStorageForm.getIfDeleted()){
            throw new OutStorageFormBizException(OutStorageFormBizException.OUTSTORAGEFORMBIZ_NOSUIT_RESULT, "没有符合条件的出库单基本信息，entityId: %d", entityId);
        }
        Product product = productServiceFacade.getById(productId);
        if(product == null || product.getIfDeleted()){
            throw new OutStorageFormBizException(OutStorageFormBizException.OUTSTORAGEFORMBIZ_NOSUIT_RESULT, "没有符合条件的货物基本信息，entityId: %d", entityId);
        }
        outStorageForm.getProducts().remove(product.getId());
        this.update(outStorageForm);
    }

    @Autowired
    private OnTruckFormServiceFacade onTruckFormServiceFacade;
    @Autowired
    private TransportContractServiceFacade transportContractServiceFacade;

    @Override
    @Transactional
    public void complete(Long entityId) {
        if(entityId == null){
            throw new OutStorageFormBizException(OutStorageFormBizException.OUTSTORAGEFORMBIZ_PARAMS_ILLEGAL, "出库单基本信息主键不能为空");
        }
        OutStorageForm outStorageForm = this.getById(entityId);
        if(outStorageForm == null || outStorageForm.getIfDeleted()){
            throw new OutStorageFormBizException(OutStorageFormBizException.OUTSTORAGEFORMBIZ_NOSUIT_RESULT, "没有符合条件的出库单基本信息，entityId: %d", entityId);
        }
        Set<Long> products = outStorageForm.getProducts();
        Iterator<Long> iterator = products.iterator();
        int totalAmount = 0;
        double totalVolume = 0, totalWeight = 0;
        while(iterator.hasNext()){
            Product product = productServiceFacade.getById(iterator.next());
            if(product != null || !product.getIfDeleted()){
                totalAmount++;
                totalVolume += product.getVolume();
                totalWeight += product.getWeight();
            }else{
                iterator.remove();
            }
        }
        outStorageForm.setProducts(products);
        outStorageForm.setTotalAmount(totalAmount);
        outStorageForm.setTotalVolume(totalVolume);
        outStorageForm.setTotalWeight(totalWeight);
        outStorageForm.setDriveWorkerAverageWeight(totalWeight/((double)outStorageForm.getDriveWorkers().size()));
        outStorageForm.setLiftWorkerAverageWeight(totalWeight/((double)outStorageForm.getLiftWorkers().size()));
        this.update(outStorageForm);
        OnTruckForm onTruckForm = new OnTruckForm();
        onTruckForm.setFormNumber("OTF"+outStorageForm.getId());
        onTruckForm.setProject(outStorageForm.getProject());
        onTruckForm.setOutStorageForm(outStorageForm.getId());
        onTruckFormServiceFacade.create(onTruckForm);
        TransportContract transportContract = new TransportContract();
        transportContract.setContractNumber("TC"+outStorageForm.getId());
        transportContract.setOnTruckForm(onTruckForm.getId());
        transportContract.setProject(outStorageForm.getProject());
        transportContract.setOutStorageForm(outStorageForm.getId());
        transportContract.setTruck(outStorageForm.getTruck());
        transportContractServiceFacade.create(transportContract);
    }
}
