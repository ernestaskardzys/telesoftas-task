package info.ernestas.gildedrose.controller;

import info.ernestas.gildedrose.kata.Item;
import info.ernestas.gildedrose.kata.ItemBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoseController.class);

    @GetMapping("/list")
    public Item listData() {
        LOGGER.info("Received list request");

        return ItemBuilder.item().setName("Test").build();
    }

}
