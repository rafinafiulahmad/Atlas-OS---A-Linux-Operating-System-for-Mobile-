package com.atlas.mobile.agent.core.security

object SecurityGuardrails {
    private val secretRegex = Regex("(?i)(api[_-]?key|bearer|token|secret|password)[:= ]+.*")
    private val injectionRegex = Regex("(?i)ignore.*previous.*instructions")

    fun scrub(input: String): String = input.replace(secretRegex, "[REDACTED_SECRET]")

    fun isSafeText(input: String): Boolean = !injectionRegex.containsMatchIn(input)

    fun isSafePath(path: String): Boolean = !path.contains("..") && !path.startsWith("/data/data/") && !path.contains("/system/")
}
