package com.noobshubham.expaymentapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.noobshubham.expaymentapp.databinding.FragmentStatusBinding

class StatusFragment : Fragment() {

    private var _binding: FragmentStatusBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentStatusBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = StatusFragmentArgs.fromBundle(requireArguments())
        // loading the gif from local assesst folder https://handyopinion.com/load-gif-in-imageview-android-java-kotlin/
        Glide.with(this.activity).load("file:///android_asset/checkmarksuccess.gif").into(binding.successful)
        binding.success.text = getString(R.string.status_msg, args.amount, args.name)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}