package com.example.exam.Views.allfragments

import android.Manifest.permission.CALL_PHONE
import android.app.Application
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
//import com.example.exam.ItemListFragmentDirections
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

        binding.callButton.setOnClickListener { makePhoneCall(this.resources.getString(R.string.phoneNumber)) }

        // aici setam titlul paginii
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.contact)

    }

    private fun makePhoneCall(number:String) {
        val intent = Intent()
        intent.action = Intent.ACTION_DIAL
        intent.data = Uri.parse("tel: $number")
        startActivity(intent)
    }



}