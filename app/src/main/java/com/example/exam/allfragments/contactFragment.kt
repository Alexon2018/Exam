package com.example.exam.allfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.exam.R
import com.example.exam.databinding.FragmentAboutBinding
import com.example.exam.databinding.FragmentContactBinding

class contactFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentContactBinding>(inflater,
            R.layout.fragment_contact,container,false)

        setHasOptionsMenu(true)
        return binding.root
    }
}