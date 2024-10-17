package com.itmk.web.goods_report.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("goods_report")
public class GoodsReport {
    @TableId(type = IdType.AUTO)
    private Long reportId;
    private Long goodsId;
    private Long reportUser;
    private String reason;
    private String status;
    private Date reportTime;
}