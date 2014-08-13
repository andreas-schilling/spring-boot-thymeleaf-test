package de.twt_gmbh.cube.configuration.db;

import java.sql.SQLException;

import org.h2.tools.Server;


/**
 * H2 initializing helper to avoid ugly exceptions due to Spring accessing the Server classes
 * and for easier starting/stoppping of the Server.
 * 
 * @author aschilling
 *
 */
public class H2ServerPublisher
{
  private Server webServer;
  private Server server;


  public H2ServerPublisher()
  {
    super();
  }


  /**
   * Starts the Web and TCP H2 servers with default settings.
   * 
   * @throws SQLException
   */
  public void start() throws SQLException
  {
    webServer =
            Server.createWebServer( "-web", "-webAllowOthers", "-webPort", "8089" )
                    .start();
    server =
            Server.createTcpServer( "-tcp", "-tcpAllowOthers", "-tcpPort", "9099" )
                    .start();
  }


  /**
   * Stops the Web and TCP H2 servers.
   */
  public void stop()
  {
    if( server != null )
    {
      server.stop();
    }
    if( webServer != null )
    {
      webServer.stop();
    }
  }
}
