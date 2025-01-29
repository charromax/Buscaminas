package com.charr0max.buscaminas.settings.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    viewModel: SettingsScreenViewModel
) {
    val userName by viewModel.userName.collectAsStateWithLifecycle()
    var newName by remember { mutableStateOf(userName) }

    LaunchedEffect(userName) {
        newName = userName
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            label = { Text("Username") },
            value = newName,
            onValueChange = {
                newName = it
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                // save
                viewModel.save(newName)
            }
        ) {
            Text("Save")
        }
    }
}