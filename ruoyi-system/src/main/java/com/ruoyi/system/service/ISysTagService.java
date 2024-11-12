package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysTag;

/**
 * 文章标签Service接口
 * 
 * @author ruoyi
 * @date 2024-11-12
 */
public interface ISysTagService 
{
    /**
     * 查询文章标签
     * 
     * @param id 文章标签主键
     * @return 文章标签
     */
    public SysTag selectSysTagById(Long id);

    /**
     * 查询文章标签列表
     * 
     * @param sysTag 文章标签
     * @return 文章标签集合
     */
    public List<SysTag> selectSysTagList(SysTag sysTag);

    /**
     * 新增文章标签
     * 
     * @param sysTag 文章标签
     * @return 结果
     */
    public int insertSysTag(SysTag sysTag);

    /**
     * 修改文章标签
     * 
     * @param sysTag 文章标签
     * @return 结果
     */
    public int updateSysTag(SysTag sysTag);

    /**
     * 批量删除文章标签
     * 
     * @param ids 需要删除的文章标签主键集合
     * @return 结果
     */
    public int deleteSysTagByIds(Long[] ids);

    /**
     * 删除文章标签信息
     * 
     * @param id 文章标签主键
     * @return 结果
     */
    public int deleteSysTagById(Long id);
}
