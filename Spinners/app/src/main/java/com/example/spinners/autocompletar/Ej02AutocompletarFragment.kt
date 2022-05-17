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
import com.example.spinners.R
import com.example.spinners.databinding.FragmentEj02AutocompletarBinding
import java.lang.Exception

class Ej02AutocompletarFragment : Fragment() {
    private var _binding: FragmentEj02AutocompletarBinding?=null
    private val binding get() =_binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding= FragmentEj02AutocompletarBinding.inflate(inflater,container,false)
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
            .apply{onItemClickListener = CustomOnItemClickListener()
                /*setOnItemClickListener { parent, view, position, id ->
            seleccionarProvincia(text.toString())
        }*/
            }

    }


    private fun seleccionarProvincia(provincia:String){

        val arrayPontevedra:Array<String> = resources.getStringArray(R.array.concellos_pontevedra)
        val arrayCoruna:Array<String> = resources.getStringArray(R.array.concellos_a_coruna)
        val arrayLugo:Array<String> = resources.getStringArray(R.array.concellos_lugo)
        val arrayOurense:Array<String> = resources.getStringArray(R.array.concellos_ourense)

        cargarSpinner(when(provincia){
            "A Coruña" -> arrayCoruna
            "Lugo" -> arrayLugo
            "Ourense" -> arrayOurense
            "Pontevedra" -> arrayPontevedra
            else -> null
        })

    }

    private fun cargarSpinner(arrayConcellos:Array<String>?){
        arrayConcellos?.let{

            binding.spinnerConcellos1
                .apply{adapter=ArrayAdapter(requireContext(),R.layout.displayed_item,it)
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

    inner class CustomOnItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            Toast.makeText(requireContext(),"Click en ${(view as TextView).text}",Toast.LENGTH_SHORT).show()

            seleccionarProvincia((view as TextView).text.toString())
        }

    }
}