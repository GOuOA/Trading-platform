import http from "@/http";
import { ListParm } from "./OrderModel";
//订单列表
export const getListApi = (parm: ListParm) => {
    return http.get("/api/goodsOrder/getList", parm)
}