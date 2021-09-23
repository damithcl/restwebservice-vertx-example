package com.techprimers.vertx;


import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import io.netty.util.Timeout;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Handler;
import io.vertx.core.Verticle;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.http.HttpClientRequest;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;


public class App extends AbstractVerticle {

	private static Logger LOGGER = Logger.getLogger("InfoLogging");
	static JsonObject json;
    public static void main(String[] args) {
    	

    	PropertyConfigurator.configure(System.getProperty("user.dir")+"/log4j.properties");
    	final HttpServerOptions httpServerOptions = new HttpServerOptions();
    	httpServerOptions.setAcceptBacklog(10000);
    	DeploymentOptions options = new DeploymentOptions().setInstances(30);
    	final Vertx vertx = Vertx.vertx();
    	final HttpServer httpServer = vertx.createHttpServer(httpServerOptions);
    	final Router router = Router.router(vertx);
    	vertx.deployVerticle((App.class), options);

          	  Route CelcomTypeCheck = router
	                     .get("/celcom/:msisdn/getsubscribertype")
	                     .produces("application/json")
	                     .handler(routingContext -> {
	                    	 HttpServerResponse response = routingContext.response();
	                      //  response.setChunked(true);
	                         String JsonResponse = "{\n" + 
	                         		"  \"getSubscriberTypeResponse\": {\n" + 
	                         		"    \"msisdn\": \"60194016983\",\n" + 
	                         		"    \"imsi\": \"502191347348042\",\n" + 
	                         		"    \"userType\": \"postpaid\",\n" + 
	                         		"    \"userStatus\": \"Active\",\n" + 
	                         		"    \"mvno\": \"No\"\n" + 
	                         		"  }\n" + 
	                         		"}";  

	        	 	                       
	        	 	                      vertx.setTimer(TimeUnit.MILLISECONDS.toMillis(333), l -> {
	        	 	                    	  json = new JsonObject(JsonResponse);
	             	                         response.putHeader("Content-Type", "application/json; charset=UTF8")
	             	                         .setStatusCode(200);
	             	                        response.end(Json.encodePrettily(json));
	             	                       LOGGER.info("-----getsubscribertype -8093----------");
	         	                          });
	                    });
        httpServer
                .requestHandler(router::accept)
                .listen(8090);

    }
}
