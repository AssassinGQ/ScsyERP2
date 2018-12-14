<template>
    <table-view :fields="fields" :create-result-labels="createResultLabels" base-url="/BasicInfo/Manufacturer" :custom-actions="customActions"/>
</template>
<script>
import TableView from '../../components/table-view'
import manufacturerField from '../../fields/LoginFields/Manufacturer.js'

export default {
    name: 'manufacturer',
        components: { TableView },
        data: () => ({
            fields: manufacturerField,
            createResultLabels: {
                UserName: '用户名',
                password: '密码'
            },
            customActions: [{
                label: '添加生产厂家',
                url: '/BasicInfo/Manufacturer/addWorkshop',
                fields: [
                    { key: 'manufacturer', label: '生产厂家', type: 'select', optionsUrl: '/BasicInfo/Manufacturer/query?Corporation=2', },
                    { key: 'workshop', label: '生产车间', type: 'select', optionsUrl: '/BasicInfo/Workshop/query', }
                ]
            },{
                label: '移除生产厂家',
                url: '/BasicInfo/Manufacturer/removeWorkshop',
                fields: [
                    { key: 'manufacturer', label: '生产厂家', type: 'select', optionsUrl: '/BasicInfo/Manufacturer/query?Corporation=2', },
                    { key: 'workshop', label: '生产车间', type: 'select', optionsUrl: '/BasicInfo/Workshop/query', }
                ]
            }],
        }),
        methods:{

        }
}
</script>