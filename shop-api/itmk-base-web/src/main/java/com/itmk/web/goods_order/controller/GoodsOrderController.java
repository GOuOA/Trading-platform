package com.itmk.web.goods_order.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itmk.utils.ResultUtils;
import com.itmk.utils.ResultVo;
import com.itmk.web.goods.entity.Goods;
import com.itmk.web.goods.entity.MyGoodsParm;
import com.itmk.web.goods.service.GoodsService;
import com.itmk.web.goods_order.entity.GoodsOrder;
import com.itmk.web.goods_order.entity.OrderParm;
import com.itmk.web.goods_order.entity.OrderVo;
import com.itmk.web.goods_order.service.GoodsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/goodsOrder")
public class GoodsOrderController {
    @Autowired
    private GoodsOrderService goodsOrderService;
    @Autowired
    private GoodsService goodsService;

    //交易订单
    @PostMapping("/replaceOrder")
    public ResultVo replaceOrder(@RequestBody GoodsOrder order) {
        goodsOrderService.replaceOrder(order);
        return ResultUtils.success("交易成功!");
    }

    //小程序我的订单
    @GetMapping("/getMyOrder")
    public ResultVo getMyOrder(MyGoodsParm parm) {
        IPage<Goods> list = goodsService.getMyOrder(parm);
        return ResultUtils.success("查询成功！", list);
    }

    //我的出售订单
    @GetMapping("/getSellOrder")
    public ResultVo getSellOrder(MyGoodsParm parm) {
        IPage<Goods> list = goodsService.getSellOrder(parm);
        return ResultUtils.success("查询成功！", list);
    }

    //删除订单
    @PostMapping("/deleteOrder")
    public ResultVo deleteOrder(@RequestBody GoodsOrder parm){
        if(goodsOrderService.removeById(parm.getOrderId())){
            return ResultUtils.success("删除成功!");
        }
        return ResultUtils.error("删除失败!");
    }

    //订单列表
    @GetMapping("/getList")
    public ResultVo getList(OrderParm parm){
        IPage<OrderVo> list = goodsOrderService.getList(parm);
        return ResultUtils.success("查询成功",list);
    }
}