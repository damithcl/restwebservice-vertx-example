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

         
        	  Route CelcomAgeCheck = router
	                     .get("/celcom/:msisdn/getprofileretrieve")
	                     .produces("application/json")
	                     .handler(routingContext -> {
	                    	 HttpServerResponse response = routingContext.response();
	                      //  response.setChunked(true);
	                         String JsonResponse = "{\n" + 
	                         		"    \"outputSDResp\": {\n" + 
	                         		"        \"crmServiceID\": \"1-20RW-144\",\n" + 
	                         		"        \"imsi\": 502191347348042,\n" + 
	                         		"        \"icicID\": 896019180627105470,\n" + 
	                         		"        \"ivrLanguage\": null,\n" + 
	                         		"        \"serviceType\": \"CNVRGTPrepaid\",\n" + 
	                         		"        \"product\": \"Xpax RM10\",\n" + 
	                         		"        \"crmCustomerID\": \"1-20P2-184\",\n" + 
	                         		"        \"customerName\": \"1-1Z5KL977\",\n" + 
	                         		"        \"accountCategory\": \"NULL-Consumer\",\n" + 
	                         		"        \"dateOfBirth\": \"1950-01-01T00:00:00.000+07:30\",\n" + 
	                         		"        \"nationality\": null,\n" + 
	                         		"        \"race\": null,\n" + 
	                         		"        \"gender\": null,\n" + 
	                         		"        \"customerIDNo\": 500101123566,\n" + 
	                         		"        \"customerIDType\": \"New NRIC\",\n" + 
	                         		"        \"vipCode\": null,\n" + 
	                         		"        \"segmentGroup\": \"Consumer\",\n" + 
	                         		"        \"segmentCode\": null,\n" + 
	                         		"        \"segmentSubGroup\": \"Retail\",\n" + 
	                         		"        \"buildingName\": null,\n" + 
	                         		"        \"floorNumber\": null,\n" + 
	                         		"        \"streetType\": null,\n" + 
	                         		"        \"streetAddress\": 121,\n" + 
	                         		"        \"houseUnitLotNumber\": null,\n" + 
	                         		"        \"postcode\": 50001,\n" + 
	                         		"        \"poBox\": null,\n" + 
	                         		"        \"state\": \"WP\",\n" + 
	                         		"        \"city\": \"KUALA LUMPUR\",\n" + 
	                         		"        \"addressType\": null,\n" + 
	                         		"        \"bestCallTime\": null,\n" + 
	                         		"        \"tPIN\": null,\n" + 
	                         		"        \"ivrHotlineExclusion\": null,\n" + 
	                         		"        \"ivrVIPHotlineExclusion\": null,\n" + 
	                         		"        \"callerNumber\": \"0194016983\",\n" + 
	                         		"        \"assetStatus\": \"Active\",\n" + 
	                         		"        \"assetSubStatus\": \"Active\",\n" + 
	                         		"        \"firstCallActivationDate\": \"2018-12-05T00:00:00.000+08:00\",\n" + 
	                         		"        \"starterPackBrand\": null,\n" + 
	                         		"        \"starterPackName\": null,\n" + 
	                         		"        \"plan\": \"Xpax Plan\",\n" + 
	                         		"        \"registrationDate\": null,\n" + 
	                         		"        \"ccToken\": \"N\",\n" + 
	                         		"        \"eliteIndicator\": \"N\",\n" + 
	                         		"        \"serviceBundleClass\": \"Mobile Service ICC\",\n" + 
	                         		"        \"creditLimit\": \"RM.00\",\n" + 
	                         		"        \"errorCode\": \"OK\",\n" + 
	                         		"        \"errorMessage\": null\n" + 
	                         		"    }\n" + 
	                         		"}";  
	                         

	        	 	                       
	        	 	                      vertx.setTimer(TimeUnit.MILLISECONDS.toMillis(334), l -> {
	        	 	                    	  json = new JsonObject(JsonResponse);
	             	                         response.putHeader("Content-Type", "application/json; charset=UTF8")
	             	                         .setStatusCode(200);
	             	                        response.end(Json.encodePrettily(json));
	             	                       LOGGER.info("-----getprofileretrive-8093----------");
	         	                          });
	        	 	                 

	                    });    	
    	
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
        	  
        

	    	Route elkPaymentResponse = router
                    .post("/:msisdn/transactions/amount")
                    .produces("application/json")
                    .handler(routingcontext -> {
                    	HttpServerResponse response = routingcontext.response();
                        String jsonResponse ="{\n" + 
                        		"    \"outputsdresp\": {\n" + 
                        		"        \"crmserviceid\": \"1-20rw-144\",\n" + 
                        		"        \"imsi\": 502191347348042,\n" + 
                        		"        \"icicid\": 896019180627105470,\n" + 
                        		"        \"ivrlanguage\": null,\n" + 
                        		"        \"servicetype\": \"cnvrgtprepaid\",\n" + 
                        		"        \"product\": \"xpax rm10\",\n" + 
                        		"        \"crmcustomerid\": \"1-20p2-184\",\n" + 
                        		"        \"customername\": \"1-1z5kl977\",\n" + 
                        		"        \"accountcategory\": \"null-consumer\",\n" + 
                        		"        \"dateofbirth\": \"1950-01-01t00:00:00.000+07:30\",\n" + 
                        		"        \"nationality\": null,\n" + 
                        		"        \"race\": null,\n" + 
                        		"        \"gender\": null,\n" + 
                        		"        \"customeridno\": 500101123566,\n" + 
                        		"        \"customeridtype\": \"new nric\",\n" + 
                        		"        \"vipcode\": null,\n" + 
                        		"        \"segmentgroup\": \"consumer\",\n" + 
                        		"        \"segmentcode\": null,\n" + 
                        		"        \"segmentsubgroup\": \"retail\",\n" + 
                        		"        \"buildingname\": null,\n" + 
                        		"        \"floornumber\": null,\n" + 
                        		"        \"streettype\": null,\n" + 
                        		"        \"streetaddress\": 121,\n" + 
                        		"        \"houseunitlotnumber\": null,\n" + 
                        		"        \"postcode\": 50001,\n" + 
                        		"        \"pobox\": null,\n" + 
                        		"        \"state\": \"wp\",\n" + 
                        		"        \"city\": \"kuala lumpur\",\n" + 
                        		"        \"addresstype\": null,\n" + 
                        		"        \"bestcalltime\": null,\n" + 
                        		"        \"tpin\": null,\n" + 
                        		"        \"ivrhotlineexclusion\": null,\n" + 
                        		"        \"ivrviphotlineexclusion\": null,\n" + 
                        		"        \"callernumber\": \"0194016983\",\n" + 
                        		"        \"assetstatus\": \"active\",\n" + 
                        		"        \"assetsubstatus\": \"active\",\n" + 
                        		"        \"firstcallactivationdate\": \"2018-12-05t00:00:00.000+08:00\",\n" + 
                        		"        \"starterpackbrand\": null,\n" + 
                        		"        \"starterpackname\": null,\n" + 
                        		"        \"plan\": \"xpax plan\",\n" + 
                        		"        \"registrationdate\": null,\n" + 
                        		"        \"cctoken\": \"n\",\n" + 
                        		"        \"eliteindicator\": \"n\",\n" + 
                        		"        \"servicebundleclass\": \"mobile service icc\",\n" + 
                        		"        \"creditlimit\": \"rm.00\",\n" + 
                        		"        \"errorcode\": \"ok\",\n" + 
                        		"        \"errormessage\": null\n" + 
                        		"    }\n" + 
                        		"}";
                    	
                        vertx.setTimer(TimeUnit.MILLISECONDS.toMillis(1000), l -> {
	 	                    	  json = new JsonObject(jsonResponse);
  	                         response.putHeader("Content-Type", "application/json; charset=UTF8")
  	                         .setStatusCode(200);
  	                        response.end(Json.encodePrettily(json));
  	                       LOGGER.info("-----ELK--Payment-8093----------");
	                          });
                       

                        
                   });
      		    	 
        		    	 Route xlTypeCheck = router
        	                     .get("/xl/:msisdn/getsubscribertype")
        	                     .produces("application/json")
        	                     .handler(routingcontext -> {
        	                         HttpServerResponse response = routingcontext.response();
        	                         String jsonResponse ="{\n" + 
        	                         		"    \"subsInfoRs\": {\n" + 
        	                         		"        \"msisdn\": \"62000000000\",\n" + 
        	                         		"        \"type\": \"0\",\n" + 
        	                         		"        \"activeDate\": \"Fri Mar 17 07:00:00 WIT 2017\",\n" + 
        	                         		"        \"responseCode\": \"00\",\n" + 
        	                         		"        \"responseMessage\": \"success\"\n" + 
        	                         		"    }\n" + 
        	                         		"}";
        	                         vertx.setTimer(TimeUnit.MILLISECONDS.toMillis(333), l -> {
          	 	                    	  json = new JsonObject(jsonResponse);
               	                         response.putHeader("Content-Type", "application/json; charset=UTF8")
               	                         .setStatusCode(200);
               	                        response.end(Json.encodePrettily(json));
               	                       LOGGER.info("-----xl-subscriber-type-8093----------");
           	                          });
        	                        
        	                         
        	                         
        	                     });
        		    	 
        		    	 Route creditcontrol = router
        	                     .get("/creditcontrol/spentCredit/:msisdn")
        	                     .produces("application/json")
        	                     .handler(routingcontext -> {
        	                         HttpServerResponse response = routingcontext.response();
        	                         
        	                         String jsonResponse ="{\n" + 
        	                         		"    \"records\": [\n" + 
        	                         		"        {\n" + 
        	                         		"            \"consumerKey\": \"K0dNFfGErBxx40A6_gnFpLdILS0a\",\n" + 
        	                         		"            \"amount\": 15\n" + 
        	                         		"        },\n" + 
        	                         		"        {\n" + 
        	                         		"            \"consumerKey\": \"v97o_0XadVSuPp0NtkSNpbJ_g98a\",\n" + 
        	                         		"            \"amount\": 25\n" + 
        	                         		"        }\n" + 
        	                         		"    ]\n" + 
        	                         		"}";
        	                         vertx.setTimer(TimeUnit.MILLISECONDS.toMillis(333), l -> {
       	 	                    	  json = new JsonObject(jsonResponse);
            	                         response.putHeader("Content-Type", "application/json; charset=UTF8")
            	                         .setStatusCode(200);
            	                        response.end(Json.encodePrettily(json));
            	                       LOGGER.info("-----cerdit-control-8093----------");
        	                          });
        	                        
        	                         
        	                         
        	                     });
        		    	 
        		    	 Route elkPaymentResponse20Kb = router
        		                    .post("/transactions/amount")
        		                    .produces("application/xml")
        		                    .handler(routingcontext -> {
        		                    	HttpServerResponse response = routingcontext.response();
        		                        String jsonResponse ="<soapenv:Body xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" + 
        		                        		"    <jsonObject>\n" + 
        		                        		"        <ResultHeader>\n" + 
        		                        		"            <Version>1</Version>\n" + 
        		                        		"            <ResultCode>0</ResultCode>\n" + 
        		                        		"            <ResultDesc>Operation successfully.</ResultDesc>\n" + 
        		                        		"        </ResultHeader>\n" + 
        		                        		"        <QueryCustomerInfoResult>\n" + 
        		                        		"            <Customer>\n" + 
        		                        		"                <CustKey>CBS237294000025371930</CustKey>\n" + 
        		                        		"                <CustInfo>\n" + 
        		                        		"                    <CustType>1</CustType>\n" + 
        		                        		"                    <CustNodeType>1</CustNodeType>\n" + 
        		                        		"                    <CustClass>1</CustClass>\n" + 
        		                        		"                    <CustCode>CBS237294000025371940</CustCode>\n" + 
        		                        		"                    <CustBasicInfo>\n" + 
        		                        		"                        <DFTWrittenLang>2063</DFTWrittenLang>\n" + 
        		                        		"                        <DFTIVRLang>2063</DFTIVRLang>\n" + 
        		                        		"                        <CustLevel>1</CustLevel>\n" + 
        		                        		"                        <DunningFlag>1</DunningFlag>\n" + 
        		                        		"                    </CustBasicInfo>\n" + 
        		                        		"                </CustInfo>\n" + 
        		                        		"                <IndividualInfo>\n" + 
        		                        		"                    <FirstName>default</FirstName>\n" + 
        		                        		"                    <HomeAddressKey>CBS220000000016545538</HomeAddressKey>\n" + 
        		                        		"                    <Gender>1</Gender>\n" + 
        		                        		"                </IndividualInfo>\n" + 
        		                        		"                <AddressInfo>\n" + 
        		                        		"                    <AddressKey>CBS220000000016545538</AddressKey>\n" + 
        		                        		"                    <Address1>unknown</Address1>\n" + 
        		                        		"                </AddressInfo>\n" + 
        		                        		"            </Customer>\n" + 
        		                        		"            <Subscriber>\n" + 
        		                        		"                <SubscriberKey>CBS237294000025371932</SubscriberKey>\n" + 
        		                        		"                <SubscriberInfo>\n" + 
        		                        		"                    <SubBasicInfo>\n" + 
        		                        		"                        <WrittenLang>2063</WrittenLang>\n" + 
        		                        		"                        <IVRLang>2063</IVRLang>\n" + 
        		                        		"                        <DunningFlag>1</DunningFlag>\n" + 
        		                        		"                    </SubBasicInfo>\n" + 
        		                        		"                    <UserCustomerKey>CBS237294000025371930</UserCustomerKey>\n" + 
        		                        		"                    <SubIdentity>\n" + 
        		                        		"                        <SubIdentityType>1</SubIdentityType>\n" + 
        		                        		"                        <SubIdentity>1648435082</SubIdentity>\n" + 
        		                        		"                        <PrimaryFlag>1</PrimaryFlag>\n" + 
        		                        		"                    </SubIdentity>\n" + 
        		                        		"                    <SubIdentity>\n" + 
        		                        		"                        <SubIdentityType>2</SubIdentityType>\n" + 
        		                        		"                        <SubIdentity>470075002433017</SubIdentity>\n" + 
        		                        		"                        <PrimaryFlag>2</PrimaryFlag>\n" + 
        		                        		"                    </SubIdentity>\n" + 
        		                        		"                    <Brand>106</Brand>\n" + 
        		                        		"                    <SubClass>1</SubClass>\n" + 
        		                        		"                    <NetworkType>1</NetworkType>\n" + 
        		                        		"                    <Status>2</Status>\n" + 
        		                        		"                    <ActiveTimeLimit>20200926095020</ActiveTimeLimit>\n" + 
        		                        		"                    <StatusDetail>000000000000000000000000</StatusDetail>\n" + 
        		                        		"                    <ActivationTime>20181114145136</ActivationTime>\n" + 
        		                        		"                    <UserCustomer>\n" + 
        		                        		"                        <CustKey>CBS237294000025371930</CustKey>\n" + 
        		                        		"                        <CustInfo>\n" + 
        		                        		"                            <CustType>1</CustType>\n" + 
        		                        		"                            <CustNodeType>1</CustNodeType>\n" + 
        		                        		"                            <CustClass>1</CustClass>\n" + 
        		                        		"                            <CustCode>CBS237294000025371940</CustCode>\n" + 
        		                        		"                            <CustBasicInfo>\n" + 
        		                        		"                                <DFTWrittenLang>2063</DFTWrittenLang>\n" + 
        		                        		"                                <DFTIVRLang>2063</DFTIVRLang>\n" + 
        		                        		"                                <CustLevel>1</CustLevel>\n" + 
        		                        		"                                <DunningFlag>1</DunningFlag>\n" + 
        		                        		"                            </CustBasicInfo>\n" + 
        		                        		"                        </CustInfo>\n" + 
        		                        		"                        <IndividualInfo>\n" + 
        		                        		"                            <FirstName>default</FirstName>\n" + 
        		                        		"                            <HomeAddressKey>CBS220000000016545538</HomeAddressKey>\n" + 
        		                        		"                            <Gender>1</Gender>\n" + 
        		                        		"                        </IndividualInfo>\n" + 
        		                        		"                    </UserCustomer>\n" + 
        		                        		"                    <AddressInfo>\n" + 
        		                        		"                        <AddressKey>CBS220000000016545538</AddressKey>\n" + 
        		                        		"                        <Address1>unknown</Address1>\n" + 
        		                        		"                    </AddressInfo>\n" + 
        		                        		"                </SubscriberInfo>\n" + 
        		                        		"                <PaymentMode>0</PaymentMode>\n" + 
        		                        		"                <PrimaryOffering>\n" + 
        		                        		"                    <OfferingKey>\n" + 
        		                        		"                        <OfferingID>304</OfferingID>\n" + 
        		                        		"                        <PurchaseSeq>4000000573452372</PurchaseSeq>\n" + 
        		                        		"                    </OfferingKey>\n" + 
        		                        		"                    <BundledFlag>S</BundledFlag>\n" + 
        		                        		"                    <OfferingClass>I</OfferingClass>\n" + 
        		                        		"                    <Status>2</Status>\n" + 
        		                        		"                    <TrialStartTime>20181114145136</TrialStartTime>\n" + 
        		                        		"                    <TrialEndTime>20181114145136</TrialEndTime>\n" + 
        		                        		"                    <ProductInst>\n" + 
        		                        		"                        <ProductID>1042</ProductID>\n" + 
        		                        		"                        <PrimaryFlag>A</PrimaryFlag>\n" + 
        		                        		"                        <PackageFlag>A</PackageFlag>\n" + 
        		                        		"                        <NetworkType>1</NetworkType>\n" + 
        		                        		"                        <ProductType>1</ProductType>\n" + 
        		                        		"                    </ProductInst>\n" + 
        		                        		"                    <ProductInst>\n" + 
        		                        		"                        <ProductID>1053</ProductID>\n" + 
        		                        		"                        <PrimaryFlag>M</PrimaryFlag>\n" + 
        		                        		"                        <PackageFlag>A</PackageFlag>\n" + 
        		                        		"                        <NetworkType>1</NetworkType>\n" + 
        		                        		"                        <ProductType>1</ProductType>\n" + 
        		                        		"                    </ProductInst>\n" + 
        		                        		"                    <ProductInst>\n" + 
        		                        		"                        <ProductID>1822969218</ProductID>\n" + 
        		                        		"                        <PrimaryFlag>A</PrimaryFlag>\n" + 
        		                        		"                        <PackageFlag>A</PackageFlag>\n" + 
        		                        		"                        <NetworkType>1</NetworkType>\n" + 
        		                        		"                        <ProductType>1</ProductType>\n" + 
        		                        		"                    </ProductInst>\n" + 
        		                        		"                    <ProductInst>\n" + 
        		                        		"                        <ProductID>1010</ProductID>\n" + 
        		                        		"                        <PrimaryFlag>A</PrimaryFlag>\n" + 
        		                        		"                        <PackageFlag>A</PackageFlag>\n" + 
        		                        		"                        <NetworkType>1</NetworkType>\n" + 
        		                        		"                        <ProductType>4</ProductType>\n" + 
        		                        		"                    </ProductInst>\n" + 
        		                        		"                    <ProductInst>\n" + 
        		                        		"                        <ProductID>1014</ProductID>\n" + 
        		                        		"                        <PrimaryFlag>A</PrimaryFlag>\n" + 
        		                        		"                        <PackageFlag>A</PackageFlag>\n" + 
        		                        		"                        <NetworkType>1</NetworkType>\n" + 
        		                        		"                        <ProductType>1</ProductType>\n" + 
        		                        		"                    </ProductInst>\n" + 
        		                        		"                    <ProductInst>\n" + 
        		                        		"                        <ProductID>1011</ProductID>\n" + 
        		                        		"                        <PrimaryFlag>A</PrimaryFlag>\n" + 
        		                        		"                        <PackageFlag>A</PackageFlag>\n" + 
        		                        		"                        <NetworkType>1</NetworkType>\n" + 
        		                        		"                        <ProductType>1</ProductType>\n" + 
        		                        		"                    </ProductInst>\n" + 
        		                        		"                </PrimaryOffering>\n" + 
        		                        		"                <SupplementaryOffering>\n" + 
        		                        		"                    <OfferingKey>\n" + 
        		                        		"                        <OfferingID>850011</OfferingID>\n" + 
        		                        		"                        <PurchaseSeq>747000024891344</PurchaseSeq>\n" + 
        		                        		"                    </OfferingKey>\n" + 
        		                        		"                    <BundledFlag>S</BundledFlag>\n" + 
        		                        		"                    <OfferingClass>I</OfferingClass>\n" + 
        		                        		"                    <Status>2</Status>\n" + 
        		                        		"                    <TrialStartTime>19700101060000</TrialStartTime>\n" + 
        		                        		"                    <TrialEndTime>19700101060000</TrialEndTime>\n" + 
        		                        		"                    <EffectiveTime>20181114145139</EffectiveTime>\n" + 
        		                        		"                    <ExpirationTime>20190910000000</ExpirationTime>\n" + 
        		                        		"                    <ActivationMode>A</ActivationMode>\n" + 
        		                        		"                    <ActivationTime>20181114145139</ActivationTime>\n" + 
        		                        		"                    <ActiveTimeLimit>20370101000000</ActiveTimeLimit>\n" + 
        		                        		"                </SupplementaryOffering>\n" + 
        		                        		"                <SupplementaryOffering>\n" + 
        		                        		"                    <OfferingKey>\n" + 
        		                        		"                        <OfferingID>830491</OfferingID>\n" + 
        		                        		"                        <PurchaseSeq>747000024891261</PurchaseSeq>\n" + 
        		                        		"                    </OfferingKey>\n" + 
        		                        		"                    <BundledFlag>S</BundledFlag>\n" + 
        		                        		"                    <OfferingClass>I</OfferingClass>\n" + 
        		                        		"                    <Status>2</Status>\n" + 
        		                        		"                    <TrialStartTime>19700101060000</TrialStartTime>\n" + 
        		                        		"                    <TrialEndTime>19700101060000</TrialEndTime>\n" + 
        		                        		"                    <EffectiveTime>20181114000000</EffectiveTime>\n" + 
        		                        		"                    <ExpirationTime>20191114000000</ExpirationTime>\n" + 
        		                        		"                    <ActivationMode>A</ActivationMode>\n" + 
        		                        		"                    <ActivationTime>20181114000000</ActivationTime>\n" + 
        		                        		"                    <ActiveTimeLimit>20370101000000</ActiveTimeLimit>\n" + 
        		                        		"                </SupplementaryOffering>\n" + 
        		                        		"                <SupplementaryOffering>\n" + 
        		                        		"                    <OfferingKey>\n" + 
        		                        		"                        <OfferingID>850006</OfferingID>\n" + 
        		                        		"                        <PurchaseSeq>747000024891342</PurchaseSeq>\n" + 
        		                        		"                    </OfferingKey>\n" + 
        		                        		"                    <BundledFlag>S</BundledFlag>\n" + 
        		                        		"                    <OfferingClass>I</OfferingClass>\n" + 
        		                        		"                    <Status>2</Status>\n" + 
        		                        		"                    <TrialStartTime>19700101060000</TrialStartTime>\n" + 
        		                        		"                    <TrialEndTime>19700101060000</TrialEndTime>\n" + 
        		                        		"                    <EffectiveTime>20181114145139</EffectiveTime>\n" + 
        		                        		"                    <ExpirationTime>20281111000000</ExpirationTime>\n" + 
        		                        		"                    <ActivationMode>A</ActivationMode>\n" + 
        		                        		"                    <ActivationTime>20181114145139</ActivationTime>\n" + 
        		                        		"                    <ActiveTimeLimit>20370101000000</ActiveTimeLimit>\n" + 
        		                        		"                </SupplementaryOffering>\n" + 
        		                        		"                <SupplementaryOffering>\n" + 
        		                        		"                    <OfferingKey>\n" + 
        		                        		"                        <OfferingID>831051</OfferingID>\n" + 
        		                        		"                        <PurchaseSeq>747000024977266</PurchaseSeq>\n" + 
        		                        		"                    </OfferingKey>\n" + 
        		                        		"                    <BundledFlag>S</BundledFlag>\n" + 
        		                        		"                    <OfferingClass>I</OfferingClass>\n" + 
        		                        		"                    <Status>2</Status>\n" + 
        		                        		"                    <TrialStartTime>19700101060000</TrialStartTime>\n" + 
        		                        		"                    <TrialEndTime>19700101060000</TrialEndTime>\n" + 
        		                        		"                    <EffectiveTime>20181116150315</EffectiveTime>\n" + 
        		                        		"                    <ExpirationTime>20191116000000</ExpirationTime>\n" + 
        		                        		"                    <ActivationMode>A</ActivationMode>\n" + 
        		                        		"                    <ActivationTime>20181116150315</ActivationTime>\n" + 
        		                        		"                    <ActiveTimeLimit>20370101000000</ActiveTimeLimit>\n" + 
        		                        		"                </SupplementaryOffering>\n" + 
        		                        		"                <SupplementaryOffering>\n" + 
        		                        		"                    <OfferingKey>\n" + 
        		                        		"                        <OfferingID>80862</OfferingID>\n" + 
        		                        		"                        <PurchaseSeq>4000000573452378</PurchaseSeq>\n" + 
        		                        		"                    </OfferingKey>\n" + 
        		                        		"                    <BundledFlag>S</BundledFlag>\n" + 
        		                        		"                    <OfferingClass>I</OfferingClass>\n" + 
        		                        		"                    <Status>2</Status>\n" + 
        		                        		"                    <TrialStartTime>20181114145136</TrialStartTime>\n" + 
        		                        		"                    <TrialEndTime>20181114145136</TrialEndTime>\n" + 
        		                        		"                    <ProductInst>\n" + 
        		                        		"                        <ProductID>1023</ProductID>\n" + 
        		                        		"                        <PrimaryFlag>A</PrimaryFlag>\n" + 
        		                        		"                        <PackageFlag>A</PackageFlag>\n" + 
        		                        		"                        <NetworkType>0</NetworkType>\n" + 
        		                        		"                        <ProductType>5</ProductType>\n" + 
        		                        		"                    </ProductInst>\n" + 
        		                        		"                    <EffectiveTime>20180927095020</EffectiveTime>\n" + 
        		                        		"                    <ExpirationTime>20370101000000</ExpirationTime>\n" + 
        		                        		"                    <ActivationMode>A</ActivationMode>\n" + 
        		                        		"                    <ActivationTime>20181114145136</ActivationTime>\n" + 
        		                        		"                    <ActiveTimeLimit>20370101000000</ActiveTimeLimit>\n" + 
        		                        		"                </SupplementaryOffering>\n" + 
        		                        		"            </Subscriber>\n" + 
        		                        		"            <Account>\n" + 
        		                        		"                <AcctKey>CBS237294000025371939</AcctKey>\n" + 
        		                        		"                <AcctInfo>\n" + 
        		                        		"                    <AcctCode>CBS237294000025371942</AcctCode>\n" + 
        		                        		"                    <UserCustomerKey>CBS237294000025371930</UserCustomerKey>\n" + 
        		                        		"                    <UserCustomer>\n" + 
        		                        		"                        <CustKey>CBS237294000025371930</CustKey>\n" + 
        		                        		"                        <CustInfo>\n" + 
        		                        		"                            <CustType>1</CustType>\n" + 
        		                        		"                            <CustNodeType>1</CustNodeType>\n" + 
        		                        		"                            <CustClass>1</CustClass>\n" + 
        		                        		"                            <CustCode>CBS237294000025371940</CustCode>\n" + 
        		                        		"                            <CustBasicInfo>\n" + 
        		                        		"                                <DFTWrittenLang>2063</DFTWrittenLang>\n" + 
        		                        		"                                <DFTIVRLang>2063</DFTIVRLang>\n" + 
        		                        		"                                <CustLevel>1</CustLevel>\n" + 
        		                        		"                                <DunningFlag>1</DunningFlag>\n" + 
        		                        		"                                <CustProperty>\n" + 
        		                        		"                                    <Code>C_LEGAL_CATEGORY</Code>\n" + 
        		                        		"                                    <Value/>\n" + 
        		                        		"                                </CustProperty>\n" + 
        		                        		"                                <CustProperty>\n" + 
        		                        		"                                    <Code>C_CUST_CLASS_NAME</Code>\n" + 
        		                        		"                                    <Value/>\n" + 
        		                        		"                                </CustProperty>\n" + 
        		                        		"                                <CustProperty>\n" + 
        		                        		"                                    <Code>C_FRAUD_FLAG</Code>\n" + 
        		                        		"                                    <Value>N</Value>\n" + 
        		                        		"                                </CustProperty>\n" + 
        		                        		"                                <CustProperty>\n" + 
        		                        		"                                    <Code>C_CUST_DECEASED</Code>\n" + 
        		                        		"                                    <Value>N</Value>\n" + 
        		                        		"                                </CustProperty>\n" + 
        		                        		"                                <CustProperty>\n" + 
        		                        		"                                    <Code>C_CONTRACT_BEGINDATE</Code>\n" + 
        		                        		"                                    <Value/>\n" + 
        		                        		"                                </CustProperty>\n" + 
        		                        		"                                <CustProperty>\n" + 
        		                        		"                                    <Code>C_CUST_MARKETSEG</Code>\n" + 
        		                        		"                                    <Value>Individual</Value>\n" + 
        		                        		"                                </CustProperty>\n" + 
        		                        		"                                <CustProperty>\n" + 
        		                        		"                                    <Code>C_CUST_BANKRUPTCY</Code>\n" + 
        		                        		"                                    <Value>N</Value>\n" + 
        		                        		"                                </CustProperty>\n" + 
        		                        		"                                <CustProperty>\n" + 
        		                        		"                                    <Code>C_OLD_IC</Code>\n" + 
        		                        		"                                    <Value/>\n" + 
        		                        		"                                </CustProperty>\n" + 
        		                        		"                                <CustProperty>\n" + 
        		                        		"                                    <Code>C_EXTERNAL_CUST_ID</Code>\n" + 
        		                        		"                                    <Value/>\n" + 
        		                        		"                                </CustProperty>\n" + 
        		                        		"                                <CustProperty>\n" + 
        		                        		"                                    <Code>C_CUST_MARKETING_CONSENT</Code>\n" + 
        		                        		"                                    <Value>N</Value>\n" + 
        		                        		"                                </CustProperty>\n" + 
        		                        		"                                <CustProperty>\n" + 
        		                        		"                                    <Code>C_REG_FLAG</Code>\n" + 
        		                        		"                                    <Value>N</Value>\n" + 
        		                        		"                                </CustProperty>\n" + 
        		                        		"                                <CustProperty>\n" + 
        		                        		"                                    <Code>C_NEW_IC</Code>\n" + 
        		                        		"                                    <Value/>\n" + 
        		                        		"                                </CustProperty>\n" + 
        		                        		"                                <CustProperty>\n" + 
        		                        		"                                    <Code>C_CUST_MEDIA_FLAG</Code>\n" + 
        		                        		"                                    <Value>N</Value>\n" + 
        		                        		"                                </CustProperty>\n" + 
        		                        		"                                <CustProperty>\n" + 
        		                        		"                                    <Code>C_CONTRACT_ENDDATE</Code>\n" + 
        		                        		"                                    <Value/>\n" + 
        		                        		"                                </CustProperty>\n" + 
        		                        		"                                <CustProperty>\n" + 
        		                        		"                                    <Code>C_TAX_PAYER_IDENTIFICATION_NO</Code>\n" + 
        		                        		"                                    <Value/>\n" + 
        		                        		"                                </CustProperty>\n" + 
        		                        		"                                <CustProperty>\n" + 
        		                        		"                                    <Code>C_CUSTOMER_TAX_RATE</Code>\n" + 
        		                        		"                                    <Value/>\n" + 
        		                        		"                                </CustProperty>\n" + 
        		                        		"                                <CustProperty>\n" + 
        		                        		"                                    <Code>C_ACCESSIBILITY_FLAG</Code>\n" + 
        		                        		"                                    <Value/>\n" + 
        		                        		"                                </CustProperty>\n" + 
        		                        		"                                <CustProperty>\n" + 
        		                        		"                                    <Code>C_EVENING_PHONE</Code>\n" + 
        		                        		"                                    <Value/>\n" + 
        		                        		"                                </CustProperty>\n" + 
        		                        		"                                <CustProperty>\n" + 
        		                        		"                                    <Code>C_CREDIT_CLASS_NAME</Code>\n" + 
        		                        		"                                    <Value/>\n" + 
        		                        		"                                </CustProperty>\n" + 
        		                        		"                                <CustProperty>\n" + 
        		                        		"                                    <Code>C_DAYTIME_PHONE</Code>\n" + 
        		                        		"                                    <Value/>\n" + 
        		                        		"                                </CustProperty>\n" + 
        		                        		"                                <CustProperty>\n" + 
        		                        		"                                    <Code>C_CUST_RFC</Code>\n" + 
        		                        		"                                    <Value/>\n" + 
        		                        		"                                </CustProperty>\n" + 
        		                        		"                                <CustProperty>\n" + 
        		                        		"                                    <Code>C_CUST_RFC</Code>\n" + 
        		                        		"                                    <Value/>\n" + 
        		                        		"                                </CustProperty>\n" + 
        		                        		"                                <CustProperty>\n" + 
        		                        		"                                    <Code>C_CUST_RFC</Code>\n" + 
        		                        		"                                    <Value/>\n" + 
        		                        		"                                </CustProperty>\n" + 
        		                        		"                                <CustProperty>\n" + 
        		                        		"                                    <Code>C_CUST_RFC</Code>\n" + 
        		                        		"                                    <Value/>\n" + 
        		                        		"                                </CustProperty>\n" + 
        		                        		"                                <CustProperty>\n" + 
        		                        		"                                    <Code>C_CUST_RFC</Code>\n" + 
        		                        		"                                    <Value/>\n" + 
        		                        		"                                </CustProperty>\n" + 
        		                        		"                                <CustProperty>\n" + 
        		                        		"                                    <Code>C_CUST_RFC</Code>\n" + 
        		                        		"                                    <Value/>\n" + 
        		                        		"                                </CustProperty>\n" + 
        		                        		"                                <CustProperty>\n" + 
        		                        		"                                    <Code>C_CUST_RFC</Code>\n" + 
        		                        		"                                    <Value/>\n" + 
        		                        		"                                </CustProperty>\n" + 
        		                        		"                                <CustProperty>\n" + 
        		                        		"                                    <Code>C_CUST_RFC</Code>\n" + 
        		                        		"                                    <Value/>\n" + 
        		                        		"                                </CustProperty>\n" + 
        		                        		"                                <CustProperty>\n" + 
        		                        		"                                    <Code>C_CUST_RFC</Code>\n" + 
        		                        		"                                    <Value/>\n" + 
        		                        		"                                </CustProperty>\n" + 
        		                        		"                            </CustBasicInfo>\n" + 
        		                        		"                        </CustInfo>\n" + 
        		                        		"                        <IndividualInfo>\n" + 
        		                        		"                            <FirstName>default</FirstName>\n" + 
        		                        		"                            <HomeAddressKey>CBS220000000016545538</HomeAddressKey>\n" + 
        		                        		"                            <Gender>1</Gender>\n" + 
        		                        		"                        </IndividualInfo>\n" + 
        		                        		"                    </UserCustomer>\n" + 
        		                        		"                    <RootAcctKey>CBS237294000025371939</RootAcctKey>\n" + 
        		                        		"                    <AcctBasicInfo>\n" + 
        		                        		"                        <AcctName>default</AcctName>\n" + 
        		                        		"                        <BillLang>2063</BillLang>\n" + 
        		                        		"                        <DunningFlag>1</DunningFlag>\n" + 
        		                        		"                        <LateFeeChargeable>N</LateFeeChargeable>\n" + 
        		                        		"                        <RedlistFlag>0</RedlistFlag>\n" + 
        		                        		"                        <ContactInfo>\n" + 
        		                        		"                            <Title>1</Title>\n" + 
        		                        		"                            <AddressKey>CBS220000000016545541</AddressKey>\n" + 
        		                        		"                        </ContactInfo>\n" + 
        		                        		"                    </AcctBasicInfo>\n" + 
        		                        		"                    <BillCycleType>01</BillCycleType>\n" + 
        		                        		"                    <AcctType>1</AcctType>\n" + 
        		                        		"                    <PaymentType>0</PaymentType>\n" + 
        		                        		"                    <AcctClass>1</AcctClass>\n" + 
        		                        		"                    <CurrencyID>1012</CurrencyID>\n" + 
        		                        		"                    <AcctPayMethod>1</AcctPayMethod>\n" + 
        		                        		"                    <AddressInfo>\n" + 
        		                        		"                        <AddressKey>CBS220000000016545538</AddressKey>\n" + 
        		                        		"                        <Address1>unknown</Address1>\n" + 
        		                        		"                    </AddressInfo>\n" + 
        		                        		"                    <AddressInfo>\n" + 
        		                        		"                        <AddressKey>CBS220000000016545541</AddressKey>\n" + 
        		                        		"                        <Address1>unknown</Address1>\n" + 
        		                        		"                    </AddressInfo>\n" + 
        		                        		"                    <BillCycleOpenDate>20190701000000</BillCycleOpenDate>\n" + 
        		                        		"                    <BillCycleEndDate>20190801000000</BillCycleEndDate>\n" + 
        		                        		"                </AcctInfo>\n" + 
        		                        		"            </Account>\n" + 
        		                        		"        </QueryCustomerInfoResult>\n" + 
        		                        		"    </jsonObject>\n" + 
        		                        		"</soapenv:Body>";
        		                    	
        		                        vertx.setTimer(TimeUnit.MILLISECONDS.toMillis(2000), l -> {
        			 	                    	//  json = new JsonObject(jsonResponse);
        		  	                         response.putHeader("Content-Type", "application/xml; charset=UTF8")
        		  	                         .setStatusCode(200);
        		  	                        response.end(jsonResponse);
        		  	                       LOGGER.info("-----ELK--Payment-8090----------");
        			                          });
        		                       

        		                        
        		                   });
        		    	 
        		    	 Route TCPBoostBackEnd = router
        	                     .post("/boost/request11")
        	                     .produces("application/json")
        	                     .handler(routingcontext -> {
        	                         JsonObject body = routingcontext.getBodyAsJson();
        	                         String requestPayLoad = body.getString("\"request\"");  
        	                         System.out.println("request"+requestPayLoad);
        	                         String jsonResponse ="{\"response\":\""+requestPayLoad+"\"}";
        	                         HttpServerResponse response = routingcontext.response();
        	                         vertx.setTimer(TimeUnit.MILLISECONDS.toMillis(1000), l -> {
       	 	                    	  json = new JsonObject(jsonResponse);
            	                         response.putHeader("Content-Type", "application/json; charset=UTF8")
            	                         .setStatusCode(200);
            	                        response.end(Json.encodePrettily(json));
            	                       LOGGER.info("-----TCP-request----------");
        	                          });        	                                	                            	                         
        	                     });
        		    	 
        		    	 router.route().handler(BodyHandler.create());


        		    	   router.route(HttpMethod.POST, "/boost/request").handler(rc -> {
        		    		     vertx.setTimer(TimeUnit.MILLISECONDS.toMillis(1000), l -> {
        		    		    	 LOGGER.info("-----IN I SEC DELAY----------");
             		    	        JsonObject json = rc.getBodyAsJson();
            		    	        String requestPayLoad=json.getString("request");
            		    	        String jsonResponse ="{\"response\":\""+requestPayLoad+"\"}";
            		    	        JsonObject jsonRes = new JsonObject(jsonResponse);
            		    	        HttpServerResponse response = rc.response();
            		    	        response.putHeader("content-type", "application/json").setStatusCode(200);
            		    	        response.end(Json.encodePrettily(jsonRes));
            		    	        LOGGER.info("-----TCP-request----------");
       	                          });   
        		    	    }); 
        		    	   
          		    	 Route SmarttypeCheckEndpoint = router
        	                     .get("/smart/msisdntype")
        	                     .produces("application/json")
        	                     .handler(routingcontext -> {
        	                         HttpServerResponse response = routingcontext.response();
        	                        String productType = routingcontext.request().getParam("producttype");
        	                         
        	                         String jsonResponse ="{\n" + 
        	                         		"    \"subscriber_id\": \"tel:+85510202667\",\n" + 
        	                         		"    \"subscriber_type\": \"postpaid\"\n" + 
        	                         		"}";
        	                         vertx.setTimer(TimeUnit.MILLISECONDS.toMillis(333), l -> {
       	 	                    	  json = new JsonObject(jsonResponse);
            	                         response.putHeader("Content-Type", "application/json; charset=UTF8")
            	                         .setStatusCode(200);
            	                        response.end(Json.encodePrettily(json));
            	                       LOGGER.info("-----SmarttypeCheckEndpoint-8091----------");
        	                          });
        	                        
        	                         
        	                         
        	                     });
          		    	 
          		    	 
          		    	 Route OrangeEndPoint = router
        	                     .post("/payment/acr:OrangeAPIToken/transactions/amount")
        	                     .produces("application/json")
        	                     .handler(routingcontext -> {
        	                         HttpServerResponse response = routingcontext.response();
        	                         String jsonResponse ="{  \n" + 
        	                         		"   \"amountTransaction\":{  \n" + 
        	                         		"      \"clientCorrelator\":\"Orange12345\",\n" + 
        	                         		"      \"endUserId\":\"772591160\",\n" + 
        	                         		"      \"paymentAmount\":{  \n" + 
        	                         		"         \"chargingInformation\":{  \n" + 
        	                         		"            \"amount\":\"1.45\",\n" + 
        	                         		"            \"currency\":\"LKR\",\n" + 
        	                         		"            \"description\":\"Alien Invaders Game\"\n" + 
        	                         		"         },\n" + 
        	                         		"         \"totalAmountCharged\":\"100\",\n" + 
        	                         		"         \"chargingMetaData\":{  \n" + 
        	                         		"            \"onBehalfOf\":\"Example Games Inc\",\n" + 
        	                         		"            \"serviceId\":\"service12345\",\n" + 
        	                         		"            \"channel\":\"5\",\n" + 
        	                         		"            \"serviceId\":\"APPLE\",\n" + 
        	                         		"            \"taxAmount\":\"0.25\"\n" + 
        	                         		"         }\n" + 
        	                         		"      },\n" + 
        	                         		"      \"referenceCode\":\"REF-12345\",\n" + 
        	                         		"      \"serverReferenceCode\":\"ABC-123\",\n" + 
        	                         		"      \"resourceURL\":\" /payment/v1/acr%3AOrangeAPIToken/transactions/amount/abc123\",\n" + 
        	                         		"      \"transactionOperationStatus\":\"Charged\"\n" + 
        	                         		"   }\n" + 
        	                         		"}";
        	                         vertx.setTimer(TimeUnit.MILLISECONDS.toMillis(333), l -> {
          	 	                    	  json = new JsonObject(jsonResponse);
               	                         response.putHeader("Content-Type", "application/json; charset=UTF8")
               	                         .setStatusCode(200);
               	                        response.end(Json.encodePrettily(json));
               	                       LOGGER.info("-----Orange B/E --8093----------");
           	                          });
        	                        
        	                         
        	                         
        	                     });

        httpServer
                .requestHandler(router::accept)
                .listen(8090);

    }
}
