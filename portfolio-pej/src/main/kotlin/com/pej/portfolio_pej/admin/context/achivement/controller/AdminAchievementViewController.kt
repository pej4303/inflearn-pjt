package com.pej.portfolio_pej.admin.context.achivement.controller

import com.pej.portfolio_pej.admin.context.achivement.service.AdminAchievementService
import com.pej.portfolio_pej.admin.data.DateFormElementDTO
import com.pej.portfolio_pej.admin.data.FormElementDTO
import com.pej.portfolio_pej.admin.data.SelectFormElementDTO
import com.pej.portfolio_pej.admin.data.TextFormElementDTO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/achievement")
class AdminAchievementViewController(private val adminAchievementService: AdminAchievementService) {
    @GetMapping
    fun achievement(model: Model): String {
        val formElement = listOf<FormElementDTO>(
            TextFormElementDTO("title", 4),
            TextFormElementDTO("description", 8),
            DateFormElementDTO("achievedDate", 5),
            TextFormElementDTO("host", 5),
            SelectFormElementDTO("isActive", 2, listOf(true.toString(), false.toString()))
        )
        model.addAttribute("formElement", formElement)

        val table = adminAchievementService.getAchievementTable()
        model.addAttribute("table", table)
        model.addAttribute("detailTable", null)

        val pageAttributes = mutableMapOf<String, Any>(
            Pair("menuName", "Resume"),
            Pair("pageName", table.name),
            Pair("editable", true),
            Pair("deletable", false),
            Pair("hasDetails", false)
        )
        model.addAllAttributes(pageAttributes)

        return "admin/page-table"
    }
}