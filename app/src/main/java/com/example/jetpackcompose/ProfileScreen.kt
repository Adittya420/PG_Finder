package com.example.jetpackcompose

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

/*
                    Text(text = "   Cancel   ", color = Color.White, textAlign = TextAlign.Center,
                        modifier = Modifier
                            .clickable { notification.value = "Cancelled" }
                            .padding(8.dp, 9.dp, 0.dp, 8.dp)
                            .fillMaxHeight()
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        Color.Cyan,
                                        "#181852".color,
                                        "#0b0a25".color
                                    )
                                )
                            )
                    )
                    //.background(color = "#ba160c".color)//orange red
                    Text(text = "     Save     ", color = Color.White,//"#ff8c00".color,
                        modifier = Modifier
                            .clickable { notification.value = "Profile updated" }
                            .padding(0.dp, 9.dp, 9.dp, 8.dp)
                            .fillMaxHeight()
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        Color.Cyan,
                                        "#181852".color,
                                        "#0b0a25".color
                                    )
                                )
                            ))*/
