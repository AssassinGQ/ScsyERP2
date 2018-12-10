export default Object.freeze([
    { key: 'Id', label: '用户编号', },
    { key: 'UserName', label: '用户名', type: 'name', },
    { key: 'UserInfo', label: '用户信息编号', },
    { key: 'Phone', label: '手机号', },
    {
        key: 'UserType', label: '用户类型', type: 'select',
        options: { 8:'超级管理员', 2: '管理员', 3: '驾驶员', 5: '客户', 7: '收货方', 0: '承运方', 6: '生产厂家', 1:'政府', 4:'押运员' }
    },
])