<template>
    <table-view :fields="fields" :create-result-labels="createResultLabels" base-url="/BasicInfo/Warehouse"/>
</template>
<script>
import TableView from '../../components/table-view'
import warehouseField from '../../fields/UnLoginFields/Warehouse.js'

export default {
    name: 'warehouse',
    components: { TableView },
    data: () => ({
        fields: warehouseField,
        createResultLabels: {
            // UserName: '用户名',
            // password: '密码'
        }
    })
}
</script>