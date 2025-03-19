package com.pej.portfolio_pej.admin.context.introduction.controller

import com.pej.portfolio_pej.admin.context.achivement.service.AdminAchievementService
import com.pej.portfolio_pej.admin.context.introduction.service.AdminIntroductionService
import com.pej.portfolio_pej.admin.data.DateFormElementDTO
import com.pej.portfolio_pej.admin.data.FormElementDTO
import com.pej.portfolio_pej.admin.data.SelectFormElementDTO
import com.pej.portfolio_pej.admin.data.TextFormElementDTO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/introduction")
class AdminIntroductionViewController(private val adminIntroductionService: AdminIntroductionService) {
    @GetMapping
    fun introduction(model: Model): String {
        // form 요소 셋팅
        val formElement = listOf<FormElementDTO>(
            TextFormElementDTO("content", 4),
            SelectFormElementDTO("isActive", 2, listOf(true.toString(), false.toString()))
        )
        model.addAttribute("formElement", formElement)
        // 테이블 셋팅
        val table = adminIntroductionService.getIntroductionTable()
        model.addAttribute("table", table)
        model.addAttribute("detailTable", null)
        // 페이지 속성 셋팅
        val pageAttributes = mutableMapOf<String, Any>(
            Pair("menuName", "Index"),
            Pair("pageName", table.name),
            Pair("editable", true),
            Pair("deletable", false),
            Pair("hasDetails", false)
        )
        model.addAllAttributes(pageAttributes)

        return "admin/page-table"
    }
}