package com.example.basefragment.Fragments.Base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import io.reactivex.disposables.CompositeDisposable


abstract class BaseFragmentWithViewModel<VB : ViewBinding, ViewModel : BaseViewModel> : Fragment() {

    open var useSharedViewModel: Boolean = false

    protected lateinit var viewModel: ViewModel
    protected abstract fun getViewModelClass(): Class<ViewModel>

    protected lateinit var binding: VB
    protected abstract fun getViewBinding(): VB

    private val disposableContainer = CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
        listeners()
    }

    open fun setUpViews() {}      // init

    abstract fun listeners()

    protected open fun observeView() {}

    protected open fun observers() {}

    private fun init() {
        binding = getViewBinding()

        viewModel = if (useSharedViewModel) {
            ViewModelProvider(requireActivity())[getViewModelClass()]
        } else {
            ViewModelProvider(this)[getViewModelClass()]
        }
    }

    override fun onDestroyView() {
        disposableContainer.clear()
        super.onDestroyView()
    }
}

