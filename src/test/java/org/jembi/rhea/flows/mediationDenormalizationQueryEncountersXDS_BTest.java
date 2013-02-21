package org.jembi.rhea.flows;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.jembi.rhea.Constants;
import org.jembi.rhea.RestfulHttpRequest;
import org.jembi.rhea.RestfulHttpResponse;
import org.junit.Assert;
import org.junit.Test;
import org.mule.api.MuleMessage;
import org.mule.module.client.MuleClient;
import org.mule.tck.junit4.FunctionalTestCase;

public class mediationDenormalizationQueryEncountersXDS_BTest extends
		FunctionalTestCase {
	
	private final Log log = LogFactory.getLog(this.getClass());
	
	@Override
	protected void doSetUp() throws Exception {
		Logger.getRootLogger().setLevel(Level.INFO);
		super.doSetUp();
	}
	
	@Override
	protected void doTearDown() throws Exception {
		Logger.getRootLogger().setLevel(Level.WARN);
		super.doTearDown();
	}

	@Override
	protected String getConfigResources() {
		return "src/main/app/queryencounters-denormalization-xds.b.xml, src/main/app/global-elements.xml";
	}
	
	@Test
	public void testSend() throws Exception {
		log.info("Starting test");
	    MuleClient client = new MuleClient(muleContext);
	    
	    RestfulHttpRequest payload = new RestfulHttpRequest();
	    payload.setHttpMethod(RestfulHttpRequest.HTTP_GET);
	    
	    Map<String, Object> properties = new HashMap<String, Object>();
	    
	    // NIST
	    //payload.setPath("ws/rest/v1/patient/NIST2010-1b48e083395f498/encounters");//NIST2010-2
	    
	    // Mohawk and EMC
	    //payload.setPath("ws/rest/v1/patient/MOH_CAAT_CR-756/encounters");
	    
	    // Nexj
	    //payload.setPath("ws/rest/v1/patient/IHERED-995/encounters?id=IHERED-995&idType=IHERED");
	    //payload.setPath("ws/rest/v1/patient/IHERED-994/encounters?id=IHERED-994&idType=IHERED");
	    //payload.setPath("ws/rest/v1/patient/IHERED-993/encounters?id=IHERED-993&idType=IHERED");
	    //payload.setPath("ws/rest/v1/patient/IHERED-992/encounters?id=IHERED-992&idType=IHERED");
	    
	    // Vitera
	    //		single repo response
	    //payload.setPath("ws/rest/v1/patient/IHEBLUE-0118jembi1/encounters?id=0118jembi1&idType=IHEBLUE");
	    //		multiple repo response
	    //payload.setPath("ws/rest/v1/patient/IHEBLUE-0118jembi/encounters?id=0118jembi1&idType=IHEBLUE");
	    
	    // Connectathon NIST RED
	    //payload.setPath("ws/rest/v1/patient/IHERED-RED5507/encounters?id=RED5507&idType=IHERED");
	    //payload.setPath("ws/rest/v1/patient/IHERED-IHERED-1336/encounters?id=IHERED-1336&idType=IHERED");
	    //payload.setPath("ws/rest/v1/patient/IHEBLUE-IHEBLUE-1338/encounters?id=IHEBLUE-1338&idType=IHEBLUE");
	    
	    // XCA
	    //payload.setPath("ws/rest/v1/patient/IHERED-69c6d1fe1f874af/encounters?id=69c6d1fe1f874af&idType=IHERED");
	    
	    // HIMMS
	    payload.setPath("ws/rest/v1/patient/ECID-dc8d2234-7fce-4869-945e-97c8b7d97332/encounters");
	    
	    MuleMessage result = client.send("vm://queryEncounters-De-normailization-XDS.b", payload, properties);
	    
	    assertNotNull(result.getPayload());
	    Assert.assertTrue(result.getPayload() instanceof RestfulHttpResponse);
	    
	    log.info(result.getPayload());
	    
	    log.info("Test completed");
	}

}
