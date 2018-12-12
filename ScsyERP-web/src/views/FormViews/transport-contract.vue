<template>
    <table-view :fields="fields" :create-result-labels="createResultLabels" base-url="/TransportContract"/>
</template>
<script>
import TableView from '../../components/table-view'
import transportContractField from '../../fields/FormFields/TransportContract.js'

export default {
    name: 'transport-contract',
    components: { TableView },
    data: () => ({
        fields: transportContractField,
        createResultLabels: {
            // UserName: '用户名',
            // password: '密码'
        }
    })
}
</script>