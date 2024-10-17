<template>
    <div class="logo">
        <img :src="MenuLogo" alt="logo" />
        <span v-if="show" class="logo-title">{{ title }}<br>{{ titleone }}</span>
    </div>
</template>
<script setup lang="ts">
import MenuLogo from '@/assets/logo.png'
import { watch, ref } from "vue";
import { collapseStore } from '@/store/collapse/index';
const store = collapseStore()
const titleone = ref("长沙幼儿师范高等专科学校");
const title = ref("校园二手交易系统");
const show = ref(true)
watch(
    () => store.getCollapse,
    (collapsed: boolean) => {
        if (!collapsed) {
            setTimeout(() => {
                show.value = !collapsed
            }, 300);
        } else {
            show.value = !collapsed
        }
    }
)
</script>
<style lang="scss" scoped>
@font-face {
    font-family: 'PANG';
    src: url('/src/fonts/Slidefu-Regular.ttf');
}

.logo {
    display: flex;
    width: 100%;
    height: 75px;
    line-height: 75px;
    background: #2b2f3a;
    text-align: center;
    cursor: pointer;
    align-items: center;

    img {
        width: 53px;
        height: 45px;
        margin: 10px 10px 10px 10px;
    }

    .logo-title {
        color: #fff;
        font-weight: 800;
        line-height: 20px;
        font-size: 13px;
        font-family: FangSong;
        font-family: 'PANG';
    }
}
</style>