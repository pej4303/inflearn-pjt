package com.pej.portfolio_pej.admin.context.experience.controller

import com.pej.portfolio_pej.admin.context.experience.service.AdminExperienceService
import com.pej.portfolio_pej.admin.data.FormElementDTO
import com.pej.portfolio_pej.admin.data.SelectFormElementDTO
import com.pej.portfolio_pej.admin.data.TextFormElementDTO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/experience")
class AdminExperienceViewController(private val adminExperienceService: AdminExperienceService) {
    @GetMapping
    fun experience(model: Model): String {
        // form 요소 셋팅
        val formElement = listOf<FormElementDTO>(
            TextFormElementDTO("title", 4),
            TextFormElementDTO("description", 8),
            SelectFormElementDTO("startYear", 3, (2010..2030).toList()),
            SelectFormElementDTO("startMonth", 2, (1..12).toList()),
            SelectFormElementDTO("endYear", 3, (2010..2030).toList()),
            SelectFormElementDTO("endMonth", 2, (1..12).toList()),
            SelectFormElementDTO("isActive", 2, listOf(true.toString(), false.toString()))
        )
        model.addAttribute("formElement", formElement)
        // 상세 form 요소 셋팅
        val detailFormElement = listOf<FormElementDTO>(
            TextFormElementDTO("content", 10),
            SelectFormElementDTO("isActive", 2, listOf(true.toString(), false.toString()))
        )
        model.addAttribute("detailFormElement", detailFormElement)
        // 테이블 셋팅
        val table = adminExperienceService.getExperienceTable()
        model.addAttribute("table", table)
        // 상세 테이블 셋팅
        val detailTable = adminExperienceService.getExperienceDetailTable(null)
        model.addAttribute("detailTable", detailTable)
        // 페이지 속성 셋팅
        val pageAttributes = mutableMapOf<String, Any>(
            Pair("menuName", "Resume"),
            Pair("pageName", table.name),
            Pair("editable", true),
            Pair("deletable", false),
            Pair("hasDetails", true)
        )
        model.addAllAttributes(pageAttributes)

        return "admin/page-table"
    }
}