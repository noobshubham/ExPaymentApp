package com.noobshubham.expaymentapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.noobshubham.expaymentapp.databinding.FragmentSendMoneyBinding

class SendMoneyFragment : Fragment() {

    private var _binding: FragmentSendMoneyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSendMoneyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonNext.setOnClickListener {
            val name = binding.setNameOf.text.toString()
            if (name.length > 3) {
                val dir = SendMoneyFragmentDirections.actionSendMoneyFragmentToMoneyAmountFragment(name)
                findNavController().navigate(dir)
            } else {
                binding.nameOf.error = "Please enter valid name."
                binding.setNameOf.requestFocus()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}