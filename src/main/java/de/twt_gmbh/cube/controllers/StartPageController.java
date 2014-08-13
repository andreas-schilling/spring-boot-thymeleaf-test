package de.twt_gmbh.cube.controllers;

import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.twt_gmbh.cube.db.repositories.EngineRepository;
import de.twt_gmbh.cube.db.repositories.VehicleRepository;


@Controller
@RequestMapping("/start")
public class StartPageController
{
  @Autowired
  private VehicleRepository vehicleRepository;

  @Autowired
  private EngineRepository engineRepository;


  public StartPageController()
  {
    super();
  }


  @RequestMapping(method = RequestMethod.GET)
  public String overview( final Locale locale, final Model model )
  {
    model.addAttribute( "vehicleCount", String.valueOf( vehicleRepository.count() ) );
    model.addAttribute( "engineCount", String.valueOf( engineRepository.count() ) );

    final String formattedDate = DateTimeFormat.longDateTime().withLocale( locale ).print( DateTime.now() );
    model.addAttribute( "currentTime", formattedDate );

    return "start";
  }

}
