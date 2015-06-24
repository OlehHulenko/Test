package ua.hulenkoOleg;


import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.server.handler.gzip.GzipHandler;


public class hulenkoOleg {
    public static void main(String[] args) throws Exception
    {

           String jettyDistKeystore = "../../jetty-distribution/target/distribution/demo-base/etc/keystore";
            String keystorePath = System.getProperty(
                    "example.keystore", jettyDistKeystore);
            File keystoreFile = new File(keystorePath);
            if (!keystoreFile.exists())
            {
                throw new FileNotFoundException(keystoreFile.getAbsolutePath());
            }

            Server server = new Server();


            HttpConfiguration http_config = new HttpConfiguration();
            http_config.setSecureScheme("https");
            http_config.setSecurePort(8443);
            http_config.setOutputBufferSize(32768);


            ServerConnector http = new ServerConnector(server,
                    new HttpConnectionFactory(http_config));
            http.setPort(8080);
            http.setIdleTimeout(30000);

            SslContextFactory sslContextFactory = new SslContextFactory();
            sslContextFactory.setKeyStorePath(keystoreFile.getAbsolutePath());
            sslContextFactory.setKeyStorePassword("OBF:1vny1zlo1x8e1vnw1vn61x8g1zlu1vn4");
            sslContextFactory.setKeyManagerPassword("OBF:1u2u1wml1z7s1z7a1wnl1u2g");


            HttpConfiguration https_config = new HttpConfiguration(http_config);
            https_config.addCustomizer(new SecureRequestCustomizer());


            ServerConnector https = new ServerConnector(server,
                    new SslConnectionFactory(sslContextFactory,HttpVersion.HTTP_1_1.asString()),
                    new HttpConnectionFactory(https_config));
            https.setPort(8443);
            https.setIdleTimeout(500000);

            server.setConnectors(new Connector[] { http, https });

            server.setHandler(new HelloHandler());

            // Start the server
            server.start();
            server.join();
        }
    }
    }
}
