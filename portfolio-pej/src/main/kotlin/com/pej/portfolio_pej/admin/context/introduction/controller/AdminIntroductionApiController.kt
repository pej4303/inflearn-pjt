package com.pej.portfolio_pej.admin.context.introduction.controller

import com.pej.portfolio_pej.admin.context.introduction.form.IntroductionForm
import com.pej.portfolio_pej.admin.context.introduction.service.AdminIntroductionService
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
@RequestMapping("/admin/api/introduction")
class AdminIntroductionApiController(private val adminIntroductionService: AdminIntroductionService) {
    @PostMapping
    fun postIntroduction(@RequestBody @Validated form: IntroductionForm): ResponseEntity<Any> {
        adminIntroductionService.save(form)
        return ApiRespone.successCreate()
    }
    @PutMapping("/{id}")
    fun putIntroduction(@PathVariable id:Long, @RequestBody form: IntroductionForm): ResponseEntity<Any> {
        adminIntroductionService.update(id, form)
        return ApiRespone.successUpdate()
    }
}