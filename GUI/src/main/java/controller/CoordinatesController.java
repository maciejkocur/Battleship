package controller;

import model.Coordinates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * Created by bartlomiej on 04.08.16.
 */
@Controller
@RequestMapping("/coordinates")
public class CoordinatesController {

    private Coordinates coordinates;

    @Autowired
    public CoordinatesController(Coordinates coordinates){
        this.coordinates=coordinates;
    }

    @RequestMapping(method= RequestMethod.GET,produces = "application/json")
    public @ResponseBody List coords(){
        return coordinates.showCoordinates();
    }

}
