package com.example.exam.Views.allfragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.exam.ViewModels.InventoryViewModel
import com.example.exam.ViewModels.InventoryViewModelFactory
import com.example.exam.databinding.FragmentAddItemBinding
import com.example.exam.model.InventoryApplication
import com.example.exam.model.Item

class AddItemFragment : Fragment() {

    private val viewModel: InventoryViewModel by activityViewModels {
        InventoryViewModelFactory(
            (activity?.application as InventoryApplication).database
                .itemDao()
        )
    }
    private val navigationArgs: ItemDetailFragmentArgs by navArgs()
    lateinit var item: Item

    private var _binding: FragmentAddItemBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun isEntryValid(): Boolean {
        return viewModel.isEntryValid(
            binding.itemIntrebare.text.toString(),
            binding.itemRaspuns1.text.toString()
//            binding.itemPrice.text.toString(),
//            binding.itemCount.text.toString(),
        )
    }

    private fun addNewItem() {
        if (isEntryValid()) {
            viewModel.addNewItem(
                binding.itemIntrebare.text.toString(),
                binding.itemRaspuns1.text.toString(),
//                binding.itemPrice.text.toString(),
//                binding.itemCount.text.toString(),
            )
            val action = AddItemFragmentDirections.actionAddItemFragmentToItemListFragment()
            findNavController().navigate(action)
        }
        Log.i("BLABLA", "nu e valid")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = navigationArgs.itemId
        if (id > 0) {
            viewModel.retrieveItem(id).observe(this.viewLifecycleOwner) { selectedItem ->
                item = selectedItem
                bind(item)
            }
        } else {
            binding.saveAction.setOnClickListener {
                addNewItem()
            }
        }
    }

    private fun bind(item: Item) {
//        val price = "%.2f".format(item.itemPrice)
        binding.apply {
            itemIntrebare.setText(item.itemIntrebare, TextView.BufferType.SPANNABLE)
            itemRaspuns1.setText(item.itemRaspuns1, TextView.BufferType.SPANNABLE)
//            itemPrice.setText(price, TextView.BufferType.SPANNABLE)
//            itemCount.setText(item.quantityInStock.toString(), TextView.BufferType.SPANNABLE)

            saveAction.setOnClickListener { updateItem() }
        }
    }

    private fun updateItem() {
        if (isEntryValid()) {
            viewModel.updateItem(
                this.navigationArgs.itemId,
                this.binding.itemIntrebare.text.toString(),
                this.binding.itemRaspuns1.text.toString()
//                this.binding.itemPrice.text.toString(),
//                this.binding.itemCount.text.toString()
            )
            val action = AddItemFragmentDirections.actionAddItemFragmentToItemListFragment()
            findNavController().navigate(action)
        }
    }

}