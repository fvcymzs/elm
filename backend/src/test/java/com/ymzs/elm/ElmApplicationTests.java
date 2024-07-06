package com.ymzs.elm;

import java.awt.image.BufferedImage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ymzs.elm.service.DeliveryaddressService;
import com.ymzs.elm.service.UserService;
import com.ymzs.elm.utils.Text2Img;

@SpringBootTest
class ElmApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    DeliveryaddressService deliveryaddressService;

    @Test
    void contextLoads() {
        BufferedImage createImage = Text2Img.createImage("A", "Arial", 48);
        String imageToBase64 = Text2Img.imageToBase64(createImage);
        System.out.println(imageToBase64);
    }

}