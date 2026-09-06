package com.atlas.mobile.agent.core.security

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicBoolean
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class KillSwitch @Inject constructor() {
    private val isEngaged = AtomicBoolean(false)
    private val activeJobs = ConcurrentHashMap<String, Job>()

    fun register(taskId: String, job: Job) {
        if (isEngaged.get()) job.cancel(CancellationException("Kill switch is active"))
        else activeJobs[taskId] = job
    }

    fun trigger(reason: String = "Emergency Abort") {
        isEngaged.set(true)
        activeJobs.forEach { (_, job) -> job.cancel(CancellationException(reason)) }
        activeJobs.clear()
    }

    fun reset() { isEngaged.set(false) }
    fun isActive(): Boolean = isEngaged.get()
}
