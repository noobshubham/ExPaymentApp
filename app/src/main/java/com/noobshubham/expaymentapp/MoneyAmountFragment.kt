package com.noobshubham.expaymentapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.trace
import androidx.navigation.fragment.findNavController
import com.noobshubham.expaymentapp.databinding.FragmentMoneyAmountBinding

class MoneyAmountFragment : Fragment() {

    private var _binding: FragmentMoneyAmountBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMoneyAmountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // read the bundle
        val args = MoneyAmountFragmentArgs.fromBundle(requireArguments())
        binding.sendToName.text = args.name

        binding.buttonConfirm.setOnClickListener {
            // this will crash if amount is blank
            val amount = binding.amountOf.text.toString().toFloatOrNull()
            Log.d(tag,"dunno why its crashing, fix this shit!")
            if (amount == null || amount == 0.00F) {
                displayAmount(args.name, 0.00F)
                return@setOnClickListener
            }
            displayAmount(args.name, amount)
        }
    }

    private fun displayAmount(name: String, d: Float) {
        val dir = MoneyAmountFragmentDirections.actionMoneyAmountFragmentToStatusFragment(name, d)
        findNavController().navigate(dir)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}