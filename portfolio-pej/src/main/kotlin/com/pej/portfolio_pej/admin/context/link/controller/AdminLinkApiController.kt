package com.pej.portfolio_pej.admin.context.link.controller

import com.pej.portfolio_pej.admin.context.link.form.LinkForm
import com.pej.portfolio_pej.admin.context.link.service.AdminLinkService
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
@RequestMapping("/admin/api/link")
class AdminLinkApiController(private val adminLinkService: AdminLinkService) {
    @PostMapping
    fun postLink(@RequestBody @Validated form: LinkForm): ResponseEntity<Any> {
        adminLinkService.save(form)
        return ApiRespone.successCreate()
    }
    @PutMapping("/{id}")
    fun putLink(@PathVariable id:Long, @RequestBody form: LinkForm): ResponseEntity<Any> {
        adminLinkService.update(id, form)
        return ApiRespone.successUpdate()
    }
}