package com.amar.remoteapi.data.api

import com.amar.remoteapi.common.network.ApiEndpoints.POSTS
import com.amar.remoteapi.data.model.DemoData
import com.amar.remoteapi.data.model.FileUploadResponse
import com.amar.remoteapi.data.model.Post
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.accept
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.forms.formData
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders
import javax.inject.Inject

class ApiServiceImpl @Inject constructor(
      private val client: HttpClient
) : ApiService {
      override suspend fun getPosts(): List<Post> {
            return client.get(POSTS).body()
      }

      override suspend fun getDemoData(): List<DemoData> {
            return client.get("https://mocki.io/v1/f7879c28-8ecb-4bd3-97b9-89b35610ed5a").body()
//            return client.get("https://mocki.io/v1/8def9de3-7245-4c58-8037-69d39a4e17df").body()
//            return client.get("https://mocki.io/v1/a6a3ac54-f3cc-41c6-9f97-bec3edf11f60").body()
      }

      override suspend fun uploadFile(
            bytes: ByteArray,
            mimeType: String,
            fileName: String
      ): FileUploadResponse {
            return client.post("https://api.zoconut.com/dieter/v2/progress_gallery/") {
                  accept(ContentType.Application.Json)
                  header(
                        HttpHeaders.Authorization,
                        "token 9db7c2c1763ff299e9369c995e79bdf8b904ec6b"
                  )
                  setBody(
                        MultiPartFormDataContent(
                              formData {
                                    append("note", "sample note")
                                    append("Image", bytes, Headers.build {
                                          append(HttpHeaders.ContentType, mimeType)
                                          append(
                                                HttpHeaders.ContentDisposition,
                                                "filename=$fileName"
                                          )
                                    })
                              }
                        )
                  )
            }.body()
      }
}