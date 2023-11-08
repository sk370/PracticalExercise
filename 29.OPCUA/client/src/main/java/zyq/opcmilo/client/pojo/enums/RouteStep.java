package com.xxmes.opcapp.pojo.enums;

import java.util.Arrays;


public enum RouteStep {
	JOINT("joint", "010"),
	VISCOSE("viscose", "020"),
	SECTION("section", "030"),
	DEGUMING("deguming", "040"),
	CLEAN("clean", "050"),
	SORT("sort","060"),
	INSPECT("inspect", "070"),
	REINSPECT("reinspect", "080");
	
	private String routeName;
	
	private String routeStep;
	
	RouteStep(String routeName,String routeStep){
		this.routeName = routeName;
		this.routeStep = routeStep;
	}

	public String getRouteName() {
		return routeName;
	}

	public String getRouteStep() {
		return routeStep;
	}
	
	public static String getRouteStepByName(String routeName) {
		return Arrays.asList(RouteStep.values()).stream()
				.filter(item -> item.getRouteName().equals(routeName))
				.findFirst().get().getRouteStep();
	}
	
}
