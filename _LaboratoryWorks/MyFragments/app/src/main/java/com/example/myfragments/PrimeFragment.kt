package com.example.myfragments

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PrimeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_prime, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val movies = listOf(
            Movie("The Matrix", R.drawable.matrix, " science fiction classic that explores the concept of a simulated reality. " +
                    "In a dystopian future, a computer hacker named Neo (Keanu Reeves) discovers that the world he lives in is a complex computer program created by machines to subdue humanity. "),
            Movie("Inception", R.drawable.inception, "Directed by Christopher Nolan, 'Inception' is a mind-bending heist thriller. " +
                    "Dom Cobb (Leonardo DiCaprio) is a skilled thief who specializes in infiltrating the subconscious of his targets to steal their deepest secrets. "),
            Movie("Yoton Yo", R.drawable.yotonyo, "\"Yoton Yo\" is a captivating Finnish film that delves into the mystical and enigmatic world of the Northern Lights. " +
                    "Set in the remote landscapes of Lapland, the film follows the journey of a young photographer, Sari, who becomes obsessed with capturing the perfect shot of the aurora borealis. "),
            Movie("Chronicles of Eterna", R.drawable.eterna, "In a fantastical realm where magic and technology coexist, " +
                    "\"Chronicles of Eterna\" weaves an epic tale of a reluctant hero, Alaric, who discovers he possesses a unique power that can shape the destiny of his world.")
        )

        val adapter = MoviesAdapter(movies) { selectedMovie ->
            // Handle item click here, e.g., navigate to detail screen
            // You can use 'selectedMovie' to access the clicked movie

            // Get the NavController
            val navController = Navigation.findNavController(requireView())

            // Create a bundle to pass data to SecundaFragment (if needed)
            val bundle = bundleOf("movie" to selectedMovie)

            // Navigate to SecundaFragment with the provided bundle
            navController.navigate(R.id.showMovieDetail, bundle)
        }


        recyclerView.adapter = adapter
    }
}