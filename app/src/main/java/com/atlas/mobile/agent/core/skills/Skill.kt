package com.atlas.mobile.agent.core.skills

import com.atlas.mobile.agent.core.tools.RiskLevel

data class SkillManifest(
    val id: String,
    val name: String,
    val description: String,
    val instructions: String,
    val requiredTools: List<String>,
    val riskLevel: RiskLevel = RiskLevel.LOW,
    val isEnabled: Boolean = true
)

object BuiltInSkills {
    fun all(): List<SkillManifest> = listOf(
        SkillManifest("deep_research", "Deep Research", "Multi-source synthesis", "Cross reference 3+ primary sources.", listOf("web_search", "document_analyzer")),
        SkillManifest("funding_hunter", "Funding Hunter", "Grant & funding search", "Extract deadlines, eligibility and verify evidence.", listOf("web_search")),
        SkillManifest("global_south_policy", "Global South Policy", "AI policy monitoring", "Track Bangladesh & regional regulatory gazettes.", listOf("web_search", "document_analyzer")),
        SkillManifest("fact_checking", "Fact Checking", "Claim verification", "Verify claims against authoritative portals.", listOf("web_search"))
    )
}
