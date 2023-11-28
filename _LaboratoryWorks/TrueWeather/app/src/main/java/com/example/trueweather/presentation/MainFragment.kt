package com.example.trueweather.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.trueweather.R
import com.example.trueweather.data.MainFragmentViewModelFactory
import com.example.trueweather.data.ThroneRepository
import com.example.trueweather.data.remote.ThroneAPIFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class MainFragment : Fragment() {
    private lateinit var viewModel: MainFragmentViewModel
    private val repository = ThroneRepository(ThroneAPIFactory().create())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_prime, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModelFactory = MainFragmentViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainFragmentViewModel::class.java]

        val loadDataButton = view.findViewById<Button>(R.id.dataLoadBtn)
        val totalTextView = view.findViewById<TextView>(R.id.totalIDField)
        val idInput = view.findViewById<EditText>(R.id.idField)
        val formButton = view.findViewById<Button>(R.id.formViewBtn)
        val jsonButton = view.findViewById<Button>(R.id.jsonViewBtn)

        loadDataButton.setOnClickListener {
            viewModel.loadCharacters()
        }

        viewModel.totalCharacters.observe(viewLifecycleOwner) { count ->
            totalTextView.text = "Currently loaded $count IDs"
        }

        /*formButton.setOnClickListener {
            val id = idInput.text.toString().toInt()
            viewModel.getCharacter(id)?.observe(viewLifecycleOwner) { hero ->
                // Display hero data in UI
            }
        }*/

        jsonButton.setOnClickListener {
            // Display JSON response for character
        }

    }
}