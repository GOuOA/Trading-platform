<!-- <el-footer>：底栏容器。-->
<template>
    <!-- <el-container>：外层容器。当子元素中包含 <el-header> 或 <el-footer> 时，全部子元素会垂直上下排列，否则会水平左右排列。 -->
    <el-container class="mycontainer">
        <!-- <el-aside>：侧边栏容器。 -->
        <el-aside width="auto" class="asside">
            <MenuOne></MenuOne>
        </el-aside>
        <el-container>
            <!-- <el-header>：顶栏容器。 -->
            <el-header class="header">
                <div class="header-left">
                    <Collapse></Collapse>
                    <BreadCrumb></BreadCrumb>
                </div>
                <LoginOut></LoginOut>
            </el-header>
            <!-- <el-main>：主要区域容器。 -->
            <el-main class="mymain">
                <router-view></router-view>
            </el-main>
        </el-container>
    </el-container>
</template>
<script setup lang="ts">
// import Menu from './Menu.vue'
import MenuOne from "./MenuOne.vue";
import Collapse from "./Collapse.vue";
import BreadCrumb from "./BreadCrumb.vue";
import LoginOut from "./LoginOut.vue";
</script>
<style scoped lang="scss">
.mycontainer {
    height: 100%;

    .asside {
        background-color: #304156;
    }

    .header {
        height: 75px;
        background-color: #92A8D1;
        color: #fff;
        display: flex;
        align-items: center;
        justify-content: space-between;

        .header-left {
            display: flex;
            align-items: center;
        }
    }

    .mymain {
        padding: 0px;
    }
}
</style>