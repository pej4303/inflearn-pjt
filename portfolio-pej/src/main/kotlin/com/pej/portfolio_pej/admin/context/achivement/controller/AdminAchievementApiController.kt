package com.pej.portfolio_pej.admin.context.achivement.controller

import com.pej.portfolio_pej.admin.context.achivement.form.AchievementForm
import com.pej.portfolio_pej.admin.context.achivement.service.AdminAchievementService
import com.pej.portfolio_pej.admin.data.*
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin/api/achievement")
class AdminAchievementApiController(private val adminAchievementService: AdminAchievementService) {
    @PostMapping
    fun postAchievement(@RequestBody @Validated form: AchievementForm): ResponseEntity<Any> {
        adminAchievementService.save(form)
        return ApiRespone.successCreate()
    }
    @PutMapping("/{id}")
    fun putAchievement(@PathVariable id:Long, @RequestBody form: AchievementForm): ResponseEntity<Any> {
        adminAchievementService.update(id, form)
        return ApiRespone.successUpdate()
    }
}