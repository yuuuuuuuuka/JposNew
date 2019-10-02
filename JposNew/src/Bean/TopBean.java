package Bean;

public class TopBean {

	public int osi2_id;
	public String osi2_name;
	public String osi2_code;

	//コンストラクタ生成
	public TopBean() {
    }

	public TopBean(int osi2_id, String osi2_name, String osi2_code) {
        this.osi2_id = osi2_id;
        this.osi2_name = osi2_name;
        this.osi2_code = osi2_code;
    }

	//サブクラス作成し1レコード分の定義を行う


//set
    public int setOsi2_id() {
        return osi2_id;
    }

    public String setOsi2_name() {
        return osi2_name;
    }

    public String setOsi2_code() {
        return osi2_code;
    }
//get
	public int getOsi2_id() {
        return osi2_id;
    }

    public String getOsi2_name() {
        return osi2_name;
    }

    public String getOsi2_code() {
        return osi2_code;
    }


}
//public static Emy{


//}
