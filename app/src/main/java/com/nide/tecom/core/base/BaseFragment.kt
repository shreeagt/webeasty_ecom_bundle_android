package com.nide.tecom.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    abstract val layoutRes : Int
    abstract fun setUP()
    private  lateinit var _binding : ViewBinding
    var binding : VB? = null
                get() = _binding as VB?

    abstract val bindingInflater :(LayoutInflater,Int,ViewGroup?,Boolean) -> VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       _binding = bindingInflater(layoutInflater,layoutRes,container,false)
        setUP()
        return _binding.root
    }




}
