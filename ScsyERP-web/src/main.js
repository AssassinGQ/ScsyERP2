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
            path: 'GetAccount',
            component: GetAccountView,
            meta: {
                group: '用户管理', title: '生成账号'
                // permission: [TYPE_SUPERADMIN]
            },
        }, {
            path: '',//增删查改角色，修改角色的权限、父角色
            component: GetAccountView,
            meta: {
                group: '用户管理', title: '角色管理'
                // permission: [TYPE_SUPERADMIN]
            },
        }, {
            path: '',//为用户分配角色（多个）、屏蔽权限、特殊权限
            component: GetAccountView,
            meta: {
                group: '用户管理', title: '用户管理'
                // permission: [TYPE_SUPERADMIN]
            },
        }, {
            path: 'Corporation',//查询承运方信息；修改承运方信息（仅承运方）
            component: CorporationView,
            meta: {
                group: '基本信息', title: '承运方信息',
                permission: [TYPE_CORP, TYPE_CORP_ADMIN]
            }
        }, {
            path: 'Government',
            component: GovernmentView,//查询政府信息；修改政府信息（仅政府）
            meta: {
                group: '基本信息', title: '政府信息',
                permission: [TYPE_GOV]
            }
        }, {
            path: 'Admin',
            component: AdministratorView,//增删查改管理员信息
            meta: {
                group: '基本信息', title: '管理员信息',
                permission: [TYPE_CORP, TYPE_CORP_ADMIN]
            }
        }, {
            path: 'Driver',
            component: DriverView,
            children: [{ path: ':viewType?' }],
            props: ({ params: { viewType = 'driver' } }) => ({ viewType }),
            meta: {
                group: '基本信息', title: '驾押员信息',
                permission: [TYPE_CORP, TYPE_CORP_ADMIN, TYPE_GOV, TYPE_DRIVER, TYPE_ESCORT]
            },
        }, {
            path: 'Client',
            component: ClientView,
            props: ({ params: { viewType = 'seller' } }) => ({ viewType }),
            meta: {
                group: '基本信息', title: '客户信息',
                permission: [TYPE_CORP, TYPE_CORP_ADMIN, TYPE_SELLER, TYPE_BUYER]
            },
            children: [{ path: ':viewType?' }]
        }, {
            path: 'Manufacturer',
            component: ManufacturerView,
            meta: {
                group: '基本信息', title: '设备生产商信息',
                permission: [TYPE_MANU]
            }
        }, {
            path: 'Consignee',
            component: ClientView,
            props: ({ params: { viewType = 'seller' } }) => ({ viewType }),
            meta: {
                group: '基本信息', title: '客户信息',
                permission: [TYPE_CORP, TYPE_CORP_ADMIN, TYPE_SELLER, TYPE_BUYER]
            },
            children: [{ path: ':viewType?' }]
        }, {
            path: 'DriveWorker',
            component: AdministratorView,//增删查改管理员信息
            meta: {
                group: '基本信息', title: '管理员信息',
                permission: [TYPE_CORP, TYPE_CORP_ADMIN]
            }
        }, {
            path: 'LiftWorker',
            component: AdministratorView,//增删查改管理员信息
            meta: {
                group: '基本信息', title: '管理员信息',
                permission: [TYPE_CORP, TYPE_CORP_ADMIN]
            }
        }, {
            path: 'Truck',
            component: VehicleView,
            props: ({ params: { viewType = 'truck' } }) => ({ viewType }),
            meta: {
                group: '基本信息', title: '车辆信息',
                permission: [TYPE_CORP, TYPE_CORP_ADMIN]
            },
            children: [{ path: ':viewType?' }]
        }, {
            path: 'Warehouse',
            component: AdministratorView,//增删查改管理员信息
            meta: {
                group: '基本信息', title: '管理员信息',
                permission: [TYPE_CORP, TYPE_CORP_ADMIN]
            }
        }, {
            path: 'Workshop',
            component: AdministratorView,//增删查改管理员信息
            meta: {
                group: '基本信息', title: '管理员信息',
                permission: [TYPE_CORP, TYPE_CORP_ADMIN]
            }
        }, {
            path: 'Material',
            component: AdministratorView,//增删查改管理员信息
            meta: {
                group: '基本信息', title: '管理员信息',
                permission: [TYPE_CORP, TYPE_CORP_ADMIN]
            }
        }, {
            path: 'Product',
            component: GoodsView,
            meta: {
                group: '基本信息', title: '货物信息',
                permission: [TYPE_CORP, TYPE_CORP_ADMIN]
            }
        }, {
            path: 'order-place',//创建工程，入库，在库盘点，出库
            component: OrderPlaceView,
            meta: {
                group: '电子运单', title: '下达订单',
                permission: [TYPE_SELLER]
            }
        }, {
            path: 'order',
            component: OrderView,
            meta: {
                group: '费用结算', title: '订单查询',//随车清单、运输合同
                permission: [TYPE_SELLER, TYPE_BUYER, TYPE_CORP_ADMIN, TYPE_CORP]
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