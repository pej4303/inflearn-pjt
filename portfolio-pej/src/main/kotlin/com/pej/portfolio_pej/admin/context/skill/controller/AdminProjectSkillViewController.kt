package com.pej.portfolio_pej.admin.context.skill.controller

import com.pej.portfolio_pej.admin.context.skill.service.AdminProjectSkillService
import com.pej.portfolio_pej.admin.data.FormElementDTO
import com.pej.portfolio_pej.admin.data.SelectFormElementDTO
import com.pej.portfolio_pej.admin.data.TextFormElementDTO
import com.pej.portfolio_pej.domain.constant.SkillType
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/project/skill")
class AdminProjectSkillViewController(private val adminProjectSkillService: AdminProjectSkillService) {
    @GetMapping
    fun projectSkill(model: Model): String {
        val projectList = adminProjectSkillService.getProjectList()
        val skillList = adminProjectSkillService.getSkillList()

        // form 요소 셋팅
        val formElement = listOf<FormElementDTO>(
            SelectFormElementDTO("projectList", 8, projectList),
            SelectFormElementDTO("skillList", 8, skillList)
        )
        model.addAttribute("formElement", formElement)
        // 테이블 셋팅
        val table = adminProjectSkillService.getProjectSkillTable()
        model.addAttribute("table", table)
        model.addAttribute("detailTable", null)
        // 페이지 속성 셋팅
        val pageAttributes = mutableMapOf<String, Any>(
            Pair("menuName", "Projects"),
            Pair("pageName", table.name),
            Pair("editable", false),
            Pair("deletable", true),
            Pair("hasDetails", false)
        )
        model.addAllAttributes(pageAttributes)

        return "admin/page-table"
    }
}