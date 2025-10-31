package com.amar.remoteapi.data.model

import com.amar.remoteapi.common.Defaults
import com.amar.remoteapi.common.FlexString
import com.amar.remoteapi.data.serializer.CustomIntSerializable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DemoData(
      @Serializable(CustomIntSerializable::class)
      @SerialName("user_id") val id: Int = Defaults.INT_VALUE,
      @SerialName("title") val title: FlexString = Defaults.STRING_VALUE,
      @SerialName("success") val success: Boolean = Defaults.BOOLEAN_VALUE,
      @SerialName("upload_time") val uploadTime: Long = Defaults.LONG_VALUE,
      @SerialName("progress") val progress: Double = Defaults.DOUBLE_VALUE
)

/*
[
  {
    "user_id": 1,
    "title": "This is Title",
    "success": true,
    "upload_time": 16784654546,
    "progress": 61.3
  },
  {
    "user_id": "2",
    "title": 12345,
    "success": "false",
    "upload_time": "16784654890",
    "progress": "23.8"
  },
  {
    "user_id": 3.0,
    "title": true,
    "success": 1,
    "upload_time": 16784655321.0,
    "progress": "100"
  },
  {
    "user_id": "004",
    "title": null,
    "success": "true",
    "upload_time": null,
    "progress": false
  },
  {
    "user_id": false,
    "title": "Music Library Sync",
    "success": 0,
    "upload_time": "0",
    "progress": 12
  },
  {
    "user_id": "6",
    "title": 6.789,
    "success": "yes",
    "upload_time": "16784656555",
    "progress": 95.2
  },
  {
    "user_id": "N/A",
    "title": "",
    "success": "no",
    "upload_time": "",
    "progress": null
  }
]
*/