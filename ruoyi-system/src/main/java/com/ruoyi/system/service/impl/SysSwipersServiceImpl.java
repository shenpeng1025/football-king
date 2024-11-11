package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysSwipersMapper;
import com.ruoyi.system.domain.SysSwipers;
import com.ruoyi.system.service.ISysSwipersService;

/**
 * 轮播图管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-11-09
 */
@Service
public class SysSwipersServiceImpl implements ISysSwipersService 
{
    @Autowired
    private SysSwipersMapper sysSwipersMapper;

    /**
     * 查询轮播图管理
     * 
     * @param id 轮播图管理主键
     * @return 轮播图管理
     */
    @Override
    public SysSwipers selectSysSwipersById(Long id)
    {
        return sysSwipersMapper.selectSysSwipersById(id);
    }

    /**
     * 查询轮播图管理列表
     * 
     * @param sysSwipers 轮播图管理
     * @return 轮播图管理
     */
    @Override
    public List<SysSwipers> selectSysSwipersList(SysSwipers sysSwipers)
    {
        return sysSwipersMapper.selectSysSwipersList(sysSwipers);
    }

    /**
     * 新增轮播图管理
     * 
     * @param sysSwipers 轮播图管理
     * @return 结果
     */
    @Override
    public int insertSysSwipers(SysSwipers sysSwipers)
    {
        return sysSwipersMapper.insertSysSwipers(sysSwipers);
    }

    /**
     * 修改轮播图管理
     * 
     * @param sysSwipers 轮播图管理
     * @return 结果
     */
    @Override
    public int updateSysSwipers(SysSwipers sysSwipers)
    {
        return sysSwipersMapper.updateSysSwipers(sysSwipers);
    }

    /**
     * 批量删除轮播图管理
     * 
     * @param ids 需要删除的轮播图管理主键
     * @return 结果
     */
    @Override
    public int deleteSysSwipersByIds(Long[] ids)
    {
        return sysSwipersMapper.deleteSysSwipersByIds(ids);
    }

    /**
     * 删除轮播图管理信息
     * 
     * @param id 轮播图管理主键
     * @return 结果
     */
    @Override
    public int deleteSysSwipersById(Long id)
    {
        return sysSwipersMapper.deleteSysSwipersById(id);
    }
}
