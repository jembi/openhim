package org.jembi.rhea.flows;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.jembi.rhea.RestfulHttpRequest;
import org.jembi.rhea.RestfulHttpResponse;
import org.junit.Assert;
import org.junit.Test;
import org.mule.api.MuleMessage;
import org.mule.module.client.MuleClient;
import org.mule.tck.junit4.FunctionalTestCase;

/**
 * Copy of mediationDenormalizationQueryEncountersXDS_BTest with ATNA enabled
 */
public class mediationDenormalizationQueryEncountersXDS_BTest_wATNA extends
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
		return "src/main/app/queryencounters-denormalization-xds.b.xml, src/main/app/atnasend.xml, src/main/app/global-elements.xml";
	}
	
	@Test
	public void testSend() throws Exception {
		log.info("Starting test");
	    MuleClient client = new MuleClient(muleContext);
	    
	    RestfulHttpRequest payload = new RestfulHttpRequest();
	    payload.setHttpMethod(RestfulHttpRequest.HTTP_GET);
	    
	    Map<String, Object> properties = new HashMap<String, Object>();
	    
	    // NIST
	    //payload.setPath("ws/rest/v1/patient/NID-1b48e083395f498/encounters");//NIST2010-2
	    //properties.put(Constants.ASSIGNING_AUTHORITY_OID_PROPERTY_NAME, "1.19.6.24.109.42.1.3");
	    
	    // Mohawk
	    //payload.setPath("ws/rest/v1/patient/MOH_CAAT_CR-756/encounters");
	    
	    // Nexj
	    //payload.setPath("ws/rest/v1/patient/IHERED-994/encounters?id=IHERED-994&idType=IHERED");
	    //payload.setPath("ws/rest/v1/patient/IHERED-993/encounters?id=IHERED-993&idType=IHERED");
	    //payload.setPath("ws/rest/v1/patient/IHERED-992/encounters?id=IHERED-992&idType=IHERED");
	    
	    // Connectathon tuesday morning
	    payload.setPath("ws/rest/v1/patient/IHEBLUE-IHEBLUE-1354/encounters?id=IHEBLUE-1354&idType=IHEBLUE");
	    //payload.setPath("ws/rest/v1/patient/IHEGREEN-IHEGREEN-1338/encounters?id=IHEGREEN-1338&idType=IHEGREEN");
	    
	    MuleMessage result = client.send("vm://queryEncounters-De-normailization-XDS.b", payload, properties);
	    
	    assertNotNull(result.getPayload());
	    Assert.assertTrue(result.getPayload() instanceof RestfulHttpResponse);
	    log.info(result.getPayload());
	    
	    try {
	    	log.info("Giving ATNA a chance to finish...");
	    	Thread.sleep(10000);
	    } catch(InterruptedException ex) {
	    	Thread.currentThread().interrupt();
	    }
	    
	    log.info("Test completed");
	}

}
