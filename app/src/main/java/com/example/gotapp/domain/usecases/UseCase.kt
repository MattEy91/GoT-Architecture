package com.example.gotapp.domain.usecases

import com.example.gotapp.CoroutineDispatchers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Job

open class UseCase<T>(
    dispatchers: CoroutineDispatchers
) : CoroutineScope {
    fun cancel() {
        job?.cancel()
        job = null
    }
    protected open var job: Deferred<T>? = null
    override val coroutineContext = Job() + dispatchers.io
}