package com.example.spinners.spinners

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.AppCompatSpinner
import com.example.spinners.R
import com.example.spinners.databinding.FragmentEj6DialogBinding

class Ej6DialogFragment : Fragment() {
    private var _binding: FragmentEj6DialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEj6DialogBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.spinner1
            .apply { setSelection(0,false) }
            .apply{prompt="Escoge un planeta:"}
            .apply { onItemSelectedListener=CustomOnItemSelectedListener() }

        val arrayElementos:MutableList<String> = ArrayList()
        arrayElementos.add("---")
        arrayElementos.add("Elemento 1")
        arrayElementos.add("Elemento 2")
        arrayElementos.add("Elemento 3")

        binding.spinner2
            .apply{
                adapter=ArrayAdapter(requireContext(), R.layout.displayed_item, arrayElementos)
                    .apply { setDropDownViewResource(R.layout.list_items) }}
            .apply { prompt="Escoge un elemento:" }

        binding.spinner3
            .apply{setSelection(0,false)}
            .apply { adapter=ArrayAdapter.createFromResource(requireContext(),R.array.paises,R.layout.displayed_item)
                .apply { setDropDownViewResource(R.layout.displayed_item) } }
            .apply { prompt="Escoge un país" }

        binding.button.setOnClickListener{
            binding.textView.text="""PLANETA: ${binding.spinner1.selectedItem}
                |ELEMENTO: ${binding.spinner2.selectedItem}
                |PAÍS: ${binding.spinner3.selectedItem}
            """.trimMargin()
        }

    }

    inner class CustomOnItemSelectedListener : AdapterView.OnItemSelectedListener {

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            val mensajeToast = """OnItemSelectedListener:
                    |parent.selectedItem= ${parent!!.selectedItem}
                    |parent?.getItemAtPosition(position) = ${parent?.getItemAtPosition(position)}
                    |(view as TextView).text = ${(view as TextView).text}
                    |position = $position
                    |id = $id
                """.trimMargin()

            Toast.makeText(parent!!.context, mensajeToast, Toast.LENGTH_LONG).show()

            if(parent.selectedItem=="Tierra"){
                binding.spinner2.visibility=View.VISIBLE
                binding.spinner3.visibility=View.VISIBLE
            }else{
                binding.spinner2
                    .apply{setSelection(0,false)}
                    .apply { visibility=View.INVISIBLE }

                binding.spinner3
                    .apply{setSelection(0,false)}
                    .apply { visibility=View.INVISIBLE }
            }
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {

        }
    }

}


