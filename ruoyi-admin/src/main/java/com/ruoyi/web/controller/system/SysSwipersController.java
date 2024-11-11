package com.ruoyi.web.controller.system;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysSwipers;
import com.ruoyi.system.service.ISysSwipersService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 轮播图管理Controller
 * 
 * @author ruoyi
 * @date 2024-11-09
 */
@RestController
@RequestMapping("/system/swipers")
public class SysSwipersController extends BaseController
{
    @Autowired
    private ISysSwipersService sysSwipersService;

    /**
     * 查询轮播图管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:swipers:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysSwipers sysSwipers)
    {
        startPage();
        List<SysSwipers> list = sysSwipersService.selectSysSwipersList(sysSwipers);
        return getDataTable(list);
    }

    @GetMapping("/")
    public TableDataInfo uniAppList()
    {
        startPage();
        List<SysSwipers> list = sysSwipersService.selectSysSwipersList(null);
        return getDataTable(list);
    }

    /**uniAppList
     * 导出轮播图管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:swipers:export')")
    @Log(title = "轮播图管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysSwipers sysSwipers)
    {
        List<SysSwipers> list = sysSwipersService.selectSysSwipersList(sysSwipers);
        ExcelUtil<SysSwipers> util = new ExcelUtil<SysSwipers>(SysSwipers.class);
        util.exportExcel(response, list, "轮播图管理数据");
    }

    /**
     * 获取轮播图管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:swipers:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(sysSwipersService.selectSysSwipersById(id));
    }

    /**
     * 新增轮播图管理
     */
    @PreAuthorize("@ss.hasPermi('system:swipers:add')")
    @Log(title = "轮播图管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysSwipers sysSwipers)
    {
        sysSwipers.setCreateDate(new Date());
        sysSwipers.setImgStatus(0L);
        sysSwipers.setDelFlag(0L);
        return toAjax(sysSwipersService.insertSysSwipers(sysSwipers));
    }

    /**
     * 修改轮播图管理
     */
    @PreAuthorize("@ss.hasPermi('system:swipers:edit')")
    @Log(title = "轮播图管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysSwipers sysSwipers)
    {
        return toAjax(sysSwipersService.updateSysSwipers(sysSwipers));
    }

    /**
     * 删除轮播图管理
     */
    @PreAuthorize("@ss.hasPermi('system:swipers:remove')")
    @Log(title = "轮播图管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysSwipersService.deleteSysSwipersByIds(ids));
    }
}
