package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.components.MyListItem
import com.example.myapplication.ui.theme.MyApplicationTheme


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val context = LocalContext.current
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(stringResource(R.string.mylistapp))
                            },
                        )
                    }
                ) { innerPadding ->
                    MyListContent(
                        modifier = Modifier.padding(innerPadding),
                        onItemClicked = { item->
                            Toast.makeText(context, item.title, Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
    }
}


@Composable
fun MyListContent(modifier: Modifier = Modifier, onItemClicked: (MyItem)->Unit){
    LazyColumn(modifier = modifier) {
        itemsIndexed(TestItems.testItems){ index, item->
            MyListItem(
                title = item.title,
                description = item.description,
                onItemClick = {
                    onItemClicked(item)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyListPreview() {
    MyApplicationTheme {
        MyListContent(
            onItemClicked = {}
        )
    }
}