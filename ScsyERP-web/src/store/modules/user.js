const defaultUser = () => ({
    token: undefined,
    type: undefined,
    sid: undefined,
    corporationsid: undefined,
    usersid: undefined,
    cid: undefined,
    username: undefined,
    wsid: undefined
})

const state = {
    user: defaultUser(),
    pushMessages: []
}

const mutations = {
    receiveUser: (state, { token, type, sid, corporationsid, usersid, cid, username, wsid }) => {
        state.user = { token, type, sid, corporationsid, usersid, cid, username, wsid }
    },
    resetUser: state => state.user = defaultUser(),
    receivePushMessage: (state, message) => {
        state.pushMessages.push(message)
    },
    resetSocket: state => state.pushMessages = []
}

const actions = {}

export const TYPE_SUPERADMIN = 233 //超级管理员
export const TYPE_DRIVER = 0 //驾驶员
export const TYPE_SELLER = 1 // 托运方
export const TYPE_BUYER = 2 // 收货方
export const TYPE_CORP_ADMIN = 3 // 承运方管理员
export const TYPE_CORP = 4 // 承运方
export const TYPE_MANU = 5 // 承运方
export const TYPE_GOV = 6 // 政府
export const TYPE_ESCORT = 7 // 押运员

const getters = {
    user: state => state.user,
    pushMessages: state => state.pushMessages,
    isDriver: state => state.user.type === TYPE_DRIVER,
    isEscort: state => state.user.type === TYPE_ESCORT,
    isSeller: state => state.user.type === TYPE_SELLER, // 托运方
    isBuyer: state => state.user.type === TYPE_BUYER, // 收货方
    isCorpAdmin: state => state.user.type === TYPE_CORP_ADMIN, // 承运方管理员
    isCorp: state => state.user.type === TYPE_CORP, // 承运方
    isGov: state => state.user.type === TYPE_GOV, // 政府
    isManu: state => state.user.type === TYPE_MANU, // 设备生产商
    isSuperAdmin: state => state.user.type === TYPE_SUPERADMIN, // 超级管理员
}

export default { state, mutations, actions, getters }