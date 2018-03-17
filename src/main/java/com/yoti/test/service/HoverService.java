package com.yoti.test.service;

import java.util.Map;

import com.yoti.test.model.Coordinates;


public interface HoverService {
	void insertPayload(Coordinates input);
	Map<String, Object> takeInstruction(Coordinates input);
}
