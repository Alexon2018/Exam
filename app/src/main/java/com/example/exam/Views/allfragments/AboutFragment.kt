package com.example.exam.Views.allfragments

import android.content.Intent
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.exam.R
import com.example.exam.databinding.FragmentAboutBinding
import com.example.exam.databinding.FragmentContactBinding

class AboutFragment : Fragment() {

    private val myImage = "https://raw.githubusercontent.com/bumptech/glide/master/static/glide_logo.png"

    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        glideMe(myImage, binding.imageView3)
        binding.shareButton.setOnClickListener {
            startSharing()
        }

        // aici setam titlul paginii
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.aboutMe)

    }

    private fun glideMe(image : String, imageView: ImageView){
        Glide.with(this)
            .load(image)
            .into(imageView)
    }

    private fun startSharing(){
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "Cea mai cool aplicatie")
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent,null)
        shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        this.startActivity(shareIntent)
    }

}