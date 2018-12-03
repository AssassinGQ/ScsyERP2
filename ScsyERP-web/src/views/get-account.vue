<template>
    <div :class="$style.view">
        <div :class="$style.form">
            <h1 :class="$style.title">危化品运输平台</h1>
            <el-select :class="$style.select" placeholder="类型" v-model="type" type="select" size="medium" style="width: 320px">
                <el-option
                        v-for="(item, index) in options"
                        :key="index"
                        :label="item.label"
                        :value="item.value"/>
            </el-select>
            <el-input :class="$style.field" placeholder="名称" v-model="name" type="name"/>
            <el-input :class="$style.field" placeholder="用户名(不填则由系统生成)" v-model="username" name="username"/>
            <el-input :class="$style.field" placeholder="密码(不填则由系统生成)" v-model="password" name="password"/>
            <el-input :class="$style.field" placeholder="手机号" v-model="phone" type="phone"/>
            <el-button :class="$style.field" @click="getAccount" type="primary">生成账号</el-button>
        </div>
    </div>
</template>
<script>
    import {POST} from '../api'

    export default {
        name: 'getAccount',
        data: () => ({
            type: '',
            name: '',
            phone: '',
            username: '',
            password: '',
            options: [{
                value: '0',
                label: '承运方'
            }, {
                value: '1',
                label: '政府'
            }, {
                value: '2',
                label: '设备生产商'
            }]
        }),
        methods: {
            getAccount() {
                let {type, name, phone, username, password} = this
                POST('/user/getAccount', {type, name, phone, username, password})
                    .then(response=>{
                        this.username = response.username;
                        this.password = response.password;
                    })
            }
        }
    }
</script>
<style module>
    .view {
        background: white;
        /*height: 100vh;*/
        /*width: 100vw;*/
        display: flex;
        align-items: center;
        justify-content: center;
    }

    .title {
        text-align: center;
        margin: 0 0 20px 0;
    }

    .form {
        width: 400px;
        background: white;
        padding: 40px;
        box-sizing: border-box;
    }

    .field {
        margin: 16px 0 0 0 !important;
        width: 100%;
    }
</style>