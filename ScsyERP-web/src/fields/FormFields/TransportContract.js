import formField from '../BaseFields/FormField.js'

export default Object.freeze([
    ...formField,
    { key: 'ContractNumber', label: '图号', },
    { key: 'OnTruckForm', label: '图号', type: 'select', optionsUrl: '/OnTruckForm/query', },
    { key: 'project', label: '项目工程', type: 'select', optionsUrl: '/BasicInfo/Project/query', },
    { key: 'outStorageForm', label: '出库单号', type: 'select', optionsUrl: '/OutStorage/query', },
    { key: 'Truck', label: '运输车辆', type: 'select', optionsUrl: '/BasicInfo/Truck/query', },
    { key: 'Supplier', label: '合供方', },
    { key: 'ProductInsurance', label: '货物保价', },
    { key: 'RealWeight', label: '实际重量', },
    { key: 'FareByWeight', label: '按重量计算费用', },
    { key: 'TotalFareByWeight', label: '总按重量计算费用', },
    { key: 'FareByTruck', label: '按车计算费用', },
    { key: 'PrePay', label: '预付金额', },
    { key: 'OilCardType', label: '油卡类型', type: 'select', options: { 0: '中国石油', 1: '中国石化'}, },
    { key: 'OilCardNumber', label: '油卡卡号', },
    { key: 'OilCardMoney', label: '油卡预存金额', },
    { key: 'PreRepairFee', label: '预付维修费', },
])