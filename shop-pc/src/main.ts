import { createApp } from 'vue'
import App from './App.vue'
import router from '@/router/index'
import myconfirm from './utils/myconfirm'
//引入element plus
import ElementPlus from 'element-plus'
import zhCn from 'element-plus/es/locale/lang/zh-cn'
import 'element-plus/dist/index.css'
//国际化
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
//引入Pinia构造函数
import { createPinia } from 'pinia'
import piniaPersist from 'pinia-plugin-persist'
//引入按钮权限
import { permission } from './directives/permission'
// 实例化 Pinia
const pinia = createPinia()
//使用持久化插件
pinia.use(piniaPersist)
const app = createApp(App);
app.use(pinia).use(ElementPlus, {
    locale: zhCn
}).use(router).mount('#app')
//全局注册图标组件
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}
//注册自定义指令
app.directive('permission',permission)
//全局挂载
app.config.globalProperties.$myconfirm = myconfirm;