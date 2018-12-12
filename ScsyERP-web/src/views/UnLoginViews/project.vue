<template>
    <table-view :fields="fields" :create-result-labels="createResultLabels" base-url="/BasicInfo/Project"/>
</template>
<script>
import TableView from '../../components/table-view'
import projectField from '../../fields/UnLoginFields/Project.js'

export default {
    name: 'project',
    components: { TableView },
    data: () => ({
        fields: projectField,
        createResultLabels: {
            // UserName: '用户名',
            // password: '密码'
        }
    })
}
</script>