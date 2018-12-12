<template>
    <table-view :fields="fields" :create-result-labels="createResultLabels" base-url="/BasicInfo/Manufacturer"/>
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
        }
    })
}
</script>