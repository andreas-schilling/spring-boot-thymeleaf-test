package de.twt_gmbh.cube.controllers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import de.twt_gmbh.cube.db.repositories.VehicleRepository;
import de.twt_gmbh.cube.model.Vehicle;


@Controller
@RequestMapping("/vehicles")
public class VehiclesController
{
  @Autowired
  private VehicleRepository vehicleRepository;


  public VehiclesController()
  {
    super();
  }


  @RequestMapping(value = "/all", method = RequestMethod.GET, produces = { "application/json" })
  @ResponseStatus(HttpStatus.OK)
  public @ResponseBody Iterable<Vehicle> allWithMarshalling()
  {
    return vehicleRepository.findAll();
  }


  @RequestMapping(value = "/all", method = RequestMethod.GET)
  public String allWithView( final Locale locale, final Model model )
  {
    model.addAttribute( "vehicles", allWithMarshalling() );

    return "vehicles";
  }

}
