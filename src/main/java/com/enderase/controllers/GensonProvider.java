package com.enderase.controllers;

import java.text.SimpleDateFormat;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;

/**
 * A provider to tell jersey how it should parse the date when it is provided through json
 * 
 * @author Kaleb Woldearegay <kaleb@gullele.com>
 */
@Provider
public class GensonProvider implements ContextResolver<Genson> {
	private final Genson genson = new GensonBuilder().useDateFormat(new SimpleDateFormat("dd-M-yyyy hh:mm:ss")).create();

	@Override
	public Genson getContext(Class<?> type) {
		return genson;
	}
}