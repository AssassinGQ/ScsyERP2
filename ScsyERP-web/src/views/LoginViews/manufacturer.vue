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
            addWorkshopActions: [{
                label: '确认装货',
                url: '/BasicInfo/Manufacturer/addWorkshops',
                fields: [
                    { key: 'manufacturer', label: '生产厂家', type: 'select', optionsUrl: '/BasicInfo/Manufacturer/query?IfDeleted=',},
                    { key: 'zbweight', label: '折白重量' }
                ]
            }],
            removeWorkshopActions: [{
                label: '确认卸货',
                url: '/order/load',
                fields: [
                    { key: 'loadweight', label: '装货重量' },
                    { key: 'zbweight', label: '折白重量' }
                ]
            }],
        }),
        computed: {
            customActions() {[
                ...this.addWorkshopActions,
                ...this.removeWorkshopActions,
            ]}
        },
}
</script>