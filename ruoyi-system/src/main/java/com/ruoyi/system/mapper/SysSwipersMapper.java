package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysSwipers;

/**
 * 轮播图管理Mapper接口
 * 
 * @author ruoyi
 * @date 2024-11-09
 */
public interface SysSwipersMapper 
{
    /**
     * 查询轮播图管理
     * 
     * @param id 轮播图管理主键
     * @return 轮播图管理
     */
    public SysSwipers selectSysSwipersById(Long id);

    /**
     * 查询轮播图管理列表
     * 
     * @param sysSwipers 轮播图管理
     * @return 轮播图管理集合
     */
    public List<SysSwipers> selectSysSwipersList(SysSwipers sysSwipers);

    /**
     * 新增轮播图管理
     * 
     * @param sysSwipers 轮播图管理
     * @return 结果
     */
    public int insertSysSwipers(SysSwipers sysSwipers);

    /**
     * 修改轮播图管理
     * 
     * @param sysSwipers 轮播图管理
     * @return 结果
     */
    public int updateSysSwipers(SysSwipers sysSwipers);

    /**
     * 删除轮播图管理
     * 
     * @param id 轮播图管理主键
     * @return 结果
     */
    public int deleteSysSwipersById(Long id);

    /**
     * 批量删除轮播图管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysSwipersByIds(Long[] ids);
}
