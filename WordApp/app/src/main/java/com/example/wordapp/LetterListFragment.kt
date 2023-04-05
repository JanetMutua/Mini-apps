package com.example.wordapp

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wordapp.databinding.FragmentLetterListBinding

class LetterListFragment : Fragment() {

    //getting a nullable reference to FragmentLetterListBinding
    private var _binding: FragmentLetterListBinding? = null

    private val binding get () = _binding!!


    //displaying the options menu
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    //inflating the layout using onCreateView()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLetterListBinding.inflate(inflater, container, false )
        val view = binding.root
        //returning the  root view
        return view
    }


    //creating a property for the RecyclerView
    private lateinit var recyclerView: RecyclerView
    private var isLinearLayout = true

    //setting the value of the recyclerView in onViewCreated
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerView
        layoutToggle()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.layout_menu, menu)

        val layoutButton = menu.findItem(R.id.action_switch_layout)
        setIcon(layoutButton)
    }

    private fun layoutToggle(){
        when(isLinearLayout){
            true -> {
                recyclerView.layoutManager = LinearLayoutManager(context)
                recyclerView.adapter = LetterAdapter()
            }
            false -> {
                recyclerView.layoutManager = GridLayoutManager(context, 4)
                recyclerView.adapter = LetterAdapter()
            }
        }
    }
    private fun setIcon(menuItem: MenuItem?){
        if (menuItem == null)
            return
        menuItem.icon =
            if (isLinearLayout)
                //requireContext() returns the Context this fragment is associated with
                ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_grid_layout)
            else ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_linear_layout)
    }

    //  function that sets the actual layout and calls the layoutToggle() function
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_switch_layout -> {
                isLinearLayout = !isLinearLayout
                layoutToggle()
                setIcon(item)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}