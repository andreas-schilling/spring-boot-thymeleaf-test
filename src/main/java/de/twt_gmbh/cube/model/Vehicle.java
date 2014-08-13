package de.twt_gmbh.cube.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.google.common.base.Joiner;


@Entity
@Table(name = "CB_VEHICLES")
public class Vehicle implements Nameable
{
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VEH_SEQ")
  @SequenceGenerator(name = "VEH_SEQ", sequenceName = "VEH_SEQ")
  @Column(name = "VEH_ID")
  private Long id;

  @Column(name = "VEH_NAME")
  private String name;

  @ManyToOne(optional = false)
  @Fetch(FetchMode.JOIN)
  @JoinColumn(name = "VEH_ENG_ID", nullable = false)
  private Engine engine;


  public Long getId()
  {
    return id;
  }


  public void setId( final Long id )
  {
    this.id = id;
  }


  @Override
  public String getLabel()
  {
    return Joiner.on( " " ).join( getName(), getEngine().getLabel() );
  }


  public String getName()
  {
    return name;
  }


  public void setName( final String name )
  {
    this.name = name;
  }


  /**
   * @return the engine
   */
  public Engine getEngine()
  {
    return engine;
  }


  /**
   * @param engine the engine to set
   */
  public void setEngine( final Engine engine )
  {
    this.engine = engine;
  }
}
