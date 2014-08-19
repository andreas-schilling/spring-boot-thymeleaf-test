package de.twt_gmbh.cube.controllers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import de.twt_gmbh.cube.db.repositories.EngineRepository;
import de.twt_gmbh.cube.model.Engine;


@Controller
@RequestMapping("/engines")
public class EnginesController
{
  @Autowired
  private EngineRepository engineRepository;


  public EnginesController()
  {
    super();
  }


  @RequestMapping(value = "/all", method = RequestMethod.GET, produces = { "application/json" })
  @ResponseStatus(HttpStatus.OK)
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public @ResponseBody Iterable<Engine> allWithMarshalling()
  {
    return engineRepository.findAll();
  }


  @RequestMapping(value = "/all", method = RequestMethod.GET)
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public String allWithView( final Locale locale, final Model model )
  {
    //model.addAttribute( "engines", allWithMarshalling() );

    return "engines";
  }

}
