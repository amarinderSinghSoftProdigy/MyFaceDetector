package com.google.mlkit.vision.demo

import android.graphics.Bitmap
import android.os.Environment
import android.util.Log
import java.io.File
import java.io.FileOutputStream

class FileUtility {

    companion object {
        fun saveImage(finalBitmap: Bitmap?, image_name: String) {
            val root = Environment.getExternalStorageDirectory().toString()
            val myDir = File(root)
            myDir.mkdirs()
            val fname = "/Image_$image_name.jpg"
            val file = File(myDir, fname)
            if (file.exists()) file.delete()
            Log.i("LOAD", root + fname)
            try {
                val out = FileOutputStream(file)
                finalBitmap?.compress(Bitmap.CompressFormat.JPEG, 90, out)
                out.flush()
                out.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}