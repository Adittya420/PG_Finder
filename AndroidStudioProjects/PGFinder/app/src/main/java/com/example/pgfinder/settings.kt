package com.example.pgfinder

//import android.graphics.Color
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.compose.rememberNavController
import com.example.pgfinder.ui.theme.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.oAuthProvider
import com.google.firebase.ktx.Firebase
private lateinit var auth: FirebaseAuth
@OptIn(ExperimentalMaterialApi::class)


//@Composable
//fun SettingsScreen(
//    onClick: () -> Unit
//) {
//
//    Column(
//        modifier = androidx.compose.ui.Modifier
//            .background(Grey)
//            .fillMaxSize()
//    ) {
//
////        HeaderText()
//        ProfileCardUI ()
////        GeneralOptionsUI()
////        SupportOptionsUI()
//    }
//}



@Composable
fun HeaderText() {
    Text(
        text = "Settings",
        fontFamily = Poppins,
        color = SecondaryColor,
        textAlign = TextAlign.Center,
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            .padding(top = 30.dp, bottom = 10.dp),
        fontWeight = FontWeight.ExtraBold,
        fontSize = 16.sp
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProfileCardUI(
    onViewButtonClick: () -> Unit,
    OnCustumisationClick: () -> Unit,
    ) {
    auth = Firebase.auth
    val user = auth.currentUser
    Column(
        modifier = androidx.compose.ui.Modifier
            .background(Grey)
            .fillMaxSize()
    ) {

        Text(
            text = "Settings",
            fontFamily = Poppins,
            color = SecondaryColor,
            textAlign = TextAlign.Center,
            modifier = androidx.compose.ui.Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, bottom = 10.dp),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 16.sp
        )

        Card(
            modifier = androidx.compose.ui.Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(10.dp),
            backgroundColor = White,
            elevation = 0.dp,
            shape = Shapes1.large
        ) {
            Row(
                modifier = androidx.compose.ui.Modifier.padding(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column() {
                    val user = auth.currentUser
                    Text(
                        text = "Check Your Profile",
                        fontFamily = Poppins,
                        color = SecondaryColor,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                    )

                    if (user != null) {
                        Text(
                            text = user.email.toString(),
                            fontFamily = Poppins,
                            color = Gray,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.SemiBold,
                        )
                    }

                    Button(
                        modifier = androidx.compose.ui.Modifier.padding(top = 10.dp),
                        onClick = {
                            onViewButtonClick()
                        },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = PrimaryColor
                        ),
                        contentPadding = PaddingValues(horizontal = 30.dp),
                        elevation = ButtonDefaults.elevation(
                            defaultElevation = 0.dp,
                            pressedElevation = 2.dp
                        ),
                        shape = Shapes1.medium
                    ) {
                        Text(
                            text = "View",
                            fontFamily = Poppins,
                            color = SecondaryColor,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                Image(
                    painter = painterResource(id = R.drawable.ic_profile_card_image),
                    contentDescription = "",
                    modifier = androidx.compose.ui.Modifier.height(120.dp)
                )
            }
        }
        Column(
            modifier = androidx.compose.ui.Modifier
                .padding(horizontal = 14.dp)
                .padding(top = 10.dp)
        ) {
            Text(
                text = "General",
                fontFamily = Poppins,
                color = SecondaryColor,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = androidx.compose.ui.Modifier
                    .padding(vertical = 8.dp)
            )
            GeneralSettingItem(
                icon = R.drawable.ic_rounded_notification,
                mainText = "Notifications",
                subText = "Customize notifications",
                onClick = {}
            )
            GeneralSettingItem(
                icon = R.drawable.ic_more,
                mainText = "More customization",
                subText = "Customize it more to fit your usage",
                onClick = {
                    OnCustumisationClick()
                }
            )
//        GeneralSettingItem()
        }
        Column(
            modifier = androidx.compose.ui.Modifier
                .padding(horizontal = 14.dp)
                .padding(top = 10.dp)
        ) {
            Text(
                text = "Support",
                fontFamily = Poppins,
                color = SecondaryColor,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = androidx.compose.ui.Modifier
                    .padding(vertical = 8.dp)
            )
            SupportItem(
                icon = R.drawable.ic_whatsapp,
                mainText = "Contact",
                onClick = {}
            )
            SupportItem(
                icon = R.drawable.ic_feedback,
                mainText = "Feedback",
                onClick = {}
            )
            SupportItem(
                icon = R.drawable.ic_privacy_policy,
                mainText = "Privacy Policy",
                onClick = {}
            )
            SupportItem(
                icon = R.drawable.ic_about,
                mainText = "About",
                onClick = {}
            )
        }
//        Button(
//            modifier = androidx.compose.ui.Modifier.padding(top = 10.dp),
//            onClick = {
////                onViewButtonClick()
//                auth.signOut()
//
//
//            },
//            colors = ButtonDefaults.buttonColors(
//                backgroundColor = PrimaryColor
//            ),
//            contentPadding = PaddingValues(horizontal = 30.dp),
//            elevation = ButtonDefaults.elevation(
//                defaultElevation = 0.dp,
//                pressedElevation = 2.dp
//            ),
//            shape = Shapes1.medium
//        ) {
//            Text(
//                text = "SignOut",
//                fontFamily = Poppins,
//                color = SecondaryColor,
//                fontSize = 12.sp,
//                fontWeight = FontWeight.Bold
//            )
//        }
    }

}

    @ExperimentalMaterialApi
    @Composable
    fun GeneralOptionsUI() {
        Column(
            modifier = androidx.compose.ui.Modifier
                .padding(horizontal = 14.dp)
                .padding(top = 10.dp)
        ) {
            Text(
                text = "General",
                fontFamily = Poppins,
                color = SecondaryColor,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = androidx.compose.ui.Modifier
                    .padding(vertical = 8.dp)
            )
            GeneralSettingItem(
                icon = R.drawable.ic_rounded_notification,
                mainText = "Notifications",
                subText = "Customize notifications",
                onClick = {}
            )
            GeneralSettingItem(
                icon = R.drawable.ic_more,
                mainText = "More customization",
                subText = "Customize it more to fit your usage",
                onClick = {}
            )
//        GeneralSettingItem()
            Column(
                modifier = androidx.compose.ui.Modifier
                    .padding(horizontal = 14.dp)
                    .padding(top = 10.dp)
            ) {
                Text(
                    text = "Support",
                    fontFamily = Poppins,
                    color = SecondaryColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = androidx.compose.ui.Modifier
                        .padding(vertical = 8.dp)
                )
                SupportItem(
                    icon = R.drawable.ic_whatsapp,
                    mainText = "Contact",
                    onClick = {}
                )
                SupportItem(
                    icon = R.drawable.ic_feedback,
                    mainText = "Feedback",
                    onClick = {}
                )
                SupportItem(
                    icon = R.drawable.ic_privacy_policy,
                    mainText = "Privacy Policy",
                    onClick = {}
                )
                SupportItem(
                    icon = R.drawable.ic_about,
                    mainText = "About",
                    onClick = {}
                )
            }
        }
    }

    @ExperimentalMaterialApi
    @Composable
    fun GeneralSettingItem(icon: Int, mainText: String, subText: String, onClick: () -> Unit) {
        Card(
            onClick = { onClick() },
            backgroundColor = White,
            modifier = androidx.compose.ui.Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth(),
            elevation = 0.dp,
        ) {
            Row(
                modifier = androidx.compose.ui.Modifier.padding(
                    vertical = 10.dp,
                    horizontal = 14.dp
                ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = androidx.compose.ui.Modifier
                            .size(34.dp)
                            .clip(shape = Shapes.medium)
                            .background(LightPrimaryColor)
                    ) {
                        Icon(
                            painter = painterResource(id = icon),
                            contentDescription = "",
                            tint = androidx.compose.ui.graphics.Color.Unspecified,
                            modifier = androidx.compose.ui.Modifier.padding(8.dp)
                        )
                    }

                    Spacer(modifier = androidx.compose.ui.Modifier.width(14.dp))
                    Column(
                        modifier = androidx.compose.ui.Modifier.offset(y = (2).dp)
                    ) {
                        Text(
                            text = mainText,
                            fontFamily = Poppins,
                            color = SecondaryColor,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                        )

                        Text(
                            text = subText,
                            fontFamily = Poppins,
                            color = Gray,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = androidx.compose.ui.Modifier.offset(y = (-4).dp)
                        )
                    }
                }
                Icon(
                    painter = painterResource(id = R.drawable.ic_right_arrow),
                    contentDescription = "",
                    modifier = androidx.compose.ui.Modifier.size(16.dp)
                )

            }
        }
    }

    @ExperimentalMaterialApi
    @Composable
    fun SupportOptionsUI() {
        Column(
            modifier = androidx.compose.ui.Modifier
                .padding(horizontal = 14.dp)
                .padding(top = 10.dp)
        ) {
            Text(
                text = "Support",
                fontFamily = Poppins,
                color = SecondaryColor,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = androidx.compose.ui.Modifier
                    .padding(vertical = 8.dp)
            )
            SupportItem(
                icon = R.drawable.ic_whatsapp,
                mainText = "Contact",
                onClick = {}
            )
            SupportItem(
                icon = R.drawable.ic_feedback,
                mainText = "Feedback",
                onClick = {}
            )
            SupportItem(
                icon = R.drawable.ic_privacy_policy,
                mainText = "Privacy Policy",
                onClick = {}
            )
            SupportItem(
                icon = R.drawable.ic_about,
                mainText = "About",
                onClick = {}
            )
        }
    }

    @ExperimentalMaterialApi
    @Composable
    fun SupportItem(icon: Int, mainText: String, onClick: () -> Unit) {
        Card(
            onClick = { onClick() },
            backgroundColor = White,
            modifier = androidx.compose.ui.Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth(),
            elevation = 0.dp,
        ) {
            Row(
                modifier = androidx.compose.ui.Modifier.padding(
                    vertical = 10.dp,
                    horizontal = 14.dp
                ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = androidx.compose.ui.Modifier
                            .size(34.dp)
                            .clip(shape = Shapes.medium)
                            .background(LightPrimaryColor)
                    ) {
                        Icon(
                            painter = painterResource(id = icon),
                            contentDescription = "",
                            tint = androidx.compose.ui.graphics.Color.Unspecified,
                            modifier = androidx.compose.ui.Modifier.padding(8.dp)
                        )
                    }

                    Spacer(modifier = androidx.compose.ui.Modifier.width(14.dp))

                    Text(
                        text = mainText,
                        fontFamily = Poppins,
                        color = SecondaryColor,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
                Icon(
                    painter = painterResource(id = R.drawable.ic_right_arrow),
                    contentDescription = "",
                    modifier = androidx.compose.ui.Modifier.size(16.dp)
                )

            }
        }
    }
