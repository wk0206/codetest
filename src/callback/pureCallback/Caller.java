package callback.pureCallback;

public class Caller {

	public void register(CallBack callback) {
		callback.methodToCallBack();
	}

	public static void main(String[] args) {
		Caller caller = new Caller();
		CallBack callback = new CallBackImpl();
		caller.register(callback);
	}
}
