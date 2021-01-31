package com.myoldschool.mockapi

import android.content.Context
import android.net.Uri
import androidx.test.platform.app.InstrumentationRegistry
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest

open class ApiDispatcher : Dispatcher() {
    private val responseFilesByPath: Map<String, String> = mapOf(
            APIPaths.API_GET_ALL_REDCORDS to MockFiles.API_GETRECORDS_SUCCESS
    )


    private fun getResponseBodyByPath(path: String?): MockResponse {
        return getResponseBody(responseFilesByPath[path])
    }

    protected fun getResponseBody(responseFile: String?): MockResponse {
        return when (responseFile) {
            null -> MockResponse().setResponseCode(404)
            MockFiles.NO_CONTENT_200 -> MockResponse().setResponseCode(200)
            MockFiles.NO_CONTENT_204 -> MockResponse().setResponseCode(204)
            else -> {
                MockResponse().setResponseCode(200).setBody(MockRespFileReader(responseFile).content)
            }
        }
    }

    override fun dispatch(request: RecordedRequest): MockResponse {
        val pathWithoutQueryParams = Uri.parse(request?.path).path
        return   getResponseBodyByPath(pathWithoutQueryParams)
//        return if (pathWithoutQueryParams?.contains("GetTextMessagesMms") == true) {
//            getResponseBodyByPath(request?.path)
//        } else {
//            getResponseBodyByPath(pathWithoutQueryParams)
//        }
    }
}
