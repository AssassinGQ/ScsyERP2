<template>
    <table-view :fields="fields" :create-result-labels="createResultLabels" base-url="/basic_info/admin_info"/>
</template>
<script>
import TableView from '../components/table-view'

export default {
    name: 'administrator',
    components: { TableView },
    data: () => ({
        fields: [{
            key: 'username',
            label: '用户名',
        }, {
            key: 'name',
            label: '姓名',
            type: 'name'
        }, {
            key: 'phone',
            label: '手机',
            type: 'phone'
        }, {
            key: 'dept',
            label: '部门',
            type: 'select',
            options: {
                // 0: '仓储',
                1: '危化品',
                2: '财务',
                3: '信息',
                4: '经理',
            }
        }, {
            key: 'email',
            label: '邮箱',
        }],
        createResultLabels: {
            UserName: '用户名',
            password: '密码'
        }
    })
}
</script>