package com.example.trueweather.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.example.trueweather.R
import com.example.trueweather.data.MainFragmentViewModelFactory
import com.example.trueweather.data.ThroneRepository
import com.example.trueweather.data.remote.ThroneAPIFactory
import com.example.trueweather.data.remote.model.ThroneHero
import kotlinx.coroutines.launch

class MainFragment : Fragment() {
    private lateinit var viewModel: MainFragmentViewModel
    private val repository = ThroneRepository(ThroneAPIFactory().create())

    // Button variable:
    private var hasClickedJSON = false

    private fun navigateToJSONFragment(character: ThroneHero?) {
        val jsonFragment = JSONFragment()
        val bundle = Bundle().apply {
            putParcelable("character", character as Parcelable?)
        }
        jsonFragment.arguments = bundle

        val navController = findNavController()
        navController.navigate(R.id.JSONFragment, bundle) // Use the ID specified in your navigation graph
    }

    private fun navigateToWeatherFragment(character: ThroneHero?) {
        val weatFragment = WeatherFragment()
        val bundle = Bundle().apply {
            putParcelable("character", character as Parcelable?)
        }
        weatFragment.arguments = bundle

        val navController = findNavController()
        navController.navigate(R.id.weatherFragment,
            bundle) // Use the ID specified in your navigation graph
    }


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
            idInput.visibility = View.VISIBLE
            formButton.visibility = View.VISIBLE
            jsonButton.visibility = View.VISIBLE
        }

        viewModel.totalCharacters.observe(viewLifecycleOwner) { count ->
            totalTextView.text = "Currently loaded $count IDs"
        }

        formButton.setOnClickListener {
            val id = idInput.text.toString().toInt()
            // Display JSON response for character
            viewModel.viewModelScope.launch {
                hasClickedJSON = false
                viewModel.getCharacterById(id)

            }

        }

        jsonButton.setOnClickListener {
            // Display JSON response for character
            val id = idInput.text.toString().toInt()
            viewModel.viewModelScope.launch {
                hasClickedJSON = true
                viewModel.getCharacterById(id)
            }
        }

        viewModel._selectedCharacter.observe(viewLifecycleOwner) { character ->
            if (hasClickedJSON) {
                navigateToJSONFragment(character)
            } else {
                // Navigate to WeatherFragment when Weather button is pressed
                navigateToWeatherFragment(character)
            }
        }

    }
}