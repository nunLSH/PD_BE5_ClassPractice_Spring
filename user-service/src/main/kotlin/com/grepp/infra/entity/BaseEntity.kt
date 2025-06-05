package com.grepp.spring.infra.entity

import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
class BaseEntity {
    protected var activated: Boolean = true

    @CreatedDate
    protected var createdAt: LocalDateTime = LocalDateTime.now()

    @LastModifiedDate
    protected var modifiedAt: LocalDateTime = LocalDateTime.now()

    fun unActivated() {
        this.activated = false
    }
}