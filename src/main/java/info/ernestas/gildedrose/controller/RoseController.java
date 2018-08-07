package info.ernestas.gildedrose.controller;

import info.ernestas.gildedrose.model.response.ItemResponse;
import info.ernestas.gildedrose.service.CalculationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoseController.class);

    private final CalculationService calculationService;

    public RoseController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @GetMapping("/list")
    public List<ItemResponse> listData() {
        LOGGER.info("Received list request");

        return calculationService.listData();
    }

}
