package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 文章对象 sys_article
 * 
 * @author ruoyi
 * @date 2024-11-12
 */
public class SysArticle extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 文章id */
    private Long articleId;

    /** 文章标题 */
    @Excel(name = "文章标题")
    private String articleTitle;

    /** 文章内容 */
    @Excel(name = "文章内容")
    private String articleContent;

    /** 文章作者 */
    @Excel(name = "文章作者")
    private String articleAuthor;

    /** 文章标签id */
    @Excel(name = "文章标签id")
    private Long articleTagId;

    /** 文章创建日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "文章创建日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 文章更新日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "文章更新日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateDate;

    /** 文章删除标志(0:未删除,1:逻辑删除) */
    private Integer delFlag;

    public void setArticleId(Long articleId) 
    {
        this.articleId = articleId;
    }

    public Long getArticleId() 
    {
        return articleId;
    }
    public void setArticleTitle(String articleTitle) 
    {
        this.articleTitle = articleTitle;
    }

    public String getArticleTitle() 
    {
        return articleTitle;
    }
    public void setArticleContent(String articleContent) 
    {
        this.articleContent = articleContent;
    }

    public String getArticleContent() 
    {
        return articleContent;
    }
    public void setArticleAuthor(String articleAuthor) 
    {
        this.articleAuthor = articleAuthor;
    }

    public String getArticleAuthor() 
    {
        return articleAuthor;
    }
    public void setArticleTagId(Long articleTagId) 
    {
        this.articleTagId = articleTagId;
    }

    public Long getArticleTagId() 
    {
        return articleTagId;
    }
    public void setCreateDate(Date createDate) 
    {
        this.createDate = createDate;
    }

    public Date getCreateDate() 
    {
        return createDate;
    }
    public void setUpdateDate(Date updateDate) 
    {
        this.updateDate = updateDate;
    }

    public Date getUpdateDate() 
    {
        return updateDate;
    }
    public void setDelFlag(Integer delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("articleId", getArticleId())
            .append("articleTitle", getArticleTitle())
            .append("articleContent", getArticleContent())
            .append("articleAuthor", getArticleAuthor())
            .append("articleTagId", getArticleTagId())
            .append("createDate", getCreateDate())
            .append("updateDate", getUpdateDate())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
