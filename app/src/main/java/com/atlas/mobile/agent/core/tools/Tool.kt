package com.atlas.mobile.agent.core.tools

enum class RiskLevel { LOW, MEDIUM, HIGH, CRITICAL }

data class ToolInput(val toolId: String, val taskId: String, val parameters: Map<String, String>)

sealed class ToolResult {
    data class Success(val toolId: String, val output: String) : ToolResult()
    data class Failure(val toolId: String, val errorMessage: String) : ToolResult()
}

interface Tool {
    val id: String
    val name: String
    val riskLevel: RiskLevel
    suspend fun execute(input: ToolInput): ToolResult
}
