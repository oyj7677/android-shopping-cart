package nextstep.shoppingcart.ui.cart.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.data.cart.CartItem
import nextstep.shoppingcart.ui.iconpack.IconPack
import nextstep.shoppingcart.ui.iconpack.iconpack.IcMinus
import nextstep.shoppingcart.ui.iconpack.iconpack.IcPlus

@Composable
fun PriceQuantityInfo(
    modifier: Modifier = Modifier,
    cartItem: CartItem,
    onClickMinus:() -> Unit,
    onClickPlus: () -> Unit
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.End,
    ) {
        Spacer(modifier = modifier)

        Text(
            modifier = Modifier.padding(8.dp),
            text = stringResource(id = R.string.formatted_price, cartItem.product.price),
            textAlign = TextAlign.Center,
            fontSize = 22.sp,
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                modifier = Modifier.testTag(stringResource(id =R.string.test_tag_minus_icon, cartItem.product.name)),
                onClick = onClickMinus
            ) {
                Icon(
                    imageVector = IconPack.IcMinus,
                    contentDescription = stringResource(id = R.string.text_minus_Icon_description)
                )
            }
            Text(
                text = cartItem.count.toString(),
                textAlign = TextAlign.Center,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyMedium
            )
            IconButton(
                modifier = Modifier.testTag(stringResource(id =R.string.test_tag_plus_icon, cartItem.product.name)),
                onClick = onClickPlus
            ) {
                Icon(
                    imageVector = IconPack.IcPlus,
                    contentDescription = stringResource(id = R.string.text_plus_Icon_description)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PriceQuantityInfoPreview() {
    PriceQuantityInfo(Modifier, CartItem(Product(1, "name", "1000", 10000), 3), {}, {})
}