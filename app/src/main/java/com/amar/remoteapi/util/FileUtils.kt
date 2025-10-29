package com.amar.remoteapi.util

import android.content.Context
import android.net.Uri

object FileUtils {
      fun getBytesFromUri(
            context: Context,
            uri: Uri
      ) = try {
            context.contentResolver.openInputStream(uri)?.use { inputStream ->
                  inputStream.readBytes()
            }
      } catch (exception: Exception) {
            exception.printStackTrace()
            null
      }

      fun getMimeType(
            context: Context,
            uri: Uri
      ) = context.contentResolver.getType(uri) ?: "application/octet-stream"

      fun getFileName(mimeType: String): String {
            val extension = getExtensionFromMimeType(mimeType)
            val baseName = when (extension.lowercase()) {
                  "pdf" -> "file"
                  "png", "jpg", "jpeg", "gif", "webp" -> "image"
                  "mp4", "mkv", "mov", "avi" -> "video"
                  "mp3", "wav", "aac", "flac" -> "audio"
                  else -> "unknown"
            }
            return "${baseName}_${System.currentTimeMillis()}.$extension"
      }

      private fun getExtensionFromMimeType(mimeType: String) = mimeType.substringAfterLast('/')
}