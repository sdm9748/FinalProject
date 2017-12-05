package kr.or.kosta.dto;

public class Event {

	private int eventNum;
	private String eventImage1;
	private String eventImage2;
	private String eventTitle;
	private String eventContent;

	public String getEventImage1() {
		return eventImage1;
	}

	public void setEventImage1(String eventImage1) {
		this.eventImage1 = eventImage1;
	}

	public String getEventImage2() {
		return eventImage2;
	}

	public void setEventImage2(String eventImage2) {
		this.eventImage2 = eventImage2;
	}

	public int getEventNum() {
		return eventNum;
	}

	public void setEventNum(int eventNum) {
		this.eventNum = eventNum;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public String getEventContent() {
		return eventContent;
	}

	public void setEventContent(String eventContent) {
		this.eventContent = eventContent;
	}

	@Override
	public String toString() {
		return "Event [eventNum=" + eventNum + ", eventImage1=" + eventImage1 + ", eventImage2=" + eventImage2
				+ ", eventTitle=" + eventTitle + ", eventContent=" + eventContent + "]";
	}

	
}
