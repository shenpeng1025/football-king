package com.ruoyi.web.controller.system;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
import com.ruoyi.system.domain.SysArticle;
import com.ruoyi.system.service.ISysArticleService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 文章Controller
 * 
 * @author ruoyi
 * @date 2024-11-12
 */
@RestController
@RequestMapping("/article/article")
public class SysArticleController extends BaseController
{
    @Autowired
    private ISysArticleService sysArticleService;

    /**
     * 查询文章列表
     */
    @PreAuthorize("@ss.hasPermi('article:article:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysArticle sysArticle)
    {
        startPage();
        List<SysArticle> list = sysArticleService.selectSysArticleList(sysArticle);
        return getDataTable(list);
    }

    /**
     * 导出文章列表
     */
    @PreAuthorize("@ss.hasPermi('article:article:export')")
    @Log(title = "文章", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysArticle sysArticle)
    {
        List<SysArticle> list = sysArticleService.selectSysArticleList(sysArticle);
        ExcelUtil<SysArticle> util = new ExcelUtil<SysArticle>(SysArticle.class);
        util.exportExcel(response, list, "文章数据");
    }

    /**
     * 获取文章详细信息
     */
    @PreAuthorize("@ss.hasPermi('article:article:query')")
    @GetMapping(value = "/{articleId}")
    public AjaxResult getInfo(@PathVariable("articleId") Long articleId)
    {
        return success(sysArticleService.selectSysArticleByArticleId(articleId));
    }

    /**
     * 新增文章
     */
    @PreAuthorize("@ss.hasPermi('article:article:add')")
    @Log(title = "文章", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysArticle sysArticle)
    {
        sysArticle.setDelFlag(0);
        sysArticle.setCreateDate(new Date());

        return toAjax(sysArticleService.insertSysArticle(sysArticle));
    }

    /**
     * 修改文章
     */
    @PreAuthorize("@ss.hasPermi('article:article:edit')")
    @Log(title = "文章", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysArticle sysArticle)
    {
        sysArticle.setUpdateDate(new Date());
        return toAjax(sysArticleService.updateSysArticle(sysArticle));
    }

    /**
     * 删除文章
     */
    @PreAuthorize("@ss.hasPermi('article:article:remove')")
    @Log(title = "文章", businessType = BusinessType.DELETE)
	@DeleteMapping("/{articleIds}")
    public AjaxResult remove(@PathVariable Long[] articleIds)
    {
//        SysArticle sysArticle = sysArticleService.selectSysArticleByArticleId(articleIds[0]);
        return toAjax(sysArticleService.deleteSysArticleByArticleIds(articleIds));
    }

    /**
     * 预览文章
     */
    @PreAuthorize("@ss.hasPermi('article:article:preview')")
    @GetMapping("/article/{articleId}")
    public AjaxResult preview(@PathVariable("articleId") Long articleId) throws IOException
    {
        Map<String, String> dataMap = sysArticleService.previewCode(articleId);
        return success(dataMap);
    }
}
