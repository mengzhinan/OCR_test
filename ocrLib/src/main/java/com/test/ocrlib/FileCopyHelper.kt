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
    private const val LANGUAGE_FULL_NAME_CHI = "chi_sim.traineddata"
    private const val LANGUAGE_FULL_NAME_ENG = "eng.traineddata"
    private const val LANGUAGE_FULL_NAME_OSD = "osd.traineddata"

    fun copyEngToSDCard(context: Context?): Boolean {
        return copyAssetsToSDCard(context, LANGUAGE_FULL_NAME_ENG)
    }

    fun copyOsdToSDCard(context: Context?): Boolean {
        return copyAssetsToSDCard(context, LANGUAGE_FULL_NAME_OSD)
    }

    fun copyChiToSDCard(context: Context?): Boolean {
        return copyAssetsToSDCard(context, LANGUAGE_FULL_NAME_CHI)
    }

    private fun copyAssetsToSDCard(
        context: Context?,
        fullName: String?
    ): Boolean {
        context ?: return false
        fullName ?: return false

        val outFile = File(context.getExternalFilesDir(FILE_PARENT_FOLDER_NAME), fullName)
        if (outFile.exists()) {
            return true
        }

        var inputStream: InputStream? = null
        var fos: FileOutputStream? = null
        try {
            inputStream = context.assets.open(fullName)
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