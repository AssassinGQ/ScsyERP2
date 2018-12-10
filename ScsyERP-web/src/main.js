import Vue from 'vue'
import VueRouter from 'vue-router'
import echarts from 'echarts'

Vue.use(VueRouter)
import './load-element-ui'
import './load-font-awesome'

// Global Components
import FA from './components/fa'
import MAP from './components/map-box'
import TableView from './components/table-view'

Vue.component('fa', FA)
Vue.component('map-box', MAP)
Vue.component('table-view', TableView)

Vue.prototype.$echarts = echarts

import store from './store'
import App from './app.vue'

import LoginView from './views/login'
import DashboardView from './views/dashboard'
import AdministratorView from './views/administrator'
import DriverView from './views/driver'
import VehicleView from './views/vehicle'
import RouteView from './views/route'
import OrderView from './views/order'
import GoodsView from './views/goods'
import FeeCheckView from './views/fee-check'
import RepairLogView from './views/repair-log'
import CarInfoView from './views/car-info'
import ClientView from './views/client'
import ExamsView from './views/exams'
import DocumentsView from './views/documents'
import ScoresView from './views/scores'
import ReadingStatusView from './views/reading-stats'
import CorporationView from './views/corporation'
import OrderPlaceView from './views/order-place'
import LatestLogView from './views/latest-log'

//by qiu
import NoteView from './views/note'
import AccidentqueryView from './views/accidentquery'
import LockView from './views/lock'
import DataView from './views/data'
import AccidentStatsView from './views/accident-stats'
import OrderStatsView from './views/order-stats'

//by hgq
import DaeAuthView from './views/dae-auth'
import GetAccountView from './views/get-account'
import GovernmentView from './views/government'
import ManufacturerView from './views/manufacturer'

const TodoView = { render: h => h('div', 'todo') }
import {
    TYPE_CORP,
    TYPE_CORP_ADMIN,
    TYPE_SUPERADMIN,
    TYPE_MANUFACTURER,
    TYPE_DRIVER,
    TYPE_ESCORT,
    TYPE_GOV,
    TYPE_CUSTOMER,
    TYPE_CONSIGNEE
} from './store/modules/user'

const router = new VueRouter({
    mode: 'history',
    routes: [{
        path: '/',
        // redirect: '/driver',
        // redirect: '/login',
        component: DashboardView,
        children: [{
            path: 'GetAccount',
            component: GetAccountView,
            meta: {
                group: '用户管理', title: '生成账号',
                permission: [TYPE_SUPERADMIN]
            },

        }, {
            path: 'order-stats',
            component: OrderStatsView,
            meta: {
                group: '数据统计', title: '订单统计',
                permission: [TYPE_CORP, TYPE_CORP_ADMIN]
            },
            props: ({ params: { viewType = 'time' } }) => ({ viewType }),
            children: [{ path: ':viewType?' }]
        }]
    }, {
        path: '/login',
        component: LoginView,
        meta: { title: '登录' },
    },{
        path: '*',
        redirect: '/login'
    }]
})

router.beforeEach((to, from, next) => {
    if (to.path !== '/login' && !store.getters.user.token) {
        next({ path: '/login', replace: true })
    } else {
        next()
    }
})

/* Global Filters */
import { format } from 'date-fns'
import humanize from 'humanize-duration'

Vue.filter('format', (timestamp, tokens = 'YYYY-MM-DD') => timestamp ? format(timestamp, tokens) : '暂无')
Vue.filter('humanize', duration => humanize(duration, {
    language: 'zh_CN', largest: 1, units: ['d', 'm']
}))

const app = new Vue({
    el: '#app',
    router,
    store,
    render: h => h(App),
    computed: {
        pageTitle() {
            let title = this.$route.meta.title
            if (!title) {
                let matched = this.$route.matched.find(t => t.meta.title)
                if (matched) title = matched.meta.title
            }
            return title
        }
    }
})

router.afterEach(() => {
    document.title = app.pageTitle
})


/* Show API Errors */
import { handlers } from './api'

handlers.error = ({ msg: message }) => {
    if (message === 'token失效') {
        store.commit('resetUser')
        router.replace('/login')
    }
    app.$notify.error({ title: '错误', message })
}
handlers.success = ({ msg: message }) => {
    app.$notify.success({ message })
}
// handlers.message = message => app.$notify.success({ message })

import { DEBUG } from './util'

if (DEBUG) {
    window.router = router
    window.app = app
}