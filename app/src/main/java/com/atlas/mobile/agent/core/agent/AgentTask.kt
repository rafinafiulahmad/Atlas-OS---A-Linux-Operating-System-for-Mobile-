package com.atlas.mobile.agent.core.agent

import java.util.UUID

data class AgentTask(
    val id: String = UUID.randomUUID().toString(),
    val goal: String,
    val status: String = "PENDING",
    val iterationCount: Int = 0,
    val maxIterations: Int = 20,
    val maxToolCalls: Int = 50,
    val createdAt: Long = System.currentTimeMillis()
)
