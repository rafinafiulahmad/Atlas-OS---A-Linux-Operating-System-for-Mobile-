package com.atlas.mobile.agent.core.automation

import java.util.UUID

enum class WorkflowStatus { ACTIVE, PAUSED, COMPLETED, FAILED }

data class AutomaticWorkflow(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val triggerDescription: String,
    val actions: List<String>,
    val status: WorkflowStatus = WorkflowStatus.ACTIVE,
    val runCount: Int = 0
)
