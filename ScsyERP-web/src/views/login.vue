<template>
    <div :class="$style.view">
        <div :class="$style.form">
            <h1 :class="$style.title">危化品运输平台</h1>
            <el-input :class="$style.field" placeholder="用户名" v-model="UserName"/>
            <el-input :class="$style.field" placeholder="密码" v-model="PassWord" type="password"/>
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
    TYPE_SUPERADMIN,
    TYPE_MANUFACTURER,
    TYPE_DRIVER,
    TYPE_ESCORT,
    TYPE_GOV,
    state
} from '../store/modules/user'

export default {
    name: 'login',
    data: () => ({
        UserName: '',
        PassWord: ''
    }),
    methods: {
        login() {
            let { UserName, PassWord } = this
            POST('/user/dologin', { UserName: UserName, PassWord: PassWord })
                .then(user => {
                    console.log(user);
                    this.$store.commit('receiveUser', user);
                    if(user.UserType == TYPE_SUPERADMIN){
                        console.log("push GetAccount");
                        this.$router.push('/GetAccount')
                    } else if(user.UserType == TYPE_GOV){
                        this.$router.push('/government')
                    } else if(user.UserType == TYPE_MANUFACTURER){
                        this.$router.push('/manufacturer')
                    } else if(user.UserType == TYPE_DRIVER){
                        this.$router.push('/driver/driver')
                    } else if(user.UserType == TYPE_ESCORT){
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