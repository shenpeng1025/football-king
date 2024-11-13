package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 文章标签对象 sys_tag
 * 
 * @author ruoyi
 * @date 2024-11-12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SysTag extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 文章标签id */
    private Long id;

    /** 标签名称 */
    @Excel(name = "标签名称")
    private String tagName;

    /** 删除标志(0:未删除 1:删除)  */
    private Integer delFlag;

    /** 标签创建日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "标签创建日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 更新日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateDate;



    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("tagName", getTagName())
            .append("delFlag", getDelFlag())
            .append("createDate", getCreateDate())
            .append("updateDate", getUpdateDate())
            .toString();
    }
}
