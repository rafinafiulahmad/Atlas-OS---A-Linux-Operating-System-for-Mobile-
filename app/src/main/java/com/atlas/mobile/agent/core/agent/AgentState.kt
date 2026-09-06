package com.atlas.mobile.agent.core.agent

sealed class AgentState {
    object Idle : AgentState()
    data class GoalReceived(val goal: String) : AgentState()
    data class Planning(val goal: String) : AgentState()
    data class PolicyCheck(val goal: String) : AgentState()
    data class PermissionCheck(val goal: String) : AgentState()
    data class WaitingForApproval(val taskId: String, val approvalId: String, val reason: String) : AgentState()
    data class Executing(val currentStep: Int, val totalSteps: Int) : AgentState()
    data class Observing(val summary: String) : AgentState()
    data class Verifying(val status: String) : AgentState()
    data class Completed(val summary: String) : AgentState()
    data class Failed(val reason: String) : AgentState()
}

class AgentStateMachine {
    fun isValidTransition(from: AgentState, to: AgentState): Boolean {
        return when (from) {
            is AgentState.Idle -> to is AgentState.GoalReceived
            is AgentState.GoalReceived -> to is AgentState.Planning || to is AgentState.Failed
            is AgentState.Planning -> to is AgentState.PolicyCheck || to is AgentState.Failed
            is AgentState.PolicyCheck -> to is AgentState.PermissionCheck || to is AgentState.WaitingForApproval || to is AgentState.Failed
            is AgentState.PermissionCheck -> to is AgentState.Executing || to is AgentState.WaitingForApproval || to is AgentState.Failed
            is AgentState.WaitingForApproval -> to is AgentState.Executing || to is AgentState.Failed
            is AgentState.Executing -> to is AgentState.Observing || to is AgentState.WaitingForApproval || to is AgentState.Failed
            is AgentState.Observing -> to is AgentState.Verifying || to is AgentState.Failed
            is AgentState.Verifying -> to is AgentState.Executing || to is AgentState.Completed || to is AgentState.Failed
            else -> false
        }
    }
}
