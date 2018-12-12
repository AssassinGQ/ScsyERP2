<template>
    <table-view :fields="fields" :create-result-labels="createResultLabels" base-url="/OnTruckForm"/>
</template>
<script>
import TableView from '../../components/table-view'
import onTruckFormField from '../../fields/FormFields/OnTruckForm.js'

export default {
    name: 'on-truck-form',
    components: { TableView },
    data: () => ({
        fields: onTruckFormField,
        createResultLabels: {
            // UserName: '用户名',
            // password: '密码'
        }
    })
}
</script>