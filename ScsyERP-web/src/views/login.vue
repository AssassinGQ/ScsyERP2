<template>
    <div :class="$style.view">
        <div :class="$style.form">
            <h1 :class="$style.title">危化品运输平台</h1>
            <el-input :class="$style.field" placeholder="用户名" v-model="username"/>
            <el-input :class="$style.field" placeholder="密码" v-model="password" type="password"/>
            <el-button :class="$style.field" @click="login" type="primary">登录</el-button>
            <el-button :class="$style.field" type="text">忘记密码?</el-button>
        </div>
    </div>
</template>
<script>
import { POST } from '../api'
import {
    TYPE_BUYER,
    TYPE_CORP,
    TYPE_CORP_ADMIN,
    TYPE_SELLER,
    TYPE_SUPERADMIN,
    TYPE_MANU,
    TYPE_DRIVER,
    TYPE_ESCORT,
    TYPE_GOV,
    state
} from '../store/modules/user'

export default {
    name: 'login',
    data: () => ({
        username: '',
        password: ''
    }),
    methods: {
        login() {
            let { username, password } = this
            POST('/user/login', { username, password })
                .then(user => {
                    this.$store.commit('receiveUser', user);
                    if(user.type == TYPE_SUPERADMIN){
                        this.$router.push('/get-account')
                    } else if(user.type == TYPE_GOV){
                        this.$router.push('/government')
                    } else if(user.type == TYPE_MANU){
                        this.$router.push('/manufacturer')
                    } else if(user.type == TYPE_DRIVER){
                        this.$router.push('/driver/driver')
                    } else if(user.type == TYPE_ESCORT){
                        this.$router.push('/driver/escort')
                    } else{
                        this.$router.push('/order')
                    }
                })
        }
    }
}
</script>
<style module>
    .view {
        background: #eee;
        height: 100vh;
        width: 100vw;
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