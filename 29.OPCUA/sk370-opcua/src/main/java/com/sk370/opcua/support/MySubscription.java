package com.sk370.opcua.support;


import com.sk370.opcua.strategy.EquipDataGatherStrategy;
import com.sk370.opcua.strategy.SubscribeService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


public enum MySubscription {

	BTNHANDSHARK("BtnHandShark", new EquipDataGatherStrategy());
	
	private String labelType;
	
	private SubscribeService handler;
	
	MySubscription(String labelType, SubscribeService handler) {
		this.labelType = labelType;
		this.handler = handler;
	}

	public String getLabelType() {
		return labelType;
	}

	public SubscribeService getHandler() {
		return handler;
	}

	public static SubscribeService getHandleByType(String labelType) {
		List<MySubscription> mySubscriptions = Arrays.asList(MySubscription.values());
		Stream<MySubscription> mySubscriptionStream = mySubscriptions.stream().filter(item -> item.getLabelType().equals(labelType));
		Optional<MySubscription> first = mySubscriptionStream.findFirst();
		MySubscription mySubscription = first.get();
		SubscribeService handler = mySubscription.getHandler();
		return handler;
	}
	
}
