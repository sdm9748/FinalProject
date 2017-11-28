package kr.or.kosta.dto;

public class Event {

	private int eventNum;
	private String eventImage;
	private String eventTitle;
	private String eventContent;
	public int getEventNum() {
		return eventNum;
	}
	public void setEventNum(int eventNum) {
		this.eventNum = eventNum;
	}
	public String getEventImage() {
		return eventImage;
	}
	public void setEventImage(String eventImage) {
		this.eventImage = eventImage;
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
		return "Event [eventNum=" + eventNum + ", eventImage=" + eventImage + ", eventTitle=" + eventTitle
				+ ", eventContent=" + eventContent + "]";
	}
	
	
	
}
