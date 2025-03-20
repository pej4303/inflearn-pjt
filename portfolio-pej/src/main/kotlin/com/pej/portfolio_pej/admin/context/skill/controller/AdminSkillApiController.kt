package com.pej.portfolio_pej.admin.context.skill.controller

import com.pej.portfolio_pej.admin.context.link.service.AdminLinkService
import com.pej.portfolio_pej.admin.context.skill.form.SkillForm
import com.pej.portfolio_pej.admin.data.*
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin/api/skill")
class AdminSkillApiController(private val adminSkillService:AdminLinkService ) {
    @PostMapping
    fun postSkill(@RequestBody @Validated form: SkillForm): ResponseEntity<Any> {
        adminSkillService.save(form)
        return ApiRespone.successCreate()
    }
    @PutMapping("/{id}")
    fun putSkill(@PathVariable id:Long, @RequestBody form: SkillForm): ResponseEntity<Any> {
        adminSkillService.update(id, form)
        return ApiRespone.successUpdate()
    }
}