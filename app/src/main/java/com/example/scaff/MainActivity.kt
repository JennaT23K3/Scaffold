package com.example.scaff

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.scaff.ui.theme.ScaffTheme
import androidx.compose.ui.graphics.vector.ImageVector
import org.w3c.dom.Text


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScaffTheme {
                ScaffoldApp()
            }
        }
    }
}


@Composable
fun ScaffoldApp() {
    Scaffold(
        topBar = {MyTopBar()},
        content = {Text("Content for Home Screen")},
        //bottomBar = {BottomAppBar {Text(text="Bottom Bar")}}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(){
    var expanded by remember { mutableStateOf(false)}
    TopAppBar(
        title = {Text("My app")},
        navigationIcon = {
            IconButton(
                onClick = {/*TODO*/},
            ) {
                androidx.compose.material3.Icon(Icons.Filled.Menu, contentDescription = null)
            }
        },
        actions = {
            IconButton(
                onClick = {
                    expanded = !expanded
                }
            ) {
                androidx.compose.material3.Icon(Icons.Filled.MoreVert, contentDescription = null)
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = {expanded= false}){
                TextButton(onClick = {/*TODO*/}) {Text("Info")}
                TextButton(onClick = {/*TODO*/}) {Text("Settings")}
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ScaffoldPreview() {
    ScaffTheme {
        ScaffoldApp()
    }
}