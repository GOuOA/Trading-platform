package com.itmk.web.goods.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itmk.utils.ResultUtils;
import com.itmk.utils.ResultVo;
import com.itmk.web.goods.entity.*;
import com.itmk.web.goods.service.GoodsService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    //发布
    @PostMapping("/release")
    public ResultVo release(@RequestBody Goods goods) {
        //设置时间
        goods.setCreateTime(new Date());
        if (goodsService.save(goods)) {
            return ResultUtils.success("发布成功!");
        }
        return ResultUtils.error("发布失败!");
    }

    //列表
    @GetMapping("/list")
    public ResultVo getList(GoodsListParm parm) {
        //构造分页对象
        IPage<Goods> page = new Page<>
                (parm.getCurrentPage(), parm.getPageSize());
        //构造查询条件
        QueryWrapper<Goods> query = new QueryWrapper<>();
        query.lambda().like(StringUtils.isNotEmpty(parm.getGoodsName()), Goods::getGoodsName, parm.getGoodsName())
                .eq(Goods::getDeleteStatus, "0")
                .orderByDesc(Goods::getCreateTime);
        IPage<Goods> list = goodsService.page(page, query);
        return ResultUtils.success("查询成功", list);
    }

    //上架下架
    @PostMapping("/upanddown")
    public ResultVo upanddown(@RequestBody UpandDownParm parm) {
        UpdateWrapper<Goods> query = new UpdateWrapper<>();
        query.lambda().set(Goods::getStatus, parm.getStatus())
                .eq(Goods::getGoodsId, parm.getGoodsId());
        if (goodsService.update(query)) {
            return ResultUtils.success("设置成功!");
        }
        return ResultUtils.error("设置失败!");
    }

    //推荐首页
    @PostMapping("/setIndex")
    public ResultVo setIndex(@RequestBody UpandDownParm parm) {
        UpdateWrapper<Goods> query = new UpdateWrapper<>();
        query.lambda().set(Goods::getSetIndex, parm.getSetIndex())
                .eq(Goods::getGoodsId, parm.getGoodsId());
        if (goodsService.update(query)) {
            return ResultUtils.success("设置成功!");
        }
        return ResultUtils.error("设置失败!");
    }

    //删除
    @PostMapping("/delete")
    public ResultVo delete(@RequestBody UpandDownParm parm) {
        UpdateWrapper<Goods> query = new UpdateWrapper<>();
        query.lambda().set(Goods::getDeleteStatus, "1")
                .eq(Goods::getGoodsId, parm.getGoodsId());
        if (goodsService.update(query)) {
            return ResultUtils.success("删除成功!");
        }
        return ResultUtils.error("删除失败!");
    }

    //小程序首页列表查询
    @GetMapping("/getIndexList")
    public ResultVo getIndexList(WxIndexParm parm) {
        //构造查询条件
        QueryWrapper<Goods> query = new QueryWrapper<>();
        query.lambda().like(StringUtils.isNotEmpty(parm.getKeywords()), Goods::getGoodsName, parm.getKeywords())
                .eq(Goods::getStatus, "0")
                .eq(Goods::getDeleteStatus, "0")
                .eq(Goods::getSetIndex, "1")
                .eq(Goods::getSellStatus, "0")
                .orderByDesc(Goods::getCreateTime);
        //构造分页对象
        IPage<Goods> page = new Page<>
                (parm.getCurrentPage(), parm.getPageSize());
        IPage<Goods> list = goodsService.page(page, query);
        return ResultUtils.success("查询成功", list);
    }

    //小程序闲置列表查询
    @GetMapping("/getUsedList")
    public ResultVo getUsedList(WxIndexParm parm) {
        //构造查询条件
        QueryWrapper<Goods> query = new QueryWrapper<>();
        query.lambda().like(StringUtils.isNotEmpty(parm.getKeywords()), Goods::getGoodsName, parm.getKeywords())
                .eq(Goods::getStatus, "0")
                .eq(Goods::getDeleteStatus, "0")
                .eq(Goods::getType, "0")
                .eq(Goods::getSellStatus, "0")
                .eq(StringUtils.isNotEmpty(parm.getCategoryId()), Goods::getCategoryId, parm.getCategoryId())
                .orderByDesc(Goods::getCreateTime);
        //构造分页对象
        IPage<Goods> page = new Page<>
                (parm.getCurrentPage(), parm.getPageSize());
        IPage<Goods> list = goodsService.page(page, query);
        return ResultUtils.success("查询成功", list);
    }

    //小程序求购列表查询
    @GetMapping("/getBuyList")
    public ResultVo getBuyList(WxIndexParm parm) {
        //构造查询条件
        QueryWrapper<Goods> query = new QueryWrapper<>();
        query.lambda().like(StringUtils.isNotEmpty(parm.getKeywords()), Goods::getGoodsName, parm.getKeywords())
                .eq(Goods::getStatus, "0")
                .eq(Goods::getDeleteStatus, "0")
                .eq(Goods::getType, "1")
                .eq(Goods::getSellStatus, "0")
                .eq(StringUtils.isNotEmpty(parm.getCategoryId()), Goods::getCategoryId, parm.getCategoryId())
                .orderByDesc(Goods::getCreateTime);
        //构造分页对象
        IPage<Goods> page = new Page<>
                (parm.getCurrentPage(), parm.getPageSize());
        IPage<Goods> list = goodsService.page(page, query);
        return ResultUtils.success("查询成功", list);
    }

    //小程序我发布的闲置
    @GetMapping("/getMyUnusedList")
    public ResultVo getMyUnusedList(MyGoodsParm parm) {
        //构造查询条件
        QueryWrapper<Goods> query = new QueryWrapper<>();
        query.lambda().eq(Goods::getUserId, parm.getUserId())
                .eq(Goods::getType, parm.getType())
                .eq(Goods::getDeleteStatus, "0");
        //构造分页对象
        IPage<Goods> page = new Page<>
                (parm.getCurrentPage(), parm.getPageSize());
        IPage<Goods> list = goodsService.page(page, query);
        return ResultUtils.success("查询成", list);
    }

    //编辑
    @PostMapping("/edit")
    public ResultVo edit(@RequestBody Goods goods) {
        if (goodsService.updateById(goods)) {
            return ResultUtils.success("编辑成功！");
        }
        return ResultUtils.error("编辑失败!");
    }
}