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
    TYPE_BUYER,
    TYPE_CORP,
    TYPE_CORP_ADMIN,
    TYPE_SELLER,
    TYPE_SUPERADMIN,
    TYPE_MANU,
    TYPE_DRIVER,
    TYPE_ESCORT,
    TYPE_GOV
} from './store/modules/user'

const router = new VueRouter({
    mode: 'history',
    routes: [{
        path: '/',
        // redirect: '/driver',
        redirect: '/login',
        component: DashboardView,
        children: [{
            path: 'get-account',
            component: GetAccountView,
            meta: {
                group: '用户管理', title: '生成账号',
                permission: [TYPE_SUPERADMIN]
            },
        }, {
            path: 'corporation',
            component: CorporationView,
            meta: {
                group: '基本信息', title: '承运方信息',
                permission: [TYPE_CORP, TYPE_CORP_ADMIN]
            }
        }, {
            path: 'government',
            component: GovernmentView,
            meta: {
                group: '基本信息', title: '政府信息',
                permission: [TYPE_GOV]
            }
        }, {
            path: 'manufacturer',
            component: ManufacturerView,
            meta: {
                group: '基本信息', title: '设备生产商信息',
                permission: [TYPE_MANU]
            }
        }, {
            path: 'administrator',
            component: AdministratorView,
            meta: {
                group: '基本信息', title: '管理员信息',
                permission: [TYPE_CORP, TYPE_CORP_ADMIN]
            }
        }, {
            path: 'driver',
            component: DriverView,
            children: [{ path: ':viewType?' }],
            props: ({ params: { viewType = 'driver' } }) => ({ viewType }),
            meta: {
                group: '基本信息', title: '驾押员信息',
                permission: [TYPE_CORP, TYPE_CORP_ADMIN, TYPE_GOV, TYPE_DRIVER, TYPE_ESCORT]
            },
        }, {
            path: 'vehicle',
            component: VehicleView,
            props: ({ params: { viewType = 'truck' } }) => ({ viewType }),
            meta: {
                group: '基本信息', title: '车辆信息',
                permission: [TYPE_CORP, TYPE_CORP_ADMIN]
            },
            children: [{ path: ':viewType?' }]
        }, {
            path: 'client',
            component: ClientView,
            props: ({ params: { viewType = 'seller' } }) => ({ viewType }),
            meta: {
                group: '基本信息', title: '客户信息',
                permission: [TYPE_CORP, TYPE_CORP_ADMIN, TYPE_SELLER, TYPE_BUYER]
            },
            children: [{ path: ':viewType?' }]
        }, {
            path: 'goods',
            component: GoodsView,
            meta: {
                group: '基本信息', title: '货物信息',
                permission: [TYPE_CORP, TYPE_CORP_ADMIN]
            }
        }, {
            path: 'route',
            component: RouteView,
            meta: {
                group: '基本信息', title: '路线信息',
                permission: [TYPE_CORP, TYPE_CORP_ADMIN]
            }
        }, {
            path: 'order-place',
            component: OrderPlaceView,
            meta: {
                group: '电子运单', title: '下达订单',
                permission: [TYPE_SELLER]
            }
        }, {
            path: 'order',
            component: OrderView,
            meta: {
                group: '电子运单', title: '订单查询',
                permission: [TYPE_SELLER, TYPE_BUYER, TYPE_CORP_ADMIN, TYPE_CORP]
            }
        }, {
            path: 'fee-check',
            component: FeeCheckView,
            meta: {
                group: '电子运单', title: '费用审核',
                permission: [TYPE_CORP, TYPE_CORP_ADMIN]
            }
        }, {
            path: 'latest-log',
            component: LatestLogView,
            props: ({ params: { viewType = 'trucks' } }) => ({ viewType }),
            meta: {
                group: '在途监控', title: '最新日志',
                permission: [TYPE_CORP, TYPE_CORP_ADMIN]
            },
            children: [{ path: ':viewType?' }]
        }, {
            path: 'data',
            component: DataView,
            meta: {
                group: '在途监控', title: '历史日志',
                permission: [TYPE_CORP, TYPE_CORP_ADMIN]
            }
        }, {
            path: 'accidentquery',
            component: AccidentqueryView,
            meta: {
                group: '在途监控', title: '异常信息',
                permission: [TYPE_CORP, TYPE_CORP_ADMIN]
            }
        }, {
            path: 'lock',
            component: LockView,
            meta: {
                group: '在途监控', title: '开锁管理',
                permission: [TYPE_CORP, TYPE_CORP_ADMIN]
            }
        }, {
            path: 'realtime',
            component: NoteView,
            meta: {
                group: '在途监控', title: '实时消息',
                permission: [TYPE_CORP, TYPE_CORP_ADMIN]
            }
        }, {
            path: 'accident-stats',
            component: AccidentStatsView,
            meta: {
                group: '数据统计', title: '事故统计',
                permission: [TYPE_CORP, TYPE_CORP_ADMIN]
            },
            props: ({ params: { viewType = 'time' } }) => ({ viewType }),
            children: [{ path: ':viewType?' }]
        }, {
            path: 'order-stats',
            component: OrderStatsView,
            meta: {
                group: '数据统计', title: '订单统计',
                permission: [TYPE_SELLER, TYPE_CORP, TYPE_CORP_ADMIN]
            },
            props: ({ params: { viewType = 'time' } }) => ({ viewType }),
            children: [{ path: ':viewType?' }]
        }, {
            path: 'car-info',
            component: CarInfoView,
            meta: {
                group: '设备管理', title: '车辆档案',
                permission: [TYPE_CORP, TYPE_CORP_ADMIN, TYPE_MANU]
            }
        }, {
            path: 'repair-log',
            component: RepairLogView,
            meta: {
                group: '设备管理', title: '维修记录',
                permission: [TYPE_CORP, TYPE_CORP_ADMIN, TYPE_MANU]
            }
        }, {
            path: 'dae-auth',
            component: DaeAuthView,
            meta: {
                group: '学习考试', title: '权限管理',
                permission: [TYPE_SUPERADMIN]
            },
        }, {
            path: 'exams',
            component: ExamsView,
            meta: {
                group: '学习考试', title: '试卷管理',
                permission: [TYPE_CORP_ADMIN]
            },
        }, {
            path: 'documents',
            component: DocumentsView,
            meta: {
                group: '学习考试', title: '学习资料管理',
                permission: [TYPE_CORP_ADMIN]
            }
        }, {
            path: 'scores',
            component: ScoresView,
            meta: {
                group: '学习考试', title: '考试成绩查询',
                permission: [TYPE_CORP_ADMIN, TYPE_DRIVER]
            },
        }, {
            path: 'reading-stats',
            component: ReadingStatusView,
            meta: {
                group: '学习考试', title: '学习时长查询',
                permission: [TYPE_CORP_ADMIN, TYPE_DRIVER]
            },
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