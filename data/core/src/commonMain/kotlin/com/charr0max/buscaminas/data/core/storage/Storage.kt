package com.charr0max.buscaminas.data.core.storage

import kotlinx.coroutines.flow.Flow

interface Storage {

    fun <T> getAsFlow(key: Key<T>): Flow<T?>
    suspend fun <T> get(key: Key<T>): T?
    suspend fun <T> write(key: Key<T>, value: T?)
    suspend fun <T> clear(key: Key<T>) {
        write(key, null)
    }

    // define classes for all types available in DataStore
    sealed class Key<T>(
        val name: String,
        val defaultValue: T?
    ) {
        open class IntKey(name: String, defaultValue: Int? = null) : Key<Int>(name, defaultValue)
        open class LongKey(name: String, defaultValue: Long? = null) : Key<Long>(name, defaultValue)
        open class StringKey(name: String, defaultValue: String? = null) :
            Key<String>(name, defaultValue)

        open class BooleanKey(name: String, defaultValue: Boolean? = null) :
            Key<Boolean>(name, defaultValue)

        open class FloatKey(name: String, defaultValue: Float? = null) :
            Key<Float>(name, defaultValue)

        open class DoubleKey(name: String, defaultValue: Double? = null) :
            Key<Double>(name, defaultValue)
    }

}