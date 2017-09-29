/*******************************************************************************
 * Copyright (c) 2009, 2014 IBM Corp.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v1.0 which accompany this distribution. 
 *
 * The Eclipse Public License is available at 
 *    http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 *   http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *    Dave Locke - initial API and implementation and/or initial documentation
 */
package org.eclipse.paho.mqttv5.client.test.utilities;

import java.util.Enumeration;
import java.util.Hashtable;

import org.eclipse.paho.mqttv5.client.MqttClientPersistence;
import org.eclipse.paho.mqttv5.common.MqttPersistable;
import org.eclipse.paho.mqttv5.common.MqttPersistenceException;

/**
 * Persistence that uses memory
 * 
 * In cases where reliability is not required across client or device 
 * restarts memory this memory peristence can be used. In cases where
 * reliability is required like when clean session is set to false
 * then a non-volatile form of persistence should be used. 
 * 
 */
public class TestMemoryPersistence implements MqttClientPersistence {

	private Hashtable<String, MqttPersistable> data;
	
	/* (non-Javadoc)
	 * @see org.eclipse.paho.mqttv5.client.MqttClientPersistence#close()
	 */
	public void close() throws MqttPersistenceException {
		//data.clear();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.paho.mqttv5.client.MqttClientPersistence#keys()
	 */
	public Enumeration<String> keys() throws MqttPersistenceException {
		return data.keys();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.paho.mqttv5.client.MqttClientPersistence#get(java.lang.String)
	 */
	public MqttPersistable get(String key) throws MqttPersistenceException {
		return (MqttPersistable)data.get(key);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.paho.mqttv5.client.MqttClientPersistence#open(java.lang.String, java.lang.String)
	 */
	public void open(String clientId, String serverURI) throws MqttPersistenceException {
		if(this.data ==  null){
			this.data = new Hashtable<String, MqttPersistable>();
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.paho.mqttv5.client.MqttClientPersistence#put(java.lang.String, org.eclipse.paho.mqttv5.client.MqttPersistable)
	 */
	public void put(String key, MqttPersistable persistable) throws MqttPersistenceException {
		data.put(key, persistable);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.paho.mqttv5.client.MqttClientPersistence#remove(java.lang.String)
	 */
	public void remove(String key) throws MqttPersistenceException {
		data.remove(key);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.paho.mqttv5.client.MqttClientPersistence#clear()
	 */
	public void clear() throws MqttPersistenceException {
		data.clear();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.paho.mqttv5.client.MqttClientPersistence#containsKey(java.lang.String)
	 */
	public boolean containsKey(String key) throws MqttPersistenceException {
		return data.containsKey(key);
	}

	@Override
	public void open(String clientId) throws MqttPersistenceException {
		data = new Hashtable<String, MqttPersistable>();
		
	}
	
	
}