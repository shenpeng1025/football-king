package com.ruoyi.system.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.system.domain.SysArticle;

/**
 * 文章Service接口
 * 
 * @author ruoyi
 * @date 2024-11-12
 */
public interface ISysArticleService 
{
    /**
     * 查询文章
     * 
     * @param articleId 文章主键
     * @return 文章
     */
    public SysArticle selectSysArticleByArticleId(Long articleId);

    /**
     * 查询文章列表
     * 
     * @param sysArticle 文章
     * @return 文章集合
     */
    public List<SysArticle> selectSysArticleList(SysArticle sysArticle);

    /**
     * 新增文章
     * 
     * @param sysArticle 文章
     * @return 结果
     */
    public int insertSysArticle(SysArticle sysArticle);

    /**
     * 修改文章
     * 
     * @param sysArticle 文章
     * @return 结果
     */
    public int updateSysArticle(SysArticle sysArticle);

    /**
     * 批量删除文章
     * 
     * @param articleIds 需要删除的文章主键集合
     * @return 结果
     */
    public int deleteSysArticleByArticleIds(Long[] articleIds);

    /**
     * 删除文章信息
     * 
     * @param articleId 文章主键
     * @return 结果
     */
    public int deleteSysArticleByArticleId(Long articleId);


    /**
     * 预览代码
     *
     * @param articleId 表编号
     * @return 预览数据列表
     */
    public Map<String, String> previewCode(Long articleId);
}
