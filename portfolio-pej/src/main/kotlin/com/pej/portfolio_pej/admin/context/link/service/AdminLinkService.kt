package com.pej.portfolio_pej.admin.context.link.service

import com.pej.portfolio_pej.admin.data.TableDTO
import com.pej.portfolio_pej.domain.entity.Link
import com.pej.portfolio_pej.domain.repository.LinkRepository
import org.springframework.stereotype.Service

@Service
class AdminLinkService (private val linkRepository: LinkRepository) {

    fun getLinkTable(): TableDTO {
        val classInfo = Link::class
        val entities = linkRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }
}