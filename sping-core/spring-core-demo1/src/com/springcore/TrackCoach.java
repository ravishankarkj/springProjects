package com.springcore;

public class TrackCoach implements Coach {
	
	private FortuneService myFortuneService;
	
	public TrackCoach(FortuneService myFortuneService) {
		this.myFortuneService = myFortuneService;
	}

	@Override
	public String getDailyWorkout() {

		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return myFortuneService.getFortuneService();
	}
	

}
