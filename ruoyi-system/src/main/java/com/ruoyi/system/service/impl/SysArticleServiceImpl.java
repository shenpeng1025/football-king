package com.ruoyi.system.service.impl;

import java.io.StringWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.constant.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysArticleMapper;
import com.ruoyi.system.domain.SysArticle;
import com.ruoyi.system.service.ISysArticleService;

/**
 * 文章Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-11-12
 */
@Service
public class SysArticleServiceImpl implements ISysArticleService 
{
    @Autowired
    private SysArticleMapper sysArticleMapper;

    /**
     * 查询文章
     * 
     * @param articleId 文章主键
     * @return 文章
     */
    @Override
    public SysArticle selectSysArticleByArticleId(Long articleId)
    {
        return sysArticleMapper.selectSysArticleByArticleId(articleId);
    }

    /**
     * 查询文章列表
     * 
     * @param sysArticle 文章
     * @return 文章
     */
    @Override
    public List<SysArticle> selectSysArticleList(SysArticle sysArticle)
    {
        return sysArticleMapper.selectSysArticleList(sysArticle);
    }

    /**
     * 新增文章
     * 
     * @param sysArticle 文章
     * @return 结果
     */
    @Override
    public int insertSysArticle(SysArticle sysArticle)
    {
        return sysArticleMapper.insertSysArticle(sysArticle);
    }

    /**
     * 修改文章
     * 
     * @param sysArticle 文章
     * @return 结果
     */
    @Override
    public int updateSysArticle(SysArticle sysArticle)
    {
        return sysArticleMapper.updateSysArticle(sysArticle);
    }

    /**
     * 批量删除文章
     * 
     * @param articleIds 需要删除的文章主键
     * @return 结果
     */
    @Override
    public int deleteSysArticleByArticleIds(Long[] articleIds)
    {
        return sysArticleMapper.deleteSysArticleByArticleIds(articleIds);
    }

    /**
     * 删除文章信息
     * 
     * @param articleId 文章主键
     * @return 结果
     */
    @Override
    public int deleteSysArticleByArticleId(Long articleId)
    {
        return sysArticleMapper.deleteSysArticleByArticleId(articleId);
    }

    /**
     * 预览代码
     *
     * @param articleId 表编号
     * @return 预览数据列表
     */
    @Override
    public Map<String, String> previewCode(Long articleId)
    {
        Map<String, String> dataMap = new LinkedHashMap<>();
        // 查询表信息
        SysArticle sysArticle = sysArticleMapper.selectSysArticleByArticleId(articleId);
        // 设置主子表信息
        dataMap.put(articleId.toString(),sysArticle.getArticleContent());
        return dataMap;
    }
}
