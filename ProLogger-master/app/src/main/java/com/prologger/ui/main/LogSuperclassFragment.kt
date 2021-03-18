package com.prologger.ui.main

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Environment
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

open class LogSuperclassFragment : Fragment() {

    protected val SAVE_IMAGE_REQUEST_CODE: Int = 1969
    protected val CAMERA_PERMISSION_REQUEST_CODE = 1971
    private lateinit var currentPhotoPath: String

    /**
     * prepTakePhoto()
     * See if we have permission or not?
     */
    private fun prepTakePhoto() {
        val context: Context = this.context ?: return // or if block
        if (
            checkSelfPermission(
                context, // replace context with requireContext
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            takePhoto()
        } else { // what if user has not granted that permission
            val permissionRequest = arrayOf(Manifest.permission.CAMERA)
            requestPermissions(permissionRequest, CAMERA_PERMISSION_REQUEST_CODE)
        }
    }

    /**
     * private fun takePhoto()
     */
    protected fun takePhoto() {
        val context: Context = this.context ?: return // or if block
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(context.packageManager)
            if (takePictureIntent == null) {
                Toast.makeText(context, "Unable to save photo", Toast.LENGTH_LONG).show()
            } else {
                // if we have a valid intent
                val photoFile: File = createImageFile()
                photoFile.also {
                    val photoURI = FileProvider.getUriForFile(requireActivity().applicationContext, "com.prologger.android.FileProvider", it)
                    // replace activity with requireActivity
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoFile)
                    startActivityForResult(takePictureIntent, SAVE_IMAGE_REQUEST_CODE)
                }
            }
        }
    }

    /**
     * createImageFile()
     */
    private fun createImageFile(): File {
        // generate a unique filename with date.
        val timestamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        // get access to the directory where we can write pictures.
        val storageDir: File? = requireContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES) // replace context with requireContext
        // Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
        return File.createTempFile("PhotoLibrary$timestamp", ".jpg", storageDir).apply {
            currentPhotoPath = absolutePath
        }
    }

    /**
     * override fun onRequestPermissionResult
     */
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            CAMERA_PERMISSION_REQUEST_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission granted, let us do something
                    takePhoto()
                } else {
                    Toast.makeText(
                        context,
                        "Unable to take photo without permission",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
            else -> {
                super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            }
        }
    }
}