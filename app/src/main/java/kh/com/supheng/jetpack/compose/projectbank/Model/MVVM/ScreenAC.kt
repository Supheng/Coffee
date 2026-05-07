package kh.com.supheng.jetpack.compose.projectbank.Model.MVVM

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenAC(viewModel: ScreenACVM = viewModel()){
    val state by viewModel.state.collectAsStateWithLifecycle()
    var items = listOf<String>("Home", "Setting", "Username")
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Notification") },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = ""
                    )
                },
                actions = {
                    IconButton(onClick = {expanded = true}) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "Menu"
                        )
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = {expanded = false}
                        ) {
                            DropdownMenuItem(
                                text = {Text("Setting")},
                                onClick = {}
                            )
                            HorizontalDivider()
                            DropdownMenuItem(
                                text = {Text("Username")},
                                onClick = {}
                            )
                            HorizontalDivider()
                            DropdownMenuItem(
                                text = {Text("Search")},
                                onClick = {}
                            )
                        }
                    }
                }
            )
        },

        bottomBar = {
            NavigationBar{
              items.forEachIndexed { index, item ->
                  NavigationBarItem(
                      selected = selected ==index,
                      onClick = {selected = index},
                      icon = {
                          when(item){
                              "Home" -> Icon(imageVector = Icons.Default.Home, contentDescription = "")
                              "Setting" -> Icon(imageVector = Icons.Default.Settings, contentDescription = "")
                              "Username" -> Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "")
                          }
                      }
                  )
              }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {}
            ) {
                Icon(imageVector = Icons.Default.Home, contentDescription = "")
            }
        }

    ) {padding ->
        Column(
            modifier = Modifier
                .padding(padding)
        ) {

        }
    }
}


@Preview(showBackground = false)
@Composable
fun ScreenACPreview(){
    ScreenAC()
}