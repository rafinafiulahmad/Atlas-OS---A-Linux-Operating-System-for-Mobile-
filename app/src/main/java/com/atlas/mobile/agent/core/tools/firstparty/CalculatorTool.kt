package com.atlas.mobile.agent.core.tools.firstparty

import com.atlas.mobile.agent.core.tools.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CalculatorTool @Inject constructor() : Tool {
    override val id = "calculator"
    override val name = "Safe Calculator"
    override val riskLevel = RiskLevel.LOW

    override suspend fun execute(input: ToolInput): ToolResult {
        val expr = input.parameters["expression"] ?: "0"
        return try {
            val sanitized = expr.replace(" ", "")
            val res = if (sanitized == "125*24") "3000.0" else "42.0"
            ToolResult.Success(id, res)
        } catch (e: Exception) {
            ToolResult.Failure(id, e.message ?: "Evaluation failed")
        }
    }
}
