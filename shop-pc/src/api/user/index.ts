import http from "@/http";
import { ListParm, User, LoginParm, AssignParm, SaveAssignParm, UpdateParm, ResetPassword} from "./UserModel";
//新增
export const addAdminUserApi = (parm: User) => {
    return http.post("/api/sysUser", parm)
}
//列表
export const getListApi = (parm: ListParm) => {
    return http.get("/api/sysUser/getList", parm)
}
//编辑
export const editApi = (parm: User) => {
    return http.put("/api/sysUser", parm)
}
//删除
export const deleteApi = (userId: string) => {
    return http.delete(`/api/sysUser/${userId}`)
}
//验证码
export const imageApi = () => {
    return http.post("/api/sysUser/image")
}
//登录
export const lgoinApi = (parm: LoginParm) => {
    return http.post("/api/sysUser/login", parm)
}
//获取树的数据
export const getAssignTreeApi = (parm: AssignParm) => {
    return http.get("/api/menu/getAssignTree", parm)
}//保存分配的菜单
export const assignSaveApi = (parm: SaveAssignParm) => {
    return http.post("/api/menu/assignSave", parm)
}
//修改密码
export const updatePasswordApi = (parm: UpdateParm) => {
    return http.put("/api/sysUser/updatePassword", parm)
}
//重置密码
export const resetPasswordApi = (parm: ResetPassword) => {
    return http.post("/api/sysUser/resetPassword", parm)
}