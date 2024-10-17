//自定义按钮权限指令
import { Directive } from 'vue'
import { userStore } from '@/store/user/index';
export const permission: Directive = {
    mounted(el, binding) {
        console.log('自定义指令')
        console.log(binding)
        const store = userStore()
        //value按钮上的权限
        const { value } = binding;
        //获取用户所有的权限
        const permissions = store.codeList;
        console.log('所有的权限')
        // console.log(permissions)
        //判断传递进来的按钮权限，是否存在
        if (value && value instanceof Array && value.length > 0) {
            const permissionRoles = value;
            //判断传递进来的按钮权限字段，是否存在当前用户的permissions
            const hasPermission = permissions.some((role) => {
                return permissionRoles.includes(role)
            })
            if (!hasPermission) { //没有权限时，影藏
                el.style.display = 'none'
            }
        } else {
            throw new Error('need roles! Like v-permission="[\'add\',\'edit\']"')
        }
    }
}