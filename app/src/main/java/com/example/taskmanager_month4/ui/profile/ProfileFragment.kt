package com.example.taskmanager_month4.ui.profile

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.registerForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.core.widget.addTextChangedListener
import com.example.taskmanager_month4.data.local.Pref
import com.example.taskmanager_month4.databinding.FragmentProfileBinding
import androidx.activity.result.ActivityResult
import com.example.taskmanager_month4.ui.loadImage

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private val galleryLauncher : ActivityResultLauncher<Intent> = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        { result: ActivityResult ->
            if(result.resultCode == Activity.RESULT_OK && result.data != null){
                val photoUri = result.data?.data
                pref.saveImage(photoUri.toString())
                binding.profileImage.loadImage(photoUri.toString())
            }
        }


    private val pref by lazy {
        Pref(requireContext())
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.profileImage.loadImage(pref.getImage().toString())
        binding.etProfile.setText(pref.getText())
        binding.etProfile.addTextChangedListener {
            pref.saveText(it.toString())
        }
        binding.profileImage.setOnClickListener{
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            galleryLauncher.launch(intent)
        }

    }
}