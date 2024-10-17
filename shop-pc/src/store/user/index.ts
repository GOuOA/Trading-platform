import { defineStore } from "pinia";
//创建store
//defineStore第一个参数：唯一的，不能重复
export const userStore = defineStore('userStore', {
    state: () => {
        return {
            userId: '',
            nickName: "",
            menuList: [],
            codeList: [],
            token: ''
        }
    },
    //获取值
    getters: {
        getUserId(state) {
            return state.userId
        },
        getMenuList(state) {
            return state.menuList
        },
        getCodeList(state) {
            return state.codeList
        },
        getTokne(state) {
            return state.token
        }
    },
    //改变state的值
    actions: {
        setUserId(userId: string) {
            this.userId = userId;
        },
        setMenuList(menuList: any) {
            this.menuList = menuList;
        },
        setCodeList(codeList: any) {
            this.codeList = codeList;
        },
        setToken(token: string) {
            this.token = token;
        }
    },
    persist: {
        enabled: true,
        strategies: [
            {
                storage: sessionStorage, paths:
                    ['userId', 'nickName', 'menuList', 'codeList', 'token']
            },
        ]
    }
})