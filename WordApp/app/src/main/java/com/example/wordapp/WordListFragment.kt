package com.example.wordapp


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wordapp.databinding.FragmentWordListBinding


class WordListFragment : Fragment() {
    companion object{
        const val LETTER = "letter"
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }

    //getting a reference of the binding object
    private var _binding: FragmentWordListBinding? = null
    //get only variable equal to to a not-null version of _binding
    private val binding get() = _binding!!

    //performing layout inflation
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWordListBinding.inflate(inflater, container, false)
        return binding.root

    }
    private lateinit var recyclerView: RecyclerView
    //performing view binding and setup
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //fragments don't have intent property hence use activity?.intent?
        val letterId = activity?.intent?.extras?.getString(LETTER).toString()

        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = WordAdapter(letterId , requireContext())

        //adding divider decoration
        recyclerView.addItemDecoration(
            DividerItemDecoration(this.requireContext(), DividerItemDecoration.VERTICAL)
        )

    }

    //resetting binding to null
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}