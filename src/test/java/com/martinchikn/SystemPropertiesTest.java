package com.martinchikn;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SystemPropertiesTest extends TestBase {

    @Test
    @DisplayName("Оформление заказа в интернет-магазине")
    void ecomTest() {
        step("Открываем главную страницу", () -> {
            open("");
        });

        step("Переходим на страницу товара", () -> {
            $(byText("ГРАДВИС Керамическая ваза")).click();
        });

        step("Добавляем товар в корзину", () -> {
            $("[name=\"add-to-cart\"]").click();
            $(byText("Оформение заказа")).click();
        });

        step("Заполняем данные покупателя", () -> {
            $("#billing_first_name").setValue("Тест");
            $("#billing_last_name").setValue("Тестов");
            $("#billing_address_1").setValue("ул Тестовая 5");
            $("#billing_city").setValue("Москва");
            $("#billing_state").setValue("Хамовники");
            $("#billing_postcode").setValue("101010");
            $("#billing_phone").setValue("79369363636");
            $("#billing_email").setValue("test@test.ru");
            $("#place_order").click();
        });

        step("Страница подтверждения заказа", () -> {
            $(".woocommerce-order").shouldHave(text("Ваш заказ принят. Благодарим вас."));
        });

    }

}