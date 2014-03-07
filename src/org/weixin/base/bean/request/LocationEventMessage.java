package org.weixin.base.bean.request;

/**
 * 上报地理位置事件消息
 * @author kid
 *
 */
public class LocationEventMessage extends EventMessage{

	private static final long serialVersionUID = 1L;
    private double Latitude; //地理位置纬度
    private double Longitude; //地理位置经度
    private double Precision; //地理位置精度
	public double getLatitude() {
		return Latitude;
	}
	public void setLatitude(double latitude) {
		Latitude = latitude;
	}
	public double getLongitude() {
		return Longitude;
	}
	public void setLongitude(double longitude) {
		Longitude = longitude;
	}
	public double getPrecision() {
		return Precision;
	}
	public void setPrecision(double precision) {
		Precision = precision;
	}
    

}
