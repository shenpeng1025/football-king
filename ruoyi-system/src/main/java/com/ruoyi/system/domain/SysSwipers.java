package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 轮播图管理对象 sys_swipers
 * 
 * @author ruoyi
 * @date 2024-11-09
 */
public class SysSwipers extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 轮播图片Id */
    private Long id;

    /** 轮播图地址 */
    @Excel(name = "轮播图地址")
    private String imgUrl;

    /** 轮播图获取状态 */
    @Excel(name = "轮播图获取状态")
    private Long imgStatus;

    /** 轮播图获取时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "轮播图获取时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 轮播图是否过期 */
    private Long delFlag;

    /** 轮播图地址 */
    @Excel(name = "轮播图名称")
    private String imgName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public Long getId()
    {
        return id;
    }
    public void setImgUrl(String imgUrl) 
    {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl() 
    {
        return imgUrl;
    }
    public void setImgStatus(Long imgStatus) 
    {
        this.imgStatus = imgStatus;
    }

    public Long getImgStatus() 
    {
        return imgStatus;
    }
    public void setCreateDate(Date createDate) 
    {
        this.createDate = createDate;
    }

    public Date getCreateDate() 
    {
        return createDate;
    }
    public void setDelFlag(Long delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Long getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("imgUrl", getImgUrl())
            .append("imgStatus", getImgStatus())
            .append("createDate", getCreateDate())
            .append("delFlag", getDelFlag())
            .append("imgName", getImgName())
            .toString();
    }
}
