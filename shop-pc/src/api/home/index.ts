import http from "@/http";
//总数
export const getTotalApi = () => {
    return http.get("/api/home/getTotal")
}
//最近投诉
export const getDoReportApi = () => {
    return http.get("/api/home/getDoReport")
}