<!-- 一级菜单实现 -->
<template>
    <MenuLogo></MenuLogo>
    <el-menu :collapse="collapse" router background-color="#304156" :default-active="activeIndex"
        class="el-menu-vertical-demo">
        <el-menu-item v-for="item in menuList" :index="item['path']">
            <el-icon>
                <component :is="item['icon']"></component>
            </el-icon>
            <template #title>{{ item['title'] }}</template>
        </el-menu-item>
        
        <!-- <div style="margin: 15px;">
            <img height="360px" width="200px" src="@/assets/dog.gif" alt="" id="imgas">
        </div> -->
    </el-menu>
    
</template>
<script setup lang="ts">
import { collapseStore } from "@/store/collapse/index";
import { useRoute } from "vue-router";
import MenuLogo from "./MenuLogo.vue";
// import { Menu, Memo, Monitor, Calendar } from "@element-plus/icons-vue";
import { computed } from "vue";
import { userStore } from "@/store/user";
const ustore = userStore()
//获取store
const store = collapseStore()
//当前路由
const route = useRoute();
//获取激活的选项
const activeIndex = computed(() => {
    const { path } = route;
    return path;
});
//获取菜单状态
const collapse = computed(() => {
    return store.getCollapse
})
//获取菜单数据
const menuList = computed(()=>{
    return ustore.getMenuList
})
</script>
<style scoped lang="scss">
.el-menu-vertical-demo:not(.el-menu--collapse) {
    width: 230px;
    min-height: 400px;
}

.el-menu {
    border-right: none;
}

.el-menu .el-menu-item {
    color: #bfcbd9;
    font-size: 15px;
    font-weight: bold;
}

.el-menu-item.is-active {
    color: #409eff !important;
    background-color: #1f2d3d !important;
}

/* 鼠标移动菜单的颜色 */
:deep(.el-menu-item:hover) {
    background-color: #001528 !important;
}
</style>