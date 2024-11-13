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
import com.ruoyi.system.domain.SysTag;
import com.ruoyi.system.service.ISysTagService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 文章标签Controller
 * 
 * @author ruoyi
 * @date 2024-11-12
 */
@RestController
@RequestMapping("/article/tag")
public class SysTagController extends BaseController
{
    @Autowired
    private ISysTagService sysTagService;

    /**
     * 查询文章标签列表
     */
    @PreAuthorize("@ss.hasPermi('article:tag:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysTag sysTag)
    {
        startPage();
        List<SysTag> list = sysTagService.selectSysTagList(sysTag);
        return getDataTable(list);
    }

    /**
     * 导出文章标签列表
     */
    @PreAuthorize("@ss.hasPermi('article:tag:export')")
    @Log(title = "文章标签", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysTag sysTag)
    {
        List<SysTag> list = sysTagService.selectSysTagList(sysTag);
        ExcelUtil<SysTag> util = new ExcelUtil<SysTag>(SysTag.class);
        util.exportExcel(response, list, "文章标签数据");
    }

    /**
     * 获取文章标签详细信息
     */
    @PreAuthorize("@ss.hasPermi('article:tag:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(sysTagService.selectSysTagById(id));
    }

    /**
     * 新增文章标签
     */
    @PreAuthorize("@ss.hasPermi('article:tag:add')")
    @Log(title = "文章标签", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysTag sysTag)
    {
        sysTag.setCreateDate(new Date());
        sysTag.setDelFlag(0);
        return toAjax(sysTagService.insertSysTag(sysTag));
    }

    /**
     * 修改文章标签
     */
    @PreAuthorize("@ss.hasPermi('article:tag:edit')")
    @Log(title = "文章标签", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysTag sysTag)
    {
        sysTag.setUpdateDate(new Date());
        return toAjax(sysTagService.updateSysTag(sysTag));
    }

    /**
     * 删除文章标签
     */
    @PreAuthorize("@ss.hasPermi('article:tag:remove')")
    @Log(title = "文章标签", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysTagService.deleteSysTagByIds(ids));
    }
}
