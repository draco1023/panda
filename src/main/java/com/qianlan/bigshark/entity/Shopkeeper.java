package com.qianlan.bigshark.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yukong
 * @since 2019-01-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Shopkeeper implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 旺旺id
     */
    private String wangWangId;

    /**
     * 店铺名称
     */
    private String shopName;

    /**
     * 店铺网址
     */
    private String shopSite;

    /**
     * 店铺后台管理截图（路径）
     */
    private String shopAdminImg;

    /**
     * 是否禁用。0： 否 1： 是
     */
    private Integer disable;

    /**
     *  审核状态 0： 通过 1:不通过
     */
    private Integer status;

    /**
     * 添加时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime modifyTime;


}
