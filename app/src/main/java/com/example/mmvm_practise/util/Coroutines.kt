package com.example.mmvm_practise.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

object Coroutines {
    fun main(someWork:suspend () -> Unit): Job {
        return CoroutineScope(Dispatchers.Main).launch{someWork()}
    }

    // in lambda for can return as
//    fun main(someWork:suspend () -> Unit)= CoroutineScope(Dispatchers.Main).launch{someWork()}



}