<template>
    <table-view :fields="fields" :create-result-labels="createResultLabels" base-url="/InStorageForm"/>
</template>
<script>
import TableView from '../../components/table-view'
import inStorageFormField from '../../fields/FormFields/InStorageForm.js'

export default {
    name: 'in-storage-form',
    components: { TableView },
    data: () => ({
        fields: inStorageFormField,
        createResultLabels: {
            // UserName: '用户名',
            // password: '密码'
        }
    })
}
</script>