package kh.com.supheng.jetpack.compose.projectbank.Model.MVVM

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

data class ScreenState (
    val selectedIndex : Int = 0,
    val isMenuExpanded : Boolean = false
)
class ScreenACVM : ViewModel(){
    private val _state = MutableStateFlow(ScreenState())
    val state = _state.value.selectedIndex

    fun onItemSelected(index : Int){
        _state.value = _state.value.copy(selectedIndex = index)
    }
    fun onMenuToggle(expanded : Boolean){
        _state.value = _state.value.copy(isMenuExpanded = expanded)
    }
}
