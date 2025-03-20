package com.pej.portfolio_pej.admin.context.link.service

import com.pej.portfolio_pej.admin.context.link.form.LinkForm
import com.pej.portfolio_pej.admin.data.TableDTO
import com.pej.portfolio_pej.domain.entity.Link
import com.pej.portfolio_pej.domain.repository.LinkRepository
import org.springframework.transaction.annotation.Transactional
import org.springframework.stereotype.Service

@Service
class AdminLinkService (private val linkRepository: LinkRepository) {
    fun getLinkTable(): TableDTO {
        val classInfo = Link::class
        val entities = linkRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }
    @Transactional
    fun save(form: LinkForm) {
        val item = form.toEntity()
        linkRepository.save(item)
    }
    @Transactional
    fun update(id:Long, form: LinkForm) {
        val item = form.toEntity(id)
        linkRepository.save(item)
    }
}