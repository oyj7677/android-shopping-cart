package nextstep.shoppingcart

import android.content.Context
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.core.app.ApplicationProvider
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.data.cart.Cart
import nextstep.shoppingcart.ui.cart.CartScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CartScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    var context: Context = ApplicationProvider.getApplicationContext()

    @Before
    fun setup() {
        Cart.itemAllClear()
    }

    @Test
    fun 담긴_상품_가격의_총합이_노출된다() {
        Cart.addOne(Product(1, "https://picsum.photos/seed/1/200", "상품 1", 1000))
        Cart.addOne(Product(1, "https://picsum.photos/seed/1/200", "상품 1", 1000))
        Cart.addOne(Product(1, "https://picsum.photos/seed/1/200", "상품 1", 1000))

        composeTestRule.setContent {
            CartScreen(modifier = Modifier)
        }

        val actual = "${context.getString(R.string.text_shopping_cart_order)}(${context.getString(R.string.formatted_price, 3000)})"

        composeTestRule
            .onNodeWithTag(context.getString(R.string.test_tag_cart_bottom_bar))
            .assertTextEquals(actual)
    }

    @Test
    fun 담긴_상품을_제거할_수_있다() {
        Cart.addOne(Product(1, "https://picsum.photos/seed/1/200", "상품 1", 1000))

        composeTestRule.setContent {
            CartScreen(modifier = Modifier)
        }

        composeTestRule
            .onNodeWithTag(context.getString(R.string.test_tag_remove_icon, "상품 1"))
            .performClick()

        composeTestRule
            .onNodeWithTag(context.getString(R.string.test_tag_cart_card, "상품 1"))
            .assertDoesNotExist()
    }

    @Test
    fun 담긴_상품의_수량을_증가시키면_상품_가격에_반영된다() {
        Cart.addOne(Product(1, "https://picsum.photos/seed/1/200", "상품 1", 1000))
        Cart.addOne(Product(1, "https://picsum.photos/seed/1/200", "상품 2", 2000))

        composeTestRule.setContent {
            CartScreen(modifier = Modifier)
        }

        composeTestRule
            .onNodeWithTag(context.getString(R.string.test_tag_plus_icon, "상품 1"))
            .performClick()

        val actual = "${context.getString(R.string.text_shopping_cart_order)}(${
            context.getString(
                R.string.formatted_price,
                4000
            )
        })"

        composeTestRule
            .onNodeWithTag(context.getString(R.string.test_tag_cart_bottom_bar))
            .assertTextEquals(actual)
    }

    @Test
    fun 담긴_상품의_수량을_감소시키면_상품_가격에_반영된다() {
        Cart.addOne(Product(1, "https://picsum.photos/seed/1/200", "상품 1", 1000))
        Cart.addOne(Product(1, "https://picsum.photos/seed/1/200", "상품 2", 2000))

        composeTestRule.setContent {
            CartScreen(modifier = Modifier)
        }

        composeTestRule
            .onNodeWithTag(context.getString(R.string.test_tag_minus_icon, "상품 1"))
            .performClick()

        val actual = "${context.getString(R.string.text_shopping_cart_order)}(${
            context.getString(
                R.string.formatted_price,
                2000
            )
        })"

        composeTestRule
            .onNodeWithTag(context.getString(R.string.test_tag_cart_bottom_bar))
            .assertTextEquals(actual)
    }

    @Test
    fun 담긴_상품의_수량을_1보다_적게_하면_상품이_삭제된다() {
        Cart.addOne(Product(1, "https://picsum.photos/seed/1/200", "상품 1", 1000))

        composeTestRule.setContent {
            CartScreen(modifier = Modifier)
        }

        composeTestRule
            .onNodeWithTag(context.getString(R.string.test_tag_minus_icon, "상품 1"))
            .performClick()

        composeTestRule
            .onNodeWithTag(context.getString(R.string.test_tag_minus_icon, "상품 1"))
            .assertDoesNotExist()

    }
}