<template>
    <table-view :fields="fields" :create-result-labels="createResultLabels" base-url="/OutStorageForm"/>
</template>
<script>
import TableView from '../../components/table-view'
import outStorageFormField from '../../fields/FormFields/OutStorageForm.js'

export default {
    name: 'out-storage-form',
    components: { TableView },
    data: () => ({
        fields: outStorageFormField,
        createResultLabels: {
            // UserName: '用户名',
            // password: '密码'
        }
    })
}
</script>