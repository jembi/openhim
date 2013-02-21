package org.jembi.rhea.transformers;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.activation.DataHandler;

import org.jembi.TestUtil;
import org.jembi.rhea.RestfulHttpResponse;
import org.junit.Test;
import org.mule.api.ExceptionPayload;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.DataType;
import org.mule.api.transformer.Transformer;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transport.PropertyScope;

public class XDSRepositoryResponseToRestfulHttpResponseTransformerTest {
	
	@Test
	public void testTransformMessageMuleMessageString() throws TransformerException {
		MuleMessage msg = new TestMuleMessage();
		
		XDSRepositoryResponseToRestfulHttpResponseTransformer transformer = new XDSRepositoryResponseToRestfulHttpResponseTransformer();
		RestfulHttpResponse res = (RestfulHttpResponse) transformer.transform(msg, "");
		
		assertNotNull(res);
		
		System.out.println(res.getBody());
	}
	
	private static class TestMuleMessage implements MuleMessage {
		
		private static final long serialVersionUID = 1L;
		
		@Override
		public Object getPayload() {
			
			List<String> documentList = new ArrayList<String>();
			String oru_r01 = null;
			try {
				oru_r01 = TestUtil.getResourceAsString("oru_r01.xml");
			} catch (IOException e) {
				e.printStackTrace();
			}
			for (int i = 0; i < 4; i++) {
				documentList.add(oru_r01);
			}
			
			return documentList;
		}

		@Override
		public String getPayloadAsString() throws Exception {
			return (String)getPayload();
		}

		@Override public void addProperties(Map<String, Object> properties) {}
		@Override public void addProperties(Map<String, Object> properties, PropertyScope scope) {}
		@Override public void clearProperties() {}
		@Override public void clearProperties(PropertyScope scope) {}
		@Override public Object getProperty(String key) { return null; }
		@Override public void setProperty(String key, Object value) {}
		@Override public void setInvocationProperty(String key, Object value) {}
		@Override public void setOutboundProperty(String key, Object value) {}
		@Override public void setProperty(String key, Object value, PropertyScope scope) {}
		@Override public Object removeProperty(String key) { return null; }
		@Override public Object removeProperty(String key, PropertyScope scope) { return null; }
		@Override public Set<String> getPropertyNames() { return null; }
		@Override public Set<String> getPropertyNames(PropertyScope scope) { return null; }
		@Override public Set<String> getInvocationPropertyNames() { return null; }
		@Override public Set<String> getInboundPropertyNames() { return null; }
		@Override public Set<String> getOutboundPropertyNames() { return null; }
		@Override public Set<String> getSessionPropertyNames() { return null; }
		@Override public String getUniqueId() { return null; }
		@Override public String getMessageRootId() { return null; }
		@Override public void setMessageRootId(String rootId) {}
		@Override public void propagateRootId(MuleMessage parent) {}
		@Override public Object getProperty(String name, Object defaultValue) { return null; }
		@Override public <T> T getProperty(String name, PropertyScope scope) { return null; }
		@Override public <T> T getInboundProperty(String name, T defaultValue) { return null; }
		@Override public <T> T getInboundProperty(String name) { return null; }
		@Override public <T> T getInvocationProperty(String name, T defaultValue) { return null; }
		@Override public <T> T getInvocationProperty(String name) { return null; }
		@Override public <T> T getOutboundProperty(String name, T defaultValue) { return null; }
		@Override public <T> T getOutboundProperty(String name) { return null; }
		@Override public <T> T findPropertyInAnyScope(String name, T defaultValue) { return null; }
		@Override public <T> T getProperty(String name, PropertyScope scope, T defaultValue) { return null; }
		@Override public int getIntProperty(String name, int defaultValue) { return 0; }
		@Override public long getLongProperty(String name, long defaultValue) { return 0; }
		@Override public double getDoubleProperty(String name, double defaultValue) { return 0; }
		@Override public String getStringProperty(String name, String defaultValue) { return null; }
		@Override public boolean getBooleanProperty(String name, boolean defaultValue) { return false; }
		@Override public void setBooleanProperty(String name, boolean value) {}
		@Override public void setIntProperty(String name, int value) {}
		@Override public void setLongProperty(String name, long value) {}
		@Override public void setDoubleProperty(String name, double value) {}
		@Override public void setStringProperty(String name, String value) {}
		@Override public void setCorrelationId(String id) {}
		@Override public String getCorrelationId() { return null; }
		@Override public int getCorrelationSequence() { return 0; }
		@Override public void setCorrelationSequence(int sequence) {}
		@Override public int getCorrelationGroupSize() { return 0; }
		@Override public void setCorrelationGroupSize(int size) {}
		@Override public void setReplyTo(Object replyTo) {}
		@Override public Object getReplyTo() { return null; }
		@Override public ExceptionPayload getExceptionPayload() { return null; }
		@Override public void setExceptionPayload(ExceptionPayload payload) {}
		@Override public void addAttachment(String name, DataHandler dataHandler) {}
		@Override public void addOutboundAttachment(String name, DataHandler dataHandler) {}
		@Override public void addOutboundAttachment(String name, Object object, String contentType) throws Exception {}
		@Override public void removeAttachment(String name) throws Exception {}
		@Override public void removeOutboundAttachment(String name) throws Exception {}
		@Override public DataHandler getAttachment(String name) { return null; }
		@Override public DataHandler getInboundAttachment(String name) { return null; }
		@Override public DataHandler getOutboundAttachment(String name) { return null; }
		@Override public Set<String> getAttachmentNames() { return null; }
		@Override public Set<String> getInboundAttachmentNames() { return null; }
		@Override public Set<String> getOutboundAttachmentNames() { return null; }
		@Override public String getEncoding() { return null; }
		@Override public void setEncoding(String encoding) {}
		@Override public void release() {}
		@Override public void applyTransformers(MuleEvent event, List<? extends Transformer> transformers) throws MuleException {}
		@Override public void applyTransformers(MuleEvent event, Transformer... transformers) throws MuleException {}
		@Override public void applyTransformers(MuleEvent event, List<? extends Transformer> transformers, Class<?> outputType) throws MuleException {}
		@Override public void setPayload(Object payload) {}
		@Override public <T> T getPayload(Class<T> outputType) throws TransformerException { return null; }
		@Override public <T> T getPayload(DataType<T> outputType) throws TransformerException { return null; }
		@Override public String getPayloadAsString(String encoding) throws Exception { return null; }
		@Override public byte[] getPayloadAsBytes() throws Exception { return null; }
		@Override public Object getOriginalPayload() { return null; }
		@Override public String getPayloadForLogging() { return null; }
		@Override public String getPayloadForLogging(String encoding) { return null; }
		@Override public MuleContext getMuleContext() { return null; }
		@Override public DataType<?> getDataType() { return null; }
		@Override public <T> T getSessionProperty(String name, T defaultValue) { return null; }
		@Override public <T> T getSessionProperty(String name) { return null; }
		@Override public void setSessionProperty(String key, Object value) {}
		@Override public MuleMessage createInboundMessage() throws Exception { return null; }
	}


}
