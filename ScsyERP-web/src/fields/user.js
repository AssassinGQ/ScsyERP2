export default Object.freeze([
    { key: 'sid', label: '用户编号', },
    { key: 'usersid', label: '用户信息编号', },
    { key: 'username', label: '用户名', type: 'name', },
    { key: 'phone', label: '手机号', },
    {
        key: 'type', label: '用户类型', type: 'select',
        options: { 233:'超级管理员', 0: '管理员', 1: '驾驶员', 2: '托运方', 3: '收货方', 4: '承运方', 5: '设备管理商', 6:'政府', 7:'押运员' }
    },
    {
        key: 'isdocauthd', label: '阅读资料权限', type: 'select',
        options: { 0: '有权限', 1: '无权限' }
    },
    {
        key: 'isexamauthd', label: '考试权限', type: 'select',
        options: { 0: '有权限', 1: '无权限' }
    },
])