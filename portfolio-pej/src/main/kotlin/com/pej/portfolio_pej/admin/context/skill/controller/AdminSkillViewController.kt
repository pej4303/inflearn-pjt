package com.pej.portfolio_pej.admin.context.skill.controller

import com.pej.portfolio_pej.admin.context.link.service.AdminLinkService
import com.pej.portfolio_pej.admin.context.skill.service.AdminSkillService
import com.pej.portfolio_pej.admin.data.FormElementDTO
import com.pej.portfolio_pej.admin.data.SelectFormElementDTO
import com.pej.portfolio_pej.admin.data.TextFormElementDTO
import com.pej.portfolio_pej.domain.constant.SkillType
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/skill")
class AdminSkillViewController(private val adminSkillService: AdminSkillService) {
    @GetMapping
    fun link(model: Model): String {
        val formElement = listOf<FormElementDTO>(
            TextFormElementDTO("name", 4),
            SelectFormElementDTO("type", 2, SkillType.values().map{ it.name }),
            SelectFormElementDTO("isActive", 2, listOf(true.toString(), false.toString()))
        )
        model.addAttribute("formElement", formElement)

        val table = adminSkillService.getSkillTable()
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