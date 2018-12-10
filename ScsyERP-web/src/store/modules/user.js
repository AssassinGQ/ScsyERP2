const defaultUser = () => ({
    Id: undefined,
    UserName: undefined,
    UserType: undefined,
    UserInfo:undefined,
    Corporation: undefined,
    Phone: undefined
})

const state = {
    user: defaultUser(),
    pushMessages: []
}

const mutations = {
    receiveUser: (state, { Id, UserName, UserType, UserInfo, Corporation, Phone }) => {
        state.user = { Id, UserName, UserType, UserInfo, Corporation, Phone }
    },
    resetUser: state => state.user = defaultUser(),
    receivePushMessage: (state, message) => {
        state.pushMessages.push(message)
    },
    resetSocket: state => state.pushMessages = []
}

const actions = {}

export const TYPE_CORP = 0 // 承运方
export const TYPE_GOV = 1 // 政府
export const TYPE_CORP_ADMIN = 2 // 承运方管理员
export const TYPE_DRIVER = 3 //驾驶员
export const TYPE_ESCORT = 4 // 押运员
export const TYPE_CUSTOMER = 5 // 客户
export const TYPE_MANUFACTURER = 6 // 生产厂家
export const TYPE_CONSIGNEE = 7 // 收货方
export const TYPE_SUPERADMIN = 8 // 超级管理员

const getters = {
    user: state => state.user,
    pushMessages: state => state.pushMessages,
    isCorp: state => state.user.type === TYPE_CORP, // 承运方
    isGov: state => state.user.type === TYPE_GOV, // 政府
    isCorpAdmin: state => state.user.type === TYPE_CORP_ADMIN, // 承运方管理员
    isDriver: state => state.user.type === TYPE_DRIVER,
    isEscort: state => state.user.type === TYPE_ESCORT,
    isCustomer: state => state.user.type === TYPE_CUSTOMER,
    isManufacturer: state => state.user.type === TYPE_MANUFACTURER,
    isConsignee: state => state.user.type === TYPE_CONSIGNEE,
    isSuper: state => state.user.type === TYPE_SUPERADMIN,
}

export default { state, mutations, actions, getters }