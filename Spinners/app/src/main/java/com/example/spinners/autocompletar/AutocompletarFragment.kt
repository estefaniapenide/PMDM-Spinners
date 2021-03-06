package com.example.spinners.autocompletar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.spinners.R
import com.example.spinners.databinding.FragmentAutocompletarBinding

class AutocompletarFragment : Fragment() {

    private var _binding: FragmentAutocompletarBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentAutocompletarBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonAutoCom1.setOnClickListener {
            findNavController().navigate(AutocompletarFragmentDirections.actionAutocompletarFragmentToEj01AutocompletarFragment())
        }

        binding.buttonAutoCom2.setOnClickListener {
            findNavController().navigate(AutocompletarFragmentDirections.actionAutocompletarFragmentToEj02AutocompletarFragment())
        }

        binding.buttonAutoCom3.setOnClickListener{
            findNavController().navigate(AutocompletarFragmentDirections.actionAutocompletarFragmentToEj03AutocompletarFragment())
        }
    }

}