public class Student {
	public static void main(String args[]) {
		new FcuTable();
		new OcuTable();
	}
}

class FcuTable extends Table {
	public FcuTable() {
		super("FcuTable");
		titleName = "FcuTable";
	}
}

class OcuTable extends Table {
	public OcuTable() {
		super("OcuTable");
		titleName = "OcuTable";
	}
}