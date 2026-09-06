package com.atlas.mobile.agent.core.project

import java.util.UUID

enum class ProjectStatus { ACTIVE, PAUSED, ARCHIVED }

data class Project(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val objective: String,
    val instructions: String,
    val status: ProjectStatus = ProjectStatus.ACTIVE,
    val assignedSkills: List<String> = emptyList(),
    val memoryTag: String = "project_$id"
)
