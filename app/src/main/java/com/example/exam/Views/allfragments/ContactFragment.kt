package com.example.exam.Views.allfragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.exam.R
import com.example.exam.databinding.FragmentAddItemBinding
import com.example.exam.databinding.FragmentContactBinding
import com.example.exam.utils.Context


class ContactFragment : Fragment() {

    private var _binding: FragmentContactBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContactBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.shareButton.setOnClickListener {
            startSharing()
        }

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