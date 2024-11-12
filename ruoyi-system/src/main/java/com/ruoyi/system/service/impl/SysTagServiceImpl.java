package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysTagMapper;
import com.ruoyi.system.domain.SysTag;
import com.ruoyi.system.service.ISysTagService;

/**
 * 文章标签Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-11-12
 */
@Service
public class SysTagServiceImpl implements ISysTagService 
{
    @Autowired
    private SysTagMapper sysTagMapper;

    /**
     * 查询文章标签
     * 
     * @param id 文章标签主键
     * @return 文章标签
     */
    @Override
    public SysTag selectSysTagById(Long id)
    {
        return sysTagMapper.selectSysTagById(id);
    }

    /**
     * 查询文章标签列表
     * 
     * @param sysTag 文章标签
     * @return 文章标签
     */
    @Override
    public List<SysTag> selectSysTagList(SysTag sysTag)
    {
        return sysTagMapper.selectSysTagList(sysTag);
    }

    /**
     * 新增文章标签
     * 
     * @param sysTag 文章标签
     * @return 结果
     */
    @Override
    public int insertSysTag(SysTag sysTag)
    {
        return sysTagMapper.insertSysTag(sysTag);
    }

    /**
     * 修改文章标签
     * 
     * @param sysTag 文章标签
     * @return 结果
     */
    @Override
    public int updateSysTag(SysTag sysTag)
    {
        return sysTagMapper.updateSysTag(sysTag);
    }

    /**
     * 批量删除文章标签
     * 
     * @param ids 需要删除的文章标签主键
     * @return 结果
     */
    @Override
    public int deleteSysTagByIds(Long[] ids)
    {
        return sysTagMapper.deleteSysTagByIds(ids);
    }

    /**
     * 删除文章标签信息
     * 
     * @param id 文章标签主键
     * @return 结果
     */
    @Override
    public int deleteSysTagById(Long id)
    {
        return sysTagMapper.deleteSysTagById(id);
    }
}
