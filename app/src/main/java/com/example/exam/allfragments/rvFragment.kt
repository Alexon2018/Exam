package com.example.exam.allfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.exam.R
import com.example.exam.databinding.FragmentRvBinding

class rvFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentRvBinding>(inflater,
            R.layout.fragment_rv,container,false)

        binding.temp.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_rvFragment_to_detailsFragment)
        }
        setHasOptionsMenu(true)
        return binding.root
    }

}
