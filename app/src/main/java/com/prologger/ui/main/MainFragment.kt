package com.prologger.ui.main

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.lifecycle.ViewModelProvider
import com.prologger.R

class MainFragment : LogSuperclassFragment() {

    private val CAMERA_REQUEST_CODE: Int = 1970
    private val LOCATION_PERMISSION_REQUEST_CODE = 2000
    private val IMAGE_GALLERY_REQUEST_CODE: Int = 2001

    private lateinit var viewModel: MainViewModel
    private lateinit var locationViewModel: LocationViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    /**
     * On Activity Created
     */
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity.let {
            viewModel = ViewModelProvider(it!!).get(MainViewModel::class.java)
        }



        prepRequestLocationUpdates() // WORKING ON CORRECTING CODE BELOW THAT IS COMMENTED OUT
    }

    /**
     * prepRequestLocationUpdates
     */
    @SuppressLint("UseRequireInsteadOfGet")
    private fun prepRequestLocationUpdates() =
        if (checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            requestLocationUpdates()
        } else {
            val permissionRequest = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)
            requestPermissions(permissionRequest, LOCATION_PERMISSION_REQUEST_CODE)
        }

    /**
     * requestLocationUpdates
     */
    @SuppressLint("FragmentLiveDataObserve")
    private fun requestLocationUpdates() {
        locationViewModel = ViewModelProvider(this).get(LocationViewModel::class.java)

        locationViewModel.getLocationLiveData().observe(this, androidx.lifecycle.Observer {
            Log.d("Location", it.latitude)  // can assign this value to a text label on the screen
            Log.d("Location", it.longitude) // can assign this value to a text label on the screen
    
        })
    }

    /**
     * override fun onRequestPermissionResult
     */
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        when (requestCode) {

            LOCATION_PERMISSION_REQUEST_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    requestLocationUpdates() // FILE BEING CORRECTED ABOVE
                } else {
                    Toast.makeText(
                        context,
                        "Unable to update location without permission.",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
            else -> {
                super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            }
        }
    }

    /**
     * prepOpenImageGallery
     */
    private fun prepOpenImageGallery() {
        Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI).apply {
            this.type = "image/*"
            startActivityForResult(this, IMAGE_GALLERY_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            if (requestCode == CAMERA_REQUEST_CODE) {
                // get thumbnail
                val imageBitmap = data!!.extras!!.get("data") as Bitmap
                // imgPhotoTake.setImageBitmap(imageBitmap)
            } else if (requestCode == SAVE_IMAGE_REQUEST_CODE) {
                Toast.makeText(context, "Image Saved", Toast.LENGTH_LONG).show()
            } else if (requestCode == IMAGE_GALLERY_REQUEST_CODE) {

                if (data != null && data.data != null) {
                    val image = data.data
                    val source = ImageDecoder.createSource(requireActivity().contentResolver, image!!)
                    val bitmap = ImageDecoder.decodeBitmap(source)

                }
            }
        }
    }

    /**
     * companion object
     */
    companion object {
        fun newInstance() = MainFragment()
    }
}
