//抽象策略，定義策略的標準
public interface Notice {
	public void notice();
}

class NotificationCenter {
	//策略物件
	private Notice notice; 
	//綁定策略
	public NotificationCenter(Notice n) { 
		this.notice = n; 
	}
	//委託(delegation)
	public void doNotice() {
		this.notice.notice();
	}
}
//具體策略
class TimelyNotice implements Notice {
	@Override
	public void notice() {
		System.out.println("及時通知");
	}
}
class ClickedNotice implements Notice {
	@Override
	public void notice() {
		System.out.println("點擊通知");
	}
}