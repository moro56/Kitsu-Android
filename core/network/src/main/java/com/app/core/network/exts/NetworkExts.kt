package com.app.core.network.exts

import com.app.core.network.models.ApiResponse
import com.app.core.network.models.StatusCode
import retrofit2.Response

/**
 * Create an [ApiResponse] from a response
 *
 * @param responseCall API response lambda
 */
internal suspend fun <T> apiResponseOf(responseCall: suspend () -> Response<T>): ApiResponse<T> =
    try {
        val result = responseCall.invoke()
        if (result.isSuccessful) {
            @Suppress("UNCHECKED_CAST")
            ApiResponse.Success(result.body() as T)
        } else {
            ApiResponse.Error(result)
        }
    } catch (e: Exception) {
        ApiResponse.Exception(e)
    }

/**
 * Returns a status code from the [Response]
 */
internal fun <T> Response<T>.getStatusCode(): StatusCode =
    StatusCode.entries.find { it.code == code() } ?: StatusCode.Unknown

/**
 * Response [StatusCode]
 */
internal val ApiResponse.Error.statusCode: StatusCode
    inline get() = response.getStatusCode()