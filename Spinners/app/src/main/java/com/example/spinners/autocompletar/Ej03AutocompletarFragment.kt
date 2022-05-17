package com.example.spinners.autocompletar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.example.spinners.R
import com.example.spinners.databinding.FragmentEj03AutocompletarBinding
import com.example.spinners.spinners.Ej6DialogFragment

class Ej03AutocompletarFragment : Fragment() {
    private var _binding: FragmentEj03AutocompletarBinding?=null
    private val binding get() =_binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding= FragmentEj03AutocompletarBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.autoCompleteTextView2
            .apply{setAdapter(ArrayAdapter.createFromResource(requireContext(), R.array.provincias,R.layout.displayed_item))}
            .apply{threshold=1}
            .apply{onItemSelectedListener = CustomOnItemSelectedListener()}
            .apply{doOnTextChanged { text, start, before, count ->
                seleccionarProvincia(text.toString())
            }}
    }

    private fun seleccionarProvincia(provincia:String){
        cargarSpinner(when(provincia){
            "A Coruña" -> R.array.concellos_a_coruna
            "Lugo" -> R.array.concellos_lugo
            "Ourense" -> R.array.concellos_ourense
            "Pontevedra" -> R.array.concellos_pontevedra
            else -> null
        })

    }

    private fun cargarSpinner(recurso:Int?){
        recurso?.let{

            binding.spinnerConcellos1
                .apply{adapter= ArrayAdapter.createFromResource(requireContext(),it,R.layout.displayed_item)
                    .apply{setDropDownViewResource(R.layout.list_items)}}

            mostrarLocalidades()

        }?:ocultarLocalidades()
    }

    private fun mostrarLocalidades(){
        binding.spinnerConcellos1.visibility=View.VISIBLE
        binding.textView5.visibility=View.VISIBLE
    }

    private fun ocultarLocalidades(){
        binding.spinnerConcellos1.visibility=View.INVISIBLE
        binding.textView5.visibility=View.INVISIBLE
    }



    inner class CustomOnItemSelectedListener : AdapterView.OnItemSelectedListener {

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            Toast.makeText(requireContext(),"Click en ${(view as TextView).text}", Toast.LENGTH_SHORT).show()

            seleccionarProvincia((view as TextView).text.toString())
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {

        }
    }
}