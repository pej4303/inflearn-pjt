package com.pej.portfolio_pej.admin.context.project.controller

import com.pej.portfolio_pej.admin.context.project.form.ProjectSkillForm
import com.pej.portfolio_pej.admin.context.project.service.AdminProjectSkillService
import com.pej.portfolio_pej.admin.data.ApiRespone
import com.pej.portfolio_pej.admin.data.FormElementDTO
import com.pej.portfolio_pej.admin.data.SelectFormElementDTO
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/api/project/skill")
class AdminProjectSkillApiController(private val adminProjectSkillService: AdminProjectSkillService) {
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

    @PostMapping
    fun postProjectSkill(@RequestBody form: ProjectSkillForm): ResponseEntity<Any> {
        adminProjectSkillService.save(form)
        return ApiRespone.successCreate()
    }

    @DeleteMapping
    fun deleteProjectSkill(@PathVariable("id") id:Long): ResponseEntity<Any> {
        adminProjectSkillService.deleteProjectSkill(id)
        return ApiRespone.successDelete()
    }
}