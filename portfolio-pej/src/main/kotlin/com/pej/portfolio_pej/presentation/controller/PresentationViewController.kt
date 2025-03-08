package com.pej.portfolio_pej.presentation.controller

import com.pej.portfolio_pej.domain.constant.SkillType
import com.pej.portfolio_pej.presentation.service.PresentationService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PresentationViewController(
    private val presentationService: PresentationService
) {
    @GetMapping("/test")
    fun test(): String {
        return "test"
    }

    @GetMapping("/")
    fun index(model: Model): String {
        val introductionList = presentationService.getIntroductions()
        val linkList = presentationService.getLinks()

        model.addAttribute("introductionList", introductionList)
        model.addAttribute("linkList", linkList)

        return "presentation/index"
    }

    @GetMapping("/resume")
    fun resume(model: Model): String {
        val resume = presentationService.getResume()

        model.addAttribute("resume", resume)
        model.addAttribute("skillTypeList", SkillType.values())

        return "presentation/resume"
    }

    @GetMapping("/projects")
    fun projects(model: Model): String {
        val projectList = presentationService.getProjects()

        model.addAttribute("projectList", projectList)

        return "presentation/projects"
    }
}