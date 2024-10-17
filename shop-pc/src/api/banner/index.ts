import http from "@/http";
import { Banner, BannerListParm } from './BannerModel'
export const getGoodsListApi = () => {
    return http.get("/api/banner/getGoods")
}
//新增
export const addCategoryApi = (parm: Banner) => {
    return http.post("/api/banner", parm)
}
//列表
export const getListApi = (parm: BannerListParm) => {
    return http.get("/api/banner/list", parm)
}
//上架下架
export const upandownApi = (parm: Banner) => {
    return http.post("/api/banner/upandown", parm)
}
//编辑
export const editApi = (parm: Banner) => {
    return http.put("/api/banner", parm)
}
//删除
export const deleteApi = (parm: Banner) => {
    return http.delete(`/api/banner/${parm.banId}`)
}