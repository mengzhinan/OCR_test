package com.test.ocrlib

import android.content.Context
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream

/**
 * @Author: duke
 * @DateTime: 2021-03-22 18:02:29
 * @Description: 功能描述：
 *
 */
object FileCopyHelper {

    private const val FILE_PARENT_FOLDER_NAME = "tessdata"
    private const val LANGUAGE_FILE_NAME = "chi_sim"
    private const val LANGUAGE_FULL_NAME = "chi_sim.traineddata"


    fun copyChiToSDCard(context: Context?): Boolean {
        return copyAssetsToSDCard(context, LANGUAGE_FILE_NAME, LANGUAGE_FULL_NAME)
    }

    private fun copyAssetsToSDCard(
        context: Context?,
        onlyFileName: String?,
        fullName: String?
    ): Boolean {
        context ?: return false
        onlyFileName ?: return false
        fullName ?: return false

        val outFile = File(context.getExternalFilesDir(FILE_PARENT_FOLDER_NAME), fullName)
        if (outFile.exists()) {
            return true
        }

        var inputStream: InputStream? = null
        var fos: FileOutputStream? = null
        try {
            inputStream = context.assets.open(onlyFileName)
            fos = FileOutputStream(outFile)
            val buffer = ByteArray(1024)
            var byteCount = inputStream.read(buffer)
            while (byteCount != -1) {
                fos.write(buffer, 0, byteCount)
                byteCount = inputStream.read(buffer)
            }
            return true
        } catch (e: IOException) {
            e.printStackTrace()
            return false
        } finally {
            fos?.flush()
            fos?.close()
            inputStream?.close()
        }

    }

}