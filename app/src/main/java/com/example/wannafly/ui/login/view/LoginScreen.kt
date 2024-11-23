package com.example.wannafly.ui.login.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.isImeVisible
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wannafly.R
import com.example.wannafly.ui.login.uistate.SignInState

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    // TODO: this params will be removed when we had koin injection
    state: SignInState,
    onSingInClick: () -> Unit
) {
    val context = LocalContext.current
    LaunchedEffect(state.signInError) {
        state.signInError?.let { error ->
            Toast.makeText(
                context,
                error,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = if (WindowInsets.isImeVisible) {
                Modifier
                    .fillMaxSize()
                    .imePadding()
            } else {
                modifier
                    .fillMaxSize()
                    .imePadding()
            }
        ) {
            item {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Card(
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(16.dp)
                        ) {
                            var emailUpdate by remember { mutableStateOf("") }
                            var passwordUpdate by remember { mutableStateOf("") }
                            var passwordVisible by remember { mutableStateOf(false) }
                            Text(
                                text = "Let's Travel you in",
                                fontSize = 24.sp
                            )

                            Text(
                                text = "Discover the World with Every Sign In",
                                fontSize = 18.sp
                            )
                            Column(
                                modifier = Modifier
                                    .padding(vertical = 16.dp),
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                OutlinedTextField(
                                    value = emailUpdate,
                                    onValueChange = { emailUpdate = it },
                                    maxLines = 1,
                                    placeholder = {
                                        Text("Email")
                                    },
                                    shape = RoundedCornerShape(12.dp),
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Email,
                                        imeAction = ImeAction.Next
                                    ),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                )
                                OutlinedTextField(
                                    value = passwordUpdate,
                                    onValueChange = { passwordUpdate = it },
                                    maxLines = 1,
                                    placeholder = {
                                        Text("Password")
                                    },
                                    shape = RoundedCornerShape(12.dp),
                                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                                    trailingIcon = {
                                        val image = if (passwordVisible) Icons.Filled.CheckCircle else Icons.Filled.Close
                                        val description = if (passwordVisible) "Hide password" else "Show password"

                                        if (passwordUpdate.isNotEmpty()) {
                                            IconButton(
                                                onClick = { passwordVisible = !passwordVisible }
                                            ) {
                                                Icon(imageVector = image, contentDescription = description)
                                            }
                                        }
                                    },
                                    keyboardActions = KeyboardActions.Default,
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Password,
                                        imeAction = ImeAction.Done
                                    ),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                )
                                Row(
                                    horizontalArrangement = Arrangement.End,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                ) {
                                    Text(
                                        text = "Forgot password!",
                                        fontSize = 14.sp
                                    )
                                }
                            }
                            Row(
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Button(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    onClick = {

                                    }
                                ) {
                                    Text("Sign In")
                                }
                            }
                            Row(
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp)
                            ) {
                                Text("or sign in with")
                            }
                            Row(
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                ElevatedCard(
                                    // TODO: review how to goes to other screen with viewModel states
                                    onClick = onSingInClick
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .padding(8.dp)
                                    ) {
                                        Image(
                                            painter = painterResource(R.drawable.ic_google),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .size(36.dp)
                                        )
                                    }
                                }
                            }
                            Row(
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 26.dp)
                            ) {
                                Text(
                                    text = "Create account!",
                                    fontSize = 14.sp
                                )
                            }
                        }
                    }

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp)
                    ) {
                        // TODO: como faremos para estilizar um botao secundario?
                        Button(
                            colors = ButtonColors(
                                containerColor = Color.White,
                                contentColor = Color.White,
                                disabledContainerColor = Color.Gray,
                                disabledContentColor = Color.Gray
                            ),
                            modifier = Modifier
                                .fillMaxWidth(),
                            onClick = {

                            }
                        ) {
                            Text(
                                text = "Sign Up",
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                }
            }
        }
    }
}