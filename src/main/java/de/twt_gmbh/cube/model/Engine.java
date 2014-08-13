package de.twt_gmbh.cube.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "CB_ENGINES")
public class Engine implements Nameable
{
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENG_SEQ")
  @SequenceGenerator(name = "ENG_SEQ", sequenceName = "ENG_SEQ")
  @Column(name = "ENG_ID")
  private Long id;

  @Column(name = "ENG_NAME")
  private String name;


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
    return getName();
  }


  public String getName()
  {
    return name;
  }


  public void setName( final String name )
  {
    this.name = name;
  }
}
