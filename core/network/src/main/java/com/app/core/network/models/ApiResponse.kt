package com.app.core.network.models

import retrofit2.Response

/**
 * Sealed interface for defining the result of an API request
 */
sealed interface ApiResponse<out T> {
    /**
     * Success case
     *
     * @property result result of the API request
     */
    data class Success<T>(val result: T) : ApiResponse<T>

    /**
     * Success case
     *
     * @property response API request response
     */
    data class Error(val response: Response<*>) : ApiResponse<Nothing>

    /**
     * Success case
     *
     * @property throwable the throwable exception
     */
    data class Exception(val throwable: Throwable) : ApiResponse<Nothing>
}
