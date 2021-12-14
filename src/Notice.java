//��H�����A�w�q�������з�
public interface Notice {
	public void notice();
}

class NotificationCenter {
	//��������
	private Notice notice; 
	//�j�w����
	public NotificationCenter(Notice n) { 
		this.notice = n; 
	}
	//�e�U(delegation)
	public void doNotice() {
		this.notice.notice();
	}
}
//���鵦��
class TimelyNotice implements Notice {
	@Override
	public void notice() {
		System.out.println("�ήɳq��");
	}
}
class ClickedNotice implements Notice {
	@Override
	public void notice() {
		System.out.println("�I���q��");
	}
}