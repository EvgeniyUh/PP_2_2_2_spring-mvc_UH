package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {

    @GetMapping(value = "/cars")
    public String printCars(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {
        List<Car> cars = new ArrayList<>();
/*        for (int i = 0; i < 5; i++) {
            cars.add(new Car("model" + i, i, 1980 + i));
        }*/
        cars.add(new Car("model1", 1, 1981));
        cars.add(new Car("model2", 2, 1982));
        cars.add(new Car("model3", 3, 1983));
        cars.add(new Car("model4", 4, 1984));
        cars.add(new Car("model5", 5, 1985));

        if (count == null || count >= 5) {
            model.addAttribute("cars", cars);
        } else {
            model.addAttribute("cars", cars.subList(0, count));
        }
        return "cars";
    }
}
